/*
 * $Id: MediaInfoWebRegisterView.java 4244 2009-03-23 07:56:15Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/15     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.shop_listing.service.bean.ShopListingIconBean;

/**
 * 出稿情報本番反映ViewHelper
 *
 * @author Lee Hosup
 * @version $Revision: 4244 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MediaInfoWebRegisterView extends ShopBasicInfoView {

    /** 店舗コード */
    private String shopCd;

    /** 出稿対象駅：仮保存 */
    private String eki;

    /** 出稿対象市区町村：仮保存 */
    private String city;

    /** キャッチフレーズ：仮保存 */
    private String catchPhrase;

    /** アピールコメント：仮保存 */
    private String appealComment;

    /** 店舗画像URL：仮保存 */
    private String imgUrl;

    /** アピールアイコン選択：仮保存 */
    private List<ShopListingIconBean> appealIcon;

    /** リスティングアイコン選択：仮保存 */
    private List<ShopListingIconBean> listingIcon;

    /** クーポンコメント１：仮保存 */
    private String couponComment1;

    /** クーポンコメント２：仮保存 */
    private String couponComment2;

    /** クーポンコメント３：仮保存 */
    private String couponComment3;

    /** 備考：仮保存 */
    private String note;

    /** 最終更新日 */
    private String updDt;

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
     * 出稿対象駅：仮保存を取得します。
     * @return 出稿対象駅：仮保存
     */
    public String getEki() {
        return eki;
    }

    /**
     * 出稿対象駅：仮保存を設定します。
     * @param eki 出稿対象駅：仮保存
     */
    public void setEki(String eki) {
        this.eki = eki;
    }

    /**
     * 出稿対象市区町村：仮保存を取得します。
     * @return 出稿対象市区町村：仮保存
     */
    public String getCity() {
        return city;
    }

    /**
     * 出稿対象市区町村：仮保存を設定します。
     * @param city 出稿対象市区町村：仮保存
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * キャッチフレーズ：仮保存を取得します。
     * @return キャッチフレーズ：仮保存
     */
    public String getCatchPhrase() {
        return catchPhrase;
    }

    /**
     * キャッチフレーズ：仮保存を設定します。
     * @param catchPhrase キャッチフレーズ：仮保存
     */
    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    /**
     * アピールコメント：仮保存を取得します。
     * @return アピールコメント：仮保存
     */
    public String getAppealComment() {
        return appealComment;
    }

    /**
     * アピールコメント：仮保存を設定します。
     * @param appealComment アピールコメント：仮保存
     */
    public void setAppealComment(String appealComment) {
        this.appealComment = appealComment;
    }

    /**
     * 店舗画像URL：仮保存を取得します。
     * @return 店舗画像URL：仮保存
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 店舗画像URL：仮保存を設定します。
     * @param imgUrl 店舗画像URL：仮保存
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * アピールアイコン選択：仮保存を取得します。
     * @return アピールアイコン選択：仮保存
     */
    public List<ShopListingIconBean> getAppealIcon() {
        return appealIcon;
    }

    /**
     * アピールアイコン選択：仮保存を設定します。
     * @param appealIcon アピールアイコン選択：仮保存
     */
    public void setAppealIcon(List<ShopListingIconBean> appealIcon) {
        this.appealIcon = appealIcon;
    }

    /**
     * リスティングアイコン選択：仮保存を取得します。
     * @return リスティングアイコン選択：仮保存
     */
    public List<ShopListingIconBean> getListingIcon() {
        return listingIcon;
    }

    /**
     * リスティングアイコン選択：仮保存を設定します。
     * @param listingIcon リスティングアイコン選択：仮保存
     */
    public void setListingIcon(List<ShopListingIconBean> listingIcon) {
        this.listingIcon = listingIcon;
    }

    /**
     * クーポンコメント１：仮保存を取得します。
     * @return クーポンコメント１：仮保存
     */
    public String getCouponComment1() {
        return couponComment1;
    }

    /**
     * クーポンコメント１：仮保存を設定します。
     * @param couponComment1 クーポンコメント１：仮保存
     */
    public void setCouponComment1(String couponComment1) {
        this.couponComment1 = couponComment1;
    }

    /**
     * クーポンコメント２：仮保存を取得します。
     * @return クーポンコメント２：仮保存
     */
    public String getCouponComment2() {
        return couponComment2;
    }

    /**
     * クーポンコメント２：仮保存を設定します。
     * @param couponComment2 クーポンコメント２：仮保存
     */
    public void setCouponComment2(String couponComment2) {
        this.couponComment2 = couponComment2;
    }

    /**
     * クーポンコメント３：仮保存を取得します。
     * @return クーポンコメント３：仮保存
     */
    public String getCouponComment3() {
        return couponComment3;
    }

    /**
     * クーポンコメント３：仮保存を設定します。
     * @param couponComment3 クーポンコメント３：仮保存
     */
    public void setCouponComment3(String couponComment3) {
        this.couponComment3 = couponComment3;
    }

    /**
     * 備考：仮保存を取得します。
     * @return 備考：仮保存
     */
    public String getNote() {
        return note;
    }

    /**
     * 備考：仮保存を設定します。
     * @param note 備考：仮保存
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * 最終更新日を取得します。
     * @return 最終更新日
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 最終更新日を設定します。
     * @param updDt 最終更新日
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }
}
