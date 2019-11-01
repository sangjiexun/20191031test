/*
 * $Id: ShikutyosonClientSettingInfoView.java 4792 2014-01-10 02:47:00Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/12/27     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.action.view;

import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.common.ViewHelper;


/**
 * 市区町村別データ元除外設定画面表示用View
 * @author KAMEDA Takuma
 * @version $Revision: 4792 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShikutyosonClientSettingInfoView implements ViewHelper {

    /** 市区町村検索結果リスト */
    private List<ShikutyosonDetailView> shikutyosonSearchList;

    /** キー：ensenCd  値：そのensenCdに紐づくクライアントシステムタイプ 現時点では5個 */
    private Map<String, List<String>> clientsystemTypeMap;

    /** 他社データ連携種類 */
    private String dcoType;

    /** 他社データ連携種類名 */
    private String dcoName;

    /** 都道府県名 */
    private String prefName;

    /** 都道府県コード */
    private String pref;

    /** 全国都道府県JISコード */
    private String city;

    /** 他社データ連携都道府県除外設定削除用文字列 */
    private String parentalType;

    public class ShikutyosonDetailView{

        /** 全国都道府県JISコード */
        private String cityCd;

        /** 市区町村名 */
        private String cityName;

        /**
         * 全国都道府県JISコードを取得します。
         * @return 全国都道府県JISコード
         */
        public String getCityCd() {
            return cityCd;
        }

        /**
         * 全国都道府県JISコードを設定します。
         * @param cityCd 全国都道府県JISコード
         */
        public void setCityCd(String cityCd) {
            this.cityCd = cityCd;
        }

        /**
         * 市区町村名を取得します。
         * @return 市区町村名
         */
        public String getCityName() {
            return cityName;
        }

        /**
         * 市区町村名を設定します。
         * @param cityName 市区町村名
         */
        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

    }

    /**
     * 市区町村検索結果リストを設定します。
     * @param shikutyosonSearchList 市区町村検索結果リスト
     */
    public void setShikutyosonSearchList(List<ShikutyosonDetailView> shikutyosonSearchList) {
        this.shikutyosonSearchList = shikutyosonSearchList;
    }

    /**
     * 市区町村検索結果リストを取得します。
     * @return 市区町村検索結果リスト
     */
    public List<ShikutyosonDetailView> getShikutyosonSearchList() {
        return shikutyosonSearchList;
    }

    /**
     * キー：ensenCd  値：そのensenCdに紐づくクライアントシステムタイプ 現時点では5個を取得します。
     * @return キー：ensenCd  値：そのensenCdに紐づくクライアントシステムタイプ 現時点では5個
     */
    public Map<String,List<String>> getClientsystemTypeMap() {
        return clientsystemTypeMap;
    }

    /**
     * キー：ensenCd  値：そのensenCdに紐づくクライアントシステムタイプ 現時点では5個を設定します。
     * @param clientsystemTypeMap キー：ensenCd  値：そのensenCdに紐づくクライアントシステムタイプ 現時点では5個
     */
    public void setClientsystemTypeMap(Map<String,List<String>> clientsystemTypeMap) {
        this.clientsystemTypeMap = clientsystemTypeMap;
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
