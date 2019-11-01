/*
 * $Id: AdDataMatchingDaoImpl.java 4352 2009-08-28 06:57:37Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/28     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.common.dwr.dao.impl;

import net.chintai.backend.sysadmin.common.dwr.dao.AdDataMatchingDao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 *
 * @author Lee Hosup
 * @version $Revision: 4352 $
 * Copyright:(C) CHINTAI Corporation All Right Reserved.
 */
public class AdDataMatchingDaoImpl extends SqlMapClientDaoSupport implements AdDataMatchingDao {

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.common.dwr.dao.AdDataMatching#countMonthlyAdData
     * (java.lang.String)
     */
    public String countMonthlyAdData(String date) {
        return (String) getSqlMapClientTemplate().queryForObject(
                "adDataMatchingForAjax.countMonthyData", date);
    }

}
