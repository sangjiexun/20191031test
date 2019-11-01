/*
 * $Id: RosenEkiSearchForCsvDaoImpl.java 3707 2007-12-26 05:42:05Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/17  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.master.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.master.dao.RosenEkiSearchForCsvDao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.event.RowHandler;

/**
 * RosenEkiSearchForCsvDaoの実装クラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3707 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenEkiSearchForCsvDaoImpl extends SqlMapClientDaoSupport implements RosenEkiSearchForCsvDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.dao.RosenEkiSearchForCsvDao#selectEnsenEkiToCsv(com.ibatis.sqlmap.client.event.RowHandler)
     */
    public void selectEnsenEkiToCsv(RowHandler handler) {
        getSqlMapClientTemplate().queryWithRowHandler("master.selectEnsenEkiForCsv", handler);
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.dao.RosenEkiSearchForCsvDao#selectEnsenEkiToCsv()
     */
    public List selectEnsenEkiToCsv() {
        return getSqlMapClientTemplate().queryForList("master.selectEnsenEkiForCsv");
    }

}
