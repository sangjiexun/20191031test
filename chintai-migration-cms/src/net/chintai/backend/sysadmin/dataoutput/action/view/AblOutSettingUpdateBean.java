/*
 * $Id: AblOutSettingUpdateBean.java 4788 2014-01-10 02:06:42Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/17     BGT)亀田       新規作成
 * 2014/1/7       BGT)亀田       E-0053_スマイティ用データ抽出　市区・駅対応 docNameArray追加
 *
 */
package net.chintai.backend.sysadmin.dataoutput.action.view;


/**
 * エイブル担当店/取扱店出力情報設定Form用Bean
 * @author KAMEDA Takuma
 * @version $Revision: 4788 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AblOutSettingUpdateBean {

    /** 他社データ連携種類配列 */
    private String[] dcoTypeArray;

    /** 物件出力区分配列 */
    private String[] bukkenOutKbnArray;

    /** 更新日付配列 */
    private String[] updDtArray;

    /** 連携対象会社名配列 */
    private String[] dcoNameArray;

    /**
     * 他社データ連携種類配列を取得します。
     * @return 他社データ連携種類配列
     */
    public String[] getDcoTypeArray() {
        return dcoTypeArray;
    }

    /**
     * 他社データ連携種類配列を設定します。
     * @param dcoTypeArray 他社データ連携種類配列
     */
    public void setDcoTypeArray(String[] dcoTypeArray) {
        this.dcoTypeArray = dcoTypeArray;
    }

    /**
     * 物件出力区分配列を取得します。
     * @return 物件出力区分配列
     */
    public String[] getBukkenOutKbnArray() {
        return bukkenOutKbnArray;
    }

    /**
     * 物件出力区分配列を設定します。
     * @param bukkenOutKbnArray 物件出力区分配列
     */
    public void setBukkenOutKbnArray(String[] bukkenOutKbnArray) {
        this.bukkenOutKbnArray = bukkenOutKbnArray;
    }

    /**
     * 更新日付配列を取得します。
     * @return 更新日付配列
     */
    public String[] getUpdDtArray() {
        return updDtArray;
    }

    /**
     * 更新日付配列を設定します。
     * @param updDtArray 更新日付配列
     */
    public void setUpdDtArray(String[] updDtArray) {
        this.updDtArray = updDtArray;
    }

    /**
     * 連携対象会社名配列を取得します。
     * @return 連携対象会社名配列
     */
    public String[] getDcoNameArray() {
        return dcoNameArray;
    }

    /**
     * 連携対象会社名配列を設定します。
     * @param dcoNameArray 連携対象会社名配列
     */
    public void setDcoNameArray(String[] dcoNameArray) {
        this.dcoNameArray = dcoNameArray;
    }


}
