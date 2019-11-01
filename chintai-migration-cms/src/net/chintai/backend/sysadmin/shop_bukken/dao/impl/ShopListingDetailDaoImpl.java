package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingDetailDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingDetailParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ShopListingDetailDaoの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingDetailDaoImpl extends SqlMapClientDaoSupport implements
        ShopListingDetailDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingDetailDao#getShopListingDetail(net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingDetailParamBean)
     */
    @SuppressWarnings("unchecked")
    public List getShopListingDetail(
            ShopListingDetailParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList(
                "shopBukken.selectShopListingDetail", paramBean);
    }

}
