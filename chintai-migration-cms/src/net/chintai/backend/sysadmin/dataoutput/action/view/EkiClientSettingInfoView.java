/*
 * $Id: EkiClientSettingInfoView.java 4789 2014-01-10 02:11:15Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/12/17     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.action.view;

import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.common.ViewHelper;


/**
 * 他社データ連携駅除外設定画面用Viewクラス
 * @author KAMEDA Takuma
 * @version $Revision: 4789 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class EkiClientSettingInfoView implements ViewHelper{


    /** キー：ekiCd  値：そのekiCdに紐づくクライアントシステムタイプ 現時点では5個 */
    private Map<String, List<String>> clientsystemTypeMap;

    /** 駅情報リスト*/
    private List<EkiDetailView> ekiNameList;

    /** 他社データ連携種類 */
    private String dcoType;

    /** 沿線コード */
    private String ensenCd;

    /** 沿線タイプ */
    private String ensenType;

    /** 沿線名称 */
    private String ensenName;

    /** 他社データ連携種類名 */
    private String dcoName;

    /** 他社データ連携都道府県除外設定削除用文字列 */
    private String parentalType;

    public class EkiDetailView implements ViewHelper{

        /** 駅コード */
        private String ekiCd;

        /** 駅名 */
        private String ekiName;



        /**
         * 駅コードを取得します。
         * @return ekiCd 駅コード
         */
        public String getEkiCd() {
            return ekiCd;
        }


        /**
         * 駅コードを設定します。
         * @param ekiCd 駅コード
         */
        public void setEkiCd(String ekiCd) {
            this.ekiCd = ekiCd;
        }


        /**
         * 駅名を取得します。
         * @return ekiName 駅名
         */
        public String getEkiName() {
            return ekiName;
        }


        /**
         * 駅名を取得します。
         * @param ekiName 駅名
         */
        public void setEkiName(String ekiName) {
            this.ekiName = ekiName;
        }

    }

    /**
     * キー：ekiCd  値：そのekiCdに紐づくクライアントシステムタイプ 現時点では5個を取得します。
     * @return キー：ekiCd  値：そのekiCdに紐づくクライアントシステムタイプ 現時点では5個
     */
    public Map<String,List<String>> getClientsystemTypeMap() {
        return clientsystemTypeMap;
    }

    /**
     * キー：ekiCd  値：そのekiCdに紐づくクライアントシステムタイプ 現時点では5個を設定します。
     * @param clientsystemTypeMap キー：ekiCd  値：そのekiCdに紐づくクライアントシステムタイプ 現時点では5個
     */
    public void setClientsystemTypeMap(Map<String,List<String>> clientsystemTypeMap) {
        this.clientsystemTypeMap = clientsystemTypeMap;
    }

    /**
     * 駅情報リストを取得します。
     * @return 駅情報リスト
     */
    public List<EkiDetailView> getEkiNameList() {
        return ekiNameList;
    }

    /**
     * 駅情報リストを設定します。
     * @param ekiNameList 駅情報リスト
     */
    public void setEkiNameList(List<EkiDetailView> ekiNameList) {
        this.ekiNameList = ekiNameList;
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
