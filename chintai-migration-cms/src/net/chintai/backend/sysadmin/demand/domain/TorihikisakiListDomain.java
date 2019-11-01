/*
 * $Id: TorihikisakiListDomain.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/19  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.domain;

/**
 * 取引先リスト検索結果(CSV出力検索用)
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiListDomain {

    /** 不動産会社コード */
    private String fudousanCd;

    /** 取引先コード */
    private String torihikisakiCd;

    /** 不動産会社名 */
    private String fudousanName;

    /** 不動産会社-郵便番号 */
    private String fZipcd;

    /** 不動産会社-都道府県名 */
    private String fPrefName;

    /** 不動産会社-住所１ */
    private String fAddress1;

    /** 不動産会社-住所２ */
    private String fAddress2;

    /** 不動産会社-電話番号 */
    private String fTel;

    /** 不動産会社-ファクス番号 */
    private String fFax;

    /** 不動産会社-担当者名 */
    private String fTantou;

    /** 取引先名 */
    private String torihikisakiName;

    /** 取引先-郵便番号 */
    private String tZipcd;

    /** 取引先-都道府県名 */
    private String tPrefName;

    /** 取引先-住所１ */
    private String tAddress1;

    /** 取引先-住所２ */
    private String tAddress2;

    /** 取引先-電話番号 */
    private String tTel;

    /** 取引先-ファクス番号 */
    private String tFax;

    /** 取引先-担当者名 */
    private String tTantou;

    /** 取引先担当支社コード */
    private String shisyaCd;

    /** 取引先担当支社名 */
    private String shisyaName;

    /** 適用年 */
    private String startYear;

    /** 適用月 */
    private String startMonth;

    /** 物件枠 */
    private String bukkenCnt;

    /** リスティング枠 */
    private String tokusenCnt;

    /** 取引先シーケンス番号 */
    private String torihikisakiSeq;

    /**
     * 不動産会社コードを取得します。
     * @return 不動産会社コード
     */
    public String getFudousanCd() {
        return fudousanCd;
    }

    /**
     * 不動産会社コードを設定します。
     * @param fudousanCd 不動産会社コード
     */
    public void setFudousanCd(String fudousanCd) {
        this.fudousanCd = fudousanCd;
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
     * 不動産会社名を取得します。
     * @return 不動産会社名
     */
    public String getFudousanName() {
        return fudousanName;
    }

    /**
     * 不動産会社名を設定します。
     * @param fudousanName 不動産会社名
     */
    public void setFudousanName(String fudousanName) {
        this.fudousanName = fudousanName;
    }

    /**
     * 不動産会社-郵便番号を取得します。
     * @return 不動産会社-郵便番号
     */
    public String getFZipcd() {
        return fZipcd;
    }

    /**
     * 不動産会社-郵便番号を設定します。
     * @param fZipcd 不動産会社-郵便番号
     */
    public void setFZipcd(String fZipcd) {
        this.fZipcd = fZipcd;
    }

    /**
     * 不動産会社-都道府県名を取得します。
     * @return 不動産会社-都道府県名
     */
    public String getFPrefName() {
        return fPrefName;
    }

    /**
     * 不動産会社-都道府県名を設定します。
     * @param fPrefName 不動産会社-都道府県名
     */
    public void setFPrefName(String fPrefName) {
        this.fPrefName = fPrefName;
    }

    /**
     * 不動産会社-住所１を取得します。
     * @return 不動産会社-住所１
     */
    public String getFAddress1() {
        return fAddress1;
    }

    /**
     * 不動産会社-住所１を設定します。
     * @param fAddress1 不動産会社-住所１
     */
    public void setFAddress1(String fAddress1) {
        this.fAddress1 = fAddress1;
    }

    /**
     * 不動産会社-住所２を取得します。
     * @return 不動産会社-住所２
     */
    public String getFAddress2() {
        return fAddress2;
    }

    /**
     * 不動産会社-住所２を設定します。
     * @param fAddress2 不動産会社-住所２
     */
    public void setFAddress2(String fAddress2) {
        this.fAddress2 = fAddress2;
    }

    /**
     * 不動産会社-電話番号を取得します。
     * @return 不動産会社-電話番号
     */
    public String getFTel() {
        return fTel;
    }

    /**
     * 不動産会社-電話番号を設定します。
     * @param fTel 不動産会社-電話番号
     */
    public void setFTel(String fTel) {
        this.fTel = fTel;
    }

    /**
     * 不動産会社-ファクス番号を取得します。
     * @return 不動産会社-ファクス番号
     */
    public String getFFax() {
        return fFax;
    }

    /**
     * 不動産会社-ファクス番号を設定します。
     * @param fFax 不動産会社-ファクス番号
     */
    public void setFFax(String fFax) {
        this.fFax = fFax;
    }

    /**
     * 不動産会社-担当者名を取得します。
     * @return 不動産会社-担当者名
     */
    public String getFTantou() {
        return fTantou;
    }

    /**
     * 不動産会社-担当者名を設定します。
     * @param fTantou 不動産会社-担当者名
     */
    public void setFTantou(String fTantou) {
        this.fTantou = fTantou;
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
     * 取引先-郵便番号を取得します。
     * @return 取引先-郵便番号
     */
    public String getTZipcd() {
        return tZipcd;
    }

    /**
     * 取引先-郵便番号を設定します。
     * @param tZipcd 取引先-郵便番号
     */
    public void setTZipcd(String tZipcd) {
        this.tZipcd = tZipcd;
    }

    /**
     * 取引先-都道府県名を取得します。
     * @return 取引先-都道府県名
     */
    public String getTPrefName() {
        return tPrefName;
    }

    /**
     * 取引先-都道府県名を設定します。
     * @param tPrefName 取引先-都道府県名
     */
    public void setTPrefName(String tPrefName) {
        this.tPrefName = tPrefName;
    }

    /**
     * 取引先-住所１を取得します。
     * @return 取引先-住所１
     */
    public String getTAddress1() {
        return tAddress1;
    }

    /**
     * 取引先-住所１を設定します。
     * @param tAddress1 取引先-住所１
     */
    public void setTAddress1(String tAddress1) {
        this.tAddress1 = tAddress1;
    }

    /**
     * 取引先-住所２を取得します。
     * @return 取引先-住所２
     */
    public String getTAddress2() {
        return tAddress2;
    }

    /**
     * 取引先-住所２を設定します。
     * @param tAddress2 取引先-住所２
     */
    public void setTAddress2(String tAddress2) {
        this.tAddress2 = tAddress2;
    }

    /**
     * 取引先-電話番号を取得します。
     * @return 取引先-電話番号
     */
    public String getTTel() {
        return tTel;
    }

    /**
     * 取引先-電話番号を設定します。
     * @param tTel 取引先-電話番号
     */
    public void setTTel(String tTel) {
        this.tTel = tTel;
    }

    /**
     * 取引先-ファクス番号を取得します。
     * @return 取引先-ファクス番号
     */
    public String getTFax() {
        return tFax;
    }

    /**
     * 取引先-ファクス番号を設定します。
     * @param tFax 取引先-ファクス番号
     */
    public void setTFax(String tFax) {
        this.tFax = tFax;
    }

    /**
     * 取引先-担当者名を取得します。
     * @return 取引先-担当者名
     */
    public String getTTantou() {
        return tTantou;
    }

    /**
     * 取引先-担当者名を設定します。
     * @param tTantou 取引先-担当者名
     */
    public void setTTantou(String tTantou) {
        this.tTantou = tTantou;
    }

    /**
     * 取引先担当支社コードを取得します。
     * @return 取引先担当支社コード
     */
    public String getShisyaCd() {
        return shisyaCd;
    }

    /**
     * 取引先担当支社コードを設定します。
     * @param shisyaCd 取引先担当支社コード
     */
    public void setShisyaCd(String shisyaCd) {
        this.shisyaCd = shisyaCd;
    }

    /**
     * 取引先担当支社名を取得します。
     * @return 取引先担当支社名
     */
    public String getShisyaName() {
        return shisyaName;
    }

    /**
     * 取引先担当支社名を設定します。
     * @param shisyaName 取引先担当支社名
     */
    public void setShisyaName(String shisyaName) {
        this.shisyaName = shisyaName;
    }

    /**
     * 適用年を取得します。
     * @return 適用年
     */
    public String getStartYear() {
        return startYear;
    }

    /**
     * 適用年を設定します。
     * @param startYear 適用年
     */
    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    /**
     * 適用月を取得します。
     * @return 適用月
     */
    public String getStartMonth() {
        return startMonth;
    }

    /**
     * 適用月を設定します。
     * @param startMonth 適用月
     */
    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
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
     * 取引先シーケンス番号を取得します。
     * @return 取引先シーケンス番号
     */
    public String getTorihikisakiSeq() {
        return torihikisakiSeq;
    }

    /**
     * 取引先シーケンス番号を設定します。
     * @param torihikisakiSeq 取引先シーケンス番号
     */
    public void setTorihikisakiSeq(String torihikisakiSeq) {
        this.torihikisakiSeq = torihikisakiSeq;
    }
}
