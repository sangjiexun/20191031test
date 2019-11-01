/*
 * $Id: CjnLogOperationInfo.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/01  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.domain;

/**
 * システム操作履歴検索（CHINTAIへの問い合せ管理）Bean
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnLogOperationInfo {

    /** ユーザID */
    private String userId;

    /** ユーザID(CHINTAI問い合せ管理権限有) */
    private String authUserId;

    /** 問い合せユーザシーケンス */
    private String cjnAccountSeq;

    /** 問い合せマスタシーケンス */
    private String cjnInqKindSeq;

    /** ユーザ名 */
    private String userName;

    /** 処理区分 */
    private String sessionStatus;

    /** 問い合せID */
    private String cjnInqId;

    /** 問い合せ種類 */
    private String inqTitle;

    /** 処理日時 */
    private String updDt;

    /**
     * 問い合せIDを設定します。
     * @param cjnInqId 問い合せID
     */
    public void setCjnInqId(String cjnInqId) {
        this.cjnInqId = cjnInqId;
    }

    /**
     * 問い合せIDを取得します。
     * @return 問い合せID
     */
    public String getCjnInqId() {
        return cjnInqId;
    }

    /**
     * 問い合せ種類を設定します。
     * @param inqTitle 問い合せ種類
     */
    public void setInqTitle(String inqTitle) {
        this.inqTitle = inqTitle;
    }

    /**
     * 処理区分を取得します。
     * @return sessionStatus 処理区分
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
     * 問い合せ種類を取得します。
     * @return 問い合せ種類
     */
    public String getInqTitle() {
        return inqTitle;
    }

    /**
     * 処理日時を設定します。
     * @param updDt 処理日時
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
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
     * ユーザID(CHINTAI問い合せ管理権限有)を取得します。
     * @return ユーザID(CHINTAI問い合せ管理権限有)
     */
    public String getAuthUserId() {
        return authUserId;
    }

    /**
     * ユーザID(CHINTAI問い合せ管理権限有)を設定します。
     * @param authUserId ユーザID(CHINTAI問い合せ管理権限有)
     */
    public void setAuthUserId(String authUserId) {
        this.authUserId = authUserId;
    }

    /**
     * 問い合せユーザシーケンスを設定します。
     * @param cjnAccountSeq 問い合せユーザシーケンス
     */
    public void setCjnAccountSeq(String cjnAccountSeq) {
        this.cjnAccountSeq = cjnAccountSeq;
    }

    /**
     * 問い合せユーザシーケンスを取得します。
     * @return 問い合せユーザシーケンス
     */
    public String getCjnAccountSeq() {
        return cjnAccountSeq;
    }

    /**
     * 問い合せマスタシーケンスを設定します。
     * @param cjnInqKindSeq 問い合せマスタシーケンス
     */
    public void setCjnInqKindSeq(String cjnInqKindSeq) {
        this.cjnInqKindSeq = cjnInqKindSeq;
    }

    /**
     * 問い合せマスタシーケンスを取得します。
     * @return 問い合せマスタシーケンス
     */
    public String getCjnInqKindSeq() {
        return cjnInqKindSeq;
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
     * 処理日時を取得します。
     * @return 処理日時
     */
    public String getUpdDt() {
        return updDt;
    }

}
