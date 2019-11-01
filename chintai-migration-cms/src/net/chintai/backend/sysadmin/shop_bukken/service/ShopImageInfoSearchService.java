/*
 * $Id: ShopImageInfoSearchService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service;

import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopImageInfoSearchInServiceBean;
import net.chintai.backend.sysadmin.shop_bukken.service.bean.ShopImageInfoSearchOutServiceBean;

/**
 * 店舗画像情報照会を提供するサービスクラス。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopImageInfoSearchService {

    /**
     * 店舗画像情報を照会する。
     * 
     * @param inServiceBean 店舗コード
     * @return 取得された店舗画像情報
     * @throws Exception
     */
    public ShopImageInfoSearchOutServiceBean shopImageInfoSearchByShopCd(
            ShopImageInfoSearchInServiceBean inServiceBean) throws Exception;

}
