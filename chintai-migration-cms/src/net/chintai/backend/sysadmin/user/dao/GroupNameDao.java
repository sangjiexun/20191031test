/*
 * $Id: GroupNameDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/25  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao;

import net.chintai.backend.sysadmin.user.domain.UserDomain;

/**
 * グループ名取得DAO
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface GroupNameDao {

    /**
     * ユーザIDで合っているグループ名を取得する
     * @param paramBean ユーザID
     * @return UserDomain グループ名
     */
    public UserDomain getGroupName(GroupNameParamBean paramBean);
}
