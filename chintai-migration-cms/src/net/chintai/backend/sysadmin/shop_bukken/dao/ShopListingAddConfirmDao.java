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
public interface ShopListingAddConfirmDao {

    /**
     * 登録する店舗リスティング情報と同じ適用月のデータがあるかを確認
     * @param paramBean 登録パラメータ（取引先シーケンス、適用月）
     * @return 検索結果件数
     */
    public int checkAppliyYmdh(ShopListingKikanChkBean paramBean);

    /**
     * @param paramBean
     * @return
     */
    public List<ShopListingKikanChkBean> checkKeiyakuEndDt(ShopListingAddConfirmParamBean paramBean);

    /**
     * @param paramBean
     * @return
     */
    public ShopListingKikanChkBean viewCheck(ShopListingAddConfirmParamBean paramBean);
}
