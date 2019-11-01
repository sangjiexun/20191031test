/*
 * $Id: MediaInfoUpdatePageDao.java 4259 2009-03-25 06:22:41Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/12     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao;

import java.util.List;

import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingCityDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingDataDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingEkiDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingIconDomain;

/**
 * 出稿情報編集画面データ取得用DAO
 *
 * @author Lee Hosup
 * @version $Revision: 4259 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface MediaInfoUpdatePageDao {

    /**
     * 店舗リスティングデータテーブルの情報を取得します。
     *
     * @param shopCd 店舗コード。
     * @return 店舗リスティングデータテーブルの情報。
     */
    ShopListingDataDomain searchMediaInfoData(ShopListingDataParamBean paramBean);

    /**
     * 店舗リスティング駅テーブルの情報を取得します。
     *
     * @param shopCd 店舗コード。
     * @return 店舗リスティング駅テーブルの情報。
     */
    List<ShopListingEkiDomain> searchMedaiInfoEki(ShopListingEkiParamBean paramBean);

    /**
     * 店舗リスティング市区町村テーブルの情報を取得します。
     *
     * @param shopCd 店舗コード。
     * @return 店舗リスティング市区町村テーブルの情報。
     */
    List<ShopListingCityDomain> searchMedaiInfoCity(ShopListingCityParamBean paramBean);

    /**
     * 店舗リスティングアイコンテーブルの情報を取得します。
     *
     * @param shopCd 店舗コード。
     * @return 店舗リスティングアイコンテーブルの情報。
     */
    List<ShopListingIconDomain> searchMedaiInfoIcon(ShopListingIconParamBean paramBean);
}
