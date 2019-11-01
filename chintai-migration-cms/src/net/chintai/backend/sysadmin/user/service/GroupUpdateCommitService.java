/*
 * $Id: GroupUpdateCommitService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/26  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service;

import java.lang.reflect.InvocationTargetException;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.user.service.bean.GroupUpdateCommitInServiceBean;

/**
 * グループの権限を更新するサービスクラス。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface GroupUpdateCommitService {

    /**
     * グループ削除完了
     * @param inServiceBean 削除リスト
     * @throws InvocationTargetException, IllegalAccessException
     */
    public void updateGroup(GroupUpdateCommitInServiceBean inServiceBean) throws ApplicationException;

}
