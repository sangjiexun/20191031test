/*
 * $Id: MobileMaintenanceDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/13  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.master.dao;

import java.util.List;

import net.chintai.backend.sysadmin.master.domain.MobileMaintenanceListInfo;

/**
 * 携帯ゲーム対応機種メンテナンスDAO
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface MobileMaintenanceDao {

    /**
     * 携帯ゲーム対応機種メンテナンス (CSV ファイルのダウンロード用)
     * @return MobileMaintenanceListInfo
     */
    public List<MobileMaintenanceListInfo> selectMobileMaintenanceCsvForDownload();

    /**
     * 携帯ゲーム対応機種メンテナンス (CSV ファイルのアップロード用)
     * @param param
     */
    public void insertMobileMaintenanceCsvForUpload(MobileMaintenanceParamBean param);
    
    /**
     * 携帯ゲーム対応機種テーブルのデータを全削除します。
     */
    public void deleteAllMobileLists();
    
}
