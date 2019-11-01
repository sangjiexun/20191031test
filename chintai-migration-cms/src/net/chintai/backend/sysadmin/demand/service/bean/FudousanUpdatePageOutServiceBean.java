/*
 * $Id: FudousanUpdatePageOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/29     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.bean;

/**
 * 不動産会社更新情報
 * 
 * @author TAKAHASHI Yuki
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanUpdatePageOutServiceBean {

    /** 不動産会社名 */
    private String fudousanName;

    /** 不動産会社コード */
    private String fudousanCd;

    /** 郵便番号（前3桁） */
    private String zipCode1;

    /** 郵便番号（後4桁） */
    private String zipCode2;

    /** 都道府県コード */
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
     * @return address1
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * @param address1 設定する address1
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * @return address2
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * @param address2 設定する address2
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * @return fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax 設定する fax
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * @return fudousanCd
     */
    public String getFudousanCd() {
        return fudousanCd;
    }

    /**
     * @param fudousanCd 設定する fudousanCd
     */
    public void setFudousanCd(String fudousanCd) {
        this.fudousanCd = fudousanCd;
    }

    /**
     * @return fudousanName
     */
    public String getFudousanName() {
        return fudousanName;
    }

    /**
     * @param fudousanName 設定する fudousanName
     */
    public void setFudousanName(String fudousanName) {
        this.fudousanName = fudousanName;
    }

    /**
     * @return insDt
     */
    public String getInsDt() {
        return insDt;
    }

    /**
     * @param insDt 設定する insDt
     */
    public void setInsDt(String insDt) {
        this.insDt = insDt;
    }

    /**
     * @return prefName
     */
    public String getPrefName() {
        return prefName;
    }

    /**
     * @param prefName 設定する prefName
     */
    public void setPrefName(String prefName) {
        this.prefName = prefName;
    }

    /**
     * @return tantou
     */
    public String getTantou() {
        return tantou;
    }

    /**
     * @param tantou 設定する tantou
     */
    public void setTantou(String tantou) {
        this.tantou = tantou;
    }

    /**
     * @return tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel 設定する tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return updDt
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * @param updDt 設定する updDt
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
     * @return zipCode1
     */
    public String getZipCode1() {
        return zipCode1;
    }

    /**
     * @param zipCode1 設定する zipCode1
     */
    public void setZipCode1(String zipCode1) {
        this.zipCode1 = zipCode1;
    }

    /**
     * @return zipCode2
     */
    public String getZipCode2() {
        return zipCode2;
    }

    /**
     * @param zipCode2 設定する zipCode2
     */
    public void setZipCode2(String zipCode2) {
        this.zipCode2 = zipCode2;
    }

    /**
     * @return prefCd
     */
    public String getPrefCd() {
        return prefCd;
    }

    /**
     * @param prefCd 設定する prefCd
     */
    public void setPrefCd(String prefCd) {
        this.prefCd = prefCd;
    }

}
