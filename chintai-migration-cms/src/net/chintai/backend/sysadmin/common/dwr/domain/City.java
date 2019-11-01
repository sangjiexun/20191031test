/*
 * $Id: City.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/03  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.common.dwr.domain;

/**
 * 店舗検索の地域・沿線から検索するときに使用する市区町村Bean
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class City {

    /** 全国都道府県JISコード */
    private String cityCode;

    /** 市区町村名 */
    private String cityName;

    /**
     * 全国都道府県JISコードを取得します。
     * @return cityCode 全国都道府県JISコード
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 全国都道府県JISコードを設定します。
     * @param cityCode 全国都道府県JISコード
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * 市区町村名を取得します。
     * @return cityName 市区町村名
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 市区町村名を設定します。
     * @param cityName 市区町村名
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
