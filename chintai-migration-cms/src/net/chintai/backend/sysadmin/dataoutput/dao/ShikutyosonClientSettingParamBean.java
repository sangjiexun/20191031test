/*
 * $Id: ShikutyosonClientSettingParamBean.java 4796 2014-01-10 04:15:22Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/12/27     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.dao;


/**
 * 市区町村別データ元出力検索用Bean
 * @author KAMEDA Takuma
 * @version $Revision: 4796 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShikutyosonClientSettingParamBean {

    /** 他社データ連携種類 */
    private String dcoType;

    /** 都道府県コード */
    private String prefCd;

    /** 全国都道府県JISコード */
    private String cityCd;

    /** 都道府県コード */
    private String pref;

    /** 全国都道府県JISコード */
    private String city;

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
     * 都道府県コードを取得します。
     * @return 都道府県コード
     */
    public String getPrefCd() {
        return prefCd;
    }

    /**
     * 都道府県コードを設定します。
     * @param prefCd 都道府県コード
     */
    public void setPrefCd(String prefCd) {
        this.prefCd = prefCd;
    }

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


}
