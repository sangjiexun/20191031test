package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingUpdatePageDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingUpdatePageParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.ShopListingDetailDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ShopListingUpdatePageDaoの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingUpdatePageDaoImpl extends SqlMapClientDaoSupport implements
        ShopListingUpdatePageDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingUpdatePageDao#getShopListing(net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingUpdatePageParamBean)
     */
    public ShopListingDetailDomain getShopListing(
            ShopListingUpdatePageParamBean paramBean) {
        return (ShopListingDetailDomain) getSqlMapClientTemplate().queryForObject(
                "shopBukken.selectShopListingForUpdate", paramBean);
    }

}
