/*
 * $Id: UserListDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/20  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao;

import java.util.List;


/**
 * ユーザリストの取得するDAO
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface UserListDao {
    
    /**
     * ユーザリストを取得する
     * @return List ユーザリスト
     */
    public List userList();
}
