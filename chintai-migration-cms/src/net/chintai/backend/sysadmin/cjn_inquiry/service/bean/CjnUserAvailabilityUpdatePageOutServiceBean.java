/*
 * $Id: CjnUserAvailabilityUpdatePageOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 2007/09/27  BGT)児島       実際のデータ構造に合わせて全面的に刷新
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.bean;

import java.util.List;

/**
 * 閲覧可能ユーザ情報を表すBean。
 * 
 * @author JavaBeans Code Generator
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserAvailabilityUpdatePageOutServiceBean {

    /** 問い合せシーケンス */
    private int cjnInqKindSeq;

    /** 問い合せタイトル */
    private String inqTitle;

    /** 問い合せ説明 */
    private String inqComment;

    /** 閲覧可否付きユーザ情報リスト */
    private List<ReadableUserBean> readableUserList;

    /** 最終更新日時 */
    private String lastUpdateTime;

    /**
     * ユーザおよび閲覧可否情報
     * 
     * @author KOJIMA Takanori
     */
    public class ReadableUserBean {

        /** 閲覧可否 */
        private boolean exists;

        /** CHINTAI問い合せ管理アカウントシーケンス */
        private String cjnAccountSeq;

        /** 名前 */
        private String userName;

        /**
         * 閲覧可否を取得します。
         * @return 閲覧可否
         */
        public boolean isExists() {
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
         * CHINTAI問い合せ管理アカウントシーケンスを取得します。
         * @return CHINTAI問い合せ管理アカウントシーケンス
         */
        public String getCjnAccountSeq() {
            return cjnAccountSeq;
        }

        /**
         * CHINTAI問い合せ管理アカウントシーケンスを設定します。
         * @param cjnAccountSeq CHINTAI問い合せ管理アカウントシーケンス
         */
        public void setCjnAccountSeq(String cjnAccountSeq) {
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
     * 閲覧可否付きユーザ情報リストを取得します。
     * @return 閲覧可否付きユーザ情報リスト
     */
    public List<ReadableUserBean> getReadableUserList() {
        return readableUserList;
    }

    /**
     * 閲覧可否付きユーザ情報リストを設定します。
     * @param readableUserList 閲覧可否付きユーザ情報リスト
     */
    public void setReadableUserList(List<ReadableUserBean> readableUserList) {
        this.readableUserList = readableUserList;
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
