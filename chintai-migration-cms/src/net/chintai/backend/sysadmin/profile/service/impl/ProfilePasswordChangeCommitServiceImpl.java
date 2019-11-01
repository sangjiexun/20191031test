/*
 * $Id: ProfilePasswordChangeCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
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
import net.chintai.backend.sysadmin.profile.dao.ProfilePasswordChangeCommitDao;
import net.chintai.backend.sysadmin.profile.dao.ProfilePasswordChangeCommitParamBean;
import net.chintai.backend.sysadmin.profile.service.ProfilePasswordChangeCommitService;
import net.chintai.backend.sysadmin.profile.service.bean.ProfilePasswordChangeCommitInServiceBean;

/**
 * ProfilePasswordChangeCommitServiceインターフェースの実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ProfilePasswordChangeCommitServiceImpl implements
        ProfilePasswordChangeCommitService {

    /** プロフィールパスワード変更完了DAO */
    private ProfilePasswordChangeCommitDao profilePasswordChangeCommitDao = null;

    /**
     * ProfilePasswordChangeCommitDaoを設定する
     * @param profilePasswordChangeCommitDao
     */
    public void setProfilePasswordChangeCommitDao(
            ProfilePasswordChangeCommitDao profilePasswordChangeCommitDao) {
        this.profilePasswordChangeCommitDao = profilePasswordChangeCommitDao;
    }

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.profile.service.ProfilePasswordChangeCommitService#profilePasswordChangeCommit(net.chintai.backend.sysadmin.profile.service.bean.ProfilePasswordChangeCommitInServiceBean)
     */
    public void profilePasswordChangeCommit(
            ProfilePasswordChangeCommitInServiceBean inServiceBean)
            throws ApplicationException {

        ProfilePasswordChangeCommitParamBean paramBean =
            new ProfilePasswordChangeCommitParamBean();
        
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        
        // プロフィールパスワード変更処理を行う
        int affected = profilePasswordChangeCommitDao.profilePasswordChangeCommit(paramBean);
        
        if (affected == 0){
            throw new ApplicationException("ERROR.M.USER.0002");
        }
    }
}