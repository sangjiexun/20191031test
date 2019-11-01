/*
 * $Id: InquiryLogOperationSearchInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/11  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.shop_inquiry.service.bean;

import net.chintai.backend.sysadmin.common.session.SessionSearchCondition;

/**
 * システム操作履歴検索InServiceBean
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class InquiryLogOperationSearchInServiceBean implements SessionSearchCondition {

    /** serialVersionUID */
    private static final long serialVersionUID = -1007738355648053785L;

    /** 店舗コード */
    private String shopCd;

    /** 会社名／事務所名 */
    private String companyBumonName;

    /** 処理区分 */
    private String sessionStatus;

    /** 問い合せID */
    private String inqId;

    /** 問い合せ日時（下限） */
    private String insDtFrom;

    /** 問い合せ年（下限） */
    private String fromYear;

    /** 問い合せ月（下限） */
    private String fromMonth;

    /** 問い合せ日（下限） */
    private String fromDay;

    /** 問い合せ時（下限） */
    private String fromTime;

    /** 問い合せ日時（上限） */
    private String insDtTo;

    /** 問い合せ年（上限） */
    private String toYear;

    /** 問い合せ月（上限） */
    private String toMonth;

    /** 問い合せ日（上限） */
    private String toDay;

    /** 問い合せ時（上限） */
    private String toTime;

    /** 開始位置 */
    private int offSet;

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
     * 問い合せ日時（下限）を取得します。
     * @return 問い合せ日時（下限）
     */
    public String getInsDtFrom() {
        return insDtFrom;
    }

    /**
     * 問い合せ日時（下限）を設定します。
     * @param insDtFrom 問い合せ日時（下限）
     */
    public void setInsDtFrom(String insDtFrom) {
        this.insDtFrom = insDtFrom;
    }

    /**
     * 問い合せ年（下限）を取得します。
     * @return 問い合せ年（下限）
     */
    public String getFromYear() {
        return fromYear;
    }

    /**
     * 問い合せ年（下限）を設定します。
     * @param fromYear 問い合せ年（下限）
     */
    public void setFromYear(String fromYear) {
        this.fromYear = fromYear;
    }

    /**
     * 問い合せ月（下限）を取得します。
     * @return 問い合せ月（下限）
     */
    public String getFromMonth() {
        return fromMonth;
    }

    /**
     * 問い合せ月（下限）を設定します。
     * @param fromMonth 問い合せ月（下限）
     */
    public void setFromMonth(String fromMonth) {
        this.fromMonth = fromMonth;
    }

    /**
     * 問い合せ日（下限）を取得します。
     * @return 問い合せ日（下限）
     */
    public String getFromDay() {
        return fromDay;
    }

    /**
     * 問い合せ日（下限）を設定します。
     * @param fromDay 問い合せ日（下限）
     */
    public void setFromDay(String fromDay) {
        this.fromDay = fromDay;
    }

    /**
     * 問い合せ時（下限）を取得します。
     * @return 問い合せ時（下限）
     */
    public String getFromTime() {
        return fromTime;
    }

    /**
     * 問い合せ時（下限）を設定します。
     * @param fromTime 問い合せ時（下限）
     */
    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    /**
     * 問い合せ日時（上限）を取得します。
     * @return 問い合せ日時（上限）
     */
    public String getInsDtTo() {
        return insDtTo;
    }

    /**
     * 問い合せ日時（上限）を設定します。
     * @param insDtTo 問い合せ日時（上限）
     */
    public void setInsDtTo(String insDtTo) {
        this.insDtTo = insDtTo;
    }

    /**
     * 問い合せ年（上限）を取得します。
     * @return 問い合せ年（上限）
     */
    public String getToYear() {
        return toYear;
    }

    /**
     * 問い合せ年（上限）を設定します。
     * @param toYear 問い合せ年（上限）
     */
    public void setToYear(String toYear) {
        this.toYear = toYear;
    }

    /**
     * 問い合せ月（上限）を取得します。
     * @return 問い合せ月（上限）
     */
    public String getToMonth() {
        return toMonth;
    }

    /**
     * 問い合せ月（上限）を設定します。
     * @param toMonth 問い合せ月（上限）
     */
    public void setToMonth(String toMonth) {
        this.toMonth = toMonth;
    }

    /**
     * 問い合せ日（上限）を取得します。
     * @return 問い合せ日（上限）
     */
    public String getToDay() {
        return toDay;
    }

    /**
     * 問い合せ日（上限）を設定します。
     * @param toDay 問い合せ日（上限）
     */
    public void setToDay(String toDay) {
        this.toDay = toDay;
    }

    /**
     * 問い合せ時（上限）を取得します。
     * @return 問い合せ時（上限）
     */
    public String getToTime() {
        return toTime;
    }

    /**
     * 問い合せ時（上限）を設定します。
     * @param toTime 問い合せ時（上限）
     */
    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    /**
     * 開始位置を取得します。
     * @return 開始位置
     */
    public int getOffSet() {
        return offSet;
    }

    /**
     * 開始位置を設定します。
     * @param offSet 開始位置
     */
    public void setOffSet(int offSet) {
        this.offSet = offSet;
    }
}