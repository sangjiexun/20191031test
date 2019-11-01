/*
 * $Id: MediaInfoConfirmDao.java 4324 2009-08-03 04:13:24Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/12  BGT)李昊燮     新規作成
 * 2009/08/03  BGT)李昊燮     エイブルリニューアル検討支援対応
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao;

import java.util.List;

import net.chintai.backend.sysadmin.shop_listing.domain.KihonKeiyakuInfoDomin;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingCityDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingEkiDomain;

/**
 * 出稿情報確認画面DAO(更新/登録画面共用)
 *
 * @author Lee Hosup
 * @version $Revision: 4324 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface MediaInfoConfirmDao {

    /**
     * 選択された出稿対象駅情報を取得します。
     *
     * @param paramBean 検索条件。
     * @return 出稿対象駅情報。
     */
    public ShopListingEkiDomain searchEkiInfo(EkiInfoSearchParamBean paramBean);

    /**
     * 選択された出稿対象市区町村情報を取得します。
     *
     * @param name 検索条件。
     * @return 出稿対象市区町村情報。
     */
    public List<ShopListingCityDomain> searchCityInfos(List<String> name);

    /**
     * 選択された出稿対象市区町村情報を取得します。
     *
     * @param name 検索条件。
     * @return 出稿対象市区町村情報。
     */
    public ShopListingCityDomain searchCityInfo(String string);

    /**
     * 出稿対象駅/市区町村上限数を取得します。
     * @param shopCd
     * @return 出稿対象駅/市区町村上限数
     */
    public KihonKeiyakuInfoDomin searchMediaCntLimit(String shopCd);

}
