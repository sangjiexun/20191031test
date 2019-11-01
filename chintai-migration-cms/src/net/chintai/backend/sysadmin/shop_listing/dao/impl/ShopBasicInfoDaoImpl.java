/*
 * $Id: ShopBasicInfoDaoImpl.java 4247 2009-03-23 09:15:01Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/27     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao.impl;

import net.chintai.backend.sysadmin.shop_listing.dao.ShopBasicInfoDao;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopBasicInfoDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ShopBasicInfoOutServiceBeanの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4247 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopBasicInfoDaoImpl extends SqlMapClientDaoSupport implements ShopBasicInfoDao {

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.dao.ShopBasicInfoOutServiceBean
     * # searchShopBasicInfo(java.lang.String)
     */
    public ShopBasicInfoDomain searchShopBasicInfo(String shopCd) {
        return (ShopBasicInfoDomain) getSqlMapClientTemplate().queryForObject(
                "shopListing.selectShopBasicInfo", shopCd);
    }

}
