/*
 * $Id: BukkenCodeSearchService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/28  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenCodeSearchInServiceBean;

/**
 * 物件検索(物件コード) Service
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface BukkenCodeSearchService {

    /**
     * 指定された検索条件で検索を実行します。
     * @param inServiceBean 検索条件Bean
     * @return 検索結果List
     * @throws  InvocationTargetException, IllegalAccessException
     */
    public List bukkenCodeSearch(BukkenCodeSearchInServiceBean inServiceBean)
        throws  InvocationTargetException, IllegalAccessException;
}