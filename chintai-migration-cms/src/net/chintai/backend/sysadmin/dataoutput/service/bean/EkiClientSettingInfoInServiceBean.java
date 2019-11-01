/*
 * $Id: EkiClientSettingInfoInServiceBean.java 4803 2014-01-10 05:38:20Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/12/18     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service.bean;



/**
 * 他社データ連携駅除外設定取得用InServiceBean
 * @author KAMEDA Takuma
 * @version $Revision: 4803 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class EkiClientSettingInfoInServiceBean {

   /** 他社データ連携種類 */
    private String dcoType;

    /** 沿線コード */
    private String ensenCd;

    /** 沿線タイプ */
    private String ensenType;

    /** 沿線名称 */
    private String ensenName;

    /** 駅コード + クライアントシステムタイプ  01_1, 01_2 など*/
    private String[] clientsystemTypeArray;

    /** 駅コード */
    private String[] ekiCdArray;

    /** 駅名 */
    private String[] ekiNameArray;

    /** 他社データ連携種類名 */
    private String dcoName;

    /** 他社データ連携都道府県除外設定削除用文字列 */
    private String parentalType;

    /**
     * 他社データ連携種類を取得します。
     * @return 他社データ連携種類
     */
    public String getDcoType() {
        return dcoType;
    }

    /**
     * 他社データ連携種類を設定します。
     * @param dcoType 他社データ連携種類
     */
    public void setDcoType(String dcoType) {
        this.dcoType = dcoType;
    }

    /**
     * 沿線コードを取得します。
     * @return 沿線コード
     */
    public String getEnsenCd() {
        return ensenCd;
    }

    /**
     * 沿線コードを設定します。
     * @param ensenCd 沿線コード
     */
    public void setEnsenCd(String ensenCd) {
        this.ensenCd = ensenCd;
    }

    /**
     * 沿線タイプを取得します。
     * @return 沿線タイプ
     */
    public String getEnsenType() {
        return ensenType;
    }

    /**
     * 沿線タイプを設定します。
     * @param ensenType 沿線タイプ
     */
    public void setEnsenType(String ensenType) {
        this.ensenType = ensenType;
    }

    /**
     * 沿線名称を取得します。
     * @return 沿線名称
     */
    public String getEnsenName() {
        return ensenName;
    }

    /**
     * 沿線名称を設定します。
     * @param ensenName 沿線名称
     */
    public void setEnsenName(String ensenName) {
        this.ensenName = ensenName;
    }

    /**
     * 駅コード + クライアントシステムタイプ  01_1, 01_2 などを取得します。
     * @return 駅コード + クライアントシステムタイプ  01_1, 01_2 など
     */
    public String[] getClientsystemTypeArray() {
        return clientsystemTypeArray;
    }

    /**
     * 駅コード + クライアントシステムタイプ  01_1, 01_2 などを設定します。
     * @param clientsystemTypeArray 駅コード + クライアントシステムタイプ  01_1, 01_2 など
     */
    public void setClientsystemTypeArray(String[] clientsystemTypeArray) {
        this.clientsystemTypeArray = clientsystemTypeArray;
    }

    /**
     * 駅コードを取得します。
     * @return 駅コード
     */
    public String[] getEkiCdArray() {
        return ekiCdArray;
    }

    /**
     * 駅コードを設定します。
     * @param ekiCdArray 駅コード
     */
    public void setEkiCdArray(String[] ekiCdArray) {
        this.ekiCdArray = ekiCdArray;
    }

    /**
     * 駅名を取得します。
     * @return 駅名
     */
    public String[] getEkiNameArray() {
        return ekiNameArray;
    }

    /**
     * 駅名を設定します。
     * @param ekiNameArray 駅名
     */
    public void setEkiNameArray(String[] ekiNameArray) {
        this.ekiNameArray = ekiNameArray;
    }

    /**
     * 他社データ連携種類名を取得します。
     * @return 他社データ連携種類名
     */
    public String getDcoName() {
        return dcoName;
    }

    /**
     * 他社データ連携種類名を設定します。
     * @param dcoName 他社データ連携種類名
     */
    public void setDcoName(String dcoName) {
        this.dcoName = dcoName;
    }

    /**
     * 他社データ連携都道府県除外設定削除用文字列を取得します。
     * @return 他社データ連携都道府県除外設定削除用文字列
     */
    public String getParentalType() {
        return parentalType;
    }

    /**
     * 他社データ連携都道府県除外設定削除用文字列を設定します。
     * @param parentalType 他社データ連携都道府県除外設定削除用文字列
     */
    public void setParentalType(String parentalType) {
        this.parentalType = parentalType;
    }

}
