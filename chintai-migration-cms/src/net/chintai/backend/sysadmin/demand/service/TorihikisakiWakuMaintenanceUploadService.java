/*
 * $Id: TorihikisakiWakuMaintenanceUploadService.java 4663 2013-10-09 08:37:05Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/01     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuMaintenanceUploadInServiceBean;


/**
 * 物件枠数・物件リスティング枠数のCSVアップロード処理サービスクラス
 * @author KAMEDA Takuma
 * @version $Revision: 4663 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiWakuMaintenanceUploadService {

    /**
     * 入力CSVファイル内容で登録、更新、削除処理をする
     * @param inServiceBean
     * @throws ApplicationException
     */
    public void torihikisakiWakuMaintenanceUploadCommit(TorihikisakiWakuMaintenanceUploadInServiceBean inServiceBean) throws ApplicationException;

}
