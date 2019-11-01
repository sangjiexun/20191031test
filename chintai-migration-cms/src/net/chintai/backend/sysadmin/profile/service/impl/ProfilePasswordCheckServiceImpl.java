/*
 * $Id: ProfilePasswordCheckServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/26  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.profile.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.profile.dao.ProfilePasswordCheckDao;
import net.chintai.backend.sysadmin.profile.dao.ProfilePasswordCheckParamBean;
import net.chintai.backend.sysadmin.profile.service.ProfilePasswordCheckService;
import net.chintai.backend.sysadmin.profile.service.bean.ProfilePasswordCheckInServiceBean;

/**
 * ProfilePasswordCheckServiceインターフェースの実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ProfilePasswordCheckServiceImpl implements
        ProfilePasswordCheckService {

    /** プロフィールパスワードチェックDAO */
    private ProfilePasswordCheckDao profilePasswordCheckDao = null;

    /**
     * ProfilePasswordCheckDaoを設定する
     * @param profilePasswordCheckDao
     */
    public void setProfilePasswordCheckDao(
            ProfilePasswordCheckDao profilePasswordCheckDao) {
        this.profilePasswordCheckDao = profilePasswordCheckDao;
    }

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.profile.service.ProfilePasswordCheckService#profilePasswordCheck(net.chintai.backend.sysadmin.profile.service.bean.ProfilePasswordCheckInServiceBean)
     */
    public int profilePasswordCheck(
            ProfilePasswordCheckInServiceBean inServiceBean)
            throws InvocationTargetException, IllegalAccessException {

        ProfilePasswordCheckParamBean paramBean =
            new ProfilePasswordCheckParamBean();
        
        // ParamBeanにユーザID,現在のパスワード設定
        BeanUtils.copyProperties(paramBean, inServiceBean);
        
        // プロフィールパスワードチェック
        return profilePasswordCheckDao.profilePasswordCheck(paramBean);
    }
}