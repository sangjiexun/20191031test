/*
 * $Id: UserInfoService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/26  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.user.service.bean.UserInfoInServiceBean;
import net.chintai.backend.sysadmin.user.service.bean.UserInfoOutServiceBean;

/**
 * ユーザ詳細情報サービスクラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface UserInfoService {

    /**
     * ユーザ詳細情報
     * @return UserInfoOutServiceBean
     * @param inServiceBean
     * @throws ApplicationException
     */
    public UserInfoOutServiceBean userInfo(UserInfoInServiceBean inServiceBean)
        throws ApplicationException;
}