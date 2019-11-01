/*
 * LoginDao.java
 * ---------------------------------------------------------
 * 更新日      更新者     内容
 * ---------------------------------------------------------
 * 2007/06/15  BGT)児島   新規作成
 *
 */
package net.chintai.backend.sysadmin.login.dao;

import net.chintai.backend.sysadmin.login.domain.User;

/**
 * ユーザーテーブルの DAO です。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface LoginDao {

    /**
     * ユーザーIDを指定してユーザーデータを取得します。
     * @param userId ユーザーID
     * @return ユーザーデータ
     */
    public User selectUser(String userId);

}