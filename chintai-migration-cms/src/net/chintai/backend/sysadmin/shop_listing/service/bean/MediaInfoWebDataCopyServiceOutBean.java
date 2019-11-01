/*
 * $Id: MediaInfoWebDataCopyServiceOutBean.java 4330 2009-08-04 02:22:29Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/12  BGT)李昊燮     新規作成
 * 2009/08/03  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_listing.service.bean;

import java.util.List;

/**
 * 出稿情報更新画面初期表示データを格納
 *
 * @author Lee Hosup
 * @version $Revision: 4330 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MediaInfoWebDataCopyServiceOutBean {

    /** Web表示中出稿情報データの件数 */
    private int webDisplayCnt;

    /** シーケンス */
    private String shopListingDataSeq;

    /** 店舗コード */
    private String shopCd;

    /** Web表示フラグ */
    private String webUpFlg;

    /** 出稿対象駅上限数 */
    private String ekiCnt;

    /** 出稿対象市区町村上限数 */
    private String cityCnt;

    /** キャッチフレーズ */
    private String catchPhrase;

    /** アピールコメント */
    private String appealComment;

    /** 店舗写真フラグ */
    private String picFlg;

    /** 店舗画像(右側) */
    private String shopImgRight;

    /** 店舗画像(左側) */
    private String shopImgLeft;

    /** clientSystemType */
    private String clientSystemType;

    /** クーポン注釈１ */
    private String couponComment1;

    /** クーポン注釈２ */
    private String couponComment2;

    /** クーポン注釈３ */
    private String couponComment3;

    /** 備考 */
    private String note;

    /** 出稿駅情報リスト */
    private List<OptionTagBean> medaiInfoEkiList;

    /** 出稿市区町村情報リスト */
    private List<OptionTagBean> medaiInfoCityList;

    /** アピールアイコン情報リスト */
    private List<ShopListingIconBean> detailList;

    /** 市区町村選択値:code */
    private String selectCityValue;

    /** 駅選択値:code */
    private String selectEkiValue;

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
     * シーケンスを取得します。
     * @return シーケンス
     */
    public String getShopListingDataSeq() {
        return shopListingDataSeq;
    }

    /**
     * シーケンスを設定します。
     * @param shopListingDataSeq シーケンス
     */
    public void setShopListingDataSeq(String shopListingDataSeq) {
        this.shopListingDataSeq = shopListingDataSeq;
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
     * Web表示フラグを取得します。
     * @return Web表示フラグ
     */
    public String getWebUpFlg() {
        return webUpFlg;
    }

    /**
     * Web表示フラグを設定します。
     * @param webUpFlg Web表示フラグ
     */
    public void setWebUpFlg(String webUpFlg) {
        this.webUpFlg = webUpFlg;
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
     * 店舗写真フラグを取得します。
     * @return 店舗写真フラグ
     */
    public String getPicFlg() {
        return picFlg;
    }

    /**
     * 店舗写真フラグを設定します。
     * @param picFlg 店舗写真フラグ
     */
    public void setPicFlg(String picFlg) {
        this.picFlg = picFlg;
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
     * クーポン注釈１を取得します。
     * @return クーポン注釈１
     */
    public String getCouponComment1() {
        return couponComment1;
    }

    /**
     * クーポン注釈１を設定します。
     * @param couponComment1 クーポン注釈１
     */
    public void setCouponComment1(String couponComment1) {
        this.couponComment1 = couponComment1;
    }

    /**
     * クーポン注釈２を取得します。
     * @return クーポン注釈２
     */
    public String getCouponComment2() {
        return couponComment2;
    }

    /**
     * クーポン注釈２を設定します。
     * @param couponComment2 クーポン注釈２
     */
    public void setCouponComment2(String couponComment2) {
        this.couponComment2 = couponComment2;
    }

    /**
     * クーポン注釈３を取得します。
     * @return クーポン注釈３
     */
    public String getCouponComment3() {
        return couponComment3;
    }

    /**
     * クーポン注釈３を設定します。
     * @param couponComment3 クーポン注釈３
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
     * 出稿駅情報リストを取得します。
     * @return 出稿駅情報リスト
     */
    public List<OptionTagBean> getMedaiInfoEkiList() {
        return medaiInfoEkiList;
    }

    /**
     * 出稿駅情報リストを設定します。
     * @param medaiInfoEkiList 出稿駅情報リスト
     */
    public void setMedaiInfoEkiList(List<OptionTagBean> medaiInfoEkiList) {
        this.medaiInfoEkiList = medaiInfoEkiList;
    }

    /**
     * 出稿市区町村情報リストを取得します。
     * @return 出稿市区町村情報リスト
     */
    public List<OptionTagBean> getMedaiInfoCityList() {
        return medaiInfoCityList;
    }

    /**
     * 出稿市区町村情報リストを設定します。
     * @param medaiInfoCityList 出稿市区町村情報リスト
     */
    public void setMedaiInfoCityList(List<OptionTagBean> medaiInfoCityList) {
        this.medaiInfoCityList = medaiInfoCityList;
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

    /**
     * 市区町村選択値:codeを取得します。
     * @return 市区町村選択値:code
     */
    public String getSelectCityValue() {
        return selectCityValue;
    }

    /**
     * 市区町村選択値:codeを設定します。
     * @param selectCityValue 市区町村選択値:code
     */
    public void setSelectCityValue(String selectCityValue) {
        this.selectCityValue = selectCityValue;
    }

    /**
     * 駅選択値:codeを取得します。
     * @return 駅選択値:code
     */
    public String getSelectEkiValue() {
        return selectEkiValue;
    }

    /**
     * 駅選択値:codeを設定します。
     * @param selectEkiValue 駅選択値:code
     */
    public void setSelectEkiValue(String selectEkiValue) {
        this.selectEkiValue = selectEkiValue;
    }

}
