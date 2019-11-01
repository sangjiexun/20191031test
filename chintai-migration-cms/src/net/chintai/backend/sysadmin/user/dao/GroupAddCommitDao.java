/*
 * $Id: GroupAddCommitDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/27  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao;

import net.chintai.backend.sysadmin.user.domain.Authority;
import net.chintai.backend.sysadmin.user.domain.Group;

/**
 * グループ追加完了のDAO
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface GroupAddCommitDao {

    /**
     * グループを追加する。
     * 
     * @param group グループ
     */
    public void insertGroup(Group group);

    /**
     * グループの権限を追加する。
     * 
     * @param authority 権限
     */
    public void insertGroupByAuthority(Authority authority);

    /**
     * 追加するグループのグループIDを取得する。
     * 
     * @return グループID
     */
    public int selectSeqGroupID();

}
