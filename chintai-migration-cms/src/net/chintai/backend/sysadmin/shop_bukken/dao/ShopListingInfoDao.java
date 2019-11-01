package net.chintai.backend.sysadmin.shop_bukken.dao;

import net.chintai.backend.sysadmin.shop_bukken.domain.ShopListingInfoDomain;


/**
 * 契約明細（数量あり）契約情報取得DAO
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopListingInfoDao {

    /**
     * 契約情報を検索
     * @param paramBean 検索パラメータ（店舗コード）
     * @return 店舗リスティング契約情報
     */
    //public Object getContractInfo(ShopListingInfoParamBean paramBean);

    public ShopListingInfoDomain getContractInfo(ShopListingInfoParamBean paramBean);
}
