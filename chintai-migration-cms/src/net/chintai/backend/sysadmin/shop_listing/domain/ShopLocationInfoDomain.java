/*
 * $Id: ShopLocationInfoDomain.java 4246 2009-03-23 09:00:00Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/15     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.domain;

/**
 * 店舗位置情報Domain。
 *
 * @author Lee Hosup
 * @version $Revision: 4246 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopLocationInfoDomain {

    /** 店舗コード */
    private String shopCd;

    /** 経度10進 */
    private String locationX;

    /** 緯度10進 */
    private String locationY;

    /** 都道府県キー文字列 */
    private String prefKey;

    /**
     * 店舗コードを取得します。
     * @return 店舗コード
     */
    public String getShopCd() {
        return shopCd;
    }

    /**
     * 店舗コードを設定します。
     * @param shopCd 店舗コード
     */
    public void setShopCd(String shopCd) {
        this.shopCd = shopCd;
    }

    /**
     * 経度10進を取得します。
     * @return 経度10進
     */
    public String getLocationX() {
        return locationX;
    }

    /**
     * 経度10進を設定します。
     * @param locationX 経度10進
     */
    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    /**
     * 緯度10進を取得します。
     * @return 緯度10進
     */
    public String getLocationY() {
        return locationY;
    }

    /**
     * 緯度10進を設定します。
     * @param locationY 緯度10進
     */
    public void setLocationY(String locationY) {
        this.locationY = locationY;
    }

    /**
     * 都道府県キー文字列を取得します。
     * @return 都道府県キー文字列
     */
    public String getPrefKey() {
        return prefKey;
    }

    /**
     * 都道府県キー文字列を設定します。
     * @param prefKey 都道府県キー文字列
     */
    public void setPrefKey(String prefKey) {
        this.prefKey = prefKey;
    }

}
