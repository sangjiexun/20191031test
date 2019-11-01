/*
 * $Id: MediaInfoRegisterCompleteDaoImpl.java 4252 2009-03-24 08:11:47Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/03     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao.impl;

import net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoRegisterCompleteDao;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingCityParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingDataParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingEkiParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingIconParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * MediaInfoUpdateCompleteDaoの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4252 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MediaInfoRegisterCompleteDaoImpl extends SqlMapClientDaoSupport implements
        MediaInfoRegisterCompleteDao {

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoRegisterCompleteDao
     * # registerShopListingCity(
     * net.chintai.backend.sysadmin.shop_listing.dao.ShopListingCityParamBean)
     */
    public String registerShopListingCity(ShopListingCityParamBean paramBean) {
        return (String) getSqlMapClientTemplate().insert("shopListing.insertShopListingCity",
                paramBean);
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoRegisterCompleteDao
     * # registerShopListingData(
     * net.chintai.backend.sysadmin.shop_listing.dao.ShopListingDataParamBean)
     */
    public String registerShopListingData(ShopListingDataParamBean paramBean) {
        return (String) getSqlMapClientTemplate().insert("shopListing.insertShopListingData",
                paramBean);
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoRegisterCompleteDao
     * # registerShopListingEki(
     * net.chintai.backend.sysadmin.shop_listing.dao.ShopListingEkiParamBean)
     */
    public String registerShopListingEki(ShopListingEkiParamBean paramBean) {
        return (String) getSqlMapClientTemplate().insert("shopListing.insertShopListingEki",
                paramBean);
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoRegisterCompleteDao
     * # registerShopListingIcon(
     * net.chintai.backend.sysadmin.shop_listing.dao.ShopListingIconParamBean)
     */
    public String registerShopListingIcon(ShopListingIconParamBean paramBean) {
        return (String) getSqlMapClientTemplate().insert("shopListing.insertShopListingIcon",
                paramBean);
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoRegisterCompleteDao
     * # searchTmpMediaInfo(java.lang.String)
     */
    public int searchTmpMediaInfo(String shopCd) {
        return (Integer) getSqlMapClientTemplate().queryForObject("shopListing.cntTmpMediaInfo",
                shopCd);
    }

}
