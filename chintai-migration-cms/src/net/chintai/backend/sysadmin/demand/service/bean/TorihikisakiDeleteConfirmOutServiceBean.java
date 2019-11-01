/*
 * $Id: TorihikisakiDeleteConfirmOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/06  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.bean;

/**
 * 取引先削除確認
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiDeleteConfirmOutServiceBean {

    /** 不動産会社名称 */
    private String fudousanName;

    /** 取引先名称 */
    private String torihikisakiName;

    /** 不動産会社コード */
    private String fudousanCd;

    /** 取引先コード */
    private String torihikisakiCd;

    /** 取引先コード */
    private String torihikisakiSeq;

    /** 郵便番号 */
    private String zipCd;

    /** 都道府県名 */
    private String prefName;

    /** 住所１ */
    private String address1;

    /** 住所２ */
    private String address2;

    /** 最終更新日 */
    private String updDt;

    /**
     * 不動産会社名称を取得します。
     * @return 不動産会社名称
     */
    public String getFudousanName() {
        return fudousanName;
    }

    /**
     * 不動産会社名称を設定します。
     * @param fudousanName 不動産会社名称
     */
    public void setFudousanName(String fudousanName) {
        this.fudousanName = fudousanName;
    }

    /**
     * 取引先名称を取得します。
     * @return 取引先名称
     */
    public String getTorihikisakiName() {
        return torihikisakiName;
    }

    /**
     * 取引先名称を設定します。
     * @param torihikisakiName 取引先名称
     */
    public void setTorihikisakiName(String torihikisakiName) {
        this.torihikisakiName = torihikisakiName;
    }

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
     * 取引先コードを取得します。
     * @return 取引先コード
     */
    public String getTorihikisakiSeq() {
        return torihikisakiSeq;
    }

    /**
     * 取引先コードを設定します。
     * @param torihikisakiSeq 取引先コード
     */
    public void setTorihikisakiSeq(String torihikisakiSeq) {
        this.torihikisakiSeq = torihikisakiSeq;
    }

    /**
     * 郵便番号を取得します。
     * @return 郵便番号
     */
    public String getZipCd() {
        return zipCd;
    }

    /**
     * 郵便番号を設定します。
     * @param zipCd 郵便番号
     */
    public void setZipCd(String zipCd) {
        this.zipCd = zipCd;
    }

    /**
     * 都道府県名を取得します。
     * @return 都道府県名
     */
    public String getPrefName() {
        return prefName;
    }

    /**
     * 都道府県名を設定します。
     * @param prefName 都道府県名
     */
    public void setPrefName(String prefName) {
        this.prefName = prefName;
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
     * 最終更新日を取得します。
     * @return 最終更新日
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 最終更新日を設定します。
     * @param updDt 最終更新日
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

}
