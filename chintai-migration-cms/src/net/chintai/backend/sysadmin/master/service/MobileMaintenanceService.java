/*
 * $Id: MobileMaintenanceService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/13  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service;

import java.util.List;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.master.service.bean.MobileMaintenanceInServiceBean;
import net.chintai.backend.sysadmin.master.service.bean.MobileMaintenanceOutServiceBean;

/**
 * 携帯ゲーム対応機種メンテナンスService
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface MobileMaintenanceService {

    /**
     * 携帯ゲーム対応機種メンテナンス (CSV ファイルのダウンロード用)データ取得
     * 
     * @return MobileMaintenanceOutServiceBean
     * @throws ApplicationException
     */
    public List<MobileMaintenanceOutServiceBean> mobileCsvDownLoad() throws ApplicationException;

    /**
     * 携帯ゲーム対応機種メンテナンス (CSV ファイルのアップロード用)
     * @throws ApplicationException
     * 
     */
    public void mobileCsvUpload(MobileMaintenanceInServiceBean inSerivceBean) throws ApplicationException;

}
