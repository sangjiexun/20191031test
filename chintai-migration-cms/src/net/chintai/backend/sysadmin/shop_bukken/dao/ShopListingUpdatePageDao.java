package net.chintai.backend.sysadmin.shop_bukken.dao;

import net.chintai.backend.sysadmin.shop_bukken.domain.ShopListingDetailDomain;

/**
 * 店舗リスティング設定情報取得DAO
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopListingUpdatePageDao {

    /**
     * 枠情報を取得します。
     * @param paramBean 検索パラメータ（取引先シーケンス番号、適用月）
     * @return 店舗リスティング情報
     */
    public ShopListingDetailDomain getShopListing(
            ShopListingUpdatePageParamBean paramBean);

}
