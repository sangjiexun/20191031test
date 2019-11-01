/*
 * $Id: UserDeleteConfirmService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/25  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service;

import java.util.List;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.user.service.bean.UserDeleteConfirmInServiceBean;


/**
 * ユーザの削除リストを取得するサービスクラス。
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface UserDeleteConfirmService {

    /**
     * ユーザの削除リストを取得する
     * @return List
     * @param  inServiceBean
     * @throws ApplicationException
     */

    public List userDeleteConfirm(UserDeleteConfirmInServiceBean inServiceBean)
        throws ApplicationException;
}
