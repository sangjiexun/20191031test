/*
 * $Id: InquiryRecentSearchInServiceBean.java 4464 2010-09-27 08:05:10Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/05  BGT)金東珍     新規作成
 * 2007/06/25  BGT)李昊燮     キャリアタイプ追加
 */
package net.chintai.backend.sysadmin.shop_inquiry.service.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import net.chintai.backend.sysadmin.common.session.SessionSearchCondition;

/**
 * 問い合せ情報検索InServiceBean
 *
 * @author Kim Dong Jin
 * @version $Revision: 4464 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class InquiryRecentSearchInServiceBean implements SessionSearchCondition {

    /** serialVersionUID */
    private static final long serialVersionUID = 1492772793233860543L;

    /** 店舗コード */
    private String shopCd;

    /** 店舗名（会社名／事務所名） */
    private String companyBumonName;

    /** 問い合せID */
    private String inqId;

    /** キーワード */
    private String keyword;

    /** キーワードリスト */
    private List<String> keywordList;

    /** キーワード区分 */
    private String keywordMode;

    /** 大学 */
    private String schoolName;

    /** 大学リスト */
    private List<String> schoolList;

    /** 大学区分 */
    private String schoolMode;

    /** キーワードor大学ラジオボタン */
    private String keywordSchool;

    /** ガクセイCHINTAIからの問合せ*/
    private String schoolFlg;

    /** 問い合せ種類 */
    private String inqFlg;

    /** 問い合せ元 */
    private String sysFlg;

    /** キャリアタイプ */
    private String carrierType;

    /** 閲覧状況 */
    private String refFlg;

    /** 処理 */
    private String inquiryStatus;

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

    /** 並替え項目 */
    private String orderByItem;

    /** ページ */
    private Integer offSet;

    /** 表示件数 */
    private Integer cnt;

    /** 順序 */
    private String orderBy;

    private String outputMode;

    private String siteType;



    /**
     * 大学を取得します。
     * @return 大学
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * 大学を設定します。
     * @param schoolName 大学
     */
    public void setSchoolName(String schoolName) {
        String replaceSchoolName = schoolName.replaceAll("　", " ");
        setSchoolList(replaceSchoolName);
        this.schoolName = replaceSchoolName;


        this.schoolName = schoolName;
    }

    /**
     * 大学リストを取得します。
     * @return 大学リスト
     */
    public List<String> getSchoolList() {
        return schoolList;
    }

    /**
     * 大学リストを設定します。
     * @param schoolList 大学リスト
     */
    public void setSchoolList(String replaceSchoolName) {

        StringTokenizer st = new StringTokenizer(replaceSchoolName, " ");
        List<String> schoolList = new ArrayList<String>();
        while (st.hasMoreTokens()) {
            schoolList.add(st.nextToken());
        }
        this.schoolList = schoolList;
    }

    /**
     * 大学区分を取得します。
     * @return 大学区分
     */
    public String getSchoolMode() {
        return schoolMode;
    }

    /**
     * 大学区分を設定します。
     * @param schoolMode 大学区分
     */
    public void setSchoolMode(String schoolMode) {
        this.schoolMode = schoolMode;
    }

    /**
     * キーワードor大学ラジオボタンを取得します。
     * @return キーワードor大学ラジオボタン
     */
    public String getKeywordSchool() {
        return keywordSchool;
    }

    /**
     * キーワードor大学ラジオボタンを設定します。
     * @param keywordSchool キーワードor大学ラジオボタン
     */
    public void setKeywordSchool(String keywordSchool) {
        this.keywordSchool = keywordSchool;
    }

    /**
     * ガクセイCHINTAIからの問合せを取得します。
     * @return ガクセイCHINTAIからの問合せ
     */
    public String getSchoolFlg() {
        return schoolFlg;
    }

    /**
     * ガクセイCHINTAIからの問合せを設定します。
     * @param schoolFlg ガクセイCHINTAIからの問合せ
     */
    public void setSchoolFlg(String schoolFlg) {
        this.schoolFlg = schoolFlg;
    }

    /**
     * 問い合せ種類を取得します。
     * @return 問い合せ種類
     */
    public String getInqFlg() {
        return inqFlg;
    }

    /**
     * 問い合せ種類を設定します。
     * @param inqFlg 問い合せ種類
     */
    public void setInqFlg(String inqFlg) {
        this.inqFlg = inqFlg;
    }

    /**
     * 店舗名（会社名／事務所名）を取得します。
     * @return 店舗名（会社名／事務所名）
     */
    public String getCompanyBumonName() {
        return companyBumonName;
    }

    /**
     * 店舗名（会社名／事務所名）を設定します。
     * @param companyBumonName 店舗名（会社名／事務所名）
     */
    public void setCompanyBumonName(String companyBumonName) {
        this.companyBumonName = companyBumonName;
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
     * キーワードリストを設定します。
     * @param keywordList キーワードリスト
     */
    public void setKeywordList(List<String> keywordList) {
        this.keywordList = keywordList;
    }

    /**
     * キーワード区分を取得します。
     * @return キーワード区分
     */
    public String getKeywordMode() {
        return keywordMode;
    }

    /**
     * キーワード区分を設定します。
     * @param keywordMode キーワード区分
     */
    public void setKeywordMode(String keywordMode) {
        this.keywordMode = keywordMode;
    }

    /**
     * 問い合せ元を取得します。
     * @return 問い合せ元
     */
    public String getSysFlg() {
        return sysFlg;
    }

    /**
     * 問い合せ元を設定します。
     * @param sysFlg 問い合せ元
     */
    public void setSysFlg(String sysFlg) {
        this.sysFlg = sysFlg;
    }

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
     * ページを取得します。
     * @return ページ
     */
    public Integer getOffSet() {
        return offSet;
    }

    /**
     * ページを設定します。
     * @param offSet ページ
     */
    public void setOffSet(Integer offSet) {
        this.offSet = offSet;
    }

    /**
     * 表示件数を取得します。
     * @return 表示件数
     */
    public Integer getCnt() {
        return cnt;
    }

    /**
     * 表示件数を設定します。
     * @param cnt 表示件数
     */
    public void setCnt(Integer cnt) {
        this.cnt = cnt;
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
     * 並替え項目を取得します。
     * @return 並替え項目
     */
    public String getOrderByItem() {
        return orderByItem;
    }

    /**
     * 並替え項目を設定します。
     * @param orderByItem 並替え項目
     */
    public void setOrderByItem(String orderByItem) {
        this.orderByItem = orderByItem;
    }

    /**
     * 問い合せ日時（上限）を設定します。
     * @param insDtTo 問い合せ日時（上限）
     */
    public void setInsDtTo(String insDtTo) {
        this.insDtTo = insDtTo;
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
     * キャリアタイプを取得します。
     * @return キャリアタイプ
     */
    public String getCarrierType() {
        return carrierType;
    }

    /**
     * キャリアタイプを設定します。
     * @param carrierType キャリアタイプ
     */
    public void setCarrierType(String carrierType) {
        this.carrierType = carrierType;
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
     * 問い合せ日時（下限）を取得します。
     * @return 問い合せ日時（下限）
     */
    public String getInsDtFrom() {
        return insDtFrom;
    }

    /**
     * キーワードを取得します。
     * @return キーワード
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * キーワードを設定します。
     * @param keyword キーワード
     */
    public void setKeyword(String keyword) {
        String replaceKeyword = keyword.replaceAll("　", " ");
        setKeywordList(replaceKeyword);
        this.keyword = replaceKeyword;
    }

    /**
     * キーワードリストを取得します。
     * @return キーワードリスト
     */
    public List<String> getKeywordList() {
        return keywordList;
    }

    /**
     * キーワードリストを取得します。
     * @param replaceKeyword キーワード
     */
    public void setKeywordList(String replaceKeyword) {
        StringTokenizer st = new StringTokenizer(replaceKeyword, " ");
        List<String> keywordList = new ArrayList<String>();
        while (st.hasMoreTokens()) {
            keywordList.add(st.nextToken());
        }
        this.keywordList = keywordList;
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
     * outputModeを取得します。
     * @return outputMode
     */
    public String getOutputMode() {
        return outputMode;
    }

    /**
     * outputModeを設定します。
     * @param outputMode outputMode
     */
    public void setOutputMode(String outputMode) {
        this.outputMode = outputMode;
    }

	/**
	 * @return siteType
	 */
	public String getSiteType() {
		return siteType;
	}

	/**
	 * @param siteType セットする siteType
	 */
	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}
}