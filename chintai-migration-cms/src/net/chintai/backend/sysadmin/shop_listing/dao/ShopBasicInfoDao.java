/*
 * $Id: ShopBasicInfoDao.java 4246 2009-03-23 09:00:00Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/27     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao;

import net.chintai.backend.sysadmin.shop_listing.domain.ShopBasicInfoDomain;

/**
 * 店舗基本情報取得DAO。
 *
 * @author Lee Hosup
 * @version $Revision: 4246 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShopBasicInfoDao {

    /**
     * 契約店舗の基本情報を取得します。
     *
     * @param shopCd
     * @return
     */
    public ShopBasicInfoDomain searchShopBasicInfo(String shopCd);
}
