/*
 * $Id: SevendaysMenuDao.java 4517 2011-09-13 00:16:51Z e-ishii $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/10/15   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.external.sevendays.dao;

/**
 * サンスイ 7days に提供するメニュー項目の表示判定を行うDAO。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 4517 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface SevendaysMenuDao {

    /**
     * 物件詳細ログ分析(CHINTAI)機能の利用可否を判定し、結果を戻します。
     * @param shopCode 店舗コード
     * @return 利用可能なとき 1, 利用不可能なとき 0
     */
    public int selectChintaiLogAnalysisEnabled(String shopCode);

    /**
     * CHINTAI 物件リスティング機能の利用可否を判定し、結果を戻します。
     * @param shopCode 店舗コード
     * @return 利用可能なとき 1以上の値(リスティング枠件数を戻す), 利用不可能なとき 0
     */
    public int selectChintaiBukkenListingEnabled(String shopCode);

    /**
     * 検索条件ログレポート機能の利用可否を判定し、結果を戻します。
     * @param shopCode  店舗コード
     * @return 利用可能なとき 1, 利用不可能なとき
     */
    public String selectLogReportEnabled(String shopCode);
}
