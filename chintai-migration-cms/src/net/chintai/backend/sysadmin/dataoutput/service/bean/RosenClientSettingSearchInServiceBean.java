/*
 * $Id: RosenClientSettingSearchInServiceBean.java 4823 2014-01-14 07:38:38Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/31     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service.bean;


/**
 * 沿線別データ元除外設定情報取得用InServiceBean
 * @author KAMEDA Takuma
 * @version $Revision: 4823 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenClientSettingSearchInServiceBean {

    /** エリアコード */
    private String areaCd;

    /** 沿線タイプ */
    private String ensenType;

    /** 検索フラグ */
    private String searchFlg;

    /** 他社データ連携種類 */
    private String dcoType;

    /** 他社データ連携種類名 */
    private String dcoName;

    /** 沿線コード + クライアントシステムタイプ  01_1, 01_2 など*/
    private String[] clientsystemTypeArray;

    /** 沿線コード配列 */
    private String[] ensenCdArray;

    /** 沿線名配列 */
    private String[] ensenNameArray;

    /** エリア名称 */
    private String areaName;

    /** 沿線名(かな)配列 */
    private String[] ensenKanaArray;

    /**
     * エリアコードを取得します。
     * @return エリアコード
     */
    public String getAreaCd() {
        return areaCd;
    }

    /**
     * エリアコードを設定します。
     * @param areaCd エリアコード
     */
    public void setAreaCd(String areaCd) {
        this.areaCd = areaCd;
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
     * 検索フラグを取得します。
     * @return 検索フラグ
     */
    public String getSearchFlg() {
        return searchFlg;
    }

    /**
     * 検索フラグを設定します。
     * @param searchFlg 検索フラグ
     */
    public void setSearchFlg(String searchFlg) {
        this.searchFlg = searchFlg;
    }

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
     * 沿線コード + クライアントシステムタイプ  01_1, 01_2 などを取得します。
     * @return 沿線コード + クライアントシステムタイプ  01_1, 01_2 など
     */
    public String[] getClientsystemTypeArray() {
        return clientsystemTypeArray;
    }

    /**
     * 沿線コード + クライアントシステムタイプ  01_1, 01_2 などを設定します。
     * @param clientsystemTypeArray 沿線コード + クライアントシステムタイプ  01_1, 01_2 など
     */
    public void setClientsystemTypeArray(String[] clientsystemTypeArray) {
        this.clientsystemTypeArray = clientsystemTypeArray;
    }

    /**
     * 沿線コード配列を取得します。
     * @return 沿線コード配列
     */
    public String[] getEnsenCdArray() {
        return ensenCdArray;
    }

    /**
     * 沿線コード配列を設定します。
     * @param ensenCdArray 沿線コード配列
     */
    public void setEnsenCdArray(String[] ensenCdArray) {
        this.ensenCdArray = ensenCdArray;
    }

    /**
     * 沿線名配列を取得します。
     * @return 沿線名配列
     */
    public String[] getEnsenNameArray() {
        return ensenNameArray;
    }

    /**
     * 沿線名配列を設定します。
     * @param ensenNameArray 沿線名配列
     */
    public void setEnsenNameArray(String[] ensenNameArray) {
        this.ensenNameArray = ensenNameArray;
    }

    /**
     * エリア名称を取得します。
     * @return エリア名称
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * エリア名称を設定します。
     * @param areaName エリア名称
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 沿線名(かな)配列を取得します。
     * @return 沿線名(かな)配列
     */
    public String[] getEnsenKanaArray() {
        return ensenKanaArray;
    }

    /**
     * 沿線名(かな)配列を設定します。
     * @param ensenKanaArray 沿線名(かな)配列
     */
    public void setEnsenKanaArray(String[] ensenKanaArray) {
        this.ensenKanaArray = ensenKanaArray;
    }

}
