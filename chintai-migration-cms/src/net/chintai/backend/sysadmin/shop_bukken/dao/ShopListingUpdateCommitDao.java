package net.chintai.backend.sysadmin.shop_bukken.dao;

/**
 * 店舗リスティング設定情報更新DAO
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopListingUpdateCommitDao {

    /**
     * 店舗リスティング設定情報を更新します。
     * @param paramBean 更新パラメータ
     * @return 更新件数
     */
    public int updateShopListing(ShopListingUpdateCommitParamBean paramBean);

}
