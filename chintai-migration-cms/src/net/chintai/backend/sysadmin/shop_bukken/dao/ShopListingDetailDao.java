package net.chintai.backend.sysadmin.shop_bukken.dao;

import java.util.List;


/**
 * 店舗リスティング情報取得DAO
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopListingDetailDao {

    /**
     * 店舗リスティング情報を取得します。
     * @param paramBean 検索パラメータ（取引先シーケンス番号）
     * @return 店舗リスティング情報
     */
    public List getShopListingDetail(
            ShopListingDetailParamBean paramBean);
}
