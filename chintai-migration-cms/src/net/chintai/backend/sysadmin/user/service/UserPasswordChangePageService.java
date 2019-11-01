/*
 * $Id: UserPasswordChangePageService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.user.service.bean.UserPasswordChangePageInServiceBean;
import net.chintai.backend.sysadmin.user.service.bean.UserPasswordChangePageOutServiceBean;

/**
 * ユーザパスワード変更画面に遷移サービスクラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface UserPasswordChangePageService {

    /**
     * ユーザパスワード変更画面に遷移
     * @param inServiceBean
     * @throws ApplicationException
     */
    public UserPasswordChangePageOutServiceBean 
        userPasswordChangePage(UserPasswordChangePageInServiceBean inServiceBean)
            throws ApplicationException;
}