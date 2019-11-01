/*
 * $Id: GroupDeleteConfirmService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/27  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service;

import java.util.List;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.user.service.bean.GroupDeleteConfirmInServiceBean;


/**
 * グループ削除確認用として削除するグループを照会するサービスクラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface GroupDeleteConfirmService {

    /**
     * グループID別、グループを照会する。
     * 
     * @param inServiceBean 検索するグループのグループID
     * @return 検索結果のグループリスト
     * @throws Exception 例外
     */
    public List getGroupListByGroupId (GroupDeleteConfirmInServiceBean inServiceBean) throws ApplicationException ;

}
