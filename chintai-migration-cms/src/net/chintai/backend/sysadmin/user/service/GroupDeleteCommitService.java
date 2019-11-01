/*
 * $Id: GroupDeleteCommitService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/27  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.user.service.bean.GroupDeleteCommitInServiceBean;

/**
 * グループを削除するサービスクラス。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface GroupDeleteCommitService {

    /**
     * ユーザーグループを削除します。
     * @param inServiceBean グルプID、最新更新日付
     * @throws ApplicationException
     */
    public void deleteGroupByGroupId(GroupDeleteCommitInServiceBean inServiceBean) throws ApplicationException;

}
