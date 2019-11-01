/*
 * $Id: UserAddCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/20  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.user.dao.UserAddCommitDao;
import net.chintai.backend.sysadmin.user.dao.UserAddCommitParamBean;
import net.chintai.backend.sysadmin.user.service.UserAddCommitService;
import net.chintai.backend.sysadmin.user.service.bean.UserAddCommitInServiceBean;

/**
 * UserAddCommitServiceの実装クラス。
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserAddCommitServiceImpl implements UserAddCommitService {

    /** ユーザ登録用 DAO */
    private UserAddCommitDao userAddCommitDao = null;

    /**
     * UserAddCommitDaoを設定する
     * @param userAddCommitDao
     */
    public void setUserAddCommitDao(UserAddCommitDao userAddCommitDao) {
        this.userAddCommitDao = userAddCommitDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.service.UserAddCommitService#setUserAddCommit(net.chintai.backend.sysadmin.user.service.bean.UserAddCommitInServiceBean)
     */
    public void userAddCommit(UserAddCommitInServiceBean inServiceBean) throws InvocationTargetException,
            IllegalAccessException {

        // inServiceBeanをParamBeanに設定
        UserAddCommitParamBean paramBean = new UserAddCommitParamBean();
        BeanUtils.copyProperties(paramBean, inServiceBean);

        // 所属グループがCHINTAIアカウント管理機能へのアクセス権限を持つ場合
        int cjnAccountCheck = userAddCommitDao.cjnAccountCheck(paramBean);
        if (cjnAccountCheck != 0) {
            paramBean.setCjnAccountSeq("true");
        }

        // ユーザ登録処理を行う
        userAddCommitDao.userAddCommit(paramBean);
    }
}