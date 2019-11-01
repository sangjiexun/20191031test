/*
 * $Id: CjnInquirySearchParamBean.java 4308 2009-07-14 06:46:43Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 2007/10/05  BGT)楊恩美     更新
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao;

import java.util.List;

/**
 * 問い合せ検索用パラメータBean。
 *
 * @author JavaBeans Code Generator
 * @author s-sugimoto
 * @version $Revision: 4308 $ *
 * @version 2008.07.10 雑誌・ザガット対応のproperty追加<br>
 *          Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquirySearchParamBean {

    /** 問い合せシーケンス */
    private int cjnInqKindSeq;

    /** 問い合せID */
    private String cjnInqId;

    /** キーワード */
    private String keywords;

    /** キーワードリスト */
    private List<String> keywordList;

    /** AND/OR */
    private String modeAndOr;

    /** 閲覧状況 */
    private String refFlg;

    /** 処理 */
    private String inquiryStatus;

    /** 問い合せ年月日時（下限） */
    private String insDateFromSearch;

    /** 問い合せ年月日時（上限） */
    private String insDateToSearch;

    /** ソートキー */
    private String sortKey;

    /** 順序 */
    private String orderBy;

    /** 表示件数 */
    private int displayNum;

    /** 問い合せ総数 */
    private int totalCnt;

    /** ユーザID */
    private String userId;

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
     * ユーザIDを設定します。
     * @return userId ユーザID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * ユーザIDを取得します。
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
     * AND/ORを取得します。
     * @return AND/OR
     */
    public String getModeAndOr() {
        return modeAndOr;
    }

    /**
     * AND/ORを設定します。
     * @param modeAndOr AND/OR
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
     * 処理を取得します。
     * @return 処理
     */
    public String getInquiryStatus() {
        return inquiryStatus;
    }

    /**
     * 処理を設定します。
     * @param inquiryStatus 処理
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
     * 問い合せ年月日時（上限）を設定します。
     * @param insDateToSearch 問い合せ年月日時（上限）
     */
    public void setInsDateToSearch(String insDateToSearch) {
        this.insDateToSearch = insDateToSearch;
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
     * 問い合せ総数を取得します。
     * @return 問い合せ総数
     */
    public int getTotalCnt() {
        return totalCnt;
    }

    /**
     * 問い合せ総数を設定します。
     * @param totalCnt 問い合せ総数
     */
    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }

    /**
     * キーワードリストを取得します。
     * @return キーワードリスト
     */
    public List<String> getKeywordList() {
        return keywordList;
    }

    /**
     * キーワードリストを設定します。
     * @param keywordList キーワードリスト
     */
    public void setKeywordList(List<String> keywordList) {
        this.keywordList = keywordList;
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
