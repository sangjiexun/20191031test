/*
 * $Id: UserPasswordChangeCommitService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/26  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.user.service.bean.UserPasswordChangeCommitInServiceBean;

/**
 * ユーザパスワード変更サービスクラス
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface UserPasswordChangeCommitService {

    /**
     * ユーザパスワード変更
     * 
     * @param inServiceBean
     * @throws ApplicationException
     */
    public void userPasswordChange(UserPasswordChangeCommitInServiceBean inServiceBean)
            throws ApplicationException;
}