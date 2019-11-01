/*
 * $Id: CjnInquiryInfoReadingLoggingParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/08  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao;

/**
 * 問い合せ詳細情報閲覧ログparamBean
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryInfoReadingLoggingParamBean {

    /** セッション履歴シーケンス */
    private int cjnHistorySeq;

    /** CHINTAIアカウントシーケンス */
    private String cjnAccountSeq;

    /** 処理区分 */
    private String sessionStatus;

    /** セッション作成日時 */
    private String updDt;

    /** 更新者 */
    private String userId;

    /** 問い合せID */
    private String cjnInqId;

    /**
     * セッション履歴シーケンスを取得します。
     * @return セッション履歴シーケンス
     */
    public int getCjnHistorySeq() {
        return cjnHistorySeq;
    }

    /**
     * セッション履歴シーケンスを設定します。
     * @param cjnHistorySeq セッション履歴シーケンス
     */
    public void setCjnHistorySeq(int cjnHistorySeq) {
        this.cjnHistorySeq = cjnHistorySeq;
    }

    /**
     * CHINTAIアカウントシーケンスを取得します。
     * @return CHINTAIアカウントシーケンス
     */
    public String getCjnAccountSeq() {
        return cjnAccountSeq;
    }

    /**
     * CHINTAIアカウントシーケンスを設定します。
     * @param cjnAccountSeq CHINTAIアカウントシーケンス
     */
    public void setCjnAccountSeq(String cjnAccountSeq) {
        this.cjnAccountSeq = cjnAccountSeq;
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
     * セッション作成日時を取得します。
     * @return セッション作成日時
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * セッション作成日時を設定します。
     * @param updDt セッション作成日時
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
     * 更新者を取得します。
     * @return 更新者
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 更新者を設定します。
     * @param userId 更新者
     */
    public void setUserId(String userId) {
        this.userId = userId;
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
}
