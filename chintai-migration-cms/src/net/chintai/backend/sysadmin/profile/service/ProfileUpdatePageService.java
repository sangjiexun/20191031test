/*
 * $Id: ProfileUpdatePageService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/03  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.profile.service;

import java.lang.reflect.InvocationTargetException;

import net.chintai.backend.sysadmin.profile.service.bean.ProfileUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.profile.service.bean.ProfileUpdatePageOutServiceBean;

/**
 * プロフィール更新画面に遷移サービスクラス。
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ProfileUpdatePageService {

    /**
     * プロフィール詳細情報
     * @return ProfileInfoOutServiceBean
     * @param inServiceBean
     * @throws InvocationTargetException, IllegalAccessException
     */
    public ProfileUpdatePageOutServiceBean profileUpdatePage
        (ProfileUpdatePageInServiceBean inServiceBean)
            throws InvocationTargetException, IllegalAccessException;
}