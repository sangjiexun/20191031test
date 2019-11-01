/*
 * $Id: ShopBindUpdatePageOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/13  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.bean;

/**
 * 店舗情報詳細検索結果
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopBindUpdatePageOutServiceBean {

    /** 店舗コード */
    private String shopCd;

    /** 地域コード */
    private String areaCd;

    /** 会社名 */
    private String company;

    /** 店舗名 */
    private String bumon;

    /** 郵便番号 */
    private String zip;

    /** 住所1 */
    private String address1;

    /** 住所2 */
    private String address2;

    /** 電話番号 */
    private String tel;

    /** ファクス */
    private String fax;

    /** メール */
    private String email;

    /** 担当者 */
    private String tantou;

    /** 不動産会社コード */
    private String fudousanCd;

    /** 取引先コード */
    private String torihikisakiCd;

    /** 不動産会社名 */
    private String fudousanName;

    /** 取引先名 */
    private String torihikisakiName;

    /** 取引先テーブルシーケンス */
    private String torihikisakiSeq;

    /** 取引先テーブル最終更新日時 */
    private String updDt;

    /**
     * 店舗コードを取得します。
     * @return 店舗コード
     */
    public String getShopCd() {
        return shopCd;
    }

    /**
     * 店舗コードを設定します。
     * @param shopCd 店舗コード
     */
    public void setShopCd(String shopCd) {
        this.shopCd = shopCd;
    }

    /**
     * 地域コードを取得します。
     * @return 地域コード
     */
    public String getAreaCd() {
        return areaCd;
    }

    /**
     * 地域コードを設定します。
     * @param areaCd 地域コード
     */
    public void setAreaCd(String areaCd) {
        this.areaCd = areaCd;
    }

    /**
     * 会社名を取得します。
     * @return 会社名
     */
    public String getCompany() {
        return company;
    }

    /**
     * 会社名を設定します。
     * @param company 会社名
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 店舗名を取得します。
     * @return 店舗名
     */
    public String getBumon() {
        return bumon;
    }

    /**
     * 店舗名を設定します。
     * @param bumon 店舗名
     */
    public void setBumon(String bumon) {
        this.bumon = bumon;
    }

    /**
     * 郵便番号を取得します。
     * @return 郵便番号
     */
    public String getZip() {
        return zip;
    }

    /**
     * 郵便番号を設定します。
     * @param zip 郵便番号
     */
    public void setZip(String zip) {
        this.zip = zip;
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
     * ファクスを取得します。
     * @return ファクス
     */
    public String getFax() {
        return fax;
    }

    /**
     * ファクスを設定します。
     * @param fax ファクス
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * メールを取得します。
     * @return メール
     */
    public String getEmail() {
        return email;
    }

    /**
     * メールを設定します。
     * @param email メール
     */
    public void setEmail(String email) {
        this.email = email;
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
     * 取引先テーブルシーケンスを取得します。
     * @return 取引先テーブルシーケンス
     */
    public String getTorihikisakiSeq() {
        return torihikisakiSeq;
    }

    /**
     * 取引先テーブルシーケンスを設定します。
     * @param torihikisakiSeq 取引先テーブルシーケンス
     */
    public void setTorihikisakiSeq(String torihikisakiSeq) {
        this.torihikisakiSeq = torihikisakiSeq;
    }

    /**
     * 取引先テーブル最終更新日時を取得します。
     * @return 取引先テーブル最終更新日時
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 取引先テーブル最終更新日時を設定します。
     * @param updDt 取引先テーブル最終更新日時
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }
}
