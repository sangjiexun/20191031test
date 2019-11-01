/*
 * $Id: GroupUsedCountService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/12  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.user.service.bean.GroupDeleteConfirmInServiceBean;

/**
 * 削除するグループ中で、現在ユーザが使っているグループをカウントする。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface GroupUsedCountService {

    /**
     * 現在ユーザが使っているグループをカウントして、その数を渡す。
     * 
     * @param inServiceBean 削除するグループIDリスト
     * @return グループIDリスト中で、現在使っている数。
     * @throws ApplicationException
     */
    public int selectUsedGroupCount(GroupDeleteConfirmInServiceBean inServiceBean) throws Exception;
}
