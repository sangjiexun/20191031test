/*
 * $Id: SevendaysMenuService.java 4513 2011-09-08 07:42:13Z e-ishii $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/10/15   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.external.sevendays.service;

/**
 * サンスイ 7days へ提供するメニューに表示する内容について、<br>
 * 表示可否の判定を行うサービスクラス。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 4513 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface SevendaysMenuService {

    /**
     * 物件詳細ログ分析(CHINTAIサイト)機能の利用可否を判定し、結果を戻します。
     * @param shopCode 店舗コード
     * @return 利用可:true, 利用不可:false
     */
    public boolean isEnabledChintaiLogAnalysis(String shopCode);

    /**
     * CHINTAI物件リスティングの機能利用可否を判定し、結果を戻します。
     * @param shopCode 店舗コード
     * @return 利用可:true, 利用不可:false
     */
    public boolean isEnabledChintaiBukkenListing(String shopCode);

    /**
     * 掲載物件リスト表示機能の利用可否を判定し、結果を戻します。
     * @param shopCode 店舗コード
     * @return 利用可:true, 利用不可:false
     */
    public boolean isEnabledKeisaiList(String shopCode);

    /**
     * キャンペーン広告管理機能の利用可否を判定し、結果を戻します。
     * @param shopCode 店舗コード
     * @return 利用可:true, 利用不可:false
     */
    public boolean isEnabledCampaign(String shopCode);


    /**
     * 検索条件ログレポートダウンロードの利用可否を判定し、結果を戻します。
     * @param shopCode 店舗コード
     * @return 利用可:true, 利用不可:false
     */
    public boolean isEnabledLogReportDownload(String shopCode);

}
