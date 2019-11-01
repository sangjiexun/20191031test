/*
 * $Id: RosenEkiSearchForDistributeCsvDaoImpl.java 3714 2007-12-26 06:23:19Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/12/26   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.master.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.master.dao.RosenEkiSearchForDistributeCsvDao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.event.RowHandler;

/**
 * RosenEkiSearchForDistributeCsvDao の実装クラス。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3714 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenEkiSearchForDistributeCsvDaoImpl extends SqlMapClientDaoSupport implements
        RosenEkiSearchForDistributeCsvDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.dao.RosenEkiSearchForDistributeCsvDao#selectEkiToCsv(com.ibatis.sqlmap.client.event.RowHandler)
     */
    public void selectEkiToCsv(RowHandler handler) {
        getSqlMapClientTemplate().queryWithRowHandler("master.selectDistributeEki", handler);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.dao.RosenEkiSearchForDistributeCsvDao#selectEnsenToCsv(com.ibatis.sqlmap.client.event.RowHandler)
     */
    public void selectEnsenToCsv(RowHandler handler) {
        getSqlMapClientTemplate().queryWithRowHandler("master.selectDistributeEnsen", handler);
    }

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.master.dao.RosenEkiSearchForDistributeCsvDao#selectEnsenToCsv()
	 */
	public List selectEnsenToCsv() {
		return getSqlMapClientTemplate().queryForList("master.selectDistributeEnsen");
	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.master.dao.RosenEkiSearchForDistributeCsvDao#selectEkiToCsv()
	 */
	public List selectEkiToCsv() {
		return getSqlMapClientTemplate().queryForList("master.selectDistributeEki");
	}

}
