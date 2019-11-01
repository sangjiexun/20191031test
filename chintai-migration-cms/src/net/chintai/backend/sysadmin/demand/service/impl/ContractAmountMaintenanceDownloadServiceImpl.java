/*
 * $Id: ContractAmountMaintenanceDownloadServiceImpl.java 4666 2013-10-09 08:46:35Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceDao;
import net.chintai.backend.sysadmin.demand.dao.ContractAmountMaintenanceDownloadParamBean;
import net.chintai.backend.sysadmin.demand.domain.ContractAmountMaintenanceDownloadDomain;
import net.chintai.backend.sysadmin.demand.service.ContractAmountMaintenanceDownloadService;
import net.chintai.backend.sysadmin.demand.service.bean.ContractAmountMaintenanceDownloadInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.ContractAmountMaintenanceDownloadOutServiceBean;


/**
 * ContractAmountMaintenanceDownloadService実装クラス
 * @author 
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountMaintenanceDownloadServiceImpl implements ContractAmountMaintenanceDownloadService{

    /** 物件枠・リスティング枠メンテナンスCsvファイル情報取得DAO */
    private ContractAmountMaintenanceDao contractAmountMaintenanceDao = null;

    /**
     * contractAmountMaintenanceDaoを設定する
     * @param contractAmountMaintenanceDao
     */
    public void setContractAmountMaintenanceDao(ContractAmountMaintenanceDao contractAmountMaintenanceDao) {
        this.contractAmountMaintenanceDao = contractAmountMaintenanceDao;
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.ContractAmountMaintenanceDownloadService#contractAmountCsvDownLoad(net.chintai.backend.sysadmin.demand.service.bean.ContractAmountMaintenanceInServiceBean)
     */
    public List<ContractAmountMaintenanceDownloadOutServiceBean> contractAmountCsvDownLoad(
            ContractAmountMaintenanceDownloadInServiceBean inServiceBean) throws ApplicationException {

        ContractAmountMaintenanceDownloadParamBean paramBean = new ContractAmountMaintenanceDownloadParamBean();

        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // 入力内容に対応した検索結果のリストを取得
        List<ContractAmountMaintenanceDownloadDomain> rsList = contractAmountMaintenanceDao.getContractAmountMaintenanceList(paramBean);
        List<ContractAmountMaintenanceDownloadOutServiceBean> contractAmountMaintenanceSearchList = new ArrayList<ContractAmountMaintenanceDownloadOutServiceBean>();

        // 検索結果を出力用のBaen設定
        for (ContractAmountMaintenanceDownloadDomain torihikiGetList : rsList){

            ContractAmountMaintenanceDownloadOutServiceBean contractAmountMaintenanceOutServiceBean = new ContractAmountMaintenanceDownloadOutServiceBean();

            try {
                BeanUtils.copyProperties(contractAmountMaintenanceOutServiceBean, torihikiGetList);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            contractAmountMaintenanceSearchList.add(contractAmountMaintenanceOutServiceBean);
        }

        return contractAmountMaintenanceSearchList;
    }

}
