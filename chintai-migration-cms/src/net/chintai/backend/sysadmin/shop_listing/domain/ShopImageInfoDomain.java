/*
 * $Id: ShopImageInfoDomain.java 4246 2009-03-23 09:00:00Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/11     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.domain;

/**
 * 店舗画像情報Domain。
 *
 * @author Lee Hosup
 * @version $Revision: 4246 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopImageInfoDomain {

    /** 店舗コード */
    private String shopCd;

    /** clientSystemType */
    private String clientSystemType;

    /** 店舗画像(左側)：店舗画像 */
    private String shopImage;

    /** 店舗画像(右側)：Manager画像 */
    private String managerImage;

    /** 店舗画像1フラグ */
    private String shopPhoto1Flg;

    /** 店舗画像2フラグ */
    private String shopPhoto2Flg;

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
     * clientSystemTypeを取得します。
     * @return clientSystemType
     */
    public String getClientSystemType() {
        return clientSystemType;
    }

    /**
     * clientSystemTypeを設定します。
     * @param clientSystemType clientSystemType
     */
    public void setClientSystemType(String clientSystemType) {
        this.clientSystemType = clientSystemType;
    }

    /**
     * 店舗画像(左側)：店舗画像を取得します。
     * @return 店舗画像(左側)：店舗画像
     */
    public String getShopImage() {
        return shopImage;
    }

    /**
     * 店舗画像(左側)：店舗画像を設定します。
     * @param shopImage 店舗画像(左側)：店舗画像
     */
    public void setShopImage(String shopImage) {
        this.shopImage = shopImage;
    }

    /**
     * 店舗画像(右側)：Manager画像を取得します。
     * @return 店舗画像(右側)：Manager画像
     */
    public String getManagerImage() {
        return managerImage;
    }

    /**
     * 店舗画像(右側)：Manager画像を設定します。
     * @param managerImage 店舗画像(右側)：Manager画像
     */
    public void setManagerImage(String managerImage) {
        this.managerImage = managerImage;
    }

    /**
     * 店舗画像1フラグを取得します。
     * @return 店舗画像1フラグ
     */
    public String getShopPhoto1Flg() {
        return shopPhoto1Flg;
    }

    /**
     * 店舗画像1フラグを設定します。
     * @param shopPhoto1Flg 店舗画像1フラグ
     */
    public void setShopPhoto1Flg(String shopPhoto1Flg) {
        this.shopPhoto1Flg = shopPhoto1Flg;
    }

    /**
     * 店舗画像2フラグを取得します。
     * @return 店舗画像2フラグ
     */
    public String getShopPhoto2Flg() {
        return shopPhoto2Flg;
    }

    /**
     * 店舗画像2フラグを設定します。
     * @param shopPhoto2Flg 店舗画像2フラグ
     */
    public void setShopPhoto2Flg(String shopPhoto2Flg) {
        this.shopPhoto2Flg = shopPhoto2Flg;
    }

}
