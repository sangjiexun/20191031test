/*
 * $Id: ContractAmountMaintenanceDao.java 4655 2013-10-09 08:15:28Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

import java.util.HashMap;
import java.util.List;

import net.chintai.backend.sysadmin.demand.domain.ContractAmountMaintenanceDownloadDomain;
import net.chintai.backend.sysadmin.demand.domain.ContractAmountMaintenanceUploadDomain;



/**
 * 物件枠数・物件リスティング枠数のCSVダウンロード・アップロードDao
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.

 */
public interface ContractAmountMaintenanceDao {

    /**
     * CSVファイルダウロード情報を取得
     * @param paramBean 入力データ
     * @return 検索結果リスト
     */
    public List<ContractAmountMaintenanceDownloadDomain> getContractAmountMaintenanceList(ContractAmountMaintenanceDownloadParamBean paramBean);

    /**
     * CSVファイルチェック、取引先テーブルに取引先シーケンス存在確認
     * @param paramBean 入力ファイル内容
     * @return 検索結果リスト
     */
    public ContractAmountMaintenanceUploadDomain getTorihikiSakiSeq(ContractAmountMaintenanceUploadParamBean paramBean);

    /**
     * CSVファイルチェック、取引先料金テーブルに取引先シーケンス及び適用月存在確認
     * @param paramBean
     * @return
     */
    public ContractAmountMaintenanceUploadDomain getExistData(ContractAmountMaintenanceUploadParamBean paramBean);

    /**
     * CSVファイル内容を登録
     * @param paramBean CSVファイル内容
     */
    public void contractAmountMaintenanceInsert(ContractAmountMaintenanceUploadParamBean paramBean);

    /**
     * CSVファイル内容で更新
     * @param paramBean CSVファイル内容
     * @return 処理件数
     */
    public int contractAmountMaintenanceUpdate(ContractAmountMaintenanceUploadParamBean paramBean);

    /**
     * CSVファイル内容を削除
     * @param paramBean CSVファイル内容
     * @return 処理件数
     */
    public int contractAmountMaintenanceDelete(ContractAmountMaintenanceUploadParamBean paramBean);

    /**
     * 契約管理マスタを取得
     * @return 契約管理情報
     */
    public List getMstSHopKeiyakuKanri();

    /**
     * 店舗管理マスタを取得し、排他をかける
     * @return 店舗管理情報
     */
    public List getShopKanri(HashMap<String,Object>  paramMap);

    /***
     * 店舗管理を更新する
     * @param paramMap
     * @return
     */
    public void shopKanriUpdateCommit(HashMap<String,Object>  paramMap);

    /**
     * 契約管理テーブルにデータ確認
     * @param paramBean CSVファイル内容
     */
    public int existsKeiyakuKanri(ContractAmountMaintenanceUploadParamBean paramBean);

    /**
     * 契約管理テーブルにデータを登録
     * @param paramBean CSVファイル内容
     */
    public void contractAmountMaintenanceHeaderInsert(ContractAmountMaintenanceUploadParamBean paramBean);

    /**
     * 日付チェック
     * @param paramBean
     * @return
     */
    public int checkAppliyYmdh(ContractAmountMaintenanceKikanChkBean paramBean);

	/**
	 * 日付チェック
	 * @param paramBean
	 * @return
	 */
	public List<ContractAmountMaintenanceKikanChkBean> checkKeiyakuEndDt(ContractAmountMaintenanceUploadParamBean paramBean);

	/**
	 * 日付チェック
	 * @param paramBean
	 * @return
	 */
	public ContractAmountMaintenanceKikanChkBean viewCheck(ContractAmountMaintenanceUploadParamBean paramBean);

}
