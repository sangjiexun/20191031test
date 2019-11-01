/*
 * $Id: ContractAmountMaintenanceDaoImpl.java 4658 2013-10-09 08:25:04Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceDao;
import net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceDownloadParamBean;
import net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceKikanChkBean;
import net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceUploadParamBean;
import net.chintai.backend.sysadmin.demand.domain.ContractAmountMaintenanceDownloadDomain;
import net.chintai.backend.sysadmin.demand.domain.ContractAmountMaintenanceUploadDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


/**
 * ContractAmountMaintenanceDaoインターフェースクの実装クラス
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountMaintenanceDaoImpl extends SqlMapClientDaoSupport implements ContractAmountMaintenanceDao{

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceDao#getContractAmountMaintenanceList(net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceDownloadParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<ContractAmountMaintenanceDownloadDomain> getContractAmountMaintenanceList(ContractAmountMaintenanceDownloadParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList("demand.contractAmountMaintenanceSelect", paramBean);
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceDao#getTorihikiSakiSeq(net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceUploadParamBean)
     */
    public ContractAmountMaintenanceUploadDomain getTorihikiSakiSeq(ContractAmountMaintenanceUploadParamBean paramBean) {
        return (ContractAmountMaintenanceUploadDomain) getSqlMapClientTemplate().queryForObject("demand.torihikisakiSeqSelect", paramBean);
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceDao#getDelKbnCheck(net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceUploadParamBean)
     */
    public ContractAmountMaintenanceUploadDomain getExistData(
            ContractAmountMaintenanceUploadParamBean paramBean) {
        return (ContractAmountMaintenanceUploadDomain) getSqlMapClientTemplate().queryForObject("demand.getExistDataSql", paramBean);
    }
    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceDao#contractAmountMaintenanceInsert(net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceUploadParamBean)
     */
    public void contractAmountMaintenanceInsert(ContractAmountMaintenanceUploadParamBean paramBean){
         getSqlMapClientTemplate().insert("demand.contractAmountMaintenanceInsert", paramBean);
     }


    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceDao#contractAmountMaintenanceUpdate(net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceUploadParamBean)
     */
    public int contractAmountMaintenanceUpdate(
            ContractAmountMaintenanceUploadParamBean paramBean) {
        return getSqlMapClientTemplate().update("demand.contractAmountMaintenanceUpdate", paramBean);
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceDao#contractAmountMaintenanceDelete(net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceUploadParamBean)
     */
    public int contractAmountMaintenanceDelete(
            ContractAmountMaintenanceUploadParamBean paramBean) {
        return getSqlMapClientTemplate().delete("demand.contractAmountMaintenanceDelete", paramBean);
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceDao#getShopKanri()
     */
    public List getShopKanri(HashMap<String,Object>  paramMap){
        return (List)getSqlMapClientTemplate().queryForList("demand.getShopKanri",paramMap);
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceDao#shopKanriUpdateCommit(java.util.HashMap)
     */
    public void shopKanriUpdateCommit(HashMap<String,Object>  paramMap){
        getSqlMapClientTemplate().update("demand.shopKanriUpdateCommit",paramMap);
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceDao#getMstSHopKeiyakuKanri()
     */
    public List getMstSHopKeiyakuKanri(){
        return (List)getSqlMapClientTemplate().queryForList("demand.getMstShopKeiyakuKanri");
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceDao#existsKeiyakuKanri(net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceUploadParamBean)
     */
    public int existsKeiyakuKanri(ContractAmountMaintenanceUploadParamBean paramBean){
        return (int)getSqlMapClientTemplate().queryForObject("demand.existsKeiyakuKanri",paramBean);
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceDao#contractAmountMaintenanceHeaderInsert(net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceUploadParamBean)
     */
    public void contractAmountMaintenanceHeaderInsert(ContractAmountMaintenanceUploadParamBean paramBean){
        getSqlMapClientTemplate().insert("demand.contractAmountMaintenanceHeaderInsert",paramBean);
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceDao#checkAppliyYmdh(net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceKikanChkBean)
     */
    public int checkAppliyYmdh(ContractAmountMaintenanceKikanChkBean paramBean) {
        return (Integer) getSqlMapClientTemplate().queryForObject("demand.contractAmountMaintenanceCountApplyYmdh", paramBean);
    }

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceDao#checkKeiyakuEndDt(net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceUploadParamBean)
	 */
	public List<ContractAmountMaintenanceKikanChkBean> checkKeiyakuEndDt(
			ContractAmountMaintenanceUploadParamBean paramBean) {
		return (List<ContractAmountMaintenanceKikanChkBean>) getSqlMapClientTemplate().queryForList(
                "demand.contractAmountMaintenanceChkKeiyakuEndDt", paramBean);
	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceDao#viewCheck(net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceUploadParamBean)
	 */
	public ContractAmountMaintenanceKikanChkBean viewCheck(
			ContractAmountMaintenanceUploadParamBean paramBean) {
		return (ContractAmountMaintenanceKikanChkBean) getSqlMapClientTemplate().queryForObject(
                "demand.viewCheck", paramBean);
	}

}
