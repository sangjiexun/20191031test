/*
 * $Id: FudousanRegisterCommitParamBean.java 3667 2007-12-20 01:50:10Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/22  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

/**
 * 登録する不動産会社の情報
 *
 * @author lee-hosup
 * @version $Revision: 3667 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanRegisterCommitParamBean {

    /** 不動産会社コード */
    private String fudousanCd;

    /** 不動産会社名 */
    private String fudousanName;

    /** 郵便番号1 */
    private String zipCode1;

    /** 郵便番号2 */
    private String zipCode2;

    /** 都道府県 */
    private String prefCd;

    /** 住所1 */
    private String address1;

    /** 住所2 */
    private String address2;

    /** 電話番号 */
    private String tel;

    /** Fax番号 */
    private String fax;

    /** 担当者 */
    private String tantou;

    /** 登録プログラムID */
    private String insPg;

    /** 登録者ID */
    private String insId;

    /** 更新プログラムID */
    private String updPg;

    /** 更新者ID */
    private String updId;

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
     * 郵便番号1を取得します。
     * @return 郵便番号1
     */
    public String getZipCode1() {
        return zipCode1;
    }

    /**
     * 郵便番号1を設定します。
     * @param zipCode1 郵便番号1
     */
    public void setZipCode1(String zipCode1) {
        this.zipCode1 = zipCode1;
    }

    /**
     * 郵便番号2を取得します。
     * @return 郵便番号2
     */
    public String getZipCode2() {
        return zipCode2;
    }

    /**
     * 郵便番号2を設定します。
     * @param zipCode2 郵便番号2
     */
    public void setZipCode2(String zipCode2) {
        this.zipCode2 = zipCode2;
    }

    /**
     * 都道府県を取得します。
     * @return 都道府県
     */
    public String getPrefCd() {
        return prefCd;
    }

    /**
     * 都道府県を設定します。
     * @param prefCd 都道府県
     */
    public void setPrefCd(String prefCd) {
        this.prefCd = prefCd;
    }

    /**
     * 住所1を取得します。
     * @return 住所1
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * 住所1を設定します。
     * @param address1 住所1
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * 住所2を取得します。
     * @return 住所2
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * 住所2を設定します。
     * @param address2 住所2
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
     * Fax番号を取得します。
     * @return Fax番号
     */
    public String getFax() {
        return fax;
    }

    /**
     * Fax番号を設定します。
     * @param fax Fax番号
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * 担当者を取得します。
     * @return 担当者
     */
    public String getTantou() {
        return tantou;
    }

    /**
     * 担当者を設定します。
     * @param tantou 担当者
     */
    public void setTantou(String tantou) {
        this.tantou = tantou;
    }

    /**
     * 登録プログラムIDを取得します。
     * @return 登録プログラムID
     */
    public String getInsPg() {
        return insPg;
    }

    /**
     * 登録プログラムIDを設定します。
     * @param insPg 登録プログラムID
     */
    public void setInsPg(String insPg) {
        this.insPg = insPg;
    }

    /**
     * 登録者IDを取得します。
     * @return 登録者ID
     */
    public String getInsId() {
        return insId;
    }

    /**
     * 登録者IDを設定します。
     * @param insId 登録者ID
     */
    public void setInsId(String insId) {
        this.insId = insId;
    }

    /**
     * 更新プログラムIDを取得します。
     * @return 更新プログラムID
     */
    public String getUpdPg() {
        return updPg;
    }

    /**
     * 更新プログラムIDを設定します。
     * @param updPg 更新プログラムID
     */
    public void setUpdPg(String updPg) {
        this.updPg = updPg;
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

}
