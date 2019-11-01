/*
 * $Id: UserUpdatePageDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/25  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao;

import net.chintai.backend.sysadmin.user.domain.UserDomain;

/**
 * ユーザ更新画面に遷移のDAO
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface UserUpdatePageDao {

    /**
     * ユーザIDでユーザ更新する情報を取得する。
     * @param paramBean ユーザID
     * @return UserDomain ユーザ更新情報
     */
    public UserDomain userUpdatePage(UserUpdatePageParamBean paramBean);
}