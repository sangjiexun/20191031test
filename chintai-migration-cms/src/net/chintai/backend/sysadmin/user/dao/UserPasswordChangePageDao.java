/*
 * $Id: UserPasswordChangePageDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao;

import net.chintai.backend.sysadmin.user.domain.UserDomain;

/**
 * ユーザパスワード変更画面に遷移DAO
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface UserPasswordChangePageDao {

    /**
     * ユーザパスワード変更画面に遷移
     * @param paramBean ユーザID
     * @return UserDomain ユーザ情報で最新更新日付
     */
    public UserDomain userPasswordChangePage(UserPasswordChangePageParamBean paramBean);
}