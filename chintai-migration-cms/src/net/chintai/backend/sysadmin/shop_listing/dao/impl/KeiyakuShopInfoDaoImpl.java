/*
 * $Id: KeiyakuShopInfoDaoImpl.java 4257 2009-03-25 05:34:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/23     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuShopInfoDao;
import net.chintai.backend.sysadmin.shop_listing.domain.KihonKeiyakuInfoDomin;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopAreaInfoDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopImageInfoDomain;
import net.chintai.backend.sysadmin.shop_listing.domain.ShopLocationInfoDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * KeiyakuShopInfoDaoの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4257 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class KeiyakuShopInfoDaoImpl extends SqlMapClientDaoSupport implements KeiyakuShopInfoDao {

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuShopInfoDao#
     * searchKeiyakuBasicInfo(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    public List<KihonKeiyakuInfoDomin> searchKeiyakuBasicInfo(String shopCd) {
        return getSqlMapClientTemplate().queryForList("shopListing.selectKeiyakuBasicInfo", shopCd);
    }

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuShopInfoDao#
     * getShopImgInfo(java.lang.String)
     */
    public ShopImageInfoDomain getShopImgInfo(String shopCd) {
        return (ShopImageInfoDomain) getSqlMapClientTemplate().queryForObject(
                "shopListing.selectShopImgInfo", shopCd);
    }

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuShopInfoDao#
     * searchLocationInfo(java.lang.String)
     */
    public ShopLocationInfoDomain searchLocationInfo(String shopCd) {
        return (ShopLocationInfoDomain) getSqlMapClientTemplate().queryForObject(
                "shopListing.selectShopLocationInfo", shopCd);
    }

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuShopInfoDao#
     * searchKihonKeiyakuYukouCnt(java.lang.String)
     */
    public String searchKihonKeiyakuYukouCnt(String shopCd) {
        return (String) getSqlMapClientTemplate().queryForObject(
                "shopListing.selectKihonKeiyakuYukouCnt", shopCd);
    }

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuShopInfoDao#
     * searchAreaInfo(java.lang.String)
     */
    public ShopAreaInfoDomain searchAreaInfo(String shopCd) {
        return (ShopAreaInfoDomain) getSqlMapClientTemplate().queryForObject(
                "shopListing.selectAreaInfo", shopCd);
    }
}
