/*
 * $Id: ReviewTodofukenMediaCountView.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/09/20  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 都道府県別出稿状況集計結果
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewTodofukenMediaCountView implements ViewHelper {

    /** 集計結果リスト */
    private List<ReviewTodofukenMediaCountDetailView> todofukenMediaCntList;

    /** 集計時点日時 */
    private String cntTime;

    /** 集計年月リスト */
    private List<String> dateList;

    /**
     * 集計結果リストを取得します。
     * @return 集計結果リスト
     */
    public List<ReviewTodofukenMediaCountDetailView> getTodofukenMediaCntList() {
        return todofukenMediaCntList;
    }

    /**
     * 集計結果リストを設定します。
     * @param todofukenMediaCntList 集計結果リスト
     */
    public void setTodofukenMediaCntList(List<ReviewTodofukenMediaCountDetailView> todofukenMediaCntList) {
        this.todofukenMediaCntList = todofukenMediaCntList;
    }

    /**
     * 集計時点日時を取得します。
     * @return 集計時点日時
     */
    public String getCntTime() {
        return cntTime;
    }

    /**
     * 集計時点日時を設定します。
     * @param cntTime 集計時点日時
     */
    public void setCntTime(String cntTime) {
        this.cntTime = cntTime;
    }

    /**
     * 集計年月リストを取得します。
     * @return 集計年月リスト
     */
    public List<String> getDateList() {
        return dateList;
    }

    /**
     * 集計年月リストを設定します。
     * @param dateList 集計年月リスト
     */
    public void setDateList(List<String> dateList) {
        this.dateList = dateList;
    }

    public class ReviewTodofukenMediaCountDetailView implements ViewHelper {

        /** 都道府県名称 */
        private String prefName;

        /** 初回審査対象リスト */
        private List syokaiShinsaCntList;

        /** 初回審査対象外リスト */
        private List syokaiShinsaSkipList;

        /** 初回審査停止リスト */
        private List syokaiAutoDelList;

        /** 定期審査対象リスト */
        private List teikiShinsaList;

        /** 定期審査停止リスト */
        private List teikiAutoDelList;

        /**
         * 都道府県名称を取得します。
         * @return 都道府県名称
         */
        public String getPrefName() {
            return prefName;
        }

        /**
         * 都道府県名称を設定します。
         * @param prefName 都道府県名称
         */
        public void setPrefName(String prefName) {
            this.prefName = prefName;
        }

        /**
         * 初回審査停止リストを取得します。
         * @return 初回審査停止リスト
         */
        public List getSyokaiAutoDelList() {
            return syokaiAutoDelList;
        }

        /**
         * 初回審査停止リストを設定します。
         * @param syokaiAutoDelList 初回審査停止リスト
         */
        public void setSyokaiAutoDelList(List syokaiAutoDelList) {
            this.syokaiAutoDelList = syokaiAutoDelList;
        }

        /**
         * 初回審査対象リストを取得します。
         * @return 初回審査対象リスト
         */
        public List getSyokaiShinsaCntList() {
            return syokaiShinsaCntList;
        }

        /**
         * 初回審査対象リストを設定します。
         * @param syokaiShinsaCntList 初回審査対象リスト
         */
        public void setSyokaiShinsaCntList(List syokaiShinsaCntList) {
            this.syokaiShinsaCntList = syokaiShinsaCntList;
        }

        /**
         * 初回審査対象外リストを取得します。
         * @return 初回審査対象外リスト
         */
        public List getSyokaiShinsaSkipList() {
            return syokaiShinsaSkipList;
        }

        /**
         * 初回審査対象外リストを設定します。
         * @param syokaiShinsaSkipList 初回審査対象外リスト
         */
        public void setSyokaiShinsaSkipList(List syokaiShinsaSkipList) {
            this.syokaiShinsaSkipList = syokaiShinsaSkipList;
        }

        /**
         * 定期審査停止リストを取得します。
         * @return 定期審査停止リスト
         */
        public List getTeikiAutoDelList() {
            return teikiAutoDelList;
        }

        /**
         * 定期審査停止リストを設定します。
         * @param teikiAutoDelList 定期審査停止リスト
         */
        public void setTeikiAutoDelList(List teikiAutoDelList) {
            this.teikiAutoDelList = teikiAutoDelList;
        }

        /**
         * 定期審査対象リストを取得します。
         * @return 定期審査対象リスト
         */
        public List getTeikiShinsaList() {
            return teikiShinsaList;
        }

        /**
         * 定期審査対象リストを設定します。
         * @param teikiShinsaList 定期審査対象リスト
         */
        public void setTeikiShinsaList(List teikiShinsaList) {
            this.teikiShinsaList = teikiShinsaList;
        }

    }
}
