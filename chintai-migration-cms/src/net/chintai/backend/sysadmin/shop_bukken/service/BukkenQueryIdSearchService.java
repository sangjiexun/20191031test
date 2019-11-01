/*
 * $Id: BukkenQueryIdSearchService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/28  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenQueryIdSearchInServiceBean;

/**
 * 
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface BukkenQueryIdSearchService {

    public List bukkenQueryIdSearch(BukkenQueryIdSearchInServiceBean inServiceBean)
        throws InvocationTargetException,IllegalAccessException;
}
