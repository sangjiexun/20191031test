/*
 * $Id: CjnUserAuthorityUpdateView.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.cjn_inquiry.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 閲覧可能問い合せ権限変更
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserAuthorityUpdateView implements ViewHelper {

    /** ユーザID */
    private String userId;

    /** 名前 */
    private String userName;

    /** CHINTAIアカウントシーケンス */
    private String cjnAccountSeq;

    /** 最新更新日時 */
    private String updDt;

    /** 問い合わせユーザアカウントリスト */
    private List<CjnUserAccountViewDetail> userAccountList;

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
     * 名前を取得します。
     * @return 名前
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 名前を設定します。
     * @param userName 名前
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
     * 最新更新日時を取得します。
     * @return 最新更新日時
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 最新更新日時を設定します。
     * @param updDt 最新更新日時
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
     * 問い合わせユーザアカウントリスト
     * @author yang-eunmi
     */
    public class CjnUserAccountViewDetail {

        /** 問い合せタイトル */
        private String inqTitle;

        /** 問い合せ説明 */
        private String inqComment;

        /** 問い合せ件数 */
        private int cnt;

        /** 問い合せマスタシーケンス */
        private int cjnInqKindSeq;

        /**
         * 問い合せタイトルを取得します。
         * @return 問い合せタイトル
         */
        public String getInqTitle() {
            return inqTitle;
        }

        /**
         * 問い合せタイトルを設定します。
         * @param inqTitle 問い合せタイトル
         */
        public void setInqTitle(String inqTitle) {
            this.inqTitle = inqTitle;
        }

        /**
         * 問い合せ説明を取得します。
         * @return 問い合せ説明
         */
        public String getInqComment() {
            return inqComment;
        }

        /**
         * 問い合せ説明を設定します。
         * @param inqComment 問い合せ説明
         */
        public void setInqComment(String inqComment) {
            this.inqComment = inqComment;
        }

        /**
         * 問い合せ件数を取得します。
         * @return 問い合せ件数
         */
        public int getCnt() {
            return cnt;
        }

        /**
         * 問い合せ件数を設定します。
         * @param cnt 問い合せ件数
         */
        public void setCnt(int cnt) {
            this.cnt = cnt;
        }

        /**
         * 問い合せマスタシーケンスを取得します。
         * @return 問い合せマスタシーケンス
         */
        public int getCjnInqKindSeq() {
            return cjnInqKindSeq;
        }

        /**
         * 問い合せマスタシーケンスを設定します。
         * @param cjnInqKindSeq 問い合せマスタシーケンス
         */
        public void setCjnInqKindSeq(int cjnInqKindSeq) {
            this.cjnInqKindSeq = cjnInqKindSeq;
        }

    }

    /**
     * 問い合わせユーザアカウントリストを取得します。
     * @return 問い合わせユーザアカウントリスト
     */
    public List<CjnUserAccountViewDetail> getUserAccountList() {
        return userAccountList;
    }

    /**
     * 問い合わせユーザアカウントリストを設定します。
     * @param userAccountList 問い合わせユーザアカウントリスト
     */
    public void setUserAccountList(List<CjnUserAccountViewDetail> userAccountList) {
        this.userAccountList = userAccountList;
    }

}
