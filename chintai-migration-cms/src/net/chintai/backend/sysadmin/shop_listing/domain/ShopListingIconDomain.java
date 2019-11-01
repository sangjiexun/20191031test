/*
 * $Id: ShopListingIconDomain.java 4246 2009-03-23 09:00:00Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/03     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.domain;

/**
 * アイコンマスタテーブル情報を取得します。
 *
 * @author Lee Hosup
 * @version $Revision: 4246 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingIconDomain {

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
}
