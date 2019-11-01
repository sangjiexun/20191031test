/*
 * $Id: ShopImageDeleteCommitDbInServiceBean.java 4295 2009-07-07 12:59:59Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/26  BGT)沈鍾沿     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_bukken.service.bean;

/**
 * 店舗画像を削除する時にDBを変更用InServiceBean
 *
 * @author Sim-JongYeon
 * @version $Revision: 4295 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopImageDeleteCommitDbInServiceBean {

    /** 店舗コード */
    private String shopCd;

    /** 店舗地図の削除フラグ */
    private String shopMapPctFileDeleteCheck;

    /** 店舗画像(左側)の削除フラグ */
    private String shopPhoto1FileDeleteCheck;

    /** 店舗画像(右側)の削除フラグ */
    private String shopPhoto2FileDeleteCheck;

    /** 店舗画像３(店内写真)の削除フラグ */
    private String shopPhoto3FileDeleteCheck;

    /** 店舗画像４(スタッフ接客写真)の削除フラグ */
    private String shopPhoto4FileDeleteCheck;

    /** 最終更新日付 */
    private String updDt;

    /** 最終更新プログラム */
    private String updPg;

    /** 最終更新者ID */
    private String updId;

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
     * 店舗地図表示フラグを取得します。
     * @return 店舗地図表示フラグ
     */
    public String getShopMapPctFileDeleteCheck() {
        return shopMapPctFileDeleteCheck;
    }

    /**
     * 店舗地図表示フラグを設定します。
     * @param shopMapPctFileDeleteCheck 店舗地図表示フラグ
     */
    public void setShopMapPctFileDeleteCheck(String shopMapPctFileDeleteCheck) {
        this.shopMapPctFileDeleteCheck = shopMapPctFileDeleteCheck;
    }

    /**
     * 店舗画像(左側)の削除フラグを取得します。
     * @return 店舗画像(左側)の削除フラグ
     */
    public String getShopPhoto1FileDeleteCheck() {
        return shopPhoto1FileDeleteCheck;
    }

    /**
     * 店舗画像(左側)の削除フラグを設定します。
     * @param shopPhoto1FileDeleteCheck 店舗画像(左側)の削除フラグ
     */
    public void setShopPhoto1FileDeleteCheck(String shopPhoto1FileDeleteCheck) {
        this.shopPhoto1FileDeleteCheck = shopPhoto1FileDeleteCheck;
    }

    /**
     * 店舗画像(右側)の削除フラグを取得します。
     * @return 店舗画像(右側)の削除フラグ
     */
    public String getShopPhoto2FileDeleteCheck() {
        return shopPhoto2FileDeleteCheck;
    }

    /**
     * 店舗画像(右側)の削除フラグを設定します。
     * @param shopPhoto2FileDeleteCheck 店舗画像(右側)の削除フラグ
     */
    public void setShopPhoto2FileDeleteCheck(String shopPhoto2FileDeleteCheck) {
        this.shopPhoto2FileDeleteCheck = shopPhoto2FileDeleteCheck;
    }

    /**
     * 店舗画像３(店内写真)の削除フラグを取得します。
     * @return 店舗画像３(店内写真)の削除フラグ
     */
    public String getShopPhoto3FileDeleteCheck() {
        return shopPhoto3FileDeleteCheck;
    }

    /**
     * 店舗画像３(店内写真)の削除フラグを設定します。
     * @param shopPhoto3FileDeleteCheck 店舗画像３(店内写真)の削除フラグ
     */
    public void setShopPhoto3FileDeleteCheck(String shopPhoto3FileDeleteCheck) {
        this.shopPhoto3FileDeleteCheck = shopPhoto3FileDeleteCheck;
    }

    /**
     * 店舗画像４(スタッフ接客写真)の削除フラグを取得します。
     * @return 店舗画像４(スタッフ接客写真)の削除フラグ
     */
    public String getShopPhoto4FileDeleteCheck() {
        return shopPhoto4FileDeleteCheck;
    }

    /**
     * 店舗画像４(スタッフ接客写真)の削除フラグを設定します。
     * @param shopPhoto4FileDeleteCheck 店舗画像４(スタッフ接客写真)の削除フラグ
     */
    public void setShopPhoto4FileDeleteCheck(String shopPhoto4FileDeleteCheck) {
        this.shopPhoto4FileDeleteCheck = shopPhoto4FileDeleteCheck;
    }

    /**
     * 最終更新日付を取得します。
     * @return 最終更新日付
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 最終更新日付を設定します。
     * @param updDt 最終更新日付
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
     * 最終更新プログラムを取得します。
     * @return 最終更新プログラム
     */
    public String getUpdPg() {
        return updPg;
    }

    /**
     * 最終更新プログラムを設定します。
     * @param updPg 最終更新プログラム
     */
    public void setUpdPg(String updPg) {
        this.updPg = updPg;
    }

    /**
     * 最終更新者IDを取得します。
     * @return 最終更新者ID
     */
    public String getUpdId() {
        return updId;
    }

    /**
     * 最終更新者IDを設定します。
     * @param updId 最終更新者ID
     */
    public void setUpdId(String updId) {
        this.updId = updId;
    }

}
