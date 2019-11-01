/*
 * $Id: KeiyakuShopSearchDaoImpl.java 4247 2009-03-23 09:15:01Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/19     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuShopSearchDao;
import net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuShopSearchParamBean;
import net.chintai.backend.sysadmin.shop_listing.domain.KeiyakuShopSearchDomain;

/**
 * KeiyakuShopSearchDaoの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4247 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class KeiyakuShopSearchDaoImpl extends SqlMapClientDaoSupport implements
        KeiyakuShopSearchDao {

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuShopSearchDao#
     * searchShopList
     * (net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuShopSearchParamBean
     * , net.chintai.backend.sysadmin.common.pager.BasePagerCondition)
     */
    @SuppressWarnings("unchecked")
    public List<KeiyakuShopSearchDomain> searchShopList(KeiyakuShopSearchParamBean paramBean,
            BasePagerCondition condition) {
        List<KeiyakuShopSearchDomain> returnList = new ArrayList<KeiyakuShopSearchDomain>();

        if (0 < condition.getLimit()) {
            returnList =
                    getSqlMapClientTemplate().queryForList("shopListing.selectShopList", paramBean,
                            condition.getOffset(), condition.getLimit());
        } else {
            returnList =
                    getSqlMapClientTemplate().queryForList("shopListing.selectShopList", paramBean);
        }

        return returnList;
    }

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuShopSearchDao#
     * searchTotalCnt
     * (net.chintai.backend.sysadmin.shop_listing.dao.KeiyakuShopSearchParamBean
     * )
     */
    public int searchTotalCnt(KeiyakuShopSearchParamBean paramBean) {
        return (Integer) getSqlMapClientTemplate().queryForObject("shopListing.selectTotalCount",
                paramBean);
    }

    /*
     * (非 Javadoc)
     *
     * @seenet.chintai.backend.sysadmin.shop_listing.dao.KeiyakuShopSearchDao#
     * searchSysdate()
     */
    public Date searchSysdate() {
        return (Date) getSqlMapClientTemplate().queryForObject("shopListing.searchSysdate");
    }

}
