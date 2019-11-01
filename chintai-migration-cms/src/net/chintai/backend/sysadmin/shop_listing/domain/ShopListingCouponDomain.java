/*
 * $Id: ShopListingCouponDomain.java 4246 2009-03-23 09:00:00Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/05     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.domain;

/**
 * 店舗リスティングクーポンテーブルの情報を格納。
 *
 * @author Lee Hosup
 * @version $Revision: 4246 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingCouponDomain {

    /** シーケンス番号 */
    private String shopListingCouponSeq;

    /** 店舗コード */
    private String shopCd;

    /** ソート順 */
    private String sortKey;

    /** クーポン利用対象 */
    private String couponRiyouTaisyo;

    /** クーポン特典 */
    private String couponTokuten;

    /** クーポン条件 */
    private String couponJouken;

    /** クーポン開始年月日 */
    private String couponStartYmd;

    /** クーポン終了年月日 */
    private String couponEndYmd;

    /** 削除区分 */
    private String delKbn;

    /** 登録プログラム */
    private String insPg;

    /** 登録者ID */
    private String insId;

    /** 更新プログラム */
    private String updPg;

    /** 更新者ID */
    private String updId;

    /** 最終更新日時 */
    private String updDt;

    /**
     * シーケンス番号を取得します。
     * @return シーケンス番号
     */
    public String getShopListingCouponSeq() {
        return shopListingCouponSeq;
    }

    /**
     * シーケンス番号を設定します。
     * @param shopListingCouponSeq シーケンス番号
     */
    public void setShopListingCouponSeq(String shopListingCouponSeq) {
        this.shopListingCouponSeq = shopListingCouponSeq;
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
     * ソート順を取得します。
     * @return ソート順
     */
    public String getSortKey() {
        return sortKey;
    }

    /**
     * ソート順を設定します。
     * @param sortKey ソート順
     */
    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    /**
     * クーポン利用対象を取得します。
     * @return クーポン利用対象
     */
    public String getCouponRiyouTaisyo() {
        return couponRiyouTaisyo;
    }

    /**
     * クーポン利用対象を設定します。
     * @param couponRiyouTaisyo クーポン利用対象
     */
    public void setCouponRiyouTaisyo(String couponRiyouTaisyo) {
        this.couponRiyouTaisyo = couponRiyouTaisyo;
    }

    /**
     * クーポン特典を取得します。
     * @return クーポン特典
     */
    public String getCouponTokuten() {
        return couponTokuten;
    }

    /**
     * クーポン特典を設定します。
     * @param couponTokuten クーポン特典
     */
    public void setCouponTokuten(String couponTokuten) {
        this.couponTokuten = couponTokuten;
    }

    /**
     * クーポン条件を取得します。
     * @return クーポン条件
     */
    public String getCouponJouken() {
        return couponJouken;
    }

    /**
     * クーポン条件を設定します。
     * @param couponJouken クーポン条件
     */
    public void setCouponJouken(String couponJouken) {
        this.couponJouken = couponJouken;
    }

    /**
     * クーポン開始年月日を取得します。
     * @return クーポン開始年月日
     */
    public String getCouponStartYmd() {
        return couponStartYmd;
    }

    /**
     * クーポン開始年月日を設定します。
     * @param couponStartYmd クーポン開始年月日
     */
    public void setCouponStartYmd(String couponStartYmd) {
        this.couponStartYmd = couponStartYmd;
    }

    /**
     * クーポン終了年月日を取得します。
     * @return クーポン終了年月日
     */
    public String getCouponEndYmd() {
        return couponEndYmd;
    }

    /**
     * クーポン終了年月日を設定します。
     * @param couponEndYmd クーポン終了年月日
     */
    public void setCouponEndYmd(String couponEndYmd) {
        this.couponEndYmd = couponEndYmd;
    }

    /**
     * 削除区分を取得します。
     * @return 削除区分
     */
    public String getDelKbn() {
        return delKbn;
    }

    /**
     * 削除区分を設定します。
     * @param delKbn 削除区分
     */
    public void setDelKbn(String delKbn) {
        this.delKbn = delKbn;
    }

    /**
     * 登録プログラムを取得します。
     * @return 登録プログラム
     */
    public String getInsPg() {
        return insPg;
    }

    /**
     * 登録プログラムを設定します。
     * @param insPg 登録プログラム
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
     * 更新プログラムを取得します。
     * @return 更新プログラム
     */
    public String getUpdPg() {
        return updPg;
    }

    /**
     * 更新プログラムを設定します。
     * @param updPg 更新プログラム
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
     * 最終更新日時を取得します。
     * @return 最終更新日時
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 最終更新日時を設定します。
     * @param updDt 最終更新日時
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

}
