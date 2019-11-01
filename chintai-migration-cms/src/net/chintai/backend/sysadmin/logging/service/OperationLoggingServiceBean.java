/*
 * $Id: OperationLoggingServiceBean.java,v 1.1 2007/10/10 01:18:03 t-kojima Exp $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/10/10   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.logging.service;

import net.chintai.backend.sysadmin.logging.SessionStatus;

/**
 * 操作ログ記録用のデータを保持するBeanです。<br>
 * このパッケージは広告チームと共有するため、独立したモジュールとして管理します。
 *
 * @author KOJIMA Takanori
 */
public class OperationLoggingServiceBean {

    /** 操作内容ID */
    private String operationId;

    /** 操作の成否 */
    private SessionStatus sessionStatus;

    /** 操作対象 */
    private String target;

    /** 操作実施者のユーザID */
    private String operUserId;

    private String pgName;

    /**
     * 操作内容IDを取得します。
     * @return 操作内容ID
     */
    public String getOperationId() {
        return operationId;
    }

    /**
     * 操作内容IDを設定します。
     * @param operationId 操作内容ID
     */
    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    /**
     * 操作の成否を取得します。
     * @return 操作の成否
     */
    public SessionStatus getSessionStatus() {
        return sessionStatus;
    }

    /**
     * 操作の成否を設定します。
     * @param sessionStatus 操作の成否
     */
    public void setSessionStatus(SessionStatus sessionStatus) {
        this.sessionStatus = sessionStatus;
    }

    /**
     * 操作対象を取得します。
     * @return 操作対象
     */
    public String getTarget() {
        return target;
    }

    /**
     * 操作対象を設定します。
     * @param target 操作対象
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * 操作実施者のユーザIDを取得します。
     * @return 操作実施者のユーザID
     */
    public String getOperUserId() {
        return operUserId;
    }

    /**
     * 操作実施者のユーザIDを設定します。
     * @param operUserId 操作実施者のユーザID
     */
    public void setOperUserId(String operUserId) {
        this.operUserId = operUserId;
    }

	/**
	 * @return pgName
	 */
	public String getPgName() {
		return pgName;
	}

	/**
	 * @param pgName セットする pgName
	 */
	public void setPgName(String pgName) {
		this.pgName = pgName;
	}

}