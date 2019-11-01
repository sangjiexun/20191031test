/*
 * $Id: ShopDetailInfoSearchParamBean.java 3765 2008-01-21 09:04:43Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/09  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

/**
 * 店舗詳細ParamBean
 *
 * @author Sim-JongYeon
 * @version $Revision: 3765 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopDetailInfoSearchParamBean {

    /** 店舗コード */
    private String shopCd;

    /** CHINTAI有効物件数取得元テーブル名 */
    private String chintaiBukkenCountTableName;

    /** エイブル有効物件数取得元テーブル名 */
    private String ableBukkenCountTableName;

    /**
     * 店舗コードを設定します。
     * @param shopCd 店舗コード
     */
    public void setShopCd(String shopCd) {
        this.shopCd = shopCd;
    }

    /**
     * 店舗コードを取得します。
     * @return 店舗コード
     */
    public String getShopCd() {
        return shopCd;
    }

    /**
     * CHINTAI有効物件数取得元テーブル名を取得します。
     * @return CHINTAI有効物件数取得元テーブル名
     */
    public String getChintaiBukkenCountTableName() {
        return chintaiBukkenCountTableName;
    }

    /**
     * CHINTAI有効物件数取得元テーブル名を設定します。
     * @param chintaiBukkenCountTableName CHINTAI有効物件数取得元テーブル名
     */
    public void setChintaiBukkenCountTableName(String chintaiBukkenCountTableName) {
        this.chintaiBukkenCountTableName = chintaiBukkenCountTableName;
    }

    /**
     * エイブル有効物件数取得元テーブル名を取得します。
     * @return エイブル有効物件数取得元テーブル名
     */
    public String getAbleBukkenCountTableName() {
        return ableBukkenCountTableName;
    }

    /**
     * エイブル有効物件数取得元テーブル名を設定します。
     * @param ableBukkenCountTableName エイブル有効物件数取得元テーブル名
     */
    public void setAbleBukkenCountTableName(String ableBukkenCountTableName) {
        this.ableBukkenCountTableName = ableBukkenCountTableName;
    }

}
