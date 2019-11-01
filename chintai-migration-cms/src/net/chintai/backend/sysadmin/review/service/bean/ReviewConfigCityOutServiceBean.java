/*
 * $Id: ReviewConfigCityOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/09/28  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.bean;

import java.util.List;

/**
 * 市区町村別比較対象設定内容検索条件
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewConfigCityOutServiceBean {

    /** 都道府県名称 */
    private String areaName;

    /** 市区町村情報リスト */
    private List<ReviewConfigCityDetailBean> prefInfoList;

    public class ReviewConfigCityDetailBean {

        /** 市区町村名称 */
        private String cityName;

        /** 比較対象区分 */
        private String compKbn;

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
         * 比較対象区分を取得
         * @return compKbn
         */
        public String getCompKbn() {
            return compKbn;
        }

        /**
         * 比較対象区分を設定する
         * @param compKbn
         */
        public void setCompKbn(String compKbn) {
            this.compKbn = compKbn;
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
    public List<ReviewConfigCityDetailBean> getPrefInfoList() {
        return prefInfoList;
    }

    /**
     * 市区町村情報リストを設定する
     * @param prefInfoList
     */
    public void setPrefInfoList(List<ReviewConfigCityDetailBean> prefInfoList) {
        this.prefInfoList = prefInfoList;
    }
}
