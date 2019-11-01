package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.event.RowHandler;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.shop_bukken.dao.NayoseSkipShopDao;
import net.chintai.backend.sysadmin.shop_bukken.domain.NayoseSkipShopDomain;



/**
 * NayoseSkipShopDaoの実装クラス
 * @author e-ishii
 * @version $Revision: 4567 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class NayoseSkipShopDaoImpl extends SqlMapClientDaoSupport implements NayoseSkipShopDao {

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.NayoseSkipShopDao#selectNayoseSkipShop(net.chintai.backend.sysadmin.common.pager.BasePagerCondition)
     */
    @SuppressWarnings("unchecked")
    public List<NayoseSkipShopDomain> selectNayoseSkipShop(BasePagerCondition condition) {
        return getSqlMapClientTemplate().queryForList("shopBukken.selectNayoseSkipShopList", condition.getOffset(), condition.getLimit());
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.NayoseSkipShopDao#selectNayoseSkipShopCount()
     */
    public int selectNayoseSkipShopCount() {

        return (Integer) getSqlMapClientTemplate().queryForObject("shopBukken.selectNayoseSkipShopCount");
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.NayoseSkipShopDao#selectNayoseSkipShopCsv(com.ibatis.sqlmap.client.event.RowHandler)
     */
    public void selectNayoseSkipShopCsv(RowHandler handler) {
        getSqlMapClientTemplate().queryWithRowHandler("shopBukken.selectNayoseSkipShopList", handler);
    }

}
