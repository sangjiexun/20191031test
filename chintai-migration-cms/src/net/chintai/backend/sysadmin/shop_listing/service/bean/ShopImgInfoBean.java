/*
 * $Id: ShopImgInfoBean.java 4247 2009-03-23 09:15:01Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/14     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service.bean;

/**
 * 店舗画像情報を格納。
 *
 * @author Lee Hosup
 * @version $Revision: 4247 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopImgInfoBean {

    /** 店舗コード */
    private String shopCd;

    /** 店舗画像１ */
    private String shopPhoto1Flg;

    /** 店舗画像２ */
    private String shopPhoto2Flg;

    /** エイブログ店舗画像 */
    private String shopImage;

    /** エイブログ店長画像 */
    private String managerImage;

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
     * 店舗画像１を取得します。
     * @return 店舗画像１
     */
    public String getShopPhoto1Flg() {
        return shopPhoto1Flg;
    }

    /**
     * 店舗画像１を設定します。
     * @param shopPhoto1Flg 店舗画像１
     */
    public void setShopPhoto1Flg(String shopPhoto1Flg) {
        this.shopPhoto1Flg = shopPhoto1Flg;
    }

    /**
     * 店舗画像２を取得します。
     * @return 店舗画像２
     */
    public String getShopPhoto2Flg() {
        return shopPhoto2Flg;
    }

    /**
     * 店舗画像２を設定します。
     * @param shopPhoto2Flg 店舗画像２
     */
    public void setShopPhoto2Flg(String shopPhoto2Flg) {
        this.shopPhoto2Flg = shopPhoto2Flg;
    }

    /**
     * エイブログ店舗画像を取得します。
     * @return エイブログ店舗画像
     */
    public String getShopImage() {
        return shopImage;
    }

    /**
     * エイブログ店舗画像を設定します。
     * @param shopImage エイブログ店舗画像
     */
    public void setShopImage(String shopImage) {
        this.shopImage = shopImage;
    }

    /**
     * エイブログ店長画像を取得します。
     * @return エイブログ店長画像
     */
    public String getManagerImage() {
        return managerImage;
    }

    /**
     * エイブログ店長画像を設定します。
     * @param managerImage エイブログ店長画像
     */
    public void setManagerImage(String managerImage) {
        this.managerImage = managerImage;
    }

}
