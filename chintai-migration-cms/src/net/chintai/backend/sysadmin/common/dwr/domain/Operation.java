/*
 * $Id: Operation.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/31  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.common.dwr.domain;

/**
 * 検索条件.操作内容の選択内容Domain
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class Operation {

    /** 操作ID */
    private String operationId;

    /** 操作内容 */
    private String operationName;

    /**
     * 操作IDを取得します。
     * @return operationId 操作ID
     */
    public String getOperationId() {
        return operationId;
    }

    /**
     * 操作IDを設定します。
     * @param operationId 操作ID
     */
    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    /**
     * 操作内容を取得します。
     * @return operationName 操作内容
     */
    public String getOperationName() {
        return operationName;
    }

    /**
     * 操作内容を設定します。
     * @param operationName 操作内容
     */
    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }
}