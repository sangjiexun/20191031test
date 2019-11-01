/*
 * $Id: ShopListingIconDaoImpl.java 4322 2009-07-17 06:54:11Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/03     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingIconDao;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingIconDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * CouponMasterDaoの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4322 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingIconDaoImpl extends SqlMapClientDaoSupport implements ShopListingIconDao {

    /*
     * (非 Javadoc)
     *
     * @seenet.chintai.backend.sysadmin.shop_listing.dao.CouponMasterDao#
     * searchIconMasterInfo()
     */
    @SuppressWarnings("unchecked")
    public List<ShopListingIconDomain> searchIconMasterInfo() {
        return getSqlMapClientTemplate().queryForList("shopListing.selectIconMaster");
    }

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.shop_listing.dao.ShopListingIconDao#
     * searchIconMasterInfoByIconId(java.util.List)
     */
    @SuppressWarnings("unchecked")
    public List<ShopListingIconDomain> searchIconMasterInfoByIconId(List iconId) {
        return getSqlMapClientTemplate().queryForList("shopListing.selectIconMasterByIconId",
                iconId);
    }
}
