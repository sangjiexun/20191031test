package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingAddCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingAddCommitParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


/**
 * ShopListingAddCommitDaoの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingAddCommitDaoImpl extends SqlMapClientDaoSupport implements
        ShopListingAddCommitDao {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingAddCommitDao#insertShopListing(net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingAddCommitParamBean)
     */
    public void insertShopListing(ShopListingAddCommitParamBean paramBean) {
        getSqlMapClientTemplate().insert("shopBukken.insertShopListing",paramBean);
    }

}
