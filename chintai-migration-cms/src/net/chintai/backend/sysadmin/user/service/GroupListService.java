/*
 * $Id: GroupListService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/18  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service;

import java.util.List;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;

/**
 * グループ一覧の取得処理を提供するサービスクラス。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface GroupListService {
    
    /**
     * グループ一覧を取得します。
     * @return グループ一覧
     * @throws Exception
     */
    public List getGroupList() throws ApplicationException ;
    
    /**
     * グループの権限一覧を取得します。
     * @return グループの権限一覧
     * @throws Exception
     */
    public List getAuthorityList() throws ApplicationException ;

}
