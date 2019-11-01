/*
 * $Id: ShopImageUpdateCommitDbInServiceBean.java 4295 2009-07-07 12:59:59Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/26  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.bean;

/**
 * 店舗画像登録する時にDBを変更用InServiceBean
 *
 * @author Sim-JongYeon
 * @version $Revision: 4295 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopImageUpdateCommitDbInServiceBean {

    /** 店舗コード */
    private String shopCd;

    /** 店舗地図表示フラグ */
    private String shopMapPctFlgOrg;

    /** 店舗画像(左側)表示フラグ */
    private String shopPhoto1FlgOrg;

    /** 店舗画像(右側)表示フラグ */
    private String shopPhoto2FlgOrg;

    /** 店舗画像3表示フラグ */
    private String shopPhoto3FlgOrg;

    /** 店舗画像4表示フラグ */
    private String shopPhoto4FlgOrg;

    /** 店舗地図コメント */
    private String shopMapPctComment;

    /** 店舗画像１(店外写真)コメント */
    private String shopPhoto1Comment;

    /** 店舗画像２(スタッフ写真)コメント */
    private String shopPhoto2Comment;

    /** 店舗画像３(店内写真)コメント */
    private String shopPhoto3Comment;

    /** 店舗画像４(スタッフ接客写真)コメント */
    private String shopPhoto4Comment;

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
    public String getShopMapPctFlgOrg() {
        return shopMapPctFlgOrg;
    }

    /**
     * 店舗地図表示フラグを設定します。
     * @param shopMapPctFlgOrg 店舗地図表示フラグ
     */
    public void setShopMapPctFlgOrg(String shopMapPctFlgOrg) {
        this.shopMapPctFlgOrg = shopMapPctFlgOrg;
    }

    /**
     * 店舗画像(左側)表示フラグを取得します。
     * @return 店舗画像(左側)表示フラグ
     */
    public String getShopPhoto1FlgOrg() {
        return shopPhoto1FlgOrg;
    }

    /**
     * 店舗画像(左側)表示フラグを設定します。
     * @param shopPhoto1FlgOrg 店舗画像(左側)表示フラグ
     */
    public void setShopPhoto1FlgOrg(String shopPhoto1FlgOrg) {
        this.shopPhoto1FlgOrg = shopPhoto1FlgOrg;
    }

    /**
     * 店舗画像(右側)表示フラグを取得します。
     * @return 店舗画像(右側)表示フラグ
     */
    public String getShopPhoto2FlgOrg() {
        return shopPhoto2FlgOrg;
    }

    /**
     * 店舗画像(右側)表示フラグを設定します。
     * @param shopPhoto2FlgOrg 店舗画像(右側)表示フラグ
     */
    public void setShopPhoto2FlgOrg(String shopPhoto2FlgOrg) {
        this.shopPhoto2FlgOrg = shopPhoto2FlgOrg;
    }

    /**
     * 店舗画像3表示フラグを取得します。
     * @return 店舗画像3表示フラグ
     */
    public String getShopPhoto3FlgOrg() {
        return shopPhoto3FlgOrg;
    }

    /**
     * 店舗画像3表示フラグを設定します。
     * @param shopPhoto3FlgOrg 店舗画像3表示フラグ
     */
    public void setShopPhoto3FlgOrg(String shopPhoto3FlgOrg) {
        this.shopPhoto3FlgOrg = shopPhoto3FlgOrg;
    }

    /**
     * 店舗画像4表示フラグを取得します。
     * @return 店舗画像4表示フラグ
     */
    public String getShopPhoto4FlgOrg() {
        return shopPhoto4FlgOrg;
    }

    /**
     * 店舗画像4表示フラグを設定します。
     * @param shopPhoto4FlgOrg 店舗画像4表示フラグ
     */
    public void setShopPhoto4FlgOrg(String shopPhoto4FlgOrg) {
        this.shopPhoto4FlgOrg = shopPhoto4FlgOrg;
    }

    /**
     * 店舗地図コメントを取得します。
     * @return 店舗地図コメント
     */
    public String getShopMapPctComment() {
        return shopMapPctComment;
    }

    /**
     * 店舗地図コメントを設定します。
     * @param shopMapPctComment 店舗地図コメント
     */
    public void setShopMapPctComment(String shopMapPctComment) {
        this.shopMapPctComment = shopMapPctComment;
    }

    /**
     * 店舗画像１(店外写真)コメントを取得します。
     * @return 店舗画像１(店外写真)コメント
     */
    public String getShopPhoto1Comment() {
        return shopPhoto1Comment;
    }

    /**
     * 店舗画像１(店外写真)コメントを設定します。
     * @param shopPhoto1Comment 店舗画像１(店外写真)コメント
     */
    public void setShopPhoto1Comment(String shopPhoto1Comment) {
        this.shopPhoto1Comment = shopPhoto1Comment;
    }

    /**
     * 店舗画像２(スタッフ写真)コメントを取得します。
     * @return 店舗画像２(スタッフ写真)コメント
     */
    public String getShopPhoto2Comment() {
        return shopPhoto2Comment;
    }

    /**
     * 店舗画像２(スタッフ写真)コメントを設定します。
     * @param shopPhoto2Comment 店舗画像２(スタッフ写真)コメント
     */
    public void setShopPhoto2Comment(String shopPhoto2Comment) {
        this.shopPhoto2Comment = shopPhoto2Comment;
    }

    /**
     * 店舗画像３(店内写真)コメントを取得します。
     * @return 店舗画像３(店内写真)コメント
     */
    public String getShopPhoto3Comment() {
        return shopPhoto3Comment;
    }

    /**
     * 店舗画像３(店内写真)コメントを設定します。
     * @param shopPhoto3Comment 店舗画像３(店内写真)コメント
     */
    public void setShopPhoto3Comment(String shopPhoto3Comment) {
        this.shopPhoto3Comment = shopPhoto3Comment;
    }

    /**
     * 店舗画像４(スタッフ接客写真)コメントを取得します。
     * @return 店舗画像４(スタッフ接客写真)コメント
     */
    public String getShopPhoto4Comment() {
        return shopPhoto4Comment;
    }

    /**
     * 店舗画像４(スタッフ接客写真)コメントを設定します。
     * @param shopPhoto4Comment 店舗画像４(スタッフ接客写真)コメント
     */
    public void setShopPhoto4Comment(String shopPhoto4Comment) {
        this.shopPhoto4Comment = shopPhoto4Comment;
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
