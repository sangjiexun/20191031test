/*
 * $Id: PrefClientUpdateBean.java 4790 2014-01-10 02:21:05Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/23     BGT)亀田       E-0070 建物名表示に関する改修 dcoType追加
 * 2014/01/07     BGT)亀田       E-0053_スマイティ用データ抽出　市区・駅対応 docName追加
 */
package net.chintai.backend.sysadmin.dataoutput.action.view;


/**
 * 画面（form）から情報を取得するためのview
 * このviewは画面表示には使用されない
 *
 *
 * @author e-ishii
 * @version $Revision: 4790 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class PrefClientUpdateBean {

    /** 都道府県コード + クライアントシステムタイプ  01_1, 01_2 など*/
    private String[] clientsystemTypeArray;

    /** 都道府県コード */
    private String[] prefcdArray;

    /** 都道府県名 */
    private String[] prefnameArray;

    /** 他社データ連携種類 */
    private String dcoType;

    /** 他社データ連携種類名 */
    private String dcoName;

    /**
     * 都道府県コード + クライアントシステムタイプ  01_1, 01_2 などを取得します。
     * @return 都道府県コード + クライアントシステムタイプ  01_1, 01_2 など
     */
    public String[] getClientsystemTypeArray() {
        return clientsystemTypeArray;
    }

    /**
     * 都道府県コード + クライアントシステムタイプ  01_1, 01_2 などを設定します。
     * @param clientsystemTypeArray 都道府県コード + クライアントシステムタイプ  01_1, 01_2 など
     */
    public void setClientsystemTypeArray(String[] clientsystemTypeArray) {
        this.clientsystemTypeArray = clientsystemTypeArray;
    }

    /**
     * 都道府県コードを取得します。
     * @return 都道府県コード
     */
    public String[] getPrefcdArray() {
        return prefcdArray;
    }

    /**
     * 都道府県コードを設定します。
     * @param prefcdArray 都道府県コード
     */
    public void setPrefcdArray(String[] prefcdArray) {
        this.prefcdArray = prefcdArray;
    }

    /**
     * 都道府県名を取得します。
     * @return 都道府県名
     */
    public String[] getPrefnameArray() {
        return prefnameArray;
    }

    /**
     * 都道府県名を設定します。
     * @param prefnameArray 都道府県名
     */
    public void setPrefnameArray(String[] prefnameArray) {
        this.prefnameArray = prefnameArray;
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


}
