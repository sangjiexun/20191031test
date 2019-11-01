/*
 * $Id: CouponEditPageDao.java 4246 2009-03-23 09:00:00Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/05     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao;

import java.util.List;

import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingCouponDomain;

/**
 * クーポン情報取得DAO
 *
 * @author Lee Hosup
 * @version $Revision: 4246 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CouponEditPageDao {

    /**
     * クーポン情報を取得します。
     *
     * @param shopCd
     * @return
     */
    public List<ShopListingCouponDomain> searchCouponInfo(String shopCd);
}