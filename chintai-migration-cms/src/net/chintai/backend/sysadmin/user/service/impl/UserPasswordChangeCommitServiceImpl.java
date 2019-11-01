/*
 * $Id: UserPasswordChangeCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/26  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.user.dao.UserPasswordChangeCommitDao;
import net.chintai.backend.sysadmin.user.dao.UserPasswordChangeCommitParamBean;
import net.chintai.backend.sysadmin.user.service.UserPasswordChangeCommitService;
import net.chintai.backend.sysadmin.user.service.bean.UserPasswordChangeCommitInServiceBean;

/**
 * UserPasswordChangeCommitServiceの実装クラス。
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserPasswordChangeCommitServiceImpl implements
        UserPasswordChangeCommitService {

    /** ユーザパスワード変更DAO */
    private UserPasswordChangeCommitDao userPasswordChangeCommitDao = null;

    /**
     * UserPasswordChangeCommitDaoを設定する
     * @param userPasswordChangeCommitDao
     */
    public void setUserPasswordChangeCommitDao(
            UserPasswordChangeCommitDao userPasswordChangeCommitDao) {
        this.userPasswordChangeCommitDao = userPasswordChangeCommitDao;
    }

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.service.UserPasswordChangeCommitService#userPasswordChange(net.chintai.backend.sysadmin.user.service.bean.UserPasswordChangeCommitInServiceBean)
     */
    public void userPasswordChange(
            UserPasswordChangeCommitInServiceBean inServiceBean)
            throws ApplicationException {

        // ユーザ削除IDリストをParamBeanに設定
        UserPasswordChangeCommitParamBean paramBean =
            new UserPasswordChangeCommitParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // ユーザ削除処理を行う
        int affected = userPasswordChangeCommitDao.userPasswordChange(paramBean);
        if (affected == 0){
            throw new ApplicationException("ERROR.M.COUNT.0001");
        }
    }
}