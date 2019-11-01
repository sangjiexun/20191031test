/*
 * $Id: ShikutyosonClientSettingCommitParamBean.java 4795 2014-01-10 04:01:11Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2014/01/06     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.dao;


/**
 * 市区町村別データ元出力設定登録用Bean
 * @author KAMEDA Takuma
 * @version $Revision: 4795 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShikutyosonClientSettingCommitParamBean {

    /** 全国都道府県JISコード */
    private String cityCd;

    /** 都道府県コード */
    private String prefCd;

    /** ユーザ利用システム種類*/
    private String clientsystemType;

    /** レコード登録者 */
    private String userId;

    /** レコード登録プログラムID */
    private String pgName;

    /** 他社データ連携種類 */
    private String dcoType;

    /** 沿線別削除処理用パラメータ */
    private String parentalType;

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
     * ユーザ利用システム種類を取得します。
     * @return ユーザ利用システム種類
     */
    public String getClientsystemType() {
        return clientsystemType;
    }

    /**
     * ユーザ利用システム種類を設定します。
     * @param clientsystemType ユーザ利用システム種類
     */
    public void setClientsystemType(String clientsystemType) {
        this.clientsystemType = clientsystemType;
    }

    /**
     * レコード登録者を取得します。
     * @return レコード登録者
     */
    public String getUserId() {
        return userId;
    }

    /**
     * レコード登録者を設定します。
     * @param userId レコード登録者
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * レコード登録プログラムIDを取得します。
     * @return レコード登録プログラムID
     */
    public String getPgName() {
        return pgName;
    }

    /**
     * レコード登録プログラムIDを設定します。
     * @param pgName レコード登録プログラムID
     */
    public void setPgName(String pgName) {
        this.pgName = pgName;
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
     * 沿線別削除処理用パラメータを取得します。
     * @return 沿線別削除処理用パラメータ
     */
    public String getParentalType() {
        return parentalType;
    }

    /**
     * 沿線別削除処理用パラメータを設定します。
     * @param parentalType 沿線別削除処理用パラメータ
     */
    public void setParentalType(String parentalType) {
        this.parentalType = parentalType;
    }

}
