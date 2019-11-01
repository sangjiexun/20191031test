/*
 * $Id: AblOutUpdateCommitInServiceBean.java 4724 2013-11-05 07:58:11Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/18     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service.bean;


/**
 * エイブル担当店/取扱店出力情報設定入力用Bean
 * @author KAMEDA Takuma
 * @version $Revision: 4724 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AblOutUpdateCommitInServiceBean {

    /** レコード登録者 */
    private String userId;

    /** レコード登録プログラムID */
    private String pgName;

    /** 他社データ連携種類配列 */
    private String[] dcoTypeArray;

    /** 物件出力区分配列 */
    private String[] bukkenOutKbnArray;

    /** 更新日付 */
    private String[] updDtArray;

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
     * 他社データ連携種類配列を取得します。
     * @return 他社データ連携種類配列
     */
    public String[] getDcoTypeArray() {
        return dcoTypeArray;
    }

    /**
     * 他社データ連携種類配列を設定します。
     * @param dcoTypeArray 他社データ連携種類配列
     */
    public void setDcoTypeArray(String[] dcoTypeArray) {
        this.dcoTypeArray = dcoTypeArray;
    }

    /**
     * 物件出力区分配列を取得します。
     * @return 物件出力区分配列
     */
    public String[] getBukkenOutKbnArray() {
        return bukkenOutKbnArray;
    }

    /**
     * 物件出力区分配列を設定します。
     * @param bukkenOutKbnArray 物件出力区分配列
     */
    public void setBukkenOutKbnArray(String[] bukkenOutKbnArray) {
        this.bukkenOutKbnArray = bukkenOutKbnArray;
    }

    /**
     * 更新日付を取得します。
     * @return 更新日付
     */
    public String[] getUpdDtArray() {
        return updDtArray;
    }

    /**
     * 更新日付を設定します。
     * @param updDtArray 更新日付
     */
    public void setUpdDtArray(String[] updDtArray) {
        this.updDtArray = updDtArray;
    }


}
