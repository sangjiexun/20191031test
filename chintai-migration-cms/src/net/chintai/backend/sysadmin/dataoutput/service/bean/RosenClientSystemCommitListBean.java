/*
 * $Id: RosenClientSystemCommitListBean.java 4806 2014-01-10 06:19:16Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/23     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service.bean;


/**
 * 沿線別データ元除外設定情報の更新用Bean
 * @author KAMEDA Takuma
 * @version $Revision: 4806 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenClientSystemCommitListBean {

    /** 他社データ連携種類 */
    private String dcoType;

    /** 沿線コード */
    private String ensenCd;

    /** ユーザ利用システム種類*/
    private String clientsystemType;

    /** レコード登録者 */
    private String userId;

    /** レコード登録プログラムID */
    private String pgName;

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

}
