package net.chintai.backend.sysadmin.shop_bukken.dao;

/**
 * 店舗リスティング設定情報削除DAO
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopListingDeleteCommitDao {

    /**
     * 契約情報を削除します。
     * @param paramBean 検索パラメータ（取引先シーケンス番号、適用月、最終更新日時）
     * @return 削除処理した件数
     */
    public int deleteKeiyakuInfo(ShopListingDeleteCommitParamBean paramBean);
}
