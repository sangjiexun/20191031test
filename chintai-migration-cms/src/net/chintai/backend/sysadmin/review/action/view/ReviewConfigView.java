/*
 * $Id: ReviewConfigView.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/13  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.review.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 「審査設定内容表示」画面用情報
 * 
 * @author Lee Hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewConfigView implements ViewHelper {

    /** 審査設定内容リスト */
    private List<ShinsaDatailView> shinsaDetailList;

    /** 間取りタイプ設定内容リスト */
    private List<MadoriDetailView> madoriDetailList;

    /** 自動削除設定内容リスト */
    private List<AutoDelDetailView> autoDelDetailList;

    /** 市区町村別比較対象設定内容リスト */
    private List<PrefDetailView> prefDetailList;

    /**
     * 自動削除設定内容リストを取得
     * @return autoDelDetailList
     */
    public List<AutoDelDetailView> getAutoDelDetailList() {
        return autoDelDetailList;
    }

    /**
     * 自動削除設定内容リストを設定する
     * @param autoDelDetailList
     */
    public void setAutoDelDetailList(List<AutoDelDetailView> autoDelDetailList) {
        this.autoDelDetailList = autoDelDetailList;
    }

    /**
     * 間取りタイプ設定内容を取得
     * @return madoriDetailList
     */
    public List<MadoriDetailView> getMadoriDetailList() {
        return madoriDetailList;
    }

    /**
     * 間取りタイプ設定内容を設定する
     * @param madoriDetailList
     */
    public void setMadoriDetailList(List<MadoriDetailView> madoriDetailList) {
        this.madoriDetailList = madoriDetailList;
    }

    /**
     * 自動削除設定内容を取得
     * @return prefDetailList
     */
    public List<PrefDetailView> getPrefDetailList() {
        return prefDetailList;
    }

    /**
     * 自動削除設定内容を設定する
     * @param prefDetailList
     */
    public void setPrefDetailList(List<PrefDetailView> prefDetailList) {
        this.prefDetailList = prefDetailList;
    }

    /**
     * 審査設定内容を取得
     * @return shinsaDetailList
     */
    public List<ShinsaDatailView> getShinsaDetailList() {
        return shinsaDetailList;
    }

    /**
     * 審査設定内容を設定する
     * @param shinsaDetailList
     */
    public void setShinsaDetailList(List<ShinsaDatailView> shinsaDetailList) {
        this.shinsaDetailList = shinsaDetailList;
    }

    /**
     * 審査設定内容リスト格納用InnerClass
     */
    public class ShinsaDatailView {

        /** 審査設定名称 */
        private String shinsaName;

        /** 審査条件 */
        private String jouken;

        /** 審査条件上下フラグ */
        private String joukenFlg;

        /** 審査除外条件 */
        private String jogai;

        /** 審査除外条件上下フラグ */
        private String jogaiFlg;

        /**
         * 審査設定名称を取得します。
         * @return 審査設定名称
         */
        public String getShinsaName() {
            return shinsaName;
        }

        /**
         * 審査設定名称を設定します。
         * @param shinsaName 審査設定名称
         */
        public void setShinsaName(String shinsaName) {
            this.shinsaName = shinsaName;
        }

        /**
         * 審査条件を取得します。
         * @return 審査条件
         */
        public String getJouken() {
            return jouken;
        }

        /**
         * 審査条件を設定します。
         * @param jouken 審査条件
         */
        public void setJouken(String jouken) {
            this.jouken = jouken;
        }

        /**
         * 審査条件上下フラグを取得します。
         * @return 審査条件上下フラグ
         */
        public String getJoukenFlg() {
            return joukenFlg;
        }

        /**
         * 審査条件上下フラグを設定します。
         * @param joukenFlg 審査条件上下フラグ
         */
        public void setJoukenFlg(String joukenFlg) {
            this.joukenFlg = joukenFlg;
        }

        /**
         * 審査除外条件を取得します。
         * @return 審査除外条件
         */
        public String getJogai() {
            return jogai;
        }

        /**
         * 審査除外条件を設定します。
         * @param jogai 審査除外条件
         */
        public void setJogai(String jogai) {
            this.jogai = jogai;
        }

        /**
         * 審査除外条件上下フラグを取得します。
         * @return 審査除外条件上下フラグ
         */
        public String getJogaiFlg() {
            return jogaiFlg;
        }

        /**
         * 審査除外条件上下フラグを設定します。
         * @param jogaiFlg 審査除外条件上下フラグ
         */
        public void setJogaiFlg(String jogaiFlg) {
            this.jogaiFlg = jogaiFlg;
        }
    }

    /**
     * 自動削除設定内容リスト格納用InnerClass
     */
    public class AutoDelDetailView {

        /** 審査設定名称 */
        private String shinsaName;

        /** 自動削除期間 */
        private String autoDelKikan;

        /**
         * 審査設定名称を取得します。
         * @return 審査設定名称
         */
        public String getShinsaName() {
            return shinsaName;
        }

        /**
         * 審査設定名称を設定します。
         * @param shinsaName 審査設定名称
         */
        public void setShinsaName(String shinsaName) {
            this.shinsaName = shinsaName;
        }

        /**
         * 自動削除期間を取得します。
         * @return 自動削除期間
         */
        public String getAutoDelKikan() {
            return autoDelKikan;
        }

        /**
         * 自動削除期間を設定します。
         * @param autoDelKikan 自動削除期間
         */
        public void setAutoDelKikan(String autoDelKikan) {
            this.autoDelKikan = autoDelKikan;
        }
    }

    /**
     * 間取りタイプ設定内容リスト格納用InnerClass
     */
    public class MadoriDetailView {

        /** 分類 */
        private String madoriTypeName;

        /** 抽出範囲 */
        private String madori;

        /** 有効期間 */
        private String minBukkenCnt;

        /** 有効範囲の上限 */
        private String maxChinryo;

        /** 有効範囲の下限 */
        private String minChinryo;

        /**
         * 分類を取得します。
         * @return 分類
         */
        public String getMadoriTypeName() {
            return madoriTypeName;
        }

        /**
         * 分類を設定します。
         * @param madoriTypeName 分類
         */
        public void setMadoriTypeName(String madoriTypeName) {
            this.madoriTypeName = madoriTypeName;
        }

        /**
         * 抽出範囲を取得します。
         * @return 抽出範囲
         */
        public String getMadori() {
            return madori;
        }

        /**
         * 抽出範囲を設定します。
         * @param madori 抽出範囲
         */
        public void setMadori(String madori) {
            this.madori = madori;
        }

        /**
         * 有効期間を取得します。
         * @return 有効期間
         */
        public String getMinBukkenCnt() {
            return minBukkenCnt;
        }

        /**
         * 有効期間を設定します。
         * @param minBukkenCnt 有効期間
         */
        public void setMinBukkenCnt(String minBukkenCnt) {
            this.minBukkenCnt = minBukkenCnt;
        }

        /**
         * 有効範囲の上限を取得します。
         * @return 有効範囲の上限
         */
        public String getMaxChinryo() {
            return maxChinryo;
        }

        /**
         * 有効範囲の上限を設定します。
         * @param maxChinryo 有効範囲の上限
         */
        public void setMaxChinryo(String maxChinryo) {
            this.maxChinryo = maxChinryo;
        }

        /**
         * 有効範囲の下限を取得します。
         * @return 有効範囲の下限
         */
        public String getMinChinryo() {
            return minChinryo;
        }

        /**
         * 有効範囲の下限を設定します。
         * @param minChinryo 有効範囲の下限
         */
        public void setMinChinryo(String minChinryo) {
            this.minChinryo = minChinryo;
        }

    }

    /**
     * 市区町村別比較対象設定内容リスト格納用InnerView
     */
    public class PrefDetailView {

        /** エリア名称 */
        private String areaName;

        /** 都道府県名称,コド情報配列のリスト */
        private List<String[]> prefInfoList;

        /**
         * エリア名称を取得します。
         * @return エリア名称
         */
        public String getAreaName() {
            return areaName;
        }

        /**
         * エリア名称を設定します。
         * @param areaName エリア名称
         */
        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        /**
         * 都道府県名称,コド情報配列のリストを取得します。
         * @return 都道府県名称,コド情報配列のリスト
         */
        public List<String[]> getPrefInfoList() {
            return prefInfoList;
        }

        /**
         * 都道府県名称,コド情報配列のリストを設定します。
         * @param prefInfoList 都道府県名称,コド情報配列のリスト
         */
        public void setPrefInfoList(List<String[]> prefInfoList) {
            this.prefInfoList = prefInfoList;
        }

    }
}
