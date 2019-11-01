/*
 * $Id: UserUpdatePageService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/25  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.user.service.bean.UserUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.user.service.bean.UserUpdatePageOutServiceBean;


/**
 * ユーザ更新画面に遷移サービスクラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface UserUpdatePageService {

    /**
     * ユーザ更新完了
     * @return UserUpdatePageOutServiceBean
     * @param inServiceBean
     * @throws ApplicationException
     */
    public UserUpdatePageOutServiceBean 
            userUpdatePage(UserUpdatePageInServiceBean inServiceBean)
            throws ApplicationException;
}
