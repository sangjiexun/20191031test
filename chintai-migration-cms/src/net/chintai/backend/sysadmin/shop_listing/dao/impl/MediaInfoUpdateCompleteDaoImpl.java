/*
 * $Id: MediaInfoUpdateCompleteDaoImpl.java 4249 2009-03-24 05:36:55Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/14     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao.impl;

import net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoUpdateCompleteDao;
import net.chintai.backend.sysadmin.shop_listing.dao.ShopListingDataParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * MediaInfoUpdateCompleteDaoの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4249 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MediaInfoUpdateCompleteDaoImpl extends SqlMapClientDaoSupport implements
        MediaInfoUpdateCompleteDao {

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoUpdateCompleteDao#
     * deleteShopMediaCity(java.lang.String)
     */
    public int deleteShopMediaCity(String shopCd) {
        return getSqlMapClientTemplate().delete("shopListing.deleteCity", shopCd);
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoUpdateCompleteDao#
     * deleteShopMediaEki(java.lang.String)
     */
    public int deleteShopMediaEki(String shopCd) {
        return getSqlMapClientTemplate().delete("shopListing.deleteEki", shopCd);
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoUpdateCompleteDao#
     * deleteShopMediaIcon(java.lang.String)
     */
    public int deleteShopMediaIcon(String shopCd) {
        return getSqlMapClientTemplate().delete("shopListing.deleteIcon", shopCd);
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.shop_listing.dao.MediaInfoUpdateCompleteDao#
     * updateShopMediaData
     * (net.chintai.backend.sysadmin.shop_listing.dao.ShopListingDataParamBean)
     */
    public void updateShopMediaData(ShopListingDataParamBean dataParamBean) {
        getSqlMapClientTemplate().update("shopListing.updateMediaInfo", dataParamBean, 1);

    }

}
