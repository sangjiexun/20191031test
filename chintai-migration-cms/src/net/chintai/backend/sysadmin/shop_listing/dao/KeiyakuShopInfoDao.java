/*
 * $Id: KeiyakuShopInfoDao.java 4257 2009-03-25 05:34:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/23     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao;

import java.util.List;

import net.chintai.backend.sysadmin.shop_listing.domain.KihonKeiyakuInfoDomin;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopAreaInfoDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopImageInfoDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopLocationInfoDomain;

/**
 * 契約店舗詳細取得DAO。
 *
 * @author Lee Hosup
 * @version $Revision: 4257 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface KeiyakuShopInfoDao {

    /**
     * 基本契約情報を取得します。
     * @param shopCd 店舗コード。
     * @return 基本契約情報リスト。
     */
    public List<KihonKeiyakuInfoDomin> searchKeiyakuBasicInfo(String shopCd);

    /**
     * 店舗画像情報を取得します。
     *
     * @param shopCd 店舗コード。
     * @return 店舗画像情報。
     */
    public ShopImageInfoDomain getShopImgInfo(String shopCd);

    /**
     * 店舗位置情報を取得します。
     *
     * @param shopCd 店舗コード。
     * @return 店舗位置情報。
     */
    public ShopLocationInfoDomain searchLocationInfo(String shopCd);

    /**
     * 有効基本契約件数を取得します。
     *
     * @param shopCd 店舗コード。
     * @return 有効な基本契約件数。
     */
    public String searchKihonKeiyakuYukouCnt(String shopCd);

    /**
     * 店舗の最寄駅情報を取得します。
     *
     * @param shopCd 店舗コード。
     * @return 最寄り駅情報
     */
    public ShopAreaInfoDomain searchAreaInfo(String shopCd);

}
