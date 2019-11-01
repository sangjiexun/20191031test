/*
 * $Id: GroupListDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/18  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao;

import java.util.List;


/**
 * グループリストの DAO です。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface GroupListDao {
    
    /**
     * グループの全件を取得します。
     * @return List グループリスト
     */
    public List getGroupList();
    
    /**
     * グループの権限の全件を取得します。
     * @return List グループリスト
     */
    public List getAuthorityList();

}
