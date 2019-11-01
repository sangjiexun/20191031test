/*
 * $Id: ProfileUpdatePageServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/03  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.profile.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.profile.dao.ProfileUpdatePageDao;
import net.chintai.backend.sysadmin.profile.dao.ProfileUpdatePageParamBean;
import net.chintai.backend.sysadmin.profile.domain.Profile;
import net.chintai.backend.sysadmin.profile.service.ProfileUpdatePageService;
import net.chintai.backend.sysadmin.profile.service.bean.ProfileUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.profile.service.bean.ProfileUpdatePageOutServiceBean;

/**
 * ProfileUpdatePageServiceインターフェースの実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ProfileUpdatePageServiceImpl implements ProfileUpdatePageService {

    /** プロフィール更新画面に遷移DAO */
    private ProfileUpdatePageDao profileUpdatePageDao = null;

    /**
     * ProfileUpdatePageDaoを設定する
     * @param profileUpdatePageDao
     */
    public void setProfileUpdatePageDao(ProfileUpdatePageDao profileUpdatePageDao) {
        this.profileUpdatePageDao = profileUpdatePageDao;
    }

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.profile.service.ProfileUpdatePageService#profileUpdatePage(net.chintai.backend.sysadmin.profile.service.bean.ProfileUpdatePageInServiceBean)
     */
    public ProfileUpdatePageOutServiceBean profileUpdatePage(
            ProfileUpdatePageInServiceBean inServiceBean)
            throws InvocationTargetException, IllegalAccessException {

        // プロフィールIDをParamBeanに設定
        ProfileUpdatePageParamBean paramBean = new ProfileUpdatePageParamBean();
        BeanUtils.copyProperties(paramBean, inServiceBean);


        // プロフィール詳細情報を取得
        Profile profile = (Profile)profileUpdatePageDao.profileUpdatePage(paramBean);
        
        ProfileUpdatePageOutServiceBean outServiceBean =
            new ProfileUpdatePageOutServiceBean();
        
        // 取得した情報をOutServiceBeanに設定
        BeanUtils.copyProperties(outServiceBean, profile);

        return outServiceBean;
    }
}