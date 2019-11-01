package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingUpdateCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingUpdateCommitParamBean;

/**
 * ShopListingUpdateCommitDaoの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingUpdateCommitDaoImpl extends SqlMapClientDaoSupport implements
        ShopListingUpdateCommitDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingUpdateCommitDao#updateShopListing(net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingUpdateCommitParamBean)
     */
    public int updateShopListing(ShopListingUpdateCommitParamBean paramBean) {
        return getSqlMapClientTemplate().update("shopBukken.updateShopListing", paramBean);
    }
}
