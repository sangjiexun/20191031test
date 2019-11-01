/*
 * $Id: MediaInfoRegisterPageOutServiceBean.java 4324 2009-08-03 04:13:24Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/03  BGT)李昊燮     新規作成
 * 2009/08/03  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_listing.service.bean;

import java.util.List;

/**
 * 出稿情報登録画面表示情報を格納。
 *
 * @author Lee Hosup
 * @version $Revision: 4324 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MediaInfoRegisterPageOutServiceBean {

    /** Web表示中出稿情報データの件数 */
    private int webDisplayCnt;

    /** 出稿対象駅上限数 */
    private String ekiCnt;

    /** 出稿対象市区町村上限数 */
    private String cityCnt;

    /** エリア(駅指定) */
    private String areaCd;

    /** 沿線タイプ */
    private String ensenTypeCd;

    /** 沿線 */
    private String ensenCd;

    /** 駅 */
    private String ekiCd;

    /** エリア(市区町村指定) */
    private String cityAreaCd;

    /** 都道府県 */
    private String prefCd;

    /** 市区町村 */
    private String cityCd;

    /** キャッチフレーズ */
    private String catchPhrase;

    /** アピールコメント */
    private String appealComment;

    /** 店舗画像(右側) */
    private String shopImgRight;

    /** 店舗画像(左側) */
    private String shopImgLeft;

    /** clientSystemType */
    private String clientSystemType;

    /** 画像区分 */
    private String picKbn;

    /** 注釈1 */
    private String couponComment1;

    /** 注釈2 */
    private String couponComment2;

    /** 注釈3 */
    private String couponComment3;

    /** 備考 */
    private String note;

    /** アピールアイコン情報リスト */
    private List<ShopListingIconBean> detailList;

    /**
     * Web表示中出稿情報データの件数を取得します。
     * @return Web表示中出稿情報データの件数
     */
    public int getWebDisplayCnt() {
        return webDisplayCnt;
    }

    /**
     * Web表示中出稿情報データの件数を設定します。
     * @param webDisplayCnt Web表示中出稿情報データの件数
     */
    public void setWebDisplayCnt(int webDisplayCnt) {
        this.webDisplayCnt = webDisplayCnt;
    }

    /**
     * 出稿対象駅上限数を取得します。
     * @return 出稿対象駅上限数
     */
    public String getEkiCnt() {
        return ekiCnt;
    }

    /**
     * 出稿対象駅上限数を設定します。
     * @param ekiCnt 出稿対象駅上限数
     */
    public void setEkiCnt(String ekiCnt) {
        this.ekiCnt = ekiCnt;
    }

    /**
     * 出稿対象市区町村上限数を取得します。
     * @return 出稿対象市区町村上限数
     */
    public String getCityCnt() {
        return cityCnt;
    }

    /**
     * 出稿対象市区町村上限数を設定します。
     * @param cityCnt 出稿対象市区町村上限数
     */
    public void setCityCnt(String cityCnt) {
        this.cityCnt = cityCnt;
    }

    /**
     * エリア(駅指定)を取得します。
     * @return エリア(駅指定)
     */
    public String getAreaCd() {
        return areaCd;
    }

    /**
     * エリア(駅指定)を設定します。
     * @param areaCd エリア(駅指定)
     */
    public void setAreaCd(String areaCd) {
        this.areaCd = areaCd;
    }

    /**
     * 沿線タイプを取得します。
     * @return 沿線タイプ
     */
    public String getEnsenTypeCd() {
        return ensenTypeCd;
    }

    /**
     * 沿線タイプを設定します。
     * @param ensenTypeCd 沿線タイプ
     */
    public void setEnsenTypeCd(String ensenTypeCd) {
        this.ensenTypeCd = ensenTypeCd;
    }

    /**
     * 沿線を取得します。
     * @return 沿線
     */
    public String getEnsenCd() {
        return ensenCd;
    }

    /**
     * 沿線を設定します。
     * @param ensenCd 沿線
     */
    public void setEnsenCd(String ensenCd) {
        this.ensenCd = ensenCd;
    }

    /**
     * 駅を取得します。
     * @return 駅
     */
    public String getEkiCd() {
        return ekiCd;
    }

    /**
     * 駅を設定します。
     * @param ekiCd 駅
     */
    public void setEkiCd(String ekiCd) {
        this.ekiCd = ekiCd;
    }

    /**
     * エリア(市区町村指定)を取得します。
     * @return エリア(市区町村指定)
     */
    public String getCityAreaCd() {
        return cityAreaCd;
    }

    /**
     * エリア(市区町村指定)を設定します。
     * @param cityAreaCd エリア(市区町村指定)
     */
    public void setCityAreaCd(String cityAreaCd) {
        this.cityAreaCd = cityAreaCd;
    }

    /**
     * 都道府県を取得します。
     * @return 都道府県
     */
    public String getPrefCd() {
        return prefCd;
    }

    /**
     * 都道府県を設定します。
     * @param prefCd 都道府県
     */
    public void setPrefCd(String prefCd) {
        this.prefCd = prefCd;
    }

    /**
     * 市区町村を取得します。
     * @return 市区町村
     */
    public String getCityCd() {
        return cityCd;
    }

    /**
     * 市区町村を設定します。
     * @param cityCd 市区町村
     */
    public void setCityCd(String cityCd) {
        this.cityCd = cityCd;
    }

    /**
     * キャッチフレーズを取得します。
     * @return キャッチフレーズ
     */
    public String getCatchPhrase() {
        return catchPhrase;
    }

    /**
     * キャッチフレーズを設定します。
     * @param catchPhrase キャッチフレーズ
     */
    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    /**
     * アピールコメントを取得します。
     * @return アピールコメント
     */
    public String getAppealComment() {
        return appealComment;
    }

    /**
     * アピールコメントを設定します。
     * @param appealComment アピールコメント
     */
    public void setAppealComment(String appealComment) {
        this.appealComment = appealComment;
    }

    /**
     * 店舗画像(右側)を取得します。
     * @return 店舗画像(右側)
     */
    public String getShopImgRight() {
        return shopImgRight;
    }

    /**
     * 店舗画像(右側)を設定します。
     * @param shopImgRight 店舗画像(右側)
     */
    public void setShopImgRight(String shopImgRight) {
        this.shopImgRight = shopImgRight;
    }

    /**
     * 店舗画像(左側)を取得します。
     * @return 店舗画像(左側)
     */
    public String getShopImgLeft() {
        return shopImgLeft;
    }

    /**
     * 店舗画像(左側)を設定します。
     * @param shopImgLeft 店舗画像(左側)
     */
    public void setShopImgLeft(String shopImgLeft) {
        this.shopImgLeft = shopImgLeft;
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
     * 画像区分を取得します。
     * @return 画像区分
     */
    public String getPicKbn() {
        return picKbn;
    }

    /**
     * 画像区分を設定します。
     * @param picKbn 画像区分
     */
    public void setPicKbn(String picKbn) {
        this.picKbn = picKbn;
    }

    /**
     * 注釈1を取得します。
     * @return 注釈1
     */
    public String getCouponComment1() {
        return couponComment1;
    }

    /**
     * 注釈1を設定します。
     * @param couponComment1 注釈1
     */
    public void setCouponComment1(String couponComment1) {
        this.couponComment1 = couponComment1;
    }

    /**
     * 注釈2を取得します。
     * @return 注釈2
     */
    public String getCouponComment2() {
        return couponComment2;
    }

    /**
     * 注釈2を設定します。
     * @param couponComment2 注釈2
     */
    public void setCouponComment2(String couponComment2) {
        this.couponComment2 = couponComment2;
    }

    /**
     * 注釈3を取得します。
     * @return 注釈3
     */
    public String getCouponComment3() {
        return couponComment3;
    }

    /**
     * 注釈3を設定します。
     * @param couponComment3 注釈3
     */
    public void setCouponComment3(String couponComment3) {
        this.couponComment3 = couponComment3;
    }

    /**
     * 備考を取得します。
     * @return 備考
     */
    public String getNote() {
        return note;
    }

    /**
     * 備考を設定します。
     * @param note 備考
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * アピールアイコン情報リストを取得します。
     * @return アピールアイコン情報リスト
     */
    public List<ShopListingIconBean> getDetailList() {
        return detailList;
    }

    /**
     * アピールアイコン情報リストを設定します。
     * @param detailList アピールアイコン情報リスト
     */
    public void setDetailList(List<ShopListingIconBean> detailList) {
        this.detailList = detailList;
    }

}
