/*
 * $Id: ShopListingDataDaoImpl.java 4247 2009-03-23 09:15:01Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/03     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao.impl;

import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingDataDao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ShopListingDataDaoの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4247 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingDataDaoImpl extends SqlMapClientDaoSupport implements ShopListingDataDao {

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.shop_listing.dao.ShopListingDataDao#
     * selectWebDisplayCnt(java.lang.String)
     */
    public int selectWebDisplayCnt(String shopCd) {
        return (Integer) getSqlMapClientTemplate().queryForObject(
                "shopListing.countWebDisplayInfo", shopCd);
    }

}
