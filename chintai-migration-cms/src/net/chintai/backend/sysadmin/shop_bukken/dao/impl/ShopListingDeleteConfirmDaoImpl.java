package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingDeleteConfirmDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingDeleteConfirmParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.ShopListingDetailDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * TorihikisakiBukkenWakuInfoDeleteConfirmDaoの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingDeleteConfirmDaoImpl extends SqlMapClientDaoSupport implements
        ShopListingDeleteConfirmDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.TorihikisakiBukkenWakuInfoDeleteConfirmDao#getShopListingForDelete(net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingDeleteConfirmParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<ShopListingDetailDomain> getShopListingForDelete(
            ShopListingDeleteConfirmParamBean paramBean) {
        return (List<ShopListingDetailDomain>) getSqlMapClientTemplate().queryForList(
                "shopBukken.selectShopListingForDelete", paramBean);
    }

}
