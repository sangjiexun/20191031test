/*
 * $Id: CjnUserListView.java 3570 2007-12-14 08:55:47Z t-kojima $
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
 * 問い合せユーザ一覧情報
 * 
 * @author JavaBeans Code Generator
 * @author yang-eunmi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserListView implements ViewHelper {

    /** ユーザリスト */
    private List<CjnUserListViewDetail> userList;

    /**
     * 問い合せユーザリスト
     * @author yang-eunmi
     */
    public class CjnUserListViewDetail {

        /** ユーザID */
        private String userId;

        /** ユーザ名 */
        private String userName;

        /** お知らせ送付メールアドレス1 */
        private String email1;

        /** お知らせ送付メール送信フラグ1 */
        private String emailStatus1;

        /** お知らせ送付メールアドレス2 */
        private String email2;

        /** お知らせ送付メール送信フラグ2 */
        private String emailStatus2;

        /** お知らせ送付メールアドレス3 */
        private String email3;

        /** お知らせ送付メール送信フラグ3 */
        private String emailStatus3;

        /** アカウント種別 */
        private String accountLevel;

        /** 登録日時 */
        private String insDt;

        /** 最終更新日時 */
        private String updDt;

        /** アカウントシーケンス */
        private String cjnAccountSeq;

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
         * ユーザ名を取得します。
         * @return ユーザ名
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
         * お知らせ送付メールアドレス1を取得します。
         * @return お知らせ送付メールアドレス1
         */
        public String getEmail1() {
            return email1;
        }

        /**
         * お知らせ送付メールアドレス1を設定します。
         * @param email1 お知らせ送付メールアドレス1
         */
        public void setEmail1(String email1) {
            this.email1 = email1;
        }

        /**
         * お知らせ送付メール送信フラグ1を取得します。
         * @return お知らせ送付メール送信フラグ1
         */
        public String getEmailStatus1() {
            return emailStatus1;
        }

        /**
         * お知らせ送付メール送信フラグ1を設定します。
         * @param emailStatus1 お知らせ送付メール送信フラグ1
         */
        public void setEmailStatus1(String emailStatus1) {
            this.emailStatus1 = emailStatus1;
        }

        /**
         * お知らせ送付メールアドレス2を取得します。
         * @return お知らせ送付メールアドレス2
         */
        public String getEmail2() {
            return email2;
        }

        /**
         * お知らせ送付メールアドレス2を設定します。
         * @param email2 お知らせ送付メールアドレス2
         */
        public void setEmail2(String email2) {
            this.email2 = email2;
        }

        /**
         * お知らせ送付メール送信フラグ2を取得します。
         * @return お知らせ送付メール送信フラグ2
         */
        public String getEmailStatus2() {
            return emailStatus2;
        }

        /**
         * お知らせ送付メール送信フラグ2を設定します。
         * @param emailStatus2 お知らせ送付メール送信フラグ2
         */
        public void setEmailStatus2(String emailStatus2) {
            this.emailStatus2 = emailStatus2;
        }

        /**
         * お知らせ送付メールアドレス3を取得します。
         * @return お知らせ送付メールアドレス3
         */
        public String getEmail3() {
            return email3;
        }

        /**
         * お知らせ送付メールアドレス3を設定します。
         * @param email3 お知らせ送付メールアドレス3
         */
        public void setEmail3(String email3) {
            this.email3 = email3;
        }

        /**
         * お知らせ送付メール送信フラグ3を取得します。
         * @return お知らせ送付メール送信フラグ3
         */
        public String getEmailStatus3() {
            return emailStatus3;
        }

        /**
         * お知らせ送付メール送信フラグ3を設定します。
         * @param emailStatus3 お知らせ送付メール送信フラグ3
         */
        public void setEmailStatus3(String emailStatus3) {
            this.emailStatus3 = emailStatus3;
        }

        /**
         * アカウント種別を取得します。
         * @return アカウント種別
         */
        public String getAccountLevel() {
            return accountLevel;
        }

        /**
         * アカウント種別を設定します。
         * @param accountLevel アカウント種別
         */
        public void setAccountLevel(String accountLevel) {
            this.accountLevel = accountLevel;
        }

        /**
         * 登録日時を取得します。
         * @return 登録日時
         */
        public String getInsDt() {
            return insDt;
        }

        /**
         * 登録日時を設定します。
         * @param insDt 登録日時
         */
        public void setInsDt(String insDt) {
            this.insDt = insDt;
        }

        /**
         * 最終更新日時を取得します。
         * @return 最終更新日時
         */
        public String getUpdDt() {
            return updDt;
        }

        /**
         * 最終更新日時を設定します。
         * @param updDt 最終更新日時
         */
        public void setUpdDt(String updDt) {
            this.updDt = updDt;
        }

        /**
         * アカウントシーケンスを取得します。
         * @return アカウントシーケンス
         */
        public String getCjnAccountSeq() {
            return cjnAccountSeq;
        }

        /**
         * アカウントシーケンスを設定します。
         * @param cjnAccountSeq アカウントシーケンス
         */
        public void setCjnAccountSeq(String cjnAccountSeq) {
            this.cjnAccountSeq = cjnAccountSeq;
        }
    }

    /**
     * ユーザリストを取得します。
     * @return ユーザリスト
     */
    public List<CjnUserListViewDetail> getUserList() {
        return userList;
    }

    /**
     * ユーザリストを設定します。
     * @param userList ユーザリスト
     */
    public void setUserList(List<CjnUserListViewDetail> userList) {
        this.userList = userList;
    }

}
