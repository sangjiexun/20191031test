/*
 * $Id: ShopBasicInfoView.java 4244 2009-03-23 07:56:15Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/20     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.action.view;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 店舗リスティング機能関連画面共通項目ViewHelper
 *
 * @author Lee Hosup
 * @version $Revision: 4244 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopBasicInfoView implements ViewHelper {

    /** 店舗名(会社名) */
    private String company;

    /** 店舗名(事務所名) */
    private String bumon;

    /** 店舗コード */
    private String shopCd;

    /** お客様設定パスワード */
    private String password;

    /**
     * 店舗名(会社名)を取得します。
     * @return 店舗名(会社名)
     */
    public String getCompany() {
        return company;
    }

    /**
     * 店舗名(会社名)を設定します。
     * @param company 店舗名(会社名)
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 店舗名(事務所名)を取得します。
     * @return 店舗名(事務所名)
     */
    public String getBumon() {
        return bumon;
    }

    /**
     * 店舗名(事務所名)を設定します。
     * @param bumon 店舗名(事務所名)
     */
    public void setBumon(String bumon) {
        this.bumon = bumon;
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
     * お客様設定パスワードを取得します。
     * @return お客様設定パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * お客様設定パスワードを設定します。
     * @param password お客様設定パスワード
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
