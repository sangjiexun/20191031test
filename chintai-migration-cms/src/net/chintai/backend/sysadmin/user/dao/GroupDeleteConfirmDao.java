/*
 * $Id: GroupDeleteConfirmDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/27  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao;

import java.util.List;


/**
 * グループ削除用として削除するグルプを照会する。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface GroupDeleteConfirmDao {

    /**
     * グループID別、グループを照会する。
     * 
     * @param paramBean inServiceBean 検索するグループのグループID
     * @return 検索結果のグループリスト
     */
    public List selectGroupListByGroupId(GroupDeleteConfirmParamBean paramBean);
    
    /**
     * 選択されたグループを削除する為に、現在使っているグループをカウントする。
     * 
     * @param paramBean グループリスト
     * @return 現在使っているグループのカウント数。
     */
    public int selectUsedGroupCount(GroupDeleteConfirmParamBean paramBean);

}
