/*
 * $Id: GroupUpdateCommitDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/26  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao;

import net.chintai.backend.sysadmin.user.domain.Authority;


/**
 * グループ更新完了のDAO
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface GroupUpdateCommitDao {

    /**
     * グループ名を変更します。
     * @param paramBean
     */
    public void updateGroupName(GroupUpdateCommitParamBean paramBean);

    /**
     * グループに紐づく権限を削除します。
     * @param paramBean
     */
    public void deleteGroupAuthority(GroupUpdateCommitParamBean paramBean);

    /**
     * グループに紐づく権限を設定します。
     * @param authority
     */
    public void insertGroupByAuthority(Authority authority);
    
    /**
     * 更新可能かどうかをチェックします。<br>
     * 他のユーザによって先に更新されている場合は更新できません。
     * @return 更新不可:0, 更新可:1
     */
    public int selectUpdatable(GroupUpdateCommitParamBean paramBean);

}
