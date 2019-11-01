/*
 * $Id: CouponEditCompleteDaoImpl.java 4248 2009-03-24 01:59:32Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/05     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao.impl;

import net.chintai.backend.sysadmin.shop_listing.dao.CouponEditCompleteDao;
import net.chintai.backend.sysadmin.shop_listing.dao.CouponEditCompleteParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * CouponEditCompleteDaoの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4248 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CouponEditCompleteDaoImpl extends SqlMapClientDaoSupport implements
        CouponEditCompleteDao {

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.shop_listing.dao.CouponEditCompleteDao#
     * registerCouponInfo(net.chintai.backend.sysadmin.shop_listing.dao.CouponEditCompleteParamBean)
     */
    public String registerCouponInfo(CouponEditCompleteParamBean paramBean) {
        return (String) getSqlMapClientTemplate().insert("shopListing.insertCouponInfo", paramBean);
    }

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.shop_listing.dao.CouponEditCompleteDao#
     * updateCouponInfo(net.chintai.backend.sysadmin.shop_listing.dao.CouponEditCompleteParamBean)
     */
    public void updateCouponInfo(CouponEditCompleteParamBean paramBean) {
        getSqlMapClientTemplate().update("shopListing.updateCouponInfo", paramBean, 1);
    }

}
