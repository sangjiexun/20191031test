/*
 * $Id: ReviewConfigCityView.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/09/28  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 「市区町村別比較対象設定内容表示」画面表示用
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewConfigCityView implements ViewHelper {

    /** 都道府県名称 */
    private String areaName;

    /** 市区町村情報リスト */
    private List<ReviewConfigCityDetailVeiw> prefInfoList;

    public class ReviewConfigCityDetailVeiw {

        /** 市区町村名称 */
        private String cityName;

        /** 市区町村 */
        private String shikutyoson;

        /** 最寄駅 */
        private String moyorieki;

        /**
         * 市区町村名称を取得
         * @return cityName
         */
        public String getCityName() {
            return cityName;
        }

        /**
         * 市区町村名称を設定する
         * @param cityName
         */
        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        /**
         * 最寄駅を取得
         * @return moyorieki
         */
        public String getMoyorieki() {
            return moyorieki;
        }

        /**
         * 最寄駅を設定する
         * @param moyorieki
         */
        public void setMoyorieki(String moyorieki) {
            this.moyorieki = moyorieki;
        }

        /**
         * 市区町村を取得
         * @return shikutyoson
         */
        public String getShikutyoson() {
            return shikutyoson;
        }

        /**
         * 市区町村を設定する
         * @param shikutyoson
         */
        public void setShikutyoson(String shikutyoson) {
            this.shikutyoson = shikutyoson;
        }

    }

    /**
     * 都道府県名称を取得
     * @return areaName
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 都道府県名称を設定する
     * @param areaName
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 市区町村情報リストを取得
     * @return prefInfoList
     */
    public List<ReviewConfigCityDetailVeiw> getPrefInfoList() {
        return prefInfoList;
    }

    /**
     * 市区町村情報リストを設定する
     * @param prefInfoList
     */
    public void setPrefInfoList(List<ReviewConfigCityDetailVeiw> prefInfoList) {
        this.prefInfoList = prefInfoList;
    }

}
