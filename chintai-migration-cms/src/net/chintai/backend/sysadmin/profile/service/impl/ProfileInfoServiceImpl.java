/*
 * $Id: ProfileInfoServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/03  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.profile.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.profile.dao.ProfileInfoDao;
import net.chintai.backend.sysadmin.profile.dao.ProfileInfoParamBean;
import net.chintai.backend.sysadmin.profile.domain.Profile;
import net.chintai.backend.sysadmin.profile.service.ProfileInfoService;
import net.chintai.backend.sysadmin.profile.service.bean.ProfileInfoInServiceBean;
import net.chintai.backend.sysadmin.profile.service.bean.ProfileInfoOutServiceBean;

/**
 * ProfileInfoServiceインターフェースの実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ProfileInfoServiceImpl implements ProfileInfoService {

    /** プロフィール詳細DAO */
    private ProfileInfoDao profileInfoDao = null;

    /**
     * ProfileInfoDaoを設定する
     * @param profileInfoDao
     */
    public void setProfileInfoDao(ProfileInfoDao profileInfoDao) {
        this.profileInfoDao = profileInfoDao;
    }

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.profile.service.ProfileInfoService#profileInfo(net.chintai.backend.sysadmin.profile.dao.ProfileInfoParamBean)
     */
    public ProfileInfoOutServiceBean profileInfo(ProfileInfoInServiceBean inServiceBean)
        throws InvocationTargetException, IllegalAccessException {

        // プロフィールIDをParamBeanに設定
        ProfileInfoParamBean paramBean = new ProfileInfoParamBean();
        BeanUtils.copyProperties(paramBean, inServiceBean);

        // プロフィール詳細情報を取得
        Profile profile = profileInfoDao.profileInfo(paramBean);
        
        ProfileInfoOutServiceBean outServiceBean = new ProfileInfoOutServiceBean();
        
        // 取得した情報をOutServiceBeanに設定
        BeanUtils.copyProperties(outServiceBean, profile);
        
        return outServiceBean;
    }
}