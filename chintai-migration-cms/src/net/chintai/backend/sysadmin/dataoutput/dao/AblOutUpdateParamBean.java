/*
 * $Id: AblOutUpdateParamBean.java 4716 2013-11-05 07:43:43Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/18     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.dao;


/**
 * エイブル担当店/取扱店出力情報設定ParamBean
 * @author KAMEDA Takuma
 * @version $Revision: 4716 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AblOutUpdateParamBean {

    /** レコード登録者 */
    private String userId;

    /** レコード登録プログラムID */
    private String pgName;

    /** 他社データ連携種類 */
    private String dcoType;

    /** 物件出力区分 */
    private String bukkenOutKbn;

    /** 更新日付 */
    private String updDt;

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
     * 物件出力区分を取得します。
     * @return 物件出力区分
     */
    public String getBukkenOutKbn() {
        return bukkenOutKbn;
    }

    /**
     * 物件出力区分を設定します。
     * @param bukkenOutKbn 物件出力区分
     */
    public void setBukkenOutKbn(String bukkenOutKbn) {
        this.bukkenOutKbn = bukkenOutKbn;
    }

    /**
     * 更新日付を取得します。
     * @return 更新日付
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 更新日付を設定します。
     * @param updDt 更新日付
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }


}
