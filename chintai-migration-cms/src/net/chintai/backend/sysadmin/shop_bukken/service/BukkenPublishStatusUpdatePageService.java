/*
 * $Id: BukkenPublishStatusUpdatePageService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/02  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import java.lang.reflect.InvocationTargetException;

import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenPublishStatusUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.BukkenPublishStatusUpdatePageOutServiceBean;

/**
 * 物件掲載状態変更画面に遷移サービスクラス
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface BukkenPublishStatusUpdatePageService {

    /**
     * 物件詳細情報
     * @return BukkenPublishStatusUpdatePageOutServiceBean
     * @param inServiceBean
     * @throws InvocationTargetException, IllegalAccessException
     */
    public BukkenPublishStatusUpdatePageOutServiceBean bukkenPublishStatusUpdatePage(
            BukkenPublishStatusUpdatePageInServiceBean inServiceBean) throws InvocationTargetException,
            IllegalAccessException;
}