/*
 * $Id: FudousanDomain.java 3678 2007-12-20 04:41:57Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/29     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.domain;

/**
 * 不動産会社詳細
 *
 * @author TAKAHASHI Yuki
 * @version $Revision: 3678 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public class FudousanDomain {

    /** 不動産会社名 */
    private String fudousanName;

    /** 不動産会社コード */
    private String fudousanCd;

    /** 郵便番号（前3桁） */
    private String zipCode1;

    /** 郵便番号（後4桁） */
    private String zipCode2;

    /** 都道府コード */
    private String prefCd;

    /** 都道府県名 */
    private String prefName;

    /** 住所１ */
    private String address1;

    /** 住所２ */
    private String address2;

    /** 電話番号 */
    private String tel;

    /** FAX番号 */
    private String fax;

    /** 担当者名 */
    private String tantou;

    /** 登録日 */
    private String insDt;

    /** 更新日 */
    private String updDt;

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
     * 郵便番号（前3桁）を取得します。
     * @return 郵便番号（前3桁）
     */
    public String getZipCode1() {
        return zipCode1;
    }

    /**
     * 郵便番号（前3桁）を設定します。
     * @param zipCode1 郵便番号（前3桁）
     */
    public void setZipCode1(String zipCode1) {
        this.zipCode1 = zipCode1;
    }

    /**
     * 郵便番号（後4桁）を取得します。
     * @return 郵便番号（後4桁）
     */
    public String getZipCode2() {
        return zipCode2;
    }

    /**
     * 郵便番号（後4桁）を設定します。
     * @param zipCode2 郵便番号（後4桁）
     */
    public void setZipCode2(String zipCode2) {
        this.zipCode2 = zipCode2;
    }

    /**
     * 都道府コードを取得します。
     * @return 都道府コード
     */
    public String getPrefCd() {
        return prefCd;
    }

    /**
     * 都道府コードを設定します。
     * @param prefCd 都道府コード
     */
    public void setPrefCd(String prefCd) {
        this.prefCd = prefCd;
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
     * FAX番号を取得します。
     * @return FAX番号
     */
    public String getFax() {
        return fax;
    }

    /**
     * FAX番号を設定します。
     * @param fax FAX番号
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
     * 登録日を取得します。
     * @return 登録日
     */
    public String getInsDt() {
        return insDt;
    }

    /**
     * 登録日を設定します。
     * @param insDt 登録日
     */
    public void setInsDt(String insDt) {
        this.insDt = insDt;
    }

    /**
     * 更新日を取得します。
     * @return 更新日
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 更新日を設定します。
     * @param updDt 更新日
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

}
