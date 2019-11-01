/*
 * $Id: ShikutyosonClientSettingInfoInServiceBean.java 4806 2014-01-10 06:19:16Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/12/27     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service.bean;


/**
 * 市区町村別データ元出力設定取得用Bean
 * @author KAMEDA Takuma
 * @version $Revision: 4806 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShikutyosonClientSettingInfoInServiceBean {

    /** 他社データ連携種類 */
     private String dcoType;

     /** 他社データ連携種類名 */
     private String dcoName;

     /** 全国都道府県JISコード + クライアントシステムタイプ  01_1, 01_2 など*/
     private String[] clientsystemTypeArray;

     /** 全国都道府県JISコードリスト */
     private String[] cityCdArray;

     /** 市区町村名 */
     private String[] cityNameArray;

     /** 都道府県名 */
     private String prefName;

     /** 都道府県コード */
     private String pref;

     /** 全国都道府県JISコード */
     private String city;

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
     * 全国都道府県JISコード + クライアントシステムタイプ  01_1, 01_2 などを取得します。
     * @return 全国都道府県JISコード + クライアントシステムタイプ  01_1, 01_2 など
     */
    public String[] getClientsystemTypeArray() {
        return clientsystemTypeArray;
    }

    /**
     * 全国都道府県JISコード + クライアントシステムタイプ  01_1, 01_2 などを設定します。
     * @param clientsystemTypeArray 全国都道府県JISコード + クライアントシステムタイプ  01_1, 01_2 など
     */
    public void setClientsystemTypeArray(String[] clientsystemTypeArray) {
        this.clientsystemTypeArray = clientsystemTypeArray;
    }

    /**
     * 全国都道府県JISコードリストを取得します。
     * @return 全国都道府県JISコードリスト
     */
    public String[] getCityCdArray() {
        return cityCdArray;
    }

    /**
     * 全国都道府県JISコードリストを設定します。
     * @param cityCdArray 全国都道府県JISコードリスト
     */
    public void setCityCdArray(String[] cityCdArray) {
        this.cityCdArray = cityCdArray;
    }

    /**
     * 市区町村名を取得します。
     * @return 市区町村名
     */
    public String[] getCityNameArray() {
        return cityNameArray;
    }

    /**
     * 市区町村名を設定します。
     * @param cityNameArray 市区町村名
     */
    public void setCityNameArray(String[] cityNameArray) {
        this.cityNameArray = cityNameArray;
    }

    /**
     * 都道府県名を取得します。
     * @return 都道府県名
     */
    public String getPrefName() {
        return prefName;
    }

    /**
     * 都道府県名を設定します。
     * @param prefName 都道府県名
     */
    public void setPrefName(String prefName) {
        this.prefName = prefName;
    }

    /**
     * 都道府県コードを取得します。
     * @return 都道府県コード
     */
    public String getPref() {
        return pref;
    }

    /**
     * 都道府県コードを設定します。
     * @param pref 都道府県コード
     */
    public void setPref(String pref) {
        this.pref = pref;
    }

    /**
     * 全国都道府県JISコードを取得します。
     * @return 全国都道府県JISコード
     */
    public String getCity() {
        return city;
    }

    /**
     * 全国都道府県JISコードを設定します。
     * @param city 全国都道府県JISコード
     */
    public void setCity(String city) {
        this.city = city;
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
