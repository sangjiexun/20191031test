/*
 * $Id: CjnUserInfoView.java 3570 2007-12-14 08:55:47Z t-kojima $
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
 * 問い合せユーザ詳細情報
 * 
 * @author JavaBeans Code Generator
 * @author yang-eunmi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserInfoView implements ViewHelper {

    /** ユーザID */
    private String userId;

    /** 名前 */
    private String userName;

    /** お知らせ送付メールアドレス1 */
    private String email1;

    /** お知らせ送付メールアドレス1状態 */
    private String emailStatus1;

    /** お知らせ送付メールアドレス2 */
    private String email2;

    /** お知らせ送付メールアドレス2状態 */
    private String emailStatus2;

    /** お知らせ送付メールアドレス3 */
    private String email3;

    /** お知らせ送付メールアドレス3状態 */
    private String emailStatus3;

    /** レベル */
    private String accountLevel;

    /** 登録日時 */
    private String insDt;

    /** 更新日時 */
    private String updDt;

    /** CHINTAIアカウントシーケンス */
    private String cjnAccountSeq;

    /** 管理メモ */
    private String adminNote;

    /** 問い合せユーザアカウントリスト */
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
     * お知らせ送付メールアドレス1状態を取得します。
     * @return お知らせ送付メールアドレス1状態
     */
    public String getEmailStatus1() {
        return emailStatus1;
    }

    /**
     * お知らせ送付メールアドレス1状態を設定します。
     * @param emailStatus1 お知らせ送付メールアドレス1状態
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
     * お知らせ送付メールアドレス2状態を取得します。
     * @return お知らせ送付メールアドレス2状態
     */
    public String getEmailStatus2() {
        return emailStatus2;
    }

    /**
     * お知らせ送付メールアドレス2状態を設定します。
     * @param emailStatus2 お知らせ送付メールアドレス2状態
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
     * お知らせ送付メールアドレス3状態を取得します。
     * @return お知らせ送付メールアドレス3状態
     */
    public String getEmailStatus3() {
        return emailStatus3;
    }

    /**
     * お知らせ送付メールアドレス3状態を設定します。
     * @param emailStatus3 お知らせ送付メールアドレス3状態
     */
    public void setEmailStatus3(String emailStatus3) {
        this.emailStatus3 = emailStatus3;
    }

    /**
     * レベルを取得します。
     * @return レベル
     */
    public String getAccountLevel() {
        return accountLevel;
    }

    /**
     * レベルを設定します。
     * @param accountLevel レベル
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
     * 更新日時を取得します。
     * @return 更新日時
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 更新日時を設定します。
     * @param updDt 更新日時
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
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
     * 管理メモを取得します。
     * @return 管理メモ
     */
    public String getAdminNote() {
        return adminNote;
    }

    /**
     * 管理メモを設定します。
     * @param adminNote 管理メモ
     */
    public void setAdminNote(String adminNote) {
        this.adminNote = adminNote;
    }

    /**
     * 問い合せユーザアカウントリスト
     * @author yang-eunmi
     */
    public class CjnUserAccountViewDetail {

        /** 問い合せタイトル */
        private String inqTitle;

        /** 問い合せ説明 */
        private String inqComment;

        /** 閲覧可否カウンター */
        private int cnt;

        /**
         * 問い合せ説明を設定します。
         * @return inqComment 問い合せ説明
         */
        public String getInqComment() {
            return inqComment;
        }

        /**
         * 問い合せ説明を取得します。
         * @param inqComment 問い合せ説明
         */
        public void setInqComment(String inqComment) {
            this.inqComment = inqComment;
        }

        /**
         * 問い合せタイトルを設定します。
         * @return inqTitle 問い合せタイトル
         */
        public String getInqTitle() {
            return inqTitle;
        }

        /**
         * 問い合せタイトルを取得します。
         * @param inqTitle 問い合せタイトル
         */
        public void setInqTitle(String inqTitle) {
            this.inqTitle = inqTitle;
        }

        /**
         * 閲覧可否カウンターを取得します。
         * @return 閲覧可否カウンター
         */
        public int getCnt() {
            return cnt;
        }

        /**
         * 閲覧可否カウンターを設定します。
         * @param cnt 閲覧可否カウンター
         */
        public void setCnt(int cnt) {
            this.cnt = cnt;
        }
    }

    // }

    /**
     * 問い合せユーザアカウントリストを取得します。
     * @return 問い合せユーザアカウントリスト
     */
    public List<CjnUserAccountViewDetail> getUserAccountList() {
        return userAccountList;
    }

    /**
     * 問い合せユーザアカウントリストを設定します。
     * @param userAccountList 問い合せユーザアカウントリスト
     */
    public void setUserAccountList(List<CjnUserAccountViewDetail> userAccountList) {
        this.userAccountList = userAccountList;
    }
}
