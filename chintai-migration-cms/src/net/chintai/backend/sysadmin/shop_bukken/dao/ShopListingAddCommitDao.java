package net.chintai.backend.sysadmin.shop_bukken.dao;


/**
 * 店舗リスティング設定情報更新DAO
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopListingAddCommitDao {

    /**
     * 契約情報を登録します。
     * @param paramBean 登録パラメータ
     */
    public void insertShopListing(ShopListingAddCommitParamBean paramBean);

}
