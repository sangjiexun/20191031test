/*
 * $Id: InquiryLogOperationSearchParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/11  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.shop_inquiry.dao;

/**
 * システム操作履歴検索ParamBean
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class InquiryLogOperationSearchParamBean {

    /** 店舗コード */
    private String shopCd;

    /** 会社名／事務所名 */
    private String companyBumonName;

    /** 処理区分 */
    private String sessionStatus;

    /** 問い合せID */
    private String inqId;

    /** 処理日時（上限） */
    private String insDtFrom;

    /** 処理日時（下限） */
    private String insDtTo;

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
     * 会社名／事務所名を取得します。
     * @return 会社名／事務所名
     */
    public String getCompanyBumonName() {
        return companyBumonName;
    }

    /**
     * 会社名／事務所名を設定します。
     * @param companyBumonName 会社名／事務所名
     */
    public void setCompanyBumonName(String companyBumonName) {
        this.companyBumonName = companyBumonName;
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
     * 処理日時（上限）を取得します。
     * @return 処理日時（上限）
     */
    public String getInsDtFrom() {
        return insDtFrom;
    }

    /**
     * 処理日時（上限）を設定します。
     * @param insDtFrom 処理日時（上限）
     */
    public void setInsDtFrom(String insDtFrom) {
        this.insDtFrom = insDtFrom;
    }

    /**
     * 処理日時（下限）を取得します。
     * @return 処理日時（下限）
     */
    public String getInsDtTo() {
        return insDtTo;
    }

    /**
     * 処理日時（下限）を設定します。
     * @param insDtTo 処理日時（下限）
     */
    public void setInsDtTo(String insDtTo) {
        this.insDtTo = insDtTo;
    }
}