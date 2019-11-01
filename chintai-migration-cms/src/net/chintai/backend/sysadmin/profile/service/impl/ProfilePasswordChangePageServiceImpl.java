/*
 * $Id: ProfilePasswordChangePageServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/04  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.profile.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.profile.dao.ProfilePasswordChangePageDao;
import net.chintai.backend.sysadmin.profile.dao.ProfilePasswordChangePageParamBean;
import net.chintai.backend.sysadmin.profile.domain.Profile;
import net.chintai.backend.sysadmin.profile.service.ProfilePasswordChangePageService;
import net.chintai.backend.sysadmin.profile.service.bean.ProfilePasswordChangePageInServiceBean;
import net.chintai.backend.sysadmin.profile.service.bean.ProfilePasswordChangePageOutServiceBean;

/**
 * ProfilePasswordChangePageServiceインターフェースの実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ProfilePasswordChangePageServiceImpl implements
        ProfilePasswordChangePageService {

    /** プロフィールパスワード変更画面に遷移DAO */
    private ProfilePasswordChangePageDao profilePasswordChangePageDao = null;

    /**
     * ProfilePasswordChangePageDaoを設定する
     * @param profilePasswordChangePageDao
     */
    public void setProfilePasswordChangePageDao(
            ProfilePasswordChangePageDao profilePasswordChangePageDao) {
        this.profilePasswordChangePageDao = profilePasswordChangePageDao;
    }

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.profile.service.ProfilePasswordChangePageService#profilePasswordChangePage(net.chintai.backend.sysadmin.profile.service.bean.ProfilePasswordChangeInServiceBean)
     */
    public ProfilePasswordChangePageOutServiceBean profilePasswordChangePage(
            ProfilePasswordChangePageInServiceBean inServiceBean)
            throws InvocationTargetException, IllegalAccessException {

        // プロフィールIDをParamBeanに設定
        ProfilePasswordChangePageParamBean paramBean =
            new ProfilePasswordChangePageParamBean();
        BeanUtils.copyProperties(paramBean, inServiceBean);

        // プロフィール詳細情報を取得
        Profile profile =
            profilePasswordChangePageDao.profilePasswordChangPage(paramBean);

        ProfilePasswordChangePageOutServiceBean outServiceBean =
            new ProfilePasswordChangePageOutServiceBean();

        // 取得した情報をOutServiceBeanに設定
        BeanUtils.copyProperties(outServiceBean, profile);      

        return outServiceBean;
    }
}