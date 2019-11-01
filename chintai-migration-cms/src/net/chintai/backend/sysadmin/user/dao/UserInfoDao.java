/*
 * $Id: UserInfoDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/26  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao;

import net.chintai.backend.sysadmin.user.domain.UserDomain;

/**
 * ユーザ詳細のDAO
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface UserInfoDao {

    /**
     * ユーザ詳細情報を取得する
     * @param paramBean ユーザID
     * @return UserDomain ユーザ詳細情報
     */
    public UserDomain userInfo(UserInfoParamBean paramBean);
}