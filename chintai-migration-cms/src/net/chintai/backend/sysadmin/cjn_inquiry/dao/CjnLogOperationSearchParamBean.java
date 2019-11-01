/*
 * $Id: CjnLogOperationSearchParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao;

/**
 * システム操作履歴検索(CHINTAIへの問い合せ管理)
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnLogOperationSearchParamBean {

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

    /** 処理日時(年月日時:to) */
    private String updDtTo;

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
     * 処理区分を取得します。
     * @return 処理区分
     */
    public String getProcessStatus() {
        return processStatus;
    }

    /**
     * 処理区分を設定します。
     * @param processStatus 処理区分
     */
    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
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
     * 処理日時(年月日時:to)を取得します。
     * @return 処理日時(年月日時:to)
     */
    public String getUpdDtTo() {
        return updDtTo;
    }

    /**
     * 処理日時(年月日時:to)を設定します。
     * @param updDtTo 処理日時(年月日時:to)
     */
    public void setUpdDtTo(String updDtTo) {
        this.updDtTo = updDtTo;
    }

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
     * ユーザ名を取得します。
     * @return ユーザ名
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

}
