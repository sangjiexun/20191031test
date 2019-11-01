/*
 * $Id: SevendaysMenuDaoImpl.java 4517 2011-09-13 00:16:51Z e-ishii $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/10/15   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.external.sevendays.dao.impl;

import net.chintai.backend.sysadmin.external.sevendays.dao.SevendaysMenuDao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * SevendaysMenuDao の実装クラス。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 4517 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class SevendaysMenuDaoImpl extends SqlMapClientDaoSupport implements SevendaysMenuDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.external.sevendays.dao.SevendaysMenuDao#selectBukkenListingEnabled(java.lang.String)
     */
    public int selectChintaiBukkenListingEnabled(String shopCode) {
        Object obj = getSqlMapClientTemplate().queryForObject("sevendays.selectChintaiBukkenListingEnabled", shopCode);
        return (obj == null) ? 0 : (Integer) obj;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.external.sevendays.dao.SevendaysMenuDao#selectLogAnalysisEnabled(java.lang.String)
     */
    public int selectChintaiLogAnalysisEnabled(String shopCode) {
        Object obj = getSqlMapClientTemplate().queryForObject("sevendays.selectChintaiLogAnalysisEnabled", shopCode);
        return (obj == null) ? 0 : (Integer) obj;
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.external.sevendays.dao.SevendaysMenuDao#selectWebLogFlgEnabled(java.lang.String)
     */
    public String selectLogReportEnabled(String shopCode) {
        return (String)getSqlMapClientTemplate().queryForObject("sevendays.selectLogReportEnabled", shopCode);
    }

}
