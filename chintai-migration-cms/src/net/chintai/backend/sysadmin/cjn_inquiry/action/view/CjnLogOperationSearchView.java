/*
 * $Id: CjnLogOperationSearchView.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.cjn_inquiry.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.PagerCondition;
import net.chintai.backend.sysadmin.common.pager.PagerViewHelper;

/**
 * システム操作履歴検索結果
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnLogOperationSearchView extends PagerViewHelper {

    /**
     * コンストラクター
     * @param condition
     */
    public CjnLogOperationSearchView(PagerCondition condition) {
        super(condition);
    }

    /** 検索対象 */
    private String searchTarget;

    /** ユーザID */
    private String userId;

    /** ユーザ名 */
    private String userName;

    /** 処理区分 */
    private String processStatus;

    /** 問い合せID */
    private String cjnInqId;

    /** 問い合せ種別シーケンス */
    private String cjnInqKindSeq;

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

    /** システム操作履歴リスト */
    private List<CjnInquiryTypeListDetailView> cjnLogOperationList;

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
     * 問い合せ種別シーケンスを取得します。
     * @return 問い合せ種別シーケンス
     */
    public String getCjnInqKindSeq() {
        return cjnInqKindSeq;
    }

    /**
     * 問い合せ種別シーケンスを設定します。
     * @param cjnInqKindSeq 問い合せ種別シーケンス
     */
    public void setCjnInqKindSeq(String cjnInqKindSeq) {
        this.cjnInqKindSeq = cjnInqKindSeq;
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
     * システム操作履歴リストを設定します。
     * @param cjnLogOperationList システム操作履歴リスト
     */
    public void setCjnLogOperationList(List<CjnInquiryTypeListDetailView> cjnLogOperationList) {
        this.cjnLogOperationList = cjnLogOperationList;
    }

    /**
     * 問い合せ種別を表現するインナークラス。
     * 
     * @author KOJIMA Takanori
     */
    public class CjnInquiryTypeListDetailView {

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
         * 問い合せ種類を設定します。
         * @param inqTitle 問い合せ種類
         */
        public void setInqTitle(String inqTitle) {
            this.inqTitle = inqTitle;
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
         * 問い合せユーザシーケンスを取得します。
         * @return 問い合せユーザシーケンス
         */
        public String getCjnAccountSeq() {
            return cjnAccountSeq;
        }

        /**
         * 問い合せユーザシーケンスを設定します。
         * @param cjnAccountSeq 問い合せユーザシーケンス
         */
        public void setCjnAccountSeq(String cjnAccountSeq) {
            this.cjnAccountSeq = cjnAccountSeq;
        }

        /**
         * 問い合せマスタシーケンスを取得します。
         * @return 問い合せマスタシーケンス
         */
        public String getCjnInqKindSeq() {
            return cjnInqKindSeq;
        }

        /**
         * 問い合せマスタシーケンスを設定します。
         * @param cjnInqKindSeq 問い合せマスタシーケンス
         */
        public void setCjnInqKindSeq(String cjnInqKindSeq) {
            this.cjnInqKindSeq = cjnInqKindSeq;
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

        /**
         * 処理日時を設定します。
         * @param updDt 処理日時
         */
        public void setUpdDt(String updDt) {
            this.updDt = updDt;
        }

    }

    /**
     * システム操作履歴リストを取得します。
     * @return システム操作履歴リスト
     */
    public List<CjnInquiryTypeListDetailView> getCjnLogOperationList() {
        return cjnLogOperationList;
    }

}
