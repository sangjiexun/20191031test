/*
 * $Id: CjnInquiryTypeListView.java 3570 2007-12-14 08:55:47Z t-kojima $
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
 * 問い合せ種別一覧情報
 * 
 * @author JavaBeans Code Generator
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryTypeListView implements ViewHelper {

    /** アカウント種別 */
    private String cjnAccountType;

    /** 問い合せ種別リスト */
    private List<CjnInquiryTypeListDetailView> inquiryTypeList;

    /**
     * アカウント種別を取得します。
     * @return アカウント種別
     */
    public String getCjnAccountType() {
        return cjnAccountType;
    }

    /**
     * アカウント種別を設定します。
     * @param cjnAccountType アカウント種別
     */
    public void setCjnAccountType(String cjnAccountType) {
        this.cjnAccountType = cjnAccountType;
    }

    /**
     * 問い合せ種別リストを取得します。
     * @return 問い合せ種別リスト
     */
    public List<CjnInquiryTypeListDetailView> getInquiryTypeList() {
        return inquiryTypeList;
    }

    /**
     * 問い合せ種別リストを設定します。
     * @param inquiryTypeList 問い合せ種別リスト
     */
    public void setInquiryTypeList(List<CjnInquiryTypeListDetailView> inquiryTypeList) {
        this.inquiryTypeList = inquiryTypeList;
    }

    /**
     * 問い合せ種別を表現するインナークラス。
     * 
     * @author KOJIMA Takanori
     */
    public class CjnInquiryTypeListDetailView {

        /** 問い合せタイトル */
        private String inqTitle;

        /** 問い合せ説明 */
        private String inqComment;

        /** 問い合せURL */
        private String inqUrl;

        /** 総数 */
        private String totalCount;

        /** 未読 */
        private String noReadCount;

        /** 未処理 */
        private String noShoriCount;

        /** 問い合せシーケンス */
        private int cjnInqKindSeq;

        /** 問い合せグループ */
        private String inqGroupType;

        /** 閲覧可能ユーザリスト */
        private List<String> readableUserList;

        /** ユーザ閲覧可否 */
        private boolean enabled;

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
         * 総数を取得します。
         * @return 総数
         */
        public String getTotalCount() {
            return totalCount;
        }

        /**
         * 総数を設定します。
         * @param totalCount 総数
         */
        public void setTotalCount(String totalCount) {
            this.totalCount = totalCount;
        }

        /**
         * 未読を取得します。
         * @return 未読
         */
        public String getNoReadCount() {
            return noReadCount;
        }

        /**
         * 未読を設定します。
         * @param noReadCount 未読
         */
        public void setNoReadCount(String noReadCount) {
            this.noReadCount = noReadCount;
        }

        /**
         * 未処理を取得します。
         * @return 未処理
         */
        public String getNoShoriCount() {
            return noShoriCount;
        }

        /**
         * 未処理を設定します。
         * @param noShoriCount 未処理
         */
        public void setNoShoriCount(String noShoriCount) {
            this.noShoriCount = noShoriCount;
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
         * 閲覧可能ユーザリストを取得します。
         * @return 閲覧可能ユーザリスト
         */
        public String getReadableUserList() {
            if (readableUserList == null) {
                return "";
            }

            StringBuilder buf = new StringBuilder();
            for (int i = 0; i < readableUserList.size(); i++) {
                buf.append(readableUserList.get(i));
                if (i < readableUserList.size() - 1) {
                    buf.append(" / ");
                }
            }
            return buf.toString();
        }

        /**
         * 閲覧可能ユーザリストを設定します。
         * @param readableUserList 閲覧可能ユーザリスト
         */
        public void setReadableUserList(List<String> readableUserList) {
            this.readableUserList = readableUserList;
        }

        /**
         * ユーザ閲覧可否を取得します。
         * @return ユーザ閲覧可否
         */
        public boolean isEnabled() {
            return enabled;
        }

        /**
         * ユーザ閲覧可否を設定します。
         * @param enabled ユーザ閲覧可否
         */
        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }
}
