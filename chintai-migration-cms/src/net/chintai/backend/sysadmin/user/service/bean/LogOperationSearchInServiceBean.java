/*
 * $Id: LogOperationSearchInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.user.service.bean;

import net.chintai.backend.sysadmin.common.session.SessionSearchCondition;

/**
 * 操作ログ検索Bean
 * 
 * @author JavaBeans Code Generator
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class LogOperationSearchInServiceBean implements SessionSearchCondition {

    /** serialVersionUID */
    private static final long serialVersionUID = -5959802606955601675L;

    /** ユーザID */
    private String userIdSearch;

    /** 名前 */
    private String userNameSearch;

    /** 操作 */
    private String authority;

    /** 操作内容 */
    private String operationIdSearch;

    /** 処理日時(下限) */
    private String insDtFrom;

    /** 処理年(下限) */
    private String fromYear;

    /** 処理月(下限) */
    private String fromMonth;

    /** 処理日(下限) */
    private String fromDay;

    /** 処理時(下限) */
    private String fromTime;

    /** 処理日時(上限) */
    private String insDtTo;

    /** 処理年(上限) */
    private String toYear;

    /** 処理年(上限) */
    private String toMonth;

    /** 処理年(上限) */
    private String toDay;

    /** 処理年(上限) */
    private String toTime;

    /** ソートキー */
    private String sortKey;

    /** 順序 */
    private String orderBy;

    /** 表示件数 */
    private int displayNum;

    /** 開始位置 */
    private int offSet;

    /**
     * ユーザIDを取得します。
     * @return ユーザID
     */
    public String getUserIdSearch() {
        return userIdSearch;
    }

    /**
     * ユーザIDを設定します。
     * @param userIdSearch ユーザID
     */
    public void setUserIdSearch(String userIdSearch) {
        this.userIdSearch = userIdSearch;
    }

    /**
     * 名前を取得します。
     * @return 名前
     */
    public String getUserNameSearch() {
        return userNameSearch;
    }

    /**
     * 名前を設定します。
     * @param userNameSearch 名前
     */
    public void setUserNameSearch(String userNameSearch) {
        this.userNameSearch = userNameSearch;
    }

    /**
     * 操作を取得します。
     * @return 操作
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * 操作を設定します。
     * @param authority 操作
     */
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    /**
     * 操作内容を取得します。
     * @return 操作内容
     */
    public String getOperationIdSearch() {
        return operationIdSearch;
    }

    /**
     * 操作内容を設定します。
     * @param operationIdSearch 操作内容
     */
    public void setOperationIdSearch(String operationIdSearch) {
        this.operationIdSearch = operationIdSearch;
    }

    /**
     * 処理日時(下限)を取得します。
     * @return 処理日時(下限)
     */
    public String getInsDtFrom() {
        return insDtFrom;
    }

    /**
     * 処理日時(下限)を設定します。
     * @param insDtFrom 処理日時(下限)
     */
    public void setInsDtFrom(String insDtFrom) {
        this.insDtFrom = insDtFrom;
    }

    /**
     * 処理日時(上限)を取得します。
     * @return 処理日時(上限)
     */
    public String getInsDtTo() {
        return insDtTo;
    }

    /**
     * 処理日時(上限)を設定します。
     * @param insDtTo 処理日時(上限)
     */
    public void setInsDtTo(String insDtTo) {
        this.insDtTo = insDtTo;
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
     * 処理日(下限)を取得します。
     * @return 処理日(下限)
     */
    public String getFromDay() {
        return fromDay;
    }

    /**
     * 処理日(下限)を設定します。
     * @param fromDay 処理日(下限)
     */
    public void setFromDay(String fromDay) {
        this.fromDay = fromDay;
    }

    /**
     * 処理月(下限)を取得します。
     * @return 処理月(下限)
     */
    public String getFromMonth() {
        return fromMonth;
    }

    /**
     * 処理月(下限)を設定します。
     * @param fromMonth 処理月(下限)
     */
    public void setFromMonth(String fromMonth) {
        this.fromMonth = fromMonth;
    }

    /**
     * 処理時(下限)を取得します。
     * @return 処理時(下限)
     */
    public String getFromTime() {
        return fromTime;
    }

    /**
     * 処理時(下限)を設定します。
     * @param fromTime 処理時(下限)
     */
    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    /**
     * 処理年(下限)を取得します。
     * @return 処理年(下限)
     */
    public String getFromYear() {
        return fromYear;
    }

    /**
     * 処理年(下限)を設定します。
     * @param fromYear 処理年(下限)
     */
    public void setFromYear(String fromYear) {
        this.fromYear = fromYear;
    }

    /**
     * 処理年(上限)を取得します。
     * @return 処理年(上限)
     */
    public String getToDay() {
        return toDay;
    }

    /**
     * 処理年(上限)を設定します。
     * @param toDay 処理年(上限)
     */
    public void setToDay(String toDay) {
        this.toDay = toDay;
    }

    /**
     * 処理年(上限)を取得します。
     * @return 処理年(上限)
     */
    public String getToMonth() {
        return toMonth;
    }

    /**
     * 処理年(上限)を設定します。
     * @param toMonth 処理年(上限)
     */
    public void setToMonth(String toMonth) {
        this.toMonth = toMonth;
    }

    /**
     * 処理年(上限)を取得します。
     * @return 処理年(上限)
     */
    public String getToTime() {
        return toTime;
    }

    /**
     * 処理年(上限)を設定します。
     * @param toTime 処理年(上限)
     */
    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    /**
     * 処理年(上限)を取得します。
     * @return 処理年(上限)
     */
    public String getToYear() {
        return toYear;
    }

    /**
     * 処理年(上限)を設定します。
     * @param toYear 処理年(上限)
     */
    public void setToYear(String toYear) {
        this.toYear = toYear;
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