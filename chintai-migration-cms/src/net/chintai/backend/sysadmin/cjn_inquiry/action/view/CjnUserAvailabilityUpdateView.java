/*
 * $Id: CjnUserAvailabilityUpdateView.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/09/17   BGT)児島      新規作成
 * 2007/09/28   BGT)児島      変数名を修正
 */
package net.chintai.backend.sysadmin.cjn_inquiry.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 閲覧可能ユーザ変更情報
 * 
 * @author JavaBeans Code Generator
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserAvailabilityUpdateView implements ViewHelper {

    /** 問い合せシーケンス */
    private int cjnInqKindSeq;

    /** 問い合せタイトル */
    private String inqTitle;

    /** 問い合せ説明 */
    private String inqComment;

    /** 閲覧可能ユーザリスト */
    private List<CjnUserAvailabilityUpdateDetailView> userList;

    /** 最終更新日時 */
    private String lastUpdateTime;

    /**
     * 問い合せシーケンスを取得します。
     * @return 問い合せシーケンス
     */
    public int getCjnInqKindSeq() {
        return cjnInqKindSeq;
    }

    /**
     * 問い合せシーケンスを設定します。
     * @param cjnInqKindSeq 問い合せシーケンス
     */
    public void setCjnInqKindSeq(int cjnInqKindSeq) {
        this.cjnInqKindSeq = cjnInqKindSeq;
    }

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
     * 閲覧可能ユーザ情報
     * 
     * @author KOJIMA Takanori
     */
    public class CjnUserAvailabilityUpdateDetailView {

        /** 閲覧可否 */
        private boolean exists;

        /** CHINTAI問い合せアカウントシーケンス */
        private int cjnAccountSeq;

        /** 名前 */
        private String userName;

        /**
         * 閲覧可否を取得します。
         * @return 閲覧可否
         */
        public boolean getExists() {
            return exists;
        }

        /**
         * 閲覧可否を設定します。
         * @param exists 閲覧可否
         */
        public void setExists(boolean exists) {
            this.exists = exists;
        }

        /**
         * CHINTAI問い合せアカウントシーケンスを取得します。
         * @return CHINTAI問い合せアカウントシーケンス
         */
        public int getCjnAccountSeq() {
            return cjnAccountSeq;
        }

        /**
         * CHINTAI問い合せアカウントシーケンスを設定します。
         * @param cjnAccountSeq CHINTAI問い合せアカウントシーケンス
         */
        public void setCjnAccountSeq(int cjnAccountSeq) {
            this.cjnAccountSeq = cjnAccountSeq;
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
    }

    /**
     * 閲覧可能ユーザリストを取得します。
     * @return 閲覧可能ユーザリスト
     */
    public List<CjnUserAvailabilityUpdateDetailView> getUserList() {
        return userList;
    }

    /**
     * 閲覧可能ユーザリストを設定します。
     * @param userList 閲覧可能ユーザリスト
     */
    public void setUserList(List<CjnUserAvailabilityUpdateDetailView> userList) {
        this.userList = userList;
    }

    /**
     * 最終更新日時を取得します。
     * @return 最終更新日時
     */
    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * 最終更新日時を設定します。
     * @param lastUpdateTime 最終更新日時
     */
    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
