package net.chintai.backend.sysadmin.shop_bukken.dao;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.domain.ShopListingDetailDomain;

/**
 * 店舗リスティング設定情報確認DAO
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopListingDeleteConfirmDao {

    /**
     * 削除する店舗リスティング情報を取得
     * @param paramBean 検索パラメータ（取引先シーケンス番号、適用月）
     * @return 店舗リスティング情報
     */
    public List<ShopListingDetailDomain> getShopListingForDelete(
            ShopListingDeleteConfirmParamBean paramBean);

}
