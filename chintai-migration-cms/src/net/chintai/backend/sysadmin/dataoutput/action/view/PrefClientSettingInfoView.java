/*
 * $Id: PrefClientSettingInfoView.java 4790 2014-01-10 02:21:05Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/23     BGT)亀田       E-0070 建物名表示に関する改修 dcoType追加
 * 2014/01/07     BGT)亀田       E-0053_スマイティ用データ抽出　市区・駅対応 docName追加
 */
package net.chintai.backend.sysadmin.dataoutput.action.view;

import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.common.ViewHelper;


/**
 * 都道府県別データ元出力設定画面view
 *
 * @author e-ishii
 * @version $Revision: 4790 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class PrefClientSettingInfoView  implements ViewHelper{


    /** キー：prefCd  値：そのprefCdに紐づくクライアントシステムタイプ 現時点では5個 */
    private Map<String, List<String>> clientsystemTypeMap;

    /** 都道府県情報リスト*/
    private List<PrefDetailView> prefNameList;

    /** 他社データ連携種類 */
    private String dcoType;

    /** 他社データ連携種類名 */
    private String dcoName;


    /**
     * 都道府県情報リストの内部view
     * @author e-ishii
     * @version $Revision: 4790 $
     * Copyright: (C) CHINTAI Corporation All Right Reserved.
     */
    public class PrefDetailView implements ViewHelper{

        /** 都道府県コード */
        private String prefcd;

        /** 都道府県名 */
        private String prefname;

        /**
         * prefcdを取得します。
         * @return prefcd
         */
        public String getPrefcd() {
            return prefcd;
        }

        /**
         * prefcdを設定します。
         * @param prefcd prefcd
         */
        public void setPrefcd(String prefcd) {
            this.prefcd = prefcd;
        }

        /**
         * prefnameを取得します。
         * @return prefname
         */
        public String getPrefname() {
            return prefname;
        }

        /**
         * prefnameを設定します。
         * @param prefname prefname
         */
        public void setPrefname(String prefname) {
            this.prefname = prefname;
        }
    }



    /**
     * キー：prefCd  値：そのprefCdに紐づくクライアントシステムタイプ 現時点では5個を取得します。
     * @return キー：prefCd  値：そのprefCdに紐づくクライアントシステムタイプ 現時点では5個
     */
    public Map<String,List<String>> getClientsystemTypeMap() {
        return clientsystemTypeMap;
    }

    /**
     * キー：prefCd  値：そのprefCdに紐づくクライアントシステムタイプ 現時点では5個を設定します。
     * @param clientsystemTypeMap キー：prefCd  値：そのprefCdに紐づくクライアントシステムタイプ 現時点では5個
     */
    public void setClientsystemTypeMap(Map<String,List<String>> clientsystemTypeMap) {
        this.clientsystemTypeMap = clientsystemTypeMap;
    }

    /**
     * 都道府県情報リストを取得します。
     * @return 都道府県情報リスト
     */
    public List<PrefDetailView> getPrefNameList() {
        return prefNameList;
    }

    /**
     * 都道府県情報リストを設定します。
     * @param prefNameList 都道府県情報リスト
     */
    public void setPrefNameList(List<PrefDetailView> prefNameList) {
        this.prefNameList = prefNameList;
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
