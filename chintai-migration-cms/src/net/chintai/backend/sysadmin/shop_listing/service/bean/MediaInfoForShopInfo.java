/*
 * $Id: MediaInfoForShopInfo.java 4247 2009-03-23 09:15:01Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/14     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service.bean;

import java.util.List;

/**
 * 契約店舗詳細画面表示用、出稿情報を格納します。
 *
 * @author Lee Hosup
 * @version $Revision: 4247 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MediaInfoForShopInfo {

    /** 店舗コード */
    private String shopCd;

    /** 経度10進 */
    private String locationX;

    /** 緯度10進 */
    private String locationY;

    /** 都道府県キー文字列 */
    private String prefKey;

    /** 出稿対象駅：Web表示中 */
    private String ekiWeb;

    /** 出稿対象駅：仮保存 */
    private String ekiTmp;

    /** 出稿対象市区町村：Web表示中 */
    private String cityWeb;

    /** 出稿対象市区町村：仮保存 */
    private String cityTmp;

    /** キャッチフレーズ：Web表示中 */
    private String catchPhraseWeb;

    /** キャッチフレーズ：仮保存 */
    private String catchPhraseTmp;

    /** アピールコメント：Web表示中 */
    private String appealCommentWeb;

    /** アピールコメント：仮保存 */
    private String appealCommentTmp;

    /** 店舗画像URL：Web表示中 */
    private String imgUrlWeb;

    /** 店舗画像URL：仮保存 */
    private String imgUrlTmp;

    /** アピールアイコン選択：Web表示中 */
    private List<ShopListingIconBean> appealIconWeb;

    /** アピールアイコン選択：仮保存 */
    private List<ShopListingIconBean> appealIconTmp;

    /** リスティングアイコン選択：Web表示中 */
    private List<ShopListingIconBean> listingIconWeb;

    /** リスティングアイコン選択：仮保存 */
    private List<ShopListingIconBean> listingIconTmp;

    /** クーポンコメント１：Web表示中 */
    private String couponComment1Web;

    /** クーポンコメント１：仮保存 */
    private String couponComment1Tmp;

    /** クーポンコメント２：Web表示中 */
    private String couponComment2Web;

    /** クーポンコメント２：仮保存 */
    private String couponComment2Tmp;

    /** クーポンコメント３：Web表示中 */
    private String couponComment3Web;

    /** クーポンコメント３：仮保存 */
    private String couponComment3Tmp;

    /** 備考：Web表示中 */
    private String noteWeb;

    /** 備考：仮保存 */
    private String noteTmp;

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
     * 経度10進を取得します。
     * @return 経度10進
     */
    public String getLocationX() {
        return locationX;
    }

    /**
     * 経度10進を設定します。
     * @param locationX 経度10進
     */
    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    /**
     * 緯度10進を取得します。
     * @return 緯度10進
     */
    public String getLocationY() {
        return locationY;
    }

    /**
     * 緯度10進を設定します。
     * @param locationY 緯度10進
     */
    public void setLocationY(String locationY) {
        this.locationY = locationY;
    }

    /**
     * 都道府県キー文字列を取得します。
     * @return 都道府県キー文字列
     */
    public String getPrefKey() {
        return prefKey;
    }

    /**
     * 都道府県キー文字列を設定します。
     * @param prefKey 都道府県キー文字列
     */
    public void setPrefKey(String prefKey) {
        this.prefKey = prefKey;
    }

    /**
     * 出稿対象駅：Web表示中を取得します。
     * @return 出稿対象駅：Web表示中
     */
    public String getEkiWeb() {
        return ekiWeb;
    }

    /**
     * 出稿対象駅：Web表示中を設定します。
     * @param ekiWeb 出稿対象駅：Web表示中
     */
    public void setEkiWeb(String ekiWeb) {
        this.ekiWeb = ekiWeb;
    }

    /**
     * 出稿対象駅：仮保存を取得します。
     * @return 出稿対象駅：仮保存
     */
    public String getEkiTmp() {
        return ekiTmp;
    }

    /**
     * 出稿対象駅：仮保存を設定します。
     * @param ekiTmp 出稿対象駅：仮保存
     */
    public void setEkiTmp(String ekiTmp) {
        this.ekiTmp = ekiTmp;
    }

    /**
     * 出稿対象市区町村：Web表示中を取得します。
     * @return 出稿対象市区町村：Web表示中
     */
    public String getCityWeb() {
        return cityWeb;
    }

    /**
     * 出稿対象市区町村：Web表示中を設定します。
     * @param cityWeb 出稿対象市区町村：Web表示中
     */
    public void setCityWeb(String cityWeb) {
        this.cityWeb = cityWeb;
    }

    /**
     * 出稿対象市区町村：仮保存を取得します。
     * @return 出稿対象市区町村：仮保存
     */
    public String getCityTmp() {
        return cityTmp;
    }

    /**
     * 出稿対象市区町村：仮保存を設定します。
     * @param cityTmp 出稿対象市区町村：仮保存
     */
    public void setCityTmp(String cityTmp) {
        this.cityTmp = cityTmp;
    }

    /**
     * キャッチフレーズ：Web表示中を取得します。
     * @return キャッチフレーズ：Web表示中
     */
    public String getCatchPhraseWeb() {
        return catchPhraseWeb;
    }

    /**
     * キャッチフレーズ：Web表示中を設定します。
     * @param catchPhraseWeb キャッチフレーズ：Web表示中
     */
    public void setCatchPhraseWeb(String catchPhraseWeb) {
        this.catchPhraseWeb = catchPhraseWeb;
    }

    /**
     * キャッチフレーズ：仮保存を取得します。
     * @return キャッチフレーズ：仮保存
     */
    public String getCatchPhraseTmp() {
        return catchPhraseTmp;
    }

    /**
     * キャッチフレーズ：仮保存を設定します。
     * @param catchPhraseTmp キャッチフレーズ：仮保存
     */
    public void setCatchPhraseTmp(String catchPhraseTmp) {
        this.catchPhraseTmp = catchPhraseTmp;
    }

    /**
     * アピールコメント：Web表示中を取得します。
     * @return アピールコメント：Web表示中
     */
    public String getAppealCommentWeb() {
        return appealCommentWeb;
    }

    /**
     * アピールコメント：Web表示中を設定します。
     * @param appealCommentWeb アピールコメント：Web表示中
     */
    public void setAppealCommentWeb(String appealCommentWeb) {
        this.appealCommentWeb = appealCommentWeb;
    }

    /**
     * アピールコメント：仮保存を取得します。
     * @return アピールコメント：仮保存
     */
    public String getAppealCommentTmp() {
        return appealCommentTmp;
    }

    /**
     * アピールコメント：仮保存を設定します。
     * @param appealCommentTmp アピールコメント：仮保存
     */
    public void setAppealCommentTmp(String appealCommentTmp) {
        this.appealCommentTmp = appealCommentTmp;
    }

    /**
     * 店舗画像URL：Web表示中を取得します。
     * @return 店舗画像URL：Web表示中
     */
    public String getImgUrlWeb() {
        return imgUrlWeb;
    }

    /**
     * 店舗画像URL：Web表示中を設定します。
     * @param imgUrlWeb 店舗画像URL：Web表示中
     */
    public void setImgUrlWeb(String imgUrlWeb) {
        this.imgUrlWeb = imgUrlWeb;
    }

    /**
     * 店舗画像URL：仮保存を取得します。
     * @return 店舗画像URL：仮保存
     */
    public String getImgUrlTmp() {
        return imgUrlTmp;
    }

    /**
     * 店舗画像URL：仮保存を設定します。
     * @param imgUrlTmp 店舗画像URL：仮保存
     */
    public void setImgUrlTmp(String imgUrlTmp) {
        this.imgUrlTmp = imgUrlTmp;
    }

    /**
     * アピールアイコン選択：Web表示中を取得します。
     * @return アピールアイコン選択：Web表示中
     */
    public List<ShopListingIconBean> getAppealIconWeb() {
        return appealIconWeb;
    }

    /**
     * アピールアイコン選択：Web表示中を設定します。
     * @param appealIconWeb アピールアイコン選択：Web表示中
     */
    public void setAppealIconWeb(List<ShopListingIconBean> appealIconWeb) {
        this.appealIconWeb = appealIconWeb;
    }

    /**
     * アピールアイコン選択：仮保存を取得します。
     * @return アピールアイコン選択：仮保存
     */
    public List<ShopListingIconBean> getAppealIconTmp() {
        return appealIconTmp;
    }

    /**
     * アピールアイコン選択：仮保存を設定します。
     * @param appealIconTmp アピールアイコン選択：仮保存
     */
    public void setAppealIconTmp(List<ShopListingIconBean> appealIconTmp) {
        this.appealIconTmp = appealIconTmp;
    }

    /**
     * リスティングアイコン選択：Web表示中を取得します。
     * @return リスティングアイコン選択：Web表示中
     */
    public List<ShopListingIconBean> getListingIconWeb() {
        return listingIconWeb;
    }

    /**
     * リスティングアイコン選択：Web表示中を設定します。
     * @param listingIconWeb リスティングアイコン選択：Web表示中
     */
    public void setListingIconWeb(List<ShopListingIconBean> listingIconWeb) {
        this.listingIconWeb = listingIconWeb;
    }

    /**
     * リスティングアイコン選択：仮保存を取得します。
     * @return リスティングアイコン選択：仮保存
     */
    public List<ShopListingIconBean> getListingIconTmp() {
        return listingIconTmp;
    }

    /**
     * リスティングアイコン選択：仮保存を設定します。
     * @param listingIconTmp リスティングアイコン選択：仮保存
     */
    public void setListingIconTmp(List<ShopListingIconBean> listingIconTmp) {
        this.listingIconTmp = listingIconTmp;
    }

    /**
     * クーポンコメント１：Web表示中を取得します。
     * @return クーポンコメント１：Web表示中
     */
    public String getCouponComment1Web() {
        return couponComment1Web;
    }

    /**
     * クーポンコメント１：Web表示中を設定します。
     * @param couponComment1Web クーポンコメント１：Web表示中
     */
    public void setCouponComment1Web(String couponComment1Web) {
        this.couponComment1Web = couponComment1Web;
    }

    /**
     * クーポンコメント１：仮保存を取得します。
     * @return クーポンコメント１：仮保存
     */
    public String getCouponComment1Tmp() {
        return couponComment1Tmp;
    }

    /**
     * クーポンコメント１：仮保存を設定します。
     * @param couponComment1Tmp クーポンコメント１：仮保存
     */
    public void setCouponComment1Tmp(String couponComment1Tmp) {
        this.couponComment1Tmp = couponComment1Tmp;
    }

    /**
     * クーポンコメント２：Web表示中を取得します。
     * @return クーポンコメント２：Web表示中
     */
    public String getCouponComment2Web() {
        return couponComment2Web;
    }

    /**
     * クーポンコメント２：Web表示中を設定します。
     * @param couponComment2Web クーポンコメント２：Web表示中
     */
    public void setCouponComment2Web(String couponComment2Web) {
        this.couponComment2Web = couponComment2Web;
    }

    /**
     * クーポンコメント２：仮保存を取得します。
     * @return クーポンコメント２：仮保存
     */
    public String getCouponComment2Tmp() {
        return couponComment2Tmp;
    }

    /**
     * クーポンコメント２：仮保存を設定します。
     * @param couponComment2Tmp クーポンコメント２：仮保存
     */
    public void setCouponComment2Tmp(String couponComment2Tmp) {
        this.couponComment2Tmp = couponComment2Tmp;
    }

    /**
     * クーポンコメント３：Web表示中を取得します。
     * @return クーポンコメント３：Web表示中
     */
    public String getCouponComment3Web() {
        return couponComment3Web;
    }

    /**
     * クーポンコメント３：Web表示中を設定します。
     * @param couponComment3Web クーポンコメント３：Web表示中
     */
    public void setCouponComment3Web(String couponComment3Web) {
        this.couponComment3Web = couponComment3Web;
    }

    /**
     * クーポンコメント３：仮保存を取得します。
     * @return クーポンコメント３：仮保存
     */
    public String getCouponComment3Tmp() {
        return couponComment3Tmp;
    }

    /**
     * クーポンコメント３：仮保存を設定します。
     * @param couponComment3Tmp クーポンコメント３：仮保存
     */
    public void setCouponComment3Tmp(String couponComment3Tmp) {
        this.couponComment3Tmp = couponComment3Tmp;
    }

    /**
     * 備考：Web表示中を取得します。
     * @return 備考：Web表示中
     */
    public String getNoteWeb() {
        return noteWeb;
    }

    /**
     * 備考：Web表示中を設定します。
     * @param noteWeb 備考：Web表示中
     */
    public void setNoteWeb(String noteWeb) {
        this.noteWeb = noteWeb;
    }

    /**
     * 備考：仮保存を取得します。
     * @return 備考：仮保存
     */
    public String getNoteTmp() {
        return noteTmp;
    }

    /**
     * 備考：仮保存を設定します。
     * @param noteTmp 備考：仮保存
     */
    public void setNoteTmp(String noteTmp) {
        this.noteTmp = noteTmp;
    }

}
