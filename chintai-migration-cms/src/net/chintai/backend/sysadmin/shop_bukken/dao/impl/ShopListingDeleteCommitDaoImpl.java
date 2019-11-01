package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingDeleteCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingDeleteCommitParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ShopListingDeleteCommitDaoの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingDeleteCommitDaoImpl extends SqlMapClientDaoSupport implements
        ShopListingDeleteCommitDao {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingDeleteCommitDao#deleteWakuInfo(net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingDeleteCommitParamBean)
     */
    public int deleteKeiyakuInfo(ShopListingDeleteCommitParamBean paramBean) {
        return getSqlMapClientTemplate().update("shopBukken.deleteKeiyakuInfo", paramBean);
    }
}
