/*
 * $Id: MediaInfoUpdateCompleteDao.java 4249 2009-03-24 05:36:55Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/14     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao;

/**
 * 出稿情報編集完了DAO
 *
 * @author Lee Hosup
 * @version $Revision: 4249 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface MediaInfoUpdateCompleteDao {

    /**
     * @param dataParamBean
     */
    void updateShopMediaData(ShopListingDataParamBean dataParamBean);

    /**
     * @param shopCd
     * @return
     */
    int deleteShopMediaEki(String shopCd);

    /**
     * @param shopCd
     * @return
     */
    int deleteShopMediaCity(String shopCd);

    /**
     * @param shopCd
     * @return
     */
    int deleteShopMediaIcon(String shopCd);

}
