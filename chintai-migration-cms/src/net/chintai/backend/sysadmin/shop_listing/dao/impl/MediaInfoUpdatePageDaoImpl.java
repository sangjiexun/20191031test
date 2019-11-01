/*
 * $Id: MediaInfoUpdatePageDaoImpl.java 4247 2009-03-23 09:15:01Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/13     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoUpdatePageDao;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingCityParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingDataParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingEkiParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingIconParamBean;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingCityDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingDataDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingEkiDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingIconDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * MediaInfoUpdatePageDaoの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4247 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MediaInfoUpdatePageDaoImpl extends SqlMapClientDaoSupport implements
        MediaInfoUpdatePageDao {

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoUpdatePageDao#
     * searchMediaInfoData
     * (net.chintai.backend.sysadmin.shop_listing.dao.ShopListingDataParamBean)
     */
    public ShopListingDataDomain searchMediaInfoData(ShopListingDataParamBean paramBean) {
        return (ShopListingDataDomain) getSqlMapClientTemplate().queryForObject(
                "shopListing.searchMediaInfoData", paramBean);
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoUpdatePageDao#
     * searchMedaiInfoCity
     * (net.chintai.backend.sysadmin.shop_listing.dao.ShopListingCityParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<ShopListingCityDomain> searchMedaiInfoCity(ShopListingCityParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList("shopListing.searchMediaInfoCity", paramBean);
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoUpdatePageDao#
     * searchMedaiInfoEki
     * (net.chintai.backend.sysadmin.shop_listing.dao.ShopListingEkiParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<ShopListingEkiDomain> searchMedaiInfoEki(ShopListingEkiParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList("shopListing.searchMediaInfoEki", paramBean);
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoUpdatePageDao#
     * searchMedaiInfoIcon
     * (net.chintai.backend.sysadmin.shop_listing.dao.ShopListingIconParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<ShopListingIconDomain> searchMedaiInfoIcon(ShopListingIconParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList("shopListing.searchMediaInfoIcon", paramBean);
    }
}
