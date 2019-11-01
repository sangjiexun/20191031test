/*
 * $Id: CouponEditPageDaoImpl.java 4247 2009-03-23 09:15:01Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/05     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.shop_listing.dao.CouponEditPageDao;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingCouponDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * CouponEditPageDaoの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4247 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CouponEditPageDaoImpl extends SqlMapClientDaoSupport implements CouponEditPageDao {

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.shop_listing.dao.CouponEditPageDao#
     * searchCouponInfo(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    public List<ShopListingCouponDomain> searchCouponInfo(String shopCd) {
        return getSqlMapClientTemplate().queryForList("shopListing.searchCouponInfo", shopCd);
    }

}
