/*
 * $Id: MediaInfoRegisterCompleteDao.java 4257 2009-03-25 05:34:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/03     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao;

/**
 * 出稿情報登録DAO。
 *
 * @author Lee Hosup
 * @version $Revision: 4257 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface MediaInfoRegisterCompleteDao {

    /**
     * 店舗リスティング出稿情報テーブルを登録します。
     *
     * @param paramBean
     * @return
     */
    public String registerShopListingData(ShopListingDataParamBean paramBean);

    /**
     * 店舗リスティングアイコン情報テーブルを登録します。
     *
     * @param paramBean
     * @return
     */
    public String registerShopListingIcon(ShopListingIconParamBean paramBean);

    /**
     * 店舗リスティング駅テーブルを登録します。
     *
     * @param paramBean
     * @return
     */
    public String registerShopListingEki(ShopListingEkiParamBean paramBean);

    /**
     * 店舗リスティング市区町村を登録します。
     *
     * @param paramBean
     * @return
     */
    public String registerShopListingCity(ShopListingCityParamBean paramBean);

    /**
     * 出稿情報(仮保存)件数を取得します。
     *
     * @param shopCd 店舗コード。
     * @return 仮保存中の出稿情報件数。
     */
    public int searchTmpMediaInfo(String shopCd);

}
