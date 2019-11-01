/*
 * $Id: CjnInquiryTypeInfoView.java 3570 2007-12-14 08:55:47Z t-kojima $
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
 * 問い合せ種別詳細情報
 * 
 * @author JavaBeans Code Generator
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryTypeInfoView implements ViewHelper {

    /** 問い合せシーケンス */
    private int cjnInqKindSeq;

    /** 問い合せタイトル */
    private String inqTitle;

    /** 問い合せ説明 */
    private String inqComment;

    /** 問い合せURL */
    private String inqUrl;

    /** 表示用タイトル */
    private String dispTitle;

    /** 表示用ソートキー */
    private int dispSortKey;

    /** 問い合せグループ */
    private String inqGroupType;

    /** 管理メモ */
    private String adminNote;

    /** 登録日時 */
    private String insDt;

    /** 最終更新日時 */
    private String updDt;

    /** 閲覧可能ユーザリスト */
    private List<CjnInquiryTypeInfoDetailView> readableUserList;

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
     * 問い合せURLを取得します。
     * @return 問い合せURL
     */
    public String getInqUrl() {
        return inqUrl;
    }

    /**
     * 問い合せURLを設定します。
     * @param inqUrl 問い合せURL
     */
    public void setInqUrl(String inqUrl) {
        this.inqUrl = inqUrl;
    }

    /**
     * 表示用タイトルを取得します。
     * @return 表示用タイトル
     */
    public String getDispTitle() {
        return dispTitle;
    }

    /**
     * 表示用タイトルを設定します。
     * @param dispTitle 表示用タイトル
     */
    public void setDispTitle(String dispTitle) {
        this.dispTitle = dispTitle;
    }

    /**
     * 表示用ソートキーを取得します。
     * @return 表示用ソートキー
     */
    public int getDispSortKey() {
        return dispSortKey;
    }

    /**
     * 表示用ソートキーを設定します。
     * @param dispSortKey 表示用ソートキー
     */
    public void setDispSortKey(int dispSortKey) {
        this.dispSortKey = dispSortKey;
    }

    /**
     * 問い合せグループを取得します。
     * @return 問い合せグループ
     */
    public String getInqGroupType() {
        return inqGroupType;
    }

    /**
     * 問い合せグループを設定します。
     * @param inqGroupType 問い合せグループ
     */
    public void setInqGroupType(String inqGroupType) {
        this.inqGroupType = inqGroupType;
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
     * 閲覧可能ユーザリストを取得します。
     * @return 閲覧可能ユーザリスト
     */
    public List<CjnInquiryTypeInfoDetailView> getReadableUserList() {
        return readableUserList;
    }

    /**
     * 閲覧可能ユーザリストを設定します。
     * @param readableUserList 閲覧可能ユーザリスト
     */
    public void setReadableUserList(List<CjnInquiryTypeInfoDetailView> readableUserList) {
        this.readableUserList = readableUserList;
    }

    /**
     * 閲覧可否ユーザ
     * 
     * @author KOJIMA Takanori
     */
    public class CjnInquiryTypeInfoDetailView {

        /** 閲覧可否 */
        private boolean exists;

        /** 名前 */
        private String userName;

        /**
         * 閲覧可否を取得します。
         * @return 閲覧可否
         */
        public String getExists() {
            return exists ? "○" : "×";
        }

        /**
         * 閲覧可否を設定します。
         * @param exists 閲覧可否
         */
        public void setExists(boolean exists) {
            this.exists = exists;
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
}