/*
 * $Id: LogOperationListView.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/16  BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.user.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.PagerCondition;
import net.chintai.backend.sysadmin.common.pager.PagerViewHelper;

/**
 * 操作ログViewHelper
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class LogOperationListView extends PagerViewHelper {

    /**
     * コンストラクター
     * @param condition
     */
    public LogOperationListView(PagerCondition condition) {
        super(condition);
    }

    /** 操作ログリスト */
    private List<LogOperationListDetailView> logOperationList;

    /** ユーザID */
    private String userIdSearch;

    /** 名前 */
    private String userNameSearch;

    /** 操作 */
    private String authority;

    /** 操作内容 */
    private String operationIdSearch;

    /** 処理年(下限) */
    private String fromYear;

    /** 処理月(下限) */
    private String fromMonth;

    /** 処理日(下限) */
    private String fromDay;

    /** 処理時(下限) */
    private String fromTime;

    /** 処理年(上限) */
    private String toYear;

    /** 処理月(上限) */
    private String toMonth;

    /** 処理日(上限) */
    private String toDay;

    /** 処理時(上限) */
    private String toTime;

    /** ソートキー */
    private String sortKey;

    /** 順序 */
    private String orderBy;

    /** 表示件数 */
    private String displayNum;

    /**
     * 操作ログリストを取得します。
     * @return 操作ログリスト
     */
    public List<LogOperationListDetailView> getLogOperationList() {
        return logOperationList;
    }

    /**
     * 操作ログリストを設定します。
     * @param logOperationList 操作ログリスト
     */
    public void setLogOperationList(List<LogOperationListDetailView> logOperationList) {
        this.logOperationList = logOperationList;
    }

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
     * 処理日(上限)を取得します。
     * @return 処理日(上限)
     */
    public String getToDay() {
        return toDay;
    }

    /**
     * 処理日(上限)を設定します。
     * @param toDay 処理日(上限)
     */
    public void setToDay(String toDay) {
        this.toDay = toDay;
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

    public class LogOperationListDetailView {

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

}
