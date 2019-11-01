/*
 * $Id: TorihikisakiWakuMaintenanceDaoImpl.java 4658 2013-10-09 08:25:04Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/09/19     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuMaintenanceDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuMaintenanceDownloadParamBean;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuMaintenanceUploadParamBean;
import net.chintai.backend.sysadmin.demand.domain.TorihikisakiWakuMaintenanceDownloadDomain;
import net.chintai.backend.sysadmin.demand.domain.TorihikisakiWakuMaintenanceUploadDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


/**
 * TorihikisakiWakuMaintenanceDaoインターフェースクの実装クラス
 * @author KAMEDA Takuma
 * @version $Revision: 4658 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuMaintenanceDaoImpl extends SqlMapClientDaoSupport implements TorihikisakiWakuMaintenanceDao{

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuMaintenanceDao#getTorihikisakiWakuMaintenanceList(net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuMaintenanceDownloadParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<TorihikisakiWakuMaintenanceDownloadDomain> getTorihikisakiWakuMaintenanceList(TorihikisakiWakuMaintenanceDownloadParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList("demand.torihikisakiWakuMaintenanceSelect", paramBean);
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuMaintenanceDao#getTorihikiSakiSeq(net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuMaintenanceUploadParamBean)
     */
    public TorihikisakiWakuMaintenanceUploadDomain getTorihikiSakiSeq(TorihikisakiWakuMaintenanceUploadParamBean paramBean) {
        return (TorihikisakiWakuMaintenanceUploadDomain) getSqlMapClientTemplate().queryForObject("demand.torihikisakiSeqSelect", paramBean);
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuMaintenanceDao#getDelKbnCheck(net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuMaintenanceUploadParamBean)
     */
    public TorihikisakiWakuMaintenanceUploadDomain getExistData(
            TorihikisakiWakuMaintenanceUploadParamBean paramBean) {
        return (TorihikisakiWakuMaintenanceUploadDomain) getSqlMapClientTemplate().queryForObject("demand.getExistDataSql", paramBean);
    }
    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuMaintenanceDao#torihikisakiWakuMaintenanceInsert(net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuMaintenanceUploadParamBean)
     */
    public void torihikisakiWakuMaintenanceInsert(TorihikisakiWakuMaintenanceUploadParamBean paramBean){
         getSqlMapClientTemplate().insert("demand.torihikisakiWakuMaintenanceInsert", paramBean);
     }


    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuMaintenanceDao#torihikisakiWakuMaintenanceUpdate(net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuMaintenanceUploadParamBean)
     */
    public int torihikisakiWakuMaintenanceUpdate(
            TorihikisakiWakuMaintenanceUploadParamBean paramBean) {
        return getSqlMapClientTemplate().update("demand.torihikisakiWakuMaintenanceUpdate", paramBean);
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuMaintenanceDao#torihikisakiWakuMaintenanceDelete(net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuMaintenanceUploadParamBean)
     */
    public int torihikisakiWakuMaintenanceDelete(
            TorihikisakiWakuMaintenanceUploadParamBean paramBean) {
        return getSqlMapClientTemplate().delete("demand.torihikisakiWakuMaintenanceDelete", paramBean);
    }



}
