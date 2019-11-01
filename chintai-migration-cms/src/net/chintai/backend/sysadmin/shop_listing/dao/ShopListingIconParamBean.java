/*
 * $Id: ShopListingIconParamBean.java 4246 2009-03-23 09:00:00Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/12     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao;

/**
 * 店舗リスティングアイコンテーブルパラメータ。
 *
 * @author Lee Hosup
 * @version $Revision: 4246 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingIconParamBean {

    /** シーケンス */
    private String shopListingIconSeq;

    /** 店舗コード */
    private String shopCd;

    /** アイコンID */
    private String iconId;

    /** リスティングフラグ */
    private String listingFlg;

    /** Web掲載フラグ */
    private String webUpFlg;

    /** 登録プログラム名 */
    private String insPg;

    /** 登録者ID */
    private String insId;

    /** 更新プログラム名 */
    private String updPg;

    /** 更新者ID */
    private String updId;

    /**
     * シーケンスを取得します。
     * @return シーケンス
     */
    public String getShopListingIconSeq() {
        return shopListingIconSeq;
    }

    /**
     * シーケンスを設定します。
     * @param shopListingIconSeq シーケンス
     */
    public void setShopListingIconSeq(String shopListingIconSeq) {
        this.shopListingIconSeq = shopListingIconSeq;
    }

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
     * アイコンIDを取得します。
     * @return アイコンID
     */
    public String getIconId() {
        return iconId;
    }

    /**
     * アイコンIDを設定します。
     * @param iconId アイコンID
     */
    public void setIconId(String iconId) {
        this.iconId = iconId;
    }

    /**
     * リスティングフラグを取得します。
     * @return リスティングフラグ
     */
    public String getListingFlg() {
        return listingFlg;
    }

    /**
     * リスティングフラグを設定します。
     * @param listingFlg リスティングフラグ
     */
    public void setListingFlg(String listingFlg) {
        this.listingFlg = listingFlg;
    }

    /**
     * Web掲載フラグを取得します。
     * @return Web掲載フラグ
     */
    public String getWebUpFlg() {
        return webUpFlg;
    }

    /**
     * Web掲載フラグを設定します。
     * @param webUpFlg Web掲載フラグ
     */
    public void setWebUpFlg(String webUpFlg) {
        this.webUpFlg = webUpFlg;
    }

    /**
     * 登録プログラム名を取得します。
     * @return 登録プログラム名
     */
    public String getInsPg() {
        return insPg;
    }

    /**
     * 登録プログラム名を設定します。
     * @param insPg 登録プログラム名
     */
    public void setInsPg(String insPg) {
        this.insPg = insPg;
    }

    /**
     * 登録者IDを取得します。
     * @return 登録者ID
     */
    public String getInsId() {
        return insId;
    }

    /**
     * 登録者IDを設定します。
     * @param insId 登録者ID
     */
    public void setInsId(String insId) {
        this.insId = insId;
    }

    /**
     * 更新プログラム名を取得します。
     * @return 更新プログラム名
     */
    public String getUpdPg() {
        return updPg;
    }

    /**
     * 更新プログラム名を設定します。
     * @param updPg 更新プログラム名
     */
    public void setUpdPg(String updPg) {
        this.updPg = updPg;
    }

    /**
     * 更新者IDを取得します。
     * @return 更新者ID
     */
    public String getUpdId() {
        return updId;
    }

    /**
     * 更新者IDを設定します。
     * @param updId 更新者ID
     */
    public void setUpdId(String updId) {
        this.updId = updId;
    }

}
