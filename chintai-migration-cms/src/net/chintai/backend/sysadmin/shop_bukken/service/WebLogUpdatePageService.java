/*
 * $Id: WebLogUpdatePageService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import java.lang.reflect.InvocationTargetException;

import net.chintai.backend.sysadmin.shop_bukken.service.bean.WebLogUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.WebLogUpdatePageOutServiceBean;

/**
 * Webログ利用可否画面に遷移サービス
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface WebLogUpdatePageService {

    /**
     * Webログ利用可否画面に遷移
     * @return WebLogUpdatePageOutServiceBean
     * @param inServiceBean
     * @throws InvocationTargetException, IllegalAccessException
     */
    public WebLogUpdatePageOutServiceBean webLogUpdatePage(WebLogUpdatePageInServiceBean inServiceBean)
            throws InvocationTargetException, IllegalAccessException;
}