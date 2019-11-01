/*
 * $Id: GroupDeleteCommitDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/27  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao;


/**
 * グループ削除完了のDAO
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface GroupDeleteCommitDao {

    /**
     * グループを削除する。
     *
     * @param paramBean
     */
    public int deleteGroupByGroupId(GroupDeleteCommitParamBean paramBean);

    /**
     * グループの権限を削除する。
     * 
     * @param paramBean
     */
    public int deleteAuthorityByGroupId(GroupDeleteCommitParamBean paramBean);

}
