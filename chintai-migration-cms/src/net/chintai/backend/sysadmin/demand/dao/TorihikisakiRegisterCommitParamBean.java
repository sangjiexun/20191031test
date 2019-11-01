/*
 * $Id: TorihikisakiRegisterCommitParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/04  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

/**
 * 取引先新規登録
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiRegisterCommitParamBean {

    /** 不動産名 */
    private String fudousanName;

    /** 不動産コード */
    private String fudousanCd;

    /** 取引先シーケンス番号 */
    private int torihikisakiSeq;

    /** 取引先名 */
    private String torihikisakiName;

    /** 取引先コード */
    private String torihikisakiCd;

    /** 郵便番号１ */
    private String zipCd1;

    /** 郵便番号２ */
    private String zipCd2;

    /** 都道府県コード */
    private String prefCd;

    /** 住所１(市区町村丁目番地) */
    private String address1;

    /** 住所２(ビルなど) */
    private String address2;

    /** 電話番号 */
    private String tel;

    /** ファクス番号 */
    private String fax;

    /** 取引先担当者 */
    private String tantou;

    /** CHINTAI支社コード */
    private String shisyaCd;

    /** 適用年 */
    private String applyYear;

    /** 適用月 */
    private String applyMonth;

    /** 物件枠 */
    private String bukkenCnt;

    /** 物件枠(手入力) */
    private String bukkenCntNote;

    /** リスティング枠 */
    private String tokusenCnt;

    /** リスティング枠(手入力) */
    private String tokusenCntNote;

    /** ユーザID */
    private String userId;

    /** プログラム名 */
    private String pgName;

    /**
     * 不動産名を取得します。
     * @return 不動産名
     */
    public String getFudousanName() {
        return fudousanName;
    }

    /**
     * 不動産名を設定します。
     * @param fudousanName 不動産名
     */
    public void setFudousanName(String fudousanName) {
        this.fudousanName = fudousanName;
    }

    /**
     * 不動産コードを取得します。
     * @return 不動産コード
     */
    public String getFudousanCd() {
        return fudousanCd;
    }

    /**
     * 不動産コードを設定します。
     * @param fudousanCd 不動産コード
     */
    public void setFudousanCd(String fudousanCd) {
        this.fudousanCd = fudousanCd;
    }

    /**
     * 取引先シーケンス番号を取得します。
     * @return 取引先シーケンス番号
     */
    public int getTorihikisakiSeq() {
        return torihikisakiSeq;
    }

    /**
     * 取引先シーケンス番号を設定します。
     * @param torihikisakiSeq 取引先シーケンス番号
     */
    public void setTorihikisakiSeq(int torihikisakiSeq) {
        this.torihikisakiSeq = torihikisakiSeq;
    }

    /**
     * 取引先名を取得します。
     * @return 取引先名
     */
    public String getTorihikisakiName() {
        return torihikisakiName;
    }

    /**
     * 取引先名を設定します。
     * @param torihikisakiName 取引先名
     */
    public void setTorihikisakiName(String torihikisakiName) {
        this.torihikisakiName = torihikisakiName;
    }

    /**
     * 取引先コードを取得します。
     * @return 取引先コード
     */
    public String getTorihikisakiCd() {
        return torihikisakiCd;
    }

    /**
     * 取引先コードを設定します。
     * @param torihikisakiCd 取引先コード
     */
    public void setTorihikisakiCd(String torihikisakiCd) {
        this.torihikisakiCd = torihikisakiCd;
    }

    /**
     * 郵便番号１を取得します。
     * @return 郵便番号１
     */
    public String getZipCd1() {
        return zipCd1;
    }

    /**
     * 郵便番号１を設定します。
     * @param zipCd1 郵便番号１
     */
    public void setZipCd1(String zipCd1) {
        this.zipCd1 = zipCd1;
    }

    /**
     * 郵便番号２を取得します。
     * @return 郵便番号２
     */
    public String getZipCd2() {
        return zipCd2;
    }

    /**
     * 郵便番号２を設定します。
     * @param zipCd2 郵便番号２
     */
    public void setZipCd2(String zipCd2) {
        this.zipCd2 = zipCd2;
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
     * 住所１(市区町村丁目番地)を取得します。
     * @return 住所１(市区町村丁目番地)
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * 住所１(市区町村丁目番地)を設定します。
     * @param address1 住所１(市区町村丁目番地)
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * 住所２(ビルなど)を取得します。
     * @return 住所２(ビルなど)
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * 住所２(ビルなど)を設定します。
     * @param address2 住所２(ビルなど)
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * 電話番号を取得します。
     * @return 電話番号
     */
    public String getTel() {
        return tel;
    }

    /**
     * 電話番号を設定します。
     * @param tel 電話番号
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * ファクス番号を取得します。
     * @return ファクス番号
     */
    public String getFax() {
        return fax;
    }

    /**
     * ファクス番号を設定します。
     * @param fax ファクス番号
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * 取引先担当者を取得します。
     * @return 取引先担当者
     */
    public String getTantou() {
        return tantou;
    }

    /**
     * 取引先担当者を設定します。
     * @param tantou 取引先担当者
     */
    public void setTantou(String tantou) {
        this.tantou = tantou;
    }

    /**
     * CHINTAI支社コードを取得します。
     * @return CHINTAI支社コード
     */
    public String getShisyaCd() {
        return shisyaCd;
    }

    /**
     * CHINTAI支社コードを設定します。
     * @param shisyaCd CHINTAI支社コード
     */
    public void setShisyaCd(String shisyaCd) {
        this.shisyaCd = shisyaCd;
    }

    /**
     * 適用年を取得します。
     * @return 適用年
     */
    public String getApplyYear() {
        return applyYear;
    }

    /**
     * 適用年を設定します。
     * @param applyYear 適用年
     */
    public void setApplyYear(String applyYear) {
        this.applyYear = applyYear;
    }

    /**
     * 適用月を取得します。
     * @return 適用月
     */
    public String getApplyMonth() {
        return applyMonth;
    }

    /**
     * 適用月を設定します。
     * @param applyMonth 適用月
     */
    public void setApplyMonth(String applyMonth) {
        this.applyMonth = applyMonth;
    }

    /**
     * 物件枠を取得します。
     * @return 物件枠
     */
    public String getBukkenCnt() {
        return bukkenCnt;
    }

    /**
     * 物件枠を設定します。
     * @param bukkenCnt 物件枠
     */
    public void setBukkenCnt(String bukkenCnt) {
        this.bukkenCnt = bukkenCnt;
    }

    /**
     * 物件枠(手入力)を取得します。
     * @return 物件枠(手入力)
     */
    public String getBukkenCntNote() {
        return bukkenCntNote;
    }

    /**
     * 物件枠(手入力)を設定します。
     * @param bukkenCntNote 物件枠(手入力)
     */
    public void setBukkenCntNote(String bukkenCntNote) {
        this.bukkenCntNote = bukkenCntNote;
    }

    /**
     * リスティング枠を取得します。
     * @return リスティング枠
     */
    public String getTokusenCnt() {
        return tokusenCnt;
    }

    /**
     * リスティング枠を設定します。
     * @param tokusenCnt リスティング枠
     */
    public void setTokusenCnt(String tokusenCnt) {
        this.tokusenCnt = tokusenCnt;
    }

    /**
     * リスティング枠(手入力)を取得します。
     * @return リスティング枠(手入力)
     */
    public String getTokusenCntNote() {
        return tokusenCntNote;
    }

    /**
     * リスティング枠(手入力)を設定します。
     * @param tokusenCntNote リスティング枠(手入力)
     */
    public void setTokusenCntNote(String tokusenCntNote) {
        this.tokusenCntNote = tokusenCntNote;
    }

    /**
     * ユーザIDを取得します。
     * @return ユーザID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * ユーザIDを設定します。
     * @param userId ユーザID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * プログラム名を取得します。
     * @return プログラム名
     */
    public String getPgName() {
        return pgName;
    }

    /**
     * プログラム名を設定します。
     * @param pgName プログラム名
     */
    public void setPgName(String pgName) {
        this.pgName = pgName;
    }
}
