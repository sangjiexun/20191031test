/*
 * $Id: AspPrefInfoService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/11  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.domain.AspPrefInfo;

/**
 * 不動産ASP設定で使用する都道府県を照会する。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AspPrefInfoService {

    /**
     * 都道府県を照会する。
     * 
     * @return 都道府県
     * @throws Exception
     */
    public List<AspPrefInfo> aspAreaPrefInfoSearch() throws Exception;

}
