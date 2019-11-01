/*
 * $Id: ProfilePasswordChangePageService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/04  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.profile.service;

import java.lang.reflect.InvocationTargetException;

import net.chintai.backend.sysadmin.profile.service.bean.ProfilePasswordChangePageInServiceBean;
import net.chintai.backend.sysadmin.profile.service.bean.ProfilePasswordChangePageOutServiceBean;

/**
 * プロフィールパスワード変更サービスクラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ProfilePasswordChangePageService {

    /**
     * プロフィールパスワード変更
     * @param inServiceBean
     * @throws InvocationTargetException, IllegalAccessException
     */
    public ProfilePasswordChangePageOutServiceBean profilePasswordChangePage
        (ProfilePasswordChangePageInServiceBean inServiceBean)
            throws InvocationTargetException, IllegalAccessException;   
}