/*
 * $Id: GroupNameService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/26  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service;

import java.lang.reflect.InvocationTargetException;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.user.service.bean.GroupNameInServiceBean;

/**
 * ユーザ更新確認サービスクラス
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface GroupNameService {

    /**
     * ユーザ更新確認
     * @param inServiceBean 更新データ
     * @return グループ名
     * @throws InvocationTargetException, IllegalAccessException
     */
    public String getGroupName(GroupNameInServiceBean inServiceBean) throws ApplicationException;
}
