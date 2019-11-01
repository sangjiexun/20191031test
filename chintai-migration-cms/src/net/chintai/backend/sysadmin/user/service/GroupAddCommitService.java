/*
 * $Id: GroupAddCommitService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/27  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service;

import net.chintai.backend.sysadmin.user.service.bean.GroupAddCommitInServiceBean;


/**
 * グループ追加完了するサービスクラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface GroupAddCommitService {

    public void insertGroup(GroupAddCommitInServiceBean inServiceBean)
    throws Exception;

}
