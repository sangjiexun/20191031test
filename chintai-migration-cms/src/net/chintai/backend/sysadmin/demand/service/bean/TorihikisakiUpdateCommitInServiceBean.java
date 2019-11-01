/*
 * $Id: TorihikisakiUpdateCommitInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/06  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.bean;

/**
 * 取引先更新用データ
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiUpdateCommitInServiceBean {

    /** 不動産名 */
    private String fudousanName;

    /** 不動産コード */
    private String fudousanCd;

    /** 不動産コード */
    private String oldFudousanCd;

    /** 取引先名 */
    private String torihikisakiName;

    /** 取引先名 */
    private String torihikisakiCd;

    /** 取引先シーケンス番号 */
    private String torihikisakiSeq;

    /** 郵便番号１ */
    private String zipCd1;

    /** 郵便番号２ */
    private String zipCd2;

    /** 都道府県コード */
    private String prefCd;

    /** 住所１ */
    private String address1;

    /** 住所２ */
    private String address2;

    /** 電話番号 */
    private String tel;

    /** ファックス番号 */
    private String fax;

    /** 担当者名 */
    private String tantou;

    /** 取引支社コード */
    private String shisyaCd;

    /** 最終更新日時 */
    private String updDt;

    /** 更新者ID */
    private String updId;

    /** 更新プログラム */
    private String updPg;

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
     * 不動産コードを取得します。
     * @return 不動産コード
     */
    public String getOldFudousanCd() {
        return oldFudousanCd;
    }

    /**
     * 不動産コードを設定します。
     * @param oldFudousanCd 不動産コード
     */
    public void setOldFudousanCd(String oldFudousanCd) {
        this.oldFudousanCd = oldFudousanCd;
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
     * 取引先名を取得します。
     * @return 取引先名
     */
    public String getTorihikisakiCd() {
        return torihikisakiCd;
    }

    /**
     * 取引先名を設定します。
     * @param torihikisakiCd 取引先名
     */
    public void setTorihikisakiCd(String torihikisakiCd) {
        this.torihikisakiCd = torihikisakiCd;
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
     * 住所１を取得します。
     * @return 住所１
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * 住所１を設定します。
     * @param address1 住所１
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * 住所２を取得します。
     * @return 住所２
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * 住所２を設定します。
     * @param address2 住所２
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
     * ファックス番号を取得します。
     * @return ファックス番号
     */
    public String getFax() {
        return fax;
    }

    /**
     * ファックス番号を設定します。
     * @param fax ファックス番号
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * 担当者名を取得します。
     * @return 担当者名
     */
    public String getTantou() {
        return tantou;
    }

    /**
     * 担当者名を設定します。
     * @param tantou 担当者名
     */
    public void setTantou(String tantou) {
        this.tantou = tantou;
    }

    /**
     * 取引支社コードを取得します。
     * @return 取引支社コード
     */
    public String getShisyaCd() {
        return shisyaCd;
    }

    /**
     * 取引支社コードを設定します。
     * @param shisyaCd 取引支社コード
     */
    public void setShisyaCd(String shisyaCd) {
        this.shisyaCd = shisyaCd;
    }

    /**
     * 最終更新日時を取得します。
     * @return 最終更新日時
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 最終更新日時を設定します。
     * @param updDt 最終更新日時
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
     * 更新者IDを取得します。
     * @return 更新者ID
     */
    public String getUpdId() {
        return updId;
    }

    /**
     * 更新者IDを設定します。
     * @param updId 更新者ID
     */
    public void setUpdId(String updId) {
        this.updId = updId;
    }

    /**
     * 更新プログラムを取得します。
     * @return 更新プログラム
     */
    public String getUpdPg() {
        return updPg;
    }

    /**
     * 更新プログラムを設定します。
     * @param updPg 更新プログラム
     */
    public void setUpdPg(String updPg) {
        this.updPg = updPg;
    }
}
