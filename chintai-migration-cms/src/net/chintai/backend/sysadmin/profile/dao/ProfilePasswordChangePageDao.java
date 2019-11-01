/*
 * $Id: ProfilePasswordChangePageDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/04  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.profile.dao;

import net.chintai.backend.sysadmin.profile.domain.Profile;

/**
 * プロフィールパスワード変更DAO
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ProfilePasswordChangePageDao {
    
    /**
     * プロフィール詳細
     * @param paramBean
     * @return Profile
     */
    public Profile profilePasswordChangPage(ProfilePasswordChangePageParamBean paramBean);
}