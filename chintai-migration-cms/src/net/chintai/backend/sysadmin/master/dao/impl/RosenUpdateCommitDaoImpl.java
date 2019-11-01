/*
 * $Id: RosenUpdateCommitDaoImpl.java 3731 2008-01-10 08:34:32Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/11/21   BGT)金東珍    新規作成
 * 2007/01/09   BGT)児島      アーキテクチャ変更をうけ全面的に書き直し
 */
package net.chintai.backend.sysadmin.master.dao.impl;

import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.master.dao.RosenUpdateCommitDao;
import net.chintai.backend.sysadmin.master.domain.EkiDomain;
import net.chintai.backend.sysadmin.master.domain.EnsenDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * RosenUpdateCommitDao インターフェースの実装クラス
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3731 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenUpdateCommitDaoImpl extends SqlMapClientDaoSupport implements RosenUpdateCommitDao {
    
    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.dao.RosenUpdateCommitDao#selectEkiMaster(java.util.List)
     */
    @SuppressWarnings("unchecked")
    public Map<String, EkiDomain> selectEkiMaster(List<EkiDomain> ekiList) {
        return getSqlMapClientTemplate().queryForMap("master.selectEkiMaster", ekiList, "ensenEkiCd");
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.dao.RosenUpdateCommitDao#selectEnsenMaster(java.util.List)
     */
    @SuppressWarnings("unchecked")
    public Map<String, EnsenDomain> selectEnsenMaster(List<String> ensenCodeList) {
        return getSqlMapClientTemplate().queryForMap("master.selectEnsenMaster", ensenCodeList, "ensenCd");
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.dao.RosenUpdateCommitDao#ekiInsert(net.chintai.backend.sysadmin.master.domain.EkiDomain)
     */
    public void ekiInsert(EkiDomain eki) {
        getSqlMapClientTemplate().insert("master.ekiInsert", eki);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.dao.RosenUpdateCommitDao#ekiUpdate(net.chintai.backend.sysadmin.master.domain.EkiDomain)
     */
    public int ekiUpdate(EkiDomain eki) {
        return getSqlMapClientTemplate().update("master.ekiUpdate", eki);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.dao.RosenUpdateCommitDao#ensenInsert(net.chintai.backend.sysadmin.master.domain.EnsenDomain)
     */
    public void ensenInsert(EnsenDomain ensen) {
        getSqlMapClientTemplate().insert("master.ensenInsert", ensen);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.dao.RosenUpdateCommitDao#ensenUpdate(net.chintai.backend.sysadmin.master.domain.EnsenDomain)
     */
    public int ensenUpdate(EnsenDomain ensen) {
        return getSqlMapClientTemplate().update("master.ensenUpdate", ensen);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.dao.RosenUpdateCommitDao#ekiUseStopFlgDelete(net.chintai.backend.sysadmin.master.domain.EkiDomain)
     */
    public void ekiUseStopFlgDelete(EkiDomain eki) {
        getSqlMapClientTemplate().delete("master.ekiUseStopFlgDelete", eki);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.dao.RosenUpdateCommitDao#ekiUseStopFlgInsert(net.chintai.backend.sysadmin.master.domain.EkiDomain)
     */
    public void ekiUseStopFlgInsert(EkiDomain eki) {
        getSqlMapClientTemplate().insert("master.ekiUseStopFlgInsert", eki);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.dao.RosenUpdateCommitDao#ensenUseStopFlgDelete(net.chintai.backend.sysadmin.master.domain.EnsenDomain)
     */
    public void ensenUseStopFlgDelete(EnsenDomain ensen) {
        getSqlMapClientTemplate().delete("master.ensenUseStopFlgDelete", ensen);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.dao.RosenUpdateCommitDao#ensenUseStopFlgInsert(net.chintai.backend.sysadmin.master.domain.EnsenDomain)
     */
    public void ensenUseStopFlgInsert(EnsenDomain ensen) {
        getSqlMapClientTemplate().insert("master.ensenUseStopFlgInsert", ensen);
    }

}
