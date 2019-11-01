/*
 * $Id: InquiryLogOperationSearchOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/11  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.shop_inquiry.service.bean;

/**
 * システム操作履歴検索OutServiceBean
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class InquiryLogOperationSearchOutServiceBean {

    /** 店舗コード */
    private String shopCd;

    /** 会社名 */
    private String company;

    /** 事務所名 */
    private String bumon;

    /** 処理区分 */
    private String sessionStatus;

    /** 問い合せID */
    private String inqId;

    /** 処理日時 */
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
     * 事務所名を取得します。
     * @return 事務所名
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
     * 処理区分を取得します。
     * @return 処理区分
     */
    public String getSessionStatus() {
        return sessionStatus;
    }

    /**
     * 処理区分を設定します。
     * @param sessionStatus 処理区分
     */
    public void setSessionStatus(String sessionStatus) {
        this.sessionStatus = sessionStatus;
    }

    /**
     * 問い合せIDを取得します。
     * @return 問い合せID
     */
    public String getInqId() {
        return inqId;
    }

    /**
     * 問い合せIDを設定します。
     * @param inqId 問い合せID
     */
    public void setInqId(String inqId) {
        this.inqId = inqId;
    }

    /**
     * 処理日時を取得します。
     * @return 処理日時
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 処理日時を設定します。
     * @param updDt 処理日時
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }
}