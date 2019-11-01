/*
 * $Id: ShopListingDataDao.java 4246 2009-03-23 09:00:00Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/03     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao;

/**
 * 店舗リスティングデータテーブルDAO。
 *
 * @author Lee Hosup
 * @version $Revision: 4246 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopListingDataDao {

    /**
     * 現在Web表示中の店舗リスティングデータの件数を取得します。
     *
     * @param shopCd
     * @return
     */
    public int selectWebDisplayCnt(String shopCd);

}
