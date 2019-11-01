/*
 * $Id: CjnInquiryInfoInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.bean;

/**
 * 問い合せ詳細照会
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryInfoInServiceBean {

    /** 問い合せID */
    private String cjnInqId;

    /** ユーザID */
    private String userId;

    /** 問い合せシーケンス */
    private int cjnInqKindSeq;

    /** CHINTAIアカウントシーケンス */
    private String cjnAccountSeq;

    /** 処理区分 */
    private String sessionStatus;

    /** ログ記録フラグ */
    private String logFlg;

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
     * ログ記録フラグを取得します。
     * @return ログ記録フラグ
     */
    public String getLogFlg() {
        return logFlg;
    }

    /**
     * ログ記録フラグを設定します。
     * @param logFlg ログ記録フラグ
     */
    public void setLogFlg(String logFlg) {
        this.logFlg = logFlg;
    }

}
