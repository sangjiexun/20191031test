/*
 * $Id: KeiyakuShopSearchOutServiceBean.java 4284 2009-07-06 12:25:15Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/19  BGT)李昊燮     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_listing.service.bean;

import java.util.Date;

/**
 * 契約店舗検索結果を保持します。
 *
 * @author Lee Hosup
 * @version $Revision: 4284 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class KeiyakuShopSearchOutServiceBean {

    /** 店舗コード */
    private String shopCd;

    /** 契約種別 */
    private String keiyakuShubetsu;

    /** 店舗ステータス */
    private String shopStatus;

    /** CHINTAIステータス */
    // 2008/07 李昊燮 エイブルリニューアル対応でコメント処理
    //private String ctStatus;

    /** 会社名 */
    private String company;

    /** 部門名 */
    private String bumon;

    /** 基本契約フラグ */
    private String kihonKeiyakuFlg;

    /** 基本契約期間(開始日) */
    private String keiyakuStartYm;

    /** 基本契約期間(終了日) */
    private String keiyakuEndYm;

    /** クーポン契約フラグ */
    private String couponKeiyakuFlg;

    /** クーポン契約期間:開始日 */
    private String couponStartYm;

    /** クーポン契約期間:終了日 */
    private String couponEndYm;

    /** クーポン１の開始日 */
    private Date coupon1StartYmd;

    /** クーポン１の終了日 */
    private Date coupon1EndYmd;

    /** クーポン２の開始日 */
    private Date coupon2StartYmd;

    /** クーポン２の終了日 */
    private Date coupon2EndYmd;

    /** クーポン３の開始日 */
    private Date coupon3StartYmd;

    /** クーポン３の終了日 */
    private Date coupon3EndYmd;

    /** 外部リンク契約フラグ */
    private String linkKeiyakuFlg;

    /** 外部リンクの開始日 */
    private String linkStartYm;

    /** 外部リンクの終了日 */
    private String linkEndYm;

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
     * 契約種別を取得します。
     * @return 契約種別
     */
    public String getKeiyakuShubetsu() {
        return keiyakuShubetsu;
    }

    /**
     * 契約種別を設定します。
     * @param keiyakuShubetsu 契約種別
     */
    public void setKeiyakuShubetsu(String keiyakuShubetsu) {
        this.keiyakuShubetsu = keiyakuShubetsu;
    }

    /**
     * 店舗ステータスを取得します。
     * @return 店舗ステータス
     */
    public String getShopStatus() {
        return shopStatus;
    }

    /**
     * 店舗ステータスを設定します。
     * @param shopStatus 店舗ステータス
     */
    public void setShopStatus(String shopStatus) {
        this.shopStatus = shopStatus;
    }

    /**
     * CHINTAIステータスを取得します。
     * @return CHINTAIステータス
     */
    //public String getCtStatus() {
    //    return ctStatus;
    //}

    /**
     * CHINTAIステータスを設定します。
     * @param ctStatus CHINTAIステータス
     */
    //public void setCtStatus(String ctStatus) {
    //    this.ctStatus = ctStatus;
    //}

    /**
     * 会社名を取得します。
     * @return 会社名
     */
    public String getCompany() {
        return company;
    }

    /**
     * CHINTAIステータスを設定します。
     * @param company CHINTAIステータス
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 部門名を取得します。
     * @return 部門名
     */
    public String getBumon() {
        return bumon;
    }

    /**
     * 部門名を設定します。
     * @param bumon 部門名
     */
    public void setBumon(String bumon) {
        this.bumon = bumon;
    }

    /**
     * 基本契約フラグを取得します。
     * @return 基本契約フラグ
     */
    public String getKihonKeiyakuFlg() {
        return kihonKeiyakuFlg;
    }

    /**
     * 基本契約フラグを設定します。
     * @param kihonKeiyakuFlg 基本契約フラグ
     */
    public void setKihonKeiyakuFlg(String kihonKeiyakuFlg) {
        this.kihonKeiyakuFlg = kihonKeiyakuFlg;
    }

    /**
     * 基本契約期間(開始日)を取得します。
     * @return 基本契約期間(開始日)
     */
    public String getKeiyakuStartYm() {
        return keiyakuStartYm;
    }

    /**
     * 基本契約期間(開始日)を設定します。
     * @param keiyakuStartYm 基本契約期間(開始日)
     */
    public void setKeiyakuStartYm(String keiyakuStartYm) {
        this.keiyakuStartYm = keiyakuStartYm;
    }

    /**
     * 基本契約期間(終了日)を取得します。
     * @return 基本契約期間(終了日)
     */
    public String getKeiyakuEndYm() {
        return keiyakuEndYm;
    }

    /**
     * 基本契約期間(終了日)を設定します。
     * @param keiyakuEndYm 基本契約期間(終了日)
     */
    public void setKeiyakuEndYm(String keiyakuEndYm) {
        this.keiyakuEndYm = keiyakuEndYm;
    }

    /**
     * クーポン契約フラグを取得します。
     * @return クーポン契約フラグ
     */
    public String getCouponKeiyakuFlg() {
        return couponKeiyakuFlg;
    }

    /**
     * クーポン契約フラグを設定します。
     * @param couponKeiyakuFlg クーポン契約フラグ
     */
    public void setCouponKeiyakuFlg(String couponKeiyakuFlg) {
        this.couponKeiyakuFlg = couponKeiyakuFlg;
    }

    /**
     * クーポン契約期間:開始日を取得します。
     * @return クーポン契約期間:開始日
     */
    public String getCouponStartYm() {
        return couponStartYm;
    }

    /**
     * クーポン契約期間:開始日を設定します。
     * @param couponStartYm クーポン契約期間:開始日
     */
    public void setCouponStartYm(String couponStartYm) {
        this.couponStartYm = couponStartYm;
    }

    /**
     * クーポン契約期間:終了日を取得します。
     * @return クーポン契約期間:終了日
     */
    public String getCouponEndYm() {
        return couponEndYm;
    }

    /**
     * クーポン契約期間:終了日を設定します。
     * @param couponEndYm クーポン契約期間:終了日
     */
    public void setCouponEndYm(String couponEndYm) {
        this.couponEndYm = couponEndYm;
    }

    /**
     * クーポン１の開始日を取得します。
     * @return クーポン１の開始日
     */
    public Date getCoupon1StartYmd() {
        return coupon1StartYmd;
    }

    /**
     * クーポン１の開始日を設定します。
     * @param coupon1StartYmd クーポン１の開始日
     */
    public void setCoupon1StartYmd(Date coupon1StartYmd) {
        this.coupon1StartYmd = coupon1StartYmd;
    }

    /**
     * クーポン１の終了日を取得します。
     * @return クーポン１の終了日
     */
    public Date getCoupon1EndYmd() {
        return coupon1EndYmd;
    }

    /**
     * クーポン１の終了日を設定します。
     * @param coupon1EndYmd クーポン１の終了日
     */
    public void setCoupon1EndYmd(Date coupon1EndYmd) {
        this.coupon1EndYmd = coupon1EndYmd;
    }

    /**
     * クーポン２の開始日を取得します。
     * @return クーポン２の開始日
     */
    public Date getCoupon2StartYmd() {
        return coupon2StartYmd;
    }

    /**
     * クーポン２の開始日を設定します。
     * @param coupon2StartYmd クーポン２の開始日
     */
    public void setCoupon2StartYmd(Date coupon2StartYmd) {
        this.coupon2StartYmd = coupon2StartYmd;
    }

    /**
     * クーポン２の終了日を取得します。
     * @return クーポン２の終了日
     */
    public Date getCoupon2EndYmd() {
        return coupon2EndYmd;
    }

    /**
     * クーポン２の終了日を設定します。
     * @param coupon2EndYmd クーポン２の終了日
     */
    public void setCoupon2EndYmd(Date coupon2EndYmd) {
        this.coupon2EndYmd = coupon2EndYmd;
    }

    /**
     * クーポン３の開始日を取得します。
     * @return クーポン３の開始日
     */
    public Date getCoupon3StartYmd() {
        return coupon3StartYmd;
    }

    /**
     * クーポン３の開始日を設定します。
     * @param coupon3StartYmd クーポン３の開始日
     */
    public void setCoupon3StartYmd(Date coupon3StartYmd) {
        this.coupon3StartYmd = coupon3StartYmd;
    }

    /**
     * クーポン３の終了日を取得します。
     * @return クーポン３の終了日
     */
    public Date getCoupon3EndYmd() {
        return coupon3EndYmd;
    }

    /**
     * クーポン３の終了日を設定します。
     * @param coupon3EndYmd クーポン３の終了日
     */
    public void setCoupon3EndYmd(Date coupon3EndYmd) {
        this.coupon3EndYmd = coupon3EndYmd;
    }

    /**
     * 外部リンク契約フラグを取得します。
     * @return 外部リンク契約フラグ
     */
    public String getLinkKeiyakuFlg() {
        return linkKeiyakuFlg;
    }

    /**
     * 外部リンク契約フラグを設定します。
     * @param linkKeiyakuFlg 外部リンク契約フラグ
     */
    public void setLinkKeiyakuFlg(String linkKeiyakuFlg) {
        this.linkKeiyakuFlg = linkKeiyakuFlg;
    }

    /**
     * 外部リンクの開始日を取得します。
     * @return 外部リンクの開始日
     */
    public String getLinkStartYm() {
        return linkStartYm;
    }

    /**
     * 外部リンクの開始日を設定します。
     * @param linkStartYm 外部リンクの開始日
     */
    public void setLinkStartYm(String linkStartYm) {
        this.linkStartYm = linkStartYm;
    }

    /**
     * 外部リンクの終了日を取得します。
     * @return 外部リンクの終了日
     */
    public String getLinkEndYm() {
        return linkEndYm;
    }

    /**
     * 外部リンクの終了日を設定します。
     * @param linkEndYm 外部リンクの終了日
     */
    public void setLinkEndYm(String linkEndYm) {
        this.linkEndYm = linkEndYm;
    }

}
