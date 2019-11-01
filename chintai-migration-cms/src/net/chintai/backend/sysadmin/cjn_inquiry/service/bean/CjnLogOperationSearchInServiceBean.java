/*
 * $Id: CjnLogOperationSearchInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 2007/12/01  BGT)児島       セッションに保持可能なように拡張
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.bean;

import net.chintai.backend.sysadmin.common.session.SessionSearchCondition;

/**
 * システム操作履歴検索条件
 * 
 * @author JavaBeans Code Generator
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnLogOperationSearchInServiceBean implements SessionSearchCondition {

    /** serialVersionUID */
    private static final long serialVersionUID = 625551206136601924L;

    /** 検索対象 */
    private String searchTarget;

    /** ユーザID */
    private String userId;

    /** ユーザ名 */
    private String userName;

    /** 処理区分 */
    private String processStatus;

    /** 問い合せ種別シーケンス */
    private int cjnInqKindSeq;

    /** 問い合せID */
    private String cjnInqId;

    /** 処理日時(年月日時:from) */
    private String updDtFrom;

    /** 処理日時(年:from) */
    private String updDtFromYear;

    /** 処理日時(月:from) */
    private String updDtFromMonth;

    /** 処理日時(日:from) */
    private String updDtFromDay;

    /** 処理日時(時:from) */
    private String updDtFromTime;

    /** 処理日時(年月日時:to) */
    private String updDtTo;

    /** 処理日時(年:to) */
    private String updDtToYear;

    /** 処理日時(月:to) */
    private String updDtToMonth;

    /** 処理日時(日:to) */
    private String updDtToDay;

    /** 処理日時(時:to) */
    private String updDtToTime;

    /** 表示開始位置 */
    private int offSet;

    /**
     * 問い合せ種別シーケンスを取得します。
     * @return 問い合せ種別シーケンス
     */
    public int getCjnInqKindSeq() {
        return cjnInqKindSeq;
    }

    /**
     * 問い合せ種別シーケンスを設定します。
     * @param cjnInqKindSeq 問い合せ種別シーケンス
     */
    public void setCjnInqKindSeq(int cjnInqKindSeq) {
        this.cjnInqKindSeq = cjnInqKindSeq;
    }

    /**
     * 処理区分を取得する
     * @return processStatus 処理区分
     */
    public String getProcessStatus() {
        return processStatus;
    }

    /**
     * 処理区分を設定する
     * @param processStatus 処理区分
     */
    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
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
     * 処理日時(日:from)を設定します。
     * @param updDtFromDay 処理日時(日:from)
     */
    public void setUpdDtFromDay(String updDtFromDay) {
        this.updDtFromDay = updDtFromDay;
    }

    /**
     * 処理日時(月:from)を設定します。
     * @param updDtFromMonth 処理日時(月:from)
     */
    public void setUpdDtFromMonth(String updDtFromMonth) {
        this.updDtFromMonth = updDtFromMonth;
    }

    /**
     * 処理日時(月:from)を取得します。
     * @return 処理日時(月:from)
     */
    public String getUpdDtFromMonth() {
        return updDtFromMonth;
    }

    /**
     * 処理日時(日:from)を取得します。
     * @return 処理日時(日:from)
     */
    public String getUpdDtFromDay() {
        return updDtFromDay;
    }

    /**
     * 処理日時(時:from)を設定します。
     * @param updDtFromTime 処理日時(時:from)
     */
    public void setUpdDtFromTime(String updDtFromTime) {
        this.updDtFromTime = updDtFromTime;
    }

    /**
     * 処理日時(年月日時:from)を取得します。
     * @return 処理日時(年月日時:from)
     */
    public String getUpdDtFrom() {
        return updDtFrom;
    }

    /**
     * 処理日時(年月日時:from)を設定します。
     * @param updDtFrom 処理日時(年月日時:from)
     */
    public void setUpdDtFrom(String updDtFrom) {
        this.updDtFrom = updDtFrom;
    }

    /**
     * 処理日時(年:from)を取得します。
     * @return updDtFromYear 処理日時(年:from)
     */
    public String getUpdDtFromYear() {
        return updDtFromYear;
    }

    /**
     * 処理日時(年:from)を設定します。
     * @param updDtFromYear 処理日時(年:from)
     */
    public void setUpdDtFromYear(String updDtFromYear) {
        this.updDtFromYear = updDtFromYear;
    }

    /**
     * 処理日時(時:from)を取得します。
     * @return 処理日時(時:from)
     */
    public String getUpdDtFromTime() {
        return updDtFromTime;
    }

    /**
     * 処理日時(年月日時:to)を設定します。
     * @param updDtTo 処理日時(年月日時:to)
     */
    public void setUpdDtTo(String updDtTo) {
        this.updDtTo = updDtTo;
    }

    /**
     * 処理日時(日:to)を設定します。
     * @param updDtToDay 処理日時(日:to)
     */
    public void setUpdDtToDay(String updDtToDay) {
        this.updDtToDay = updDtToDay;
    }

    /**
     * 処理日時(月:to)を設定します。
     * @param updDtToMonth 処理日時(月:to)
     */
    public void setUpdDtToMonth(String updDtToMonth) {
        this.updDtToMonth = updDtToMonth;
    }

    /**
     * 処理日時(月:to)を取得します。
     * @return 処理日時(月:to)
     */
    public String getUpdDtToMonth() {
        return updDtToMonth;
    }

    /**
     * 処理日時(日:to)を取得します。
     * @return 処理日時(日:to)
     */
    public String getUpdDtToDay() {
        return updDtToDay;
    }

    /**
     * 処理日時(時:to)を設定します。
     * @param updDtToTime 処理日時(時:to)
     */
    public void setUpdDtToTime(String updDtToTime) {
        this.updDtToTime = updDtToTime;
    }

    /**
     * 処理日時(年月日時:to)を取得します。
     * @return 処理日時(年月日時:to)
     */
    public String getUpdDtTo() {
        return updDtTo;
    }

    /**
     * 処理日時(年:to)を取得します。
     * @return updDtToYear 処理日時(年:to)
     */
    public String getUpdDtToYear() {
        return updDtToYear;
    }

    /**
     * 処理日時(年:to)を設定します。
     * @param updDtToYear 処理日時(年:to)
     */
    public void setUpdDtToYear(String updDtToYear) {
        this.updDtToYear = updDtToYear;
    }

    /**
     * 検索対象を取得します。
     * @return 検索対象
     */
    public String getSearchTarget() {
        return searchTarget;
    }

    /**
     * 検索対象を設定します。
     * @param searchTarget 検索対象
     */
    public void setSearchTarget(String searchTarget) {
        this.searchTarget = searchTarget;
    }

    /**
     * ユーザIDを設定します。
     * @param userId ユーザID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * ユーザIDを取得します。
     * @return ユーザID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * ユーザ名を取得します。
     * @return userName ユーザ名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * ユーザ名を設定します。
     * @param userName ユーザ名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 処理日時(時:to)を取得します。
     * @return 処理日時(時:to)
     */
    public String getUpdDtToTime() {
        return updDtToTime;
    }

    /**
     * 表示開始位置を取得します。
     * @return 表示開始位置
     */
    public int getOffSet() {
        return offSet;
    }

    /**
     * 表示開始位置を設定します。
     * @param offSet 表示開始位置
     */
    public void setOffSet(int offSet) {
        this.offSet = offSet;
    }
}
