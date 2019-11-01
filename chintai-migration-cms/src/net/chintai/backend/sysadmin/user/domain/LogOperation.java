/*
 * $Id: LogOperation.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/16  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.user.domain;

/**
 * 操作ログDomain
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class LogOperation {

    /** ユーザID */
    private String userId;

    /** ユーザ名前 */
    private String userName;

    /** 操作名前 */
    private String operationName;

    /** 成功／失敗 */
    private String sessionStatus;

    /** 変更対象 */
    private String target;

    /** 時刻 */
    private String insDt;

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
     * ユーザ名前を取得します。
     * @return ユーザ名前
     */
    public String getUserName() {
        return userName;
    }

    /**
     * ユーザ名前を設定します。
     * @param userName ユーザ名前
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 操作名前を取得します。
     * @return 操作名前
     */
    public String getOperationName() {
        return operationName;
    }

    /**
     * 操作名前を設定します。
     * @param operationName 操作名前
     */
    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    /**
     * 成功／失敗を取得します。
     * @return 成功／失敗
     */
    public String getSessionStatus() {
        return sessionStatus;
    }

    /**
     * 成功／失敗を設定します。
     * @param sessionStatus 成功／失敗
     */
    public void setSessionStatus(String sessionStatus) {
        this.sessionStatus = sessionStatus;
    }

    /**
     * 変更対象を取得します。
     * @return 変更対象
     */
    public String getTarget() {
        return target;
    }

    /**
     * 変更対象を設定します。
     * @param target 変更対象
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * 時刻を取得します。
     * @return 時刻
     */
    public String getInsDt() {
        return insDt;
    }

    /**
     * 時刻を設定します。
     * @param insDt 時刻
     */
    public void setInsDt(String insDt) {
        this.insDt = insDt;
    }
}