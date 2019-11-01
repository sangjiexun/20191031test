/*
 * $Id: ShopListingCityDomain.java 4246 2009-03-23 09:00:00Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/12     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.domain;

/**
 * 店舗リスティング市区町村テーブルDomain。
 *
 * @author Lee Hosup
 * @version $Revision: 4246 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingCityDomain {

    /** 都道府県名 */
    private String prefName;

    /** 都道府県コード */
    private String prefCd;

    /** 市区町村名 */
    private String cityName;

    /** 市区町村コード */
    private String cityCd;

    /**
     * 都道府県名を取得します。
     * @return 都道府県名
     */
    public String getPrefName() {
        return prefName;
    }

    /**
     * 都道府県名を設定します。
     * @param prefName 都道府県名
     */
    public void setPrefName(String prefName) {
        this.prefName = prefName;
    }

    /**
     * 都道府県コードを取得します。
     * @return 都道府県コード
     */
    public String getPrefCd() {
        return prefCd;
    }

    /**
     * 都道府県コードを設定します。
     * @param prefCd 都道府県コード
     */
    public void setPrefCd(String prefCd) {
        this.prefCd = prefCd;
    }

    /**
     * 市区町村名を取得します。
     * @return 市区町村名
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

    /**
     * 市区町村コードを取得します。
     * @return 市区町村コード
     */
    public String getCityCd() {
        return cityCd;
    }

    /**
     * 市区町村コードを設定します。
     * @param cityCd 市区町村コード
     */
    public void setCityCd(String cityCd) {
        this.cityCd = cityCd;
    }

}
