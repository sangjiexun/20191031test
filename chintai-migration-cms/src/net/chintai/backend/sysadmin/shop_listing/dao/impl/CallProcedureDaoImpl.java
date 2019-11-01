/*
 * $Id: CallProcedureDaoImpl.java 4247 2009-03-23 09:15:01Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/15     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.shop_listing.dao.CallProcedureDao;
import net.chintai.backend.sysadmin.shop_listing.dao.CallProcedureDaoParamBean;

/**
 * CallProcedureDaoの実装クラス。
 *
 * @author Lee Hosup
 * @version $Revision: 4247 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CallProcedureDaoImpl extends SqlMapClientDaoSupport implements CallProcedureDao {

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.shop_listing.dao.CallProcedureDao#
     * callCouponYukoFlgUpdate
     * (net.chintai.backend.sysadmin.shop_listing.dao.CallProcedureDaoParamBean)
     */
    public void callCouponYukoFlgUpdate(CallProcedureDaoParamBean paramBean) {
        getSqlMapClientTemplate().queryForObject("shopListing.callCouponFlgUpdate", paramBean);
    }

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.shop_listing.dao.CallProcedureDao#
     * callKihonYukoFlgUpdate
     * (net.chintai.backend.sysadmin.shop_listing.dao.CallProcedureDaoParamBean)
     */
    public void callKihonYukoFlgUpdate(CallProcedureDaoParamBean paramBean) {
        getSqlMapClientTemplate().queryForObject("shopListing.callKihonFlgUpdate", paramBean);
    }

    /*
     * (非 Javadoc)
     *
     * @see net.chintai.backend.sysadmin.shop_listing.dao.CallProcedureDao#
     * callLinkYukoFlgUpdate
     * (net.chintai.backend.sysadmin.shop_listing.dao.CallProcedureDaoParamBean)
     */
    public void callLinkYukoFlgUpdate(CallProcedureDaoParamBean paramBean) {
        getSqlMapClientTemplate().queryForObject("shopListing.callLinkFlgUpdate", paramBean);
    }

}
