/*
 * $Id: ProfileInfoDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/03  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.profile.dao;

import net.chintai.backend.sysadmin.profile.domain.Profile;

/**
 * プロフィール詳細DAO
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ProfileInfoDao {

    /**
     * プロフィール詳細
     * @param paramBean
     * @return Profile
     */
    public Profile profileInfo(ProfileInfoParamBean paramBean);
}