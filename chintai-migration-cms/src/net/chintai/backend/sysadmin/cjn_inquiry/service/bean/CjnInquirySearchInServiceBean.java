/*
 * $Id: CjnInquirySearchInServiceBean.java 3991 2008-07-14 11:31:20Z s-sugimoto $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 2007/09/29  BGT)児島       DB設計書に合わせて修正
 * 2007/10/05  BGT)楊恩美     更新
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.bean;

import net.chintai.backend.sysadmin.common.session.SessionSearchCondition;

/**
 * 問い合せ検索条件
 * 
 * @author JavaBeans Code Generator
 * @author KOJIMA Takanori
 * @author yang-eunmi
 * @author s-sugimoto
 * @version $Revision: 3991 $ <br>
 * @version 2008.07.10 雑誌・ザガット対応のproperty追加
 * 
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquirySearchInServiceBean implements SessionSearchCondition {

    /** serialVersionUID */
    private static final long serialVersionUID = -3933395762359428349L;

    /** 問い合せシーケンス */
    private int cjnInqKindSeq;

    /** 問い合せID */
    private String cjnInqId;

    /** キーワード */
    private String keywords;

    /** AND-OR */
    private String modeAndOr;

    /** 閲覧状況 */
    private String refFlg;

    /** 処理状況 */
    private String inquiryStatus;

    /** 問い合せ年月日時（下限） */
    private String insDateFromSearch;

    /** 問い合せ年月日時（上限） */
    private String insDateToSearch;

    /** 問い合せ年（下限） */
    private String insDtFromYear;

    /** 問い合せ月（下限） */
    private String insDtFromMonth;

    /** 問い合せ日（下限） */
    private String insDtFromDay;

    /** 問い合せ時（下限） */
    private String insDtFromTime;

    /** 問い合せ年（上限） */
    private String insDtToYear;

    /** 問い合せ月（上限） */
    private String insDtToMonth;

    /** 問い合せ日（上限） */
    private String insDtToDay;

    /** 問い合せ時（上限） */
    private String insDtToTime;

    /** ソートキー */
    private String sortKey;

    /** 順序 */
    private String orderBy;

    /** 表示件数 */
    private int displayNum;

    /** ユーザID */
    private String userId;

    /** 現在位置 */
    private int offSet;

    /**
     * PCモバイル区分
     * @since 2008.07.10 雑誌・ザガット対応
     */
    private String pcMobileStatus;

    /**
     * 取引番号
     * @since 2008.07.10 雑誌・ザガット対応
     */
    private String dealNumber;

    /**
     * 伝票番号
     * @since 2008.07.10 雑誌・ザガット対応
     */
    private String slipNumber;

    /**
     * ユーザIDを取得します。
     * @return ユーザID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * ユーザIDを設定します。
     * @param userId ユーザID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 問い合せシーケンスを取得します。
     * @return 問い合せシーケンス
     */
    public int getCjnInqKindSeq() {
        return cjnInqKindSeq;
    }

    /**
     * 問い合せシーケンスを設定します。
     * @param cjnInqKindSeq 問い合せシーケンス
     */
    public void setCjnInqKindSeq(int cjnInqKindSeq) {
        this.cjnInqKindSeq = cjnInqKindSeq;
    }

    /**
     * 問い合せIDを取得します。
     * @return 問い合せID
     */
    public String getCjnInqId() {
        return cjnInqId;
    }

    /**
     * 問い合せIDを設定します。
     * @param cjnInqId 問い合せID
     */
    public void setCjnInqId(String cjnInqId) {
        this.cjnInqId = cjnInqId;
    }

    /**
     * AND-ORを取得します。
     * @return AND-OR
     */
    public String getModeAndOr() {
        return modeAndOr;
    }

    /**
     * AND-ORを設定します。
     * @param modeAndOr AND-OR
     */
    public void setModeAndOr(String modeAndOr) {
        this.modeAndOr = modeAndOr;
    }

    /**
     * 閲覧状況を取得します。
     * @return 閲覧状況
     */
    public String getRefFlg() {
        return refFlg;
    }

    /**
     * 閲覧状況を設定します。
     * @param refFlg 閲覧状況
     */
    public void setRefFlg(String refFlg) {
        this.refFlg = refFlg;
    }

    /**
     * 処理状況を取得します。
     * @return 処理状況
     */
    public String getInquiryStatus() {
        return inquiryStatus;
    }

    /**
     * 処理状況を設定します。
     * @param inquiryStatus 処理状況
     */
    public void setInquiryStatus(String inquiryStatus) {
        this.inquiryStatus = inquiryStatus;
    }

    /**
     * 問い合せ年月日時（下限）を取得します。
     * @return 問い合せ年月日時（下限）
     */
    public String getInsDateFromSearch() {
        return insDateFromSearch;
    }

    /**
     * 問い合せ年月日時（下限）を設定します。
     * @param insDateFromSearch 問い合せ年月日時（下限）
     */
    public void setInsDateFromSearch(String insDateFromSearch) {
        this.insDateFromSearch = insDateFromSearch;
    }

    /**
     * 問い合せ年月日時（上限）を取得します。
     * @return 問い合せ年月日時（上限）
     */
    public String getInsDateToSearch() {
        return insDateToSearch;
    }

    /**
     * ソートキーを取得します。
     * @return ソートキー
     */
    public String getSortKey() {
        return sortKey;
    }

    /**
     * ソートキーを設定します。
     * @param sortKey ソートキー
     */
    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    /**
     * 順序を取得します。
     * @return 順序
     */
    public String getOrderBy() {
        return orderBy;
    }

    /**
     * 順序を設定します。
     * @param orderBy 順序
     */
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    /**
     * 表示件数を取得します。
     * @return 表示件数
     */
    public int getDisplayNum() {
        return displayNum;
    }

    /**
     * 表示件数を設定します。
     * @param displayNum 表示件数
     */
    public void setDisplayNum(int displayNum) {
        this.displayNum = displayNum;
    }

    /**
     * キーワードを取得します。
     * @return キーワード
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * キーワードを設定します。
     * @param keywords キーワード
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * 問い合せ月（下限）を取得します。
     * @return 問い合せ月（下限）
     */
    public String getInsDtFromMonth() {
        return insDtFromMonth;
    }

    /**
     * 問い合せ月（下限）を設定します。
     * @param insDtFromMonth 問い合せ月（下限）
     */
    public void setInsDtFromMonth(String insDtFromMonth) {
        this.insDtFromMonth = insDtFromMonth;
    }

    /**
     * 問い合せ日（下限）を取得します。
     * @return 問い合せ日（下限）
     */
    public String getInsDtFromDay() {
        return insDtFromDay;
    }

    /**
     * 問い合せ日（下限）を設定します。
     * @param insDtFromDay 問い合せ日（下限）
     */
    public void setInsDtFromDay(String insDtFromDay) {
        this.insDtFromDay = insDtFromDay;
    }

    /**
     * 問い合せ年月日時（上限）を設定します。
     * @param insDateToSearch 問い合せ年月日時（上限）
     */
    public void setInsDateToSearch(String insDateToSearch) {
        this.insDateToSearch = insDateToSearch;
    }

    /**
     * 問い合せ年（下限）を取得します。
     * @return 問い合せ年（下限）
     */
    public String getInsDtFromYear() {
        return insDtFromYear;
    }

    /**
     * 問い合せ年（下限）を設定します。
     * @param insDtFromYear 問い合せ年（下限）
     */
    public void setInsDtFromYear(String insDtFromYear) {
        this.insDtFromYear = insDtFromYear;
    }

    /**
     * 問い合せ月（上限）を取得します。
     * @return 問い合せ月（上限）
     */
    public String getInsDtToMonth() {
        return insDtToMonth;
    }

    /**
     * 問い合せ月（上限）を設定します。
     * @param insDtToMonth 問い合せ月（上限）
     */
    public void setInsDtToMonth(String insDtToMonth) {
        this.insDtToMonth = insDtToMonth;
    }

    /**
     * 問い合せ日（上限）を取得します。
     * @return 問い合せ日（上限）
     */
    public String getInsDtToDay() {
        return insDtToDay;
    }

    /**
     * 問い合せ日（上限）を設定します。
     * @param insDtToDay 問い合せ日（上限）
     */
    public void setInsDtToDay(String insDtToDay) {
        this.insDtToDay = insDtToDay;
    }

    /**
     * 問い合せ時（上限）を取得します。
     * @return 問い合せ時（上限）
     */
    public String getInsDtToTime() {
        return insDtToTime;
    }

    /**
     * 問い合せ時（上限）を設定します。
     * @param insDtToTime 問い合せ時（上限）
     */
    public void setInsDtToTime(String insDtToTime) {
        this.insDtToTime = insDtToTime;
    }

    /**
     * 問い合せ時（下限）を取得します。
     * @return 問い合せ時（下限）
     */
    public String getInsDtFromTime() {
        return insDtFromTime;
    }

    /**
     * 問い合せ時（下限）を設定します。
     * @param insDtFromTime 問い合せ時（下限）
     */
    public void setInsDtFromTime(String insDtFromTime) {
        this.insDtFromTime = insDtFromTime;
    }

    /**
     * 問い合せ年（上限）を取得します。
     * @return 問い合せ年（上限）
     */
    public String getInsDtToYear() {
        return insDtToYear;
    }

    /**
     * 問い合せ年（上限）を設定します。
     * @param insDtToYear 問い合せ年（上限）
     */
    public void setInsDtToYear(String insDtToYear) {
        this.insDtToYear = insDtToYear;
    }

    /**
     * 現在位置を取得します。
     * @return 現在位置
     */
    public int getOffSet() {
        return offSet;
    }

    /**
     * 現在位置を設定します。
     * @param offSet 現在位置
     */
    public void setOffSet(int offSet) {
        this.offSet = offSet;
    }

    /**
     * PCモバイル区分を取得します。
     * @return PCモバイル区分
     * @since 2008.07.10 雑誌・ザガット対応
     */
    public String getPcMobileStatus() {
        return pcMobileStatus;
    }

    /**
     * PCモバイル区分を設定します。
     * @param pcMobileStatus PCモバイル区分
     * @since 2008.07.10 雑誌・ザガット対応
     */
    public void setPcMobileStatus(String pcMobileStatus) {
        this.pcMobileStatus = pcMobileStatus;
    }

    /**
     * 取引番号を取得します。
     * @return 取引番号
     * @since 2008.07.10 雑誌・ザガット対応
     */
    public String getDealNumber() {
        return dealNumber;
    }

    /**
     * 取引番号を設定します。
     * @param dealNumber 取引番号
     * @since 2008.07.10 雑誌・ザガット対応
     */
    public void setDealNumber(String dealNumber) {
        this.dealNumber = dealNumber;
    }

    /**
     * 伝票番号を取得します。
     * @return 伝票番号
     * @since 2008.07.10 雑誌・ザガット対応
     */
    public String getSlipNumber() {
        return slipNumber;
    }

    /**
     * 伝票番号を設定します。
     * @param slipNumber 伝票番号
     * @since 2008.07.10 雑誌・ザガット対応
     */
    public void setSlipNumber(String slipNumber) {
        this.slipNumber = slipNumber;
    }
}
