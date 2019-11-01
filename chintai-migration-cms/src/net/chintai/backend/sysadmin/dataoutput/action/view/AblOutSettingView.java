/*
 * $Id: AblOutSettingView.java 4788 2014-01-10 02:06:42Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/11     BGT)亀田       新規作成
 * 2014/1/7       BGT)亀田       E-0053_スマイティ用データ抽出　市区・駅対応 docName追加
 *
 */
package net.chintai.backend.sysadmin.dataoutput.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;


/**
 * エイブル担当店/取扱店出力情報設定画面表示用Bean
 * @author KAMEDA Takuma
 * @version $Revision: 4788 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AblOutSettingView implements ViewHelper{

    /** エイブル担当店/取扱店出力情報設定List */
    private List<AblDetailView> ablSettingViewList;

    /**
     * エイブル担当店/取扱店出力情報設定Listを取得します。
     * @return エイブル担当店/取扱店出力情報設定List
     */
    public List<AblDetailView> getAblSettingViewList() {
        return ablSettingViewList;
    }

    /**
     * エイブル担当店/取扱店出力情報設定Listを設定します。
     * @param ablSettingViewList エイブル担当店/取扱店出力情報設定List
     */
    public void setAblSettingViewList(List<AblDetailView> ablSettingViewList) {
        this.ablSettingViewList = ablSettingViewList;
    }


    /**
     * エイブル担当店/取扱店出力情報設定画面表示用内部Bean
     * @author KAMEDA Takuma
     * @version $Revision: 4788 $
     * Copyright: (C) CHINTAI Corporation All Right Reserved.
     */
    public class AblDetailView implements ViewHelper{

        /** 他社データ連携種類 */
        private String dcoType;

        /** 物件出力区分 */
        private String bukkenOutKbn;

        /** 更新日付 */
        private String updDt;

        /** 連携対象会社名 */
        private String dcoName;

        /**
         * 他社データ連携種類を取得します。
         * @return 他社データ連携種類
         */
        public String getDcoType() {
            return dcoType;
        }

        /**
         * 他社データ連携種類を設定します。
         * @param dcoType 他社データ連携種類
         */
        public void setDcoType(String dcoType) {
            this.dcoType = dcoType;
        }

        /**
         * 物件出力区分を取得します。
         * @return 物件出力区分
         */
        public String getBukkenOutKbn() {
            return bukkenOutKbn;
        }

        /**
         * 物件出力区分を設定します。
         * @param bukkenOutKbn 物件出力区分
         */
        public void setBukkenOutKbn(String bukkenOutKbn) {
            this.bukkenOutKbn = bukkenOutKbn;
        }

        /**
         * 更新日付を取得します。
         * @return 更新日付
         */
        public String getUpdDt() {
            return updDt;
        }

        /**
         * 更新日付を設定します。
         * @param updDt 更新日付
         */
        public void setUpdDt(String updDt) {
            this.updDt = updDt;
        }

        /**
         * 連携対象会社名を取得します。
         * @return 連携対象会社名
         */
        public String getDcoName() {
            return dcoName;
        }

        /**
         * 連携対象会社名を設定します。
         * @param dcoName 連携対象会社名
         */
        public void setDcoName(String dcoName) {
            this.dcoName = dcoName;
        }

    }



}
