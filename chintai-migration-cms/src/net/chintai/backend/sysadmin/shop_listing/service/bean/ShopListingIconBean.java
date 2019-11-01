/*
 * $Id: ShopListingIconBean.java 4247 2009-03-23 09:15:01Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/13     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service.bean;

/**
 * アピールアイコン情報を格納。
 *
 * @author Lee Hosup
 * @version $Revision: 4247 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingIconBean {

    /** 画像パース */
    private String iconImgPath;

    /** アイコンID */
    private String iconId;

    /** リスティングフラグ */
    private String listingFlg;

    /** アイコン名 */
    private String iconName;

    /** 内容 */
    private String iconComment;

    /** 種別 */
    private String iconShubetsu;

    /** アーピルアイコン選択フラグ */
    private String appealChkFlg;

    /** リスティング選択フラグ */
    private String listingChkFlg;

    /**
     * 画像パースを取得します。
     * @return 画像パース
     */
    public String getIconImgPath() {
        return iconImgPath;
    }

    /**
     * 画像パースを設定します。
     * @param iconImgPath 画像パース
     */
    public void setIconImgPath(String iconImgPath) {
        this.iconImgPath = iconImgPath;
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
     * アイコン名を取得します。
     * @return アイコン名
     */
    public String getIconName() {
        return iconName;
    }

    /**
     * アイコン名を設定します。
     * @param iconName アイコン名
     */
    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    /**
     * 内容を取得します。
     * @return 内容
     */
    public String getIconComment() {
        return iconComment;
    }

    /**
     * 内容を設定します。
     * @param iconComment 内容
     */
    public void setIconComment(String iconComment) {
        this.iconComment = iconComment;
    }

    /**
     * 種別を取得します。
     * @return 種別
     */
    public String getIconShubetsu() {
        return iconShubetsu;
    }

    /**
     * 種別を設定します。
     * @param iconShubetsu 種別
     */
    public void setIconShubetsu(String iconShubetsu) {
        this.iconShubetsu = iconShubetsu;
    }

    /**
     * アーピルアイコン選択フラグを取得します。
     * @return アーピルアイコン選択フラグ
     */
    public String getAppealChkFlg() {
        return appealChkFlg;
    }

    /**
     * アーピルアイコン選択フラグを設定します。
     * @param appealChkFlg アーピルアイコン選択フラグ
     */
    public void setAppealChkFlg(String appealChkFlg) {
        this.appealChkFlg = appealChkFlg;
    }

    /**
     * リスティング選択フラグを取得します。
     * @return リスティング選択フラグ
     */
    public String getListingChkFlg() {
        return listingChkFlg;
    }

    /**
     * リスティング選択フラグを設定します。
     * @param listingChkFlg リスティング選択フラグ
     */
    public void setListingChkFlg(String listingChkFlg) {
        this.listingChkFlg = listingChkFlg;
    }
}
