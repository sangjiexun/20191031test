/*
 * $Id: UserAddConfirmService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/20  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service;

import java.lang.reflect.InvocationTargetException;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.user.service.bean.UserAddConfirmInServiceBean;

/**
 * ユーザIDの有無をチェックサービスクラス。
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface UserAddConfirmService {

    /**
     * ユーザIDの有無をチェックします。
     * @return int
     * @param inServiceBean
     * @throws ApplicationException
     */
    public int userAddConfirm(UserAddConfirmInServiceBean inServiceBean) throws InvocationTargetException,
            IllegalAccessException;
}
