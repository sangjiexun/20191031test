/*
 * $Id: AspGroupInfoOutServiceBean.java 3769 2008-01-21 10:41:43Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.bean;


/**
 * グループに追加する店舗情報
 *
 * @author Yang-EunMi
 * @version $Revision: 3769 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspGroupInfoOutServiceBean {

    /** 店舗コード */
    private String groupshopCd;

    /** 会社名 */
    private String company;

    /** 事務所名 */
    private String bumon;

    /** 店舗メールアドレス */
    private String email;

    /** 代表者名 */
    private String licTrust;

    /** 代表Tel */
    private String shopTel;

    /** 代表Fax */
    private String shopFax;

    /** 承認 */
    private String certifyFlg;

    /** 状態 */
    private String shopStatus;

    /** CHINTAI掲載 */
    private String ctFlg;

    /** エイブル掲載 */
    private String ablFlg;

    /** データ元 */
    private String clientsystemType;

    /** ASP */
    private String aspFlg;

    /** 売買 */
    private String adparkSendFlg;

    /** 有効物件数 */
    private String bukkenCnt;

    /** ユーザ最終更新日付 */
    private String updDt;

    /** 区分 */
    private String datakubun;

    /** 不動産ＡＳＰ連番 add kashiyama */
    private Long aspShopSeq;

    /** 連動名 add kashiyama */
    private String rendoName;

    /** 店舗管理テーブル更新日時 */
    private String shopKanriUpdDt;

    /**
     * エイブル掲載を取得します。
     * @return ablFlg エイブル掲載
     */
    public String getAblFlg() {
        return ablFlg;
    }

    /**
     * エイブル掲載を設定します。
     * @param ablFlg エイブル掲載
     */
    public void setAblFlg(String ablFlg) {
        this.ablFlg = ablFlg;
    }

    /**
     * 売買を取得します。
     * @return adparkSendFlg 売買
     */
    public String getAdparkSendFlg() {
        return adparkSendFlg;
    }

    /**
     * 売買を設定します。
     * @param adparkSendFlg 売買
     */
    public void setAdparkSendFlg(String adparkSendFlg) {
        this.adparkSendFlg = adparkSendFlg;
    }

    /**
     * ASPを取得します。
     * @return aspFlg ASP
     */
    public String getAspFlg() {
        return aspFlg;
    }

    /**
     * ASPを設定します。
     * @param aspFlg ASP
     */
    public void setAspFlg(String aspFlg) {
        this.aspFlg = aspFlg;
    }

    /**
     * 有効物件数を取得します。
     * @return bukkenCnt 有効物件数
     */
    public String getBukkenCnt() {
        return bukkenCnt;
    }

    /**
     * 有効物件数を設定します。
     * @param bukkenCnt 有効物件数
     */
    public void setBukkenCnt(String bukkenCnt) {
        this.bukkenCnt = bukkenCnt;
    }

    /**
     * 事務所名を取得します。
     * @return bumon 事務所名
     */
    public String getBumon() {
        return bumon;
    }

    /**
     * 事務所名を設定します。
     * @param bumon 事務所名
     */
    public void setBumon(String bumon) {
        this.bumon = bumon;
    }

    /**
     * 承認を取得します。
     * @return certifyFlg 承認
     */
    public String getCertifyFlg() {
        return certifyFlg;
    }

    /**
     * 承認を設定します。
     * @param certifyFlg 承認
     */
    public void setCertifyFlg(String certifyFlg) {
        this.certifyFlg = certifyFlg;
    }

    /**
     * データ元を取得します。
     * @return clientsystemType データ元
     */
    public String getClientsystemType() {
        return clientsystemType;
    }

    /**
     * データ元を設定します。
     * @param clientsystemType データ元
     */
    public void setClientsystemType(String clientsystemType) {
        this.clientsystemType = clientsystemType;
    }

    /**
     * 会社名を取得します。
     * @return company 会社名
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
     * CHINTAI掲載を取得します。
     * @return ctFlg CHINTAI掲載
     */
    public String getCtFlg() {
        return ctFlg;
    }

    /**
     * CHINTAI掲載を設定します。
     * @param ctFlg CHINTAI掲載
     */
    public void setCtFlg(String ctFlg) {
        this.ctFlg = ctFlg;
    }

    /**
     * 店舗メールアドレスを取得します。
     * @return email 店舗メールアドレス
     */
    public String getEmail() {
        return email;
    }

    /**
     * 店舗メールアドレスを設定します。
     * @param email 店舗メールアドレス
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 代表者名を取得します。
     * @return licTrust 代表者名
     */
    public String getLicTrust() {
        return licTrust;
    }

    /**
     * 代表者名を設定します。
     * @param licTrust 代表者名
     */
    public void setLicTrust(String licTrust) {
        this.licTrust = licTrust;
    }

    /**
     * 店舗コードを取得します。
     * @return groupshopCd
     */
    public String getGroupshopCd() {
        return groupshopCd;
    }

    /**
     * 店舗コードを設定します。
     * @param groupshopCd
     */
    public void setGroupshopCd(String groupshopCd) {
        this.groupshopCd = groupshopCd;
    }

    /**
     * 代表Faxを取得します。
     * @return shopFax 代表Fax
     */
    public String getShopFax() {
        return shopFax;
    }

    /**
     * 代表Faxを設定します。
     * @param shopFax 代表Fax
     */
    public void setShopFax(String shopFax) {
        this.shopFax = shopFax;
    }

    /**
     * 状態を取得します。
     * @return shopStatus 状態
     */
    public String getShopStatus() {
        return shopStatus;
    }

    /**
     * 状態を設定します。
     * @param shopStatus 状態
     */
    public void setShopStatus(String shopStatus) {
        this.shopStatus = shopStatus;
    }

    /**
     * 代表Telを取得します。
     * @return shopTel 代表Tel
     */
    public String getShopTel() {
        return shopTel;
    }

    /**
     * 代表Telを設定します。
     * @param shopTel 代表Tel
     */
    public void setShopTel(String shopTel) {
        this.shopTel = shopTel;
    }

    /**
     * ユーザ最終更新日付を取得します。
     * @return updDt ユーザ最終更新日付
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * ユーザ最終更新日付を設定します。
     * @param updDt ユーザ最終更新日付
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }


    /**
     * 区分を設定します。
     * @return datakubun 区分
     */
    public String getDatakubun() {
        return datakubun;
    }


    /**
     * 区分を取得します。
     * @param datakubun 区分
     */
    public void setDatakubun(String datakubun) {
        this.datakubun = datakubun;
    }

    /**
     * 不動産ＡＳＰ連番を取得します。
     *
     * @return 不動産ＡＳＰ連番
     */
    public Long getAspShopSeq() {
        return aspShopSeq;
    }

    /**
     * 不動産ＡＳＰ連番を設定します。
     *
     * @param aspShopSeq
     *            不動産ＡＳＰ連番
     */
    public void setAspShopSeq(Long aspShopSeq) {
        this.aspShopSeq = aspShopSeq;
    }

    /**
     *  連動名を返します。
     * @return  連動名
     */
    public String getRendoName() {
        return rendoName;
    }

    /**
     *  連動名を設定します。
     * @param rendoName   連動名
     */
    public void setRendoName(String rendoName) {
        this.rendoName = rendoName;
    }

    /**
     *  店舗管理テーブル更新日時を返します。
     * @return  店舗管理テーブル更新日時
     */
    public String getShopKanriUpdDt() {
        return shopKanriUpdDt;
    }

    /**
     *  店舗管理テーブル更新日時を設定します。
     * @param shopKanriUpdDt   店舗管理テーブル更新日時
     */
    public void setShopKanriUpdDt(String shopKanriUpdDt) {
        this.shopKanriUpdDt = shopKanriUpdDt;
    }

}