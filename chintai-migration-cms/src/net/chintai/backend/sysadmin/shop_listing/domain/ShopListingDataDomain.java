/*
 * $Id: ShopListingDataDomain.java 4246 2009-03-23 09:00:00Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/13     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.domain;

/**
 * 店舗リスティングデータテーブルDomain。
 *
 * @author Lee Hosup
 * @version $Revision: 4246 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingDataDomain {

    /** シーケンス */
    private String shopListingDataSeq;

    /** 店舗コード */
    private String shopCd;

    /** Web表示フラグ */
    private String webUpFlg;

    /** キャッチフレーズ */
    private String catchPhrase;

    /** アピールコメント */
    private String appealComment;

    /** 店舗写真フラグ */
    private String picFlg;

    /** クーポン注釈１ */
    private String couponComment1;

    /** クーポン注釈２ */
    private String couponComment2;

    /** クーポン注釈３ */
    private String couponComment3;

    /** 備考 */
    private String note;

    /** 最終更新日 */
    private String updDt;

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
