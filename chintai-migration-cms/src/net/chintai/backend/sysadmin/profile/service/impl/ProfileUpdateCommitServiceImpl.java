/*
 * $Id: ProfileUpdateCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/04  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.profile.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.profile.dao.ProfileUpdateCommitDao;
import net.chintai.backend.sysadmin.profile.dao.ProfileUpdateCommitParamBean;
import net.chintai.backend.sysadmin.profile.service.ProfileUpdateCommitSerivce;
import net.chintai.backend.sysadmin.profile.service.bean.ProfileUpdateCommitInServiceBean;

/**
 * ProfileUpdateCommitSerivceインターフェースの実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ProfileUpdateCommitServiceImpl implements
        ProfileUpdateCommitSerivce {

    /** プロフィール更新画面に遷移DAO */
    ProfileUpdateCommitDao profileUpdateCommitDao = null;

    /**
     * ProfileUpdateCommitDaoを設定する
     * @param profileUpdateCommitDao
     */
    public void setProfileUpdateCommitDao(
            ProfileUpdateCommitDao profileUpdateCommitDao) {
        this.profileUpdateCommitDao = profileUpdateCommitDao;
    }

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.profile.service.ProfileUpdateCommitSerivce#profileUpdateCommit(net.chintai.backend.sysadmin.profile.service.bean.ProfileUpdateCommitInServiceBean)
     */
    public void profileUpdateCommit(
            ProfileUpdateCommitInServiceBean inServiceBean)
            throws ApplicationException {
        ProfileUpdateCommitParamBean paramBean = new ProfileUpdateCommitParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // ユーザ更新処理を行う
        int affected = profileUpdateCommitDao.profileUpdateCommit(paramBean);

        if (affected == 0){
            throw new ApplicationException("ERROR.M.USER.0002");
        }
    }
}