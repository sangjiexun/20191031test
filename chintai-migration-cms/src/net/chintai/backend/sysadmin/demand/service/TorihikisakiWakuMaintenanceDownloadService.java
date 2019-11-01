/*
 * $Id: TorihikisakiWakuMaintenanceDownloadService.java 4662 2013-10-09 08:34:46Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/09/18     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import java.util.List;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuMaintenanceDownloadInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuMaintenanceDownloadOutServiceBean;


/**
 * 入力内容でCSVダウンロード処理サービスクラス
 * @author KAMEDA Takuma
 * @version $Revision: 4662 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiWakuMaintenanceDownloadService {

    /**
     * 物件枠数・物件リスティング枠数のCSVダウンロード処理をする
     * @return CSVダウンロードリスト
     * @throws Exception
     */
    public List<TorihikisakiWakuMaintenanceDownloadOutServiceBean> torihikisakiWakuCsvDownLoad(TorihikisakiWakuMaintenanceDownloadInServiceBean inServiceBean) throws ApplicationException;

}
