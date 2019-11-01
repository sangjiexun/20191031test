/*
 * $Id: UserListService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/20  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * ユーザリストを取得するサービスクラス。
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface UserListService {

    /**
     * ユーザリストを取得します。
     * @return List
     * @throws InvocationTargetException, IllegalAccessException
     */
    public List userList() throws InvocationTargetException, IllegalAccessException;
}
