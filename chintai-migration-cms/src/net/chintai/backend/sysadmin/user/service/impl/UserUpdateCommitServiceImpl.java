/*
 * $Id: UserUpdateCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/25  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.user.dao.UserUpdateCommitDao;
import net.chintai.backend.sysadmin.user.dao.UserUpdateCommitParamBean;
import net.chintai.backend.sysadmin.user.service.UserUpdateCommitService;
import net.chintai.backend.sysadmin.user.service.bean.UserUpdateCommitInServiceBean;

/**
 * UserUpdateCommitServiceの実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserUpdateCommitServiceImpl implements UserUpdateCommitService {

    /** ユーザ更新完了DAO */
    private UserUpdateCommitDao userUpdateCommitDao = null;

    /**
     * UserUpdateCommitDaoを設定する
     * @param userUpdateCommitDao
     */
    public void setUserUpdateCommitDao(UserUpdateCommitDao userUpdateCommitDao) {
        this.userUpdateCommitDao = userUpdateCommitDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.service.UserUpdateCommitService#userUpdateCommit(net.chintai.backend.sysadmin.user.service.bean.UserUpdateCommitInServiceBean)
     */
    public void userUpdateCommit(UserUpdateCommitInServiceBean inServiceBean) throws ApplicationException {

        // ユーザ更新情報をParamBeanに設定
        UserUpdateCommitParamBean paramBean = new UserUpdateCommitParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // 所属グループがCHINTAIアカウント管理機能へのアクセス権限を持つ場合
        int cjnAccountCheck = userUpdateCommitDao.cjnAccountCheck(paramBean);
        if (cjnAccountCheck != 0) {
            paramBean.setIsCjnAccount("true");
        }

        // ユーザ更新処理を行う
        int affected = userUpdateCommitDao.userUpdateCommit(paramBean);

        if (affected == 0) {
            throw new ApplicationException("ERROR.M.USER.0002");
        }

        // アクセス権限再チェック
        /*
        int cjnAccountReCheck = userUpdateCommitDao.cjnAccountCheck(paramBean);
        if (cjnAccountReCheck == 0) {
            // 所属グループの変更によりCHINTAI問い合せ管理権限が失効した場合、
            // CJN_ACCOUNT_LEVEL テーブルの該当レコードを削除
            userUpdateCommitDao.deleteCjnAccountLevel(paramBean);
        }
        */
    }
}