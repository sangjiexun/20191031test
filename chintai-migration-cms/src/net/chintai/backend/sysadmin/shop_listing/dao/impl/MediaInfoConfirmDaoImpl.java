/*
 * $Id: MediaInfoConfirmDaoImpl.java 4324 2009-08-03 04:13:24Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/12  BGT)李昊燮     新規作成
 * 2009/08/03  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_listing.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.shop_listing.dao.EkiInfoSearchParamBean;
import net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoConfirmDao;
import net.chintai.backend.sysadmin.shop_listing.domain.KihonKeiyakuInfoDomin;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingCityDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopListingEkiDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * MediaInfoConfirmDaoの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4324 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MediaInfoConfirmDaoImpl extends SqlMapClientDaoSupport implements MediaInfoConfirmDao {

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoConfirmDao#
     * searchEkiInfo
     * (net.chintai.backend.sysadmin.shop_listing.dao.EkiInfoSearchParamBean)
     */
    public ShopListingEkiDomain searchEkiInfo(EkiInfoSearchParamBean paramBean) {
        return (ShopListingEkiDomain) getSqlMapClientTemplate().queryForObject(
                "shopListing.selectedEkiInfo", paramBean);
    }

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoConfirmDao#
     * searchCityInfo(java.util.List)
     */
    @SuppressWarnings("unchecked")
    public List<ShopListingCityDomain> searchCityInfos(List<String> cityCds) {
        return getSqlMapClientTemplate().queryForList("shopListing.selectedCityInfos", cityCds);
    }

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoConfirmDao#
     * searchCityInfo(java.lang.String)
     */
    public ShopListingCityDomain searchCityInfo(String cityCd) {
        return (ShopListingCityDomain) getSqlMapClientTemplate().queryForObject(
                "shopListing.selectedCityInfo", cityCd);
    }

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoConfirmDao#
     * searchMediaCntLimit(java.lang.String)
     */
    public KihonKeiyakuInfoDomin searchMediaCntLimit(String shopCd) {
        return (KihonKeiyakuInfoDomin) getSqlMapClientTemplate().queryForObject(
                "shopListing.selectMediaCntLimit", shopCd);
    }

}
