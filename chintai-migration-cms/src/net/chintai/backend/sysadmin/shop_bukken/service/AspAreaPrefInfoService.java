/*
 * $Id: AspAreaPrefInfoService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/11  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.service.bean.AspAreaPrefInfoOutServiceBean;

/**
 * 不動産ASP設定で使用するエリアと都道府県を照会する。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AspAreaPrefInfoService {

    /**
     * エリアと都道府県を照会する。
     * 
     * @return エリアと都道府県リスト
     * @throws Exception
     */
    public List<AspAreaPrefInfoOutServiceBean> aspAreaPrefInfoSearch() throws Exception;

}
