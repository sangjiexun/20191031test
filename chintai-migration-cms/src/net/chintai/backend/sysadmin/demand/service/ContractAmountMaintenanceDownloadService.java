/*
 * $Id: ContractAmountMaintenanceDownloadService.java 4662 2013-10-09 08:34:46Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import java.util.List;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.service.bean.ContractAmountMaintenanceDownloadInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.ContractAmountMaintenanceDownloadOutServiceBean;


/**
 * 入力内容でCSVダウンロード処理サービスクラス
 * @author 
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ContractAmountMaintenanceDownloadService {

    /**
     * 物件枠数・物件リスティング枠数のCSVダウンロード処理をする
     * @return CSVダウンロードリスト
     * @throws Exception
     */
    public List<ContractAmountMaintenanceDownloadOutServiceBean> contractAmountCsvDownLoad(ContractAmountMaintenanceDownloadInServiceBean inServiceBean) throws ApplicationException;

}
