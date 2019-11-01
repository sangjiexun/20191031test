/*
 * $Id: TorihikisakiWakuInfoDeleteView.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/10  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 取引先物件枠設定情報
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuInfoDeleteView implements ViewHelper {

    /** 取引先シーケンス番号 */
    private String torihikisakiSeq;

    /** 取引先テーブルの最終更新日付 */
    private String torihikisakiUpdDt;

    /** 取引先物件枠情報リスト */
    private List<TorihikisakiWakuInfoDeleteDetailView> detailList;

    /**
     * 取引先シーケンス番号を取得します。
     * @return 取引先シーケンス番号
     */
    public String getTorihikisakiSeq() {
        return torihikisakiSeq;
    }

    /**
     * 取引先シーケンス番号を設定します。
     * @param torihikisakiSeq 取引先シーケンス番号
     */
    public void setTorihikisakiSeq(String torihikisakiSeq) {
        this.torihikisakiSeq = torihikisakiSeq;
    }

    public class TorihikisakiWakuInfoDeleteDetailView {

        /** 適用月 */
        private String startYm;

        /** 適用月(画面表示用) */
        private String startYmForDisplay;

        /** 物件枠 */
        private String bukkenCnt;

        /** 物件リスティング枠 */
        private String tokusenCnt;

        /** 最終更新自日時 */
        private String updDt;

        /**
         * 適用月を取得します。
         * @return 適用月
         */
        public String getStartYm() {
            return startYm;
        }

        /**
         * 適用月を設定します。
         * @param startYm 適用月
         */
        public void setStartYm(String startYm) {
            this.startYm = startYm;
        }

        /**
         * 物件枠を取得します。
         * @return 物件枠
         */
        public String getBukkenCnt() {
            return bukkenCnt;
        }

        /**
         * 物件枠を設定します。
         * @param bukkenCnt 物件枠
         */
        public void setBukkenCnt(String bukkenCnt) {
            this.bukkenCnt = bukkenCnt;
        }

        /**
         * 物件リスティング枠を取得します。
         * @return 物件リスティング枠
         */
        public String getTokusenCnt() {
            return tokusenCnt;
        }

        /**
         * 物件リスティング枠を設定します。
         * @param tokusenCnt 物件リスティング枠
         */
        public void setTokusenCnt(String tokusenCnt) {
            this.tokusenCnt = tokusenCnt;
        }

        /**
         * 最終更新自治時を取得します。
         * @return 最終更新自治時
         */
        public String getUpdDt() {
            return updDt;
        }

        /**
         * 最終更新自治時を設定します。
         * @param updDt 最終更新自治時
         */
        public void setUpdDt(String updDt) {
            this.updDt = updDt;
        }

        /**
         * 適用月(画面表示用)を取得します。
         * @return 適用月(画面表示用)
         */
        public String getStartYmForDisplay() {
            return startYmForDisplay;
        }

        /**
         * 適用月(画面表示用)を設定します。
         * @param startYmForDisplay 適用月(画面表示用)
         */
        public void setStartYmForDisplay(String startYmForDisplay) {
            this.startYmForDisplay = startYmForDisplay;
        }

    }

    /**
     * 取引先テーブルの最終更新日付を取得します。
     * @return 取引先テーブルの最終更新日付
     */
    public String getTorihikisakiUpdDt() {
        return torihikisakiUpdDt;
    }

    /**
     * 取引先テーブルの最終更新日付を設定します。
     * @param torihikisakiUpdDt 取引先テーブルの最終更新日付
     */
    public void setTorihikisakiUpdDt(String torihikisakiUpdDt) {
        this.torihikisakiUpdDt = torihikisakiUpdDt;
    }

    /**
     * 取引先物件枠情報リストを取得します。
     * @return 取引先物件枠情報リスト
     */
    public List<TorihikisakiWakuInfoDeleteDetailView> getDetailList() {
        return detailList;
    }

    /**
     * 取引先物件枠情報リストを設定します。
     * @param detailList 取引先物件枠情報リスト
     */
    public void setDetailList(List<TorihikisakiWakuInfoDeleteDetailView> detailList) {
        this.detailList = detailList;
    }
}
