/*
 * $Id: ShopListingDataParamBean.java 4246 2009-03-23 09:00:00Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/12     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao;

/**
 * 店舗リスティングデータテーブルパラメータ。
 *
 * @author Lee Hosup
 * @version $Revision: 4246 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingDataParamBean {

    /** シーケンス */
    private String shopListingDataSeq;

    /** 店舗コード */
    private String shopCd;

    /** キャッチフレーズ */
    private String catchPhrase;

    /** アピールコメント */
    private String appealComment;

    /** 画像区分 */
    private String picFlg;

    /** クーポンコメント１ */
    private String couponComment1;

    /** クーポンコメント２ */
    private String couponComment2;

    /** クーポンコメント３ */
    private String couponComment3;

    /** 備考 */
    private String note;

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
     * 画像区分を取得します。
     * @return 画像区分
     */
    public String getPicFlg() {
        return picFlg;
    }

    /**
     * 画像区分を設定します。
     * @param picFlg 画像区分
     */
    public void setPicFlg(String picFlg) {
        this.picFlg = picFlg;
    }

    /**
     * クーポンコメント１を取得します。
     * @return クーポンコメント１
     */
    public String getCouponComment1() {
        return couponComment1;
    }

    /**
     * クーポンコメント１を設定します。
     * @param couponComment1 クーポンコメント１
     */
    public void setCouponComment1(String couponComment1) {
        this.couponComment1 = couponComment1;
    }

    /**
     * クーポンコメント２を取得します。
     * @return クーポンコメント２
     */
    public String getCouponComment2() {
        return couponComment2;
    }

    /**
     * クーポンコメント２を設定します。
     * @param couponComment2 クーポンコメント２
     */
    public void setCouponComment2(String couponComment2) {
        this.couponComment2 = couponComment2;
    }

    /**
     * クーポンコメント３を取得します。
     * @return クーポンコメント３
     */
    public String getCouponComment3() {
        return couponComment3;
    }

    /**
     * クーポンコメント３を設定します。
     * @param couponComment3 クーポンコメント３
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
