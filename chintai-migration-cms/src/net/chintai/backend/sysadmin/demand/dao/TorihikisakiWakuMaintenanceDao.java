/*
 * $Id: TorihikisakiWakuMaintenanceDao.java 4655 2013-10-09 08:15:28Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/09/19     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

import java.util.List;

import net.chintai.backend.sysadmin.demand.domain.TorihikisakiWakuMaintenanceDownloadDomain;
import net.chintai.backend.sysadmin.demand.domain.TorihikisakiWakuMaintenanceUploadDomain;



/**
 * 物件枠数・物件リスティング枠数のCSVダウンロード・アップロードDao
 * @author KAMEDA Takuma
 * @version $Revision: 4655 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface TorihikisakiWakuMaintenanceDao {

    /**
     * CSVファイルダウロード情報を取得
     * @param paramBean 入力データ
     * @return 検索結果リスト
     */
    public List<TorihikisakiWakuMaintenanceDownloadDomain> getTorihikisakiWakuMaintenanceList(TorihikisakiWakuMaintenanceDownloadParamBean paramBean);

    /**
     * CSVファイルチェック、取引先テーブルに取引先シーケンス存在確認
     * @param paramBean 入力ファイル内容
     * @return 検索結果リスト
     */
    public TorihikisakiWakuMaintenanceUploadDomain getTorihikiSakiSeq(TorihikisakiWakuMaintenanceUploadParamBean paramBean);

    /**
     * CSVファイルチェック、取引先料金テーブルに取引先シーケンス及び適用月存在確認
     * @param paramBean
     * @return
     */
    public TorihikisakiWakuMaintenanceUploadDomain getExistData(TorihikisakiWakuMaintenanceUploadParamBean paramBean);

    /**
     * CSVファイル内容を登録
     * @param paramBean CSVファイル内容
     */
    public void torihikisakiWakuMaintenanceInsert(TorihikisakiWakuMaintenanceUploadParamBean paramBean);

    /**
     * CSVファイル内容で更新
     * @param paramBean CSVファイル内容
     * @return 処理件数
     */
    public int torihikisakiWakuMaintenanceUpdate(TorihikisakiWakuMaintenanceUploadParamBean paramBean);

    /**
     * CSVファイル内容を削除
     * @param paramBean CSVファイル内容
     * @return 処理件数
     */
    public int torihikisakiWakuMaintenanceDelete(TorihikisakiWakuMaintenanceUploadParamBean paramBean);

}
