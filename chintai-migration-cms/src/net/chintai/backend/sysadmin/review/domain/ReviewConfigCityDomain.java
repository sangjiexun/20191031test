/*
 * $Id: ReviewConfigCityDomain.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/09/27  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.domain;

/**
 * 市区町村別比較対象設定情報を照会するクラス
 * 
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewConfigCityDomain {

    /** 都道府県名称 */
    private String prefName;

    /** 市区町村名称 */
    private String cityName;

    /** 比較対象区分 */
    private String compKbn;

    /**
     * 市区町村名称を取得します。
     * @return 市区町村名称
     */
    public String getCityName() {
        return cityName;
    }

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
     * 市区町村名称を設定します。
     * @param cityName 市区町村名称
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * 比較対象区分を取得します。
     * @return 比較対象区分
     */
    public String getCompKbn() {
        return compKbn;
    }

    /**
     * 比較対象区分を設定します。
     * @param compKbn 比較対象区分
     */
    public void setCompKbn(String compKbn) {
        this.compKbn = compKbn;
    }
}
