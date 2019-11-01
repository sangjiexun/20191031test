/*
 * $Id: ShopBasicInfoService.java 4246 2009-03-23 09:00:00Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/24     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service;

import net.chintai.backend.sysadmin.shop_listing.service.bean.ShopBasicInfoOutServiceBean;

/**
 * 契約情報登録画面表示サービス。
 *
 * @author Lee Hosup
 * @version $Revision: 4246 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopBasicInfoService {

    /**
     * 店舗基本情報を取得します。
     * @param shopCd
     * @return
     */
    public ShopBasicInfoOutServiceBean searchShopBasicInfo(String shopCd);

}
