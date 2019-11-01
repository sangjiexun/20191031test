/*
 * $Id: LogOperationSearchParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.user.dao;

/**
 * 操作ログ検索Bean
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class LogOperationSearchParamBean {

    /** ユーザID */
    private String userIdSearch;

    /** 名前 */
    private String userNameSearch;

    /** 操作 */
    private String operationIdSearch;

    /** 処理日時(下限) */
    private String insDtFrom;

    /** 処理日時(上限) */
    private String insDtTo;

    /** ソートキー */
    private String sortKey;

    /** 順序 */
    private String orderBy;

    /** 表示件数 */
    private String displayNum;

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
    public String getOperationIdSearch() {
        return operationIdSearch;
    }

    /**
     * 操作を設定します。
     * @param operationIdSearch 操作
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
    public String getDisplayNum() {
        return displayNum;
    }

    /**
     * 表示件数を設定します。
     * @param displayNum 表示件数
     */
    public void setDisplayNum(String displayNum) {
        this.displayNum = displayNum;
    }
}