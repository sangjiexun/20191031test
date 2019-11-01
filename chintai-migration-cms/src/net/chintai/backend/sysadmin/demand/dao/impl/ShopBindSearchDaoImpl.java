/*
 * $Id: ShopBindSearchDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/09  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.demand.dao.ShopBindSearchDao;
import net.chintai.backend.sysadmin.demand.dao.ShopBindSearchParamBean;
import net.chintai.backend.sysadmin.demand.domain.ShopBindSearchDomain;


/**
 * ShopBindSearchDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopBindSearchDaoImpl extends SqlMapClientDaoSupport implements ShopBindSearchDao {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.ShopBindSearchDao#selectAlertBukken(net.chintai.backend.sysadmin.demand.dao.ShopBindSearchParamBean, net.chintai.backend.sysadmin.common.pager.BasePagerCondition)
     */
    @SuppressWarnings("unchecked")
    public List<ShopBindSearchDomain> selectAlertBukken(ShopBindSearchParamBean paramBean,
            BasePagerCondition condition) {
        return getSqlMapClientTemplate().queryForList(
                "demand.selectShopBind", paramBean, condition.getOffset(), condition.getLimit());
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.ShopBindSearchDao#selectTotalCount(net.chintai.backend.sysadmin.demand.dao.ShopBindSearchParamBean)
     */
    public int selectTotalCount(ShopBindSearchParamBean paramBean) {
        return (Integer) getSqlMapClientTemplate().queryForObject(
                "demand.selectShopBindTotalCnt", paramBean);
    }

}
