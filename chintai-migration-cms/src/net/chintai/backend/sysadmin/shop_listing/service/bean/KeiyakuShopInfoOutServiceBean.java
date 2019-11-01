/*
 * $Id: KeiyakuShopInfoOutServiceBean.java 4406 2009-10-14 01:56:40Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/23  BGT)李昊燮     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_listing.service.bean;

/**
 * 契約店舗詳細画面
 *
 * @author Lee Hosup
 * @version $Revision: 4406 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class KeiyakuShopInfoOutServiceBean {

    /** 店舗リスティングSEQ */
    private String pkShopListingSeq;

    /** 契約種別 */
    private String keiyakuShubetsu;

    /** 基本契約フラグ */
    private String kihonKeiyakuFlg;

    /** 基本契約開始日 */
    private String keiyakuStartYm;

    /** 基本契約終了日 */
    private String keiyakuEndYm;

    /** クーポン契約フラグ */
    private String couponKeiyakuFlg;

    /** クーポン契約開始日 */
    private String couponStartYm;

    /** クーポン契約終了日 */
    private String couponEndYm;

    /** リンク契約フラグ */
    private String linkKeiyakuFlg;

    /** 外部リンク契約開始日 */
    private String linkStartYm;

    /** 外部リンク契約開始日 */
    private String linkEndYm;

    /** 備考 */
    private String note;

    /** 最終更新日 */
    private String updDt;

    /** リンク表示フラグ */
    private String linkFlg;

    /** 契約中フラグ */
    private String keiyakuChuuFlg;

    /**
     * 店舗リスティングSEQを取得します。
     * @return 店舗リスティングSEQ
     */
    public String getPkShopListingSeq() {
        return pkShopListingSeq;
    }

    /**
     * 店舗リスティングSEQを設定します。
     * @param pkShopListingSeq 店舗リスティングSEQ
     */
    public void setPkShopListingSeq(String pkShopListingSeq) {
        this.pkShopListingSeq = pkShopListingSeq;
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
     * 基本契約開始日を取得します。
     * @return 基本契約開始日
     */
    public String getKeiyakuStartYm() {
        return keiyakuStartYm;
    }

    /**
     * 基本契約開始日を設定します。
     * @param keiyakuStartYm 基本契約開始日
     */
    public void setKeiyakuStartYm(String keiyakuStartYm) {
        this.keiyakuStartYm = keiyakuStartYm;
    }

    /**
     * 基本契約終了日を取得します。
     * @return 基本契約終了日
     */
    public String getKeiyakuEndYm() {
        return keiyakuEndYm;
    }

    /**
     * 基本契約終了日を設定します。
     * @param keiyakuEndYm 基本契約終了日
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
     * クーポン契約開始日を取得します。
     * @return クーポン契約開始日
     */
    public String getCouponStartYm() {
        return couponStartYm;
    }

    /**
     * クーポン契約開始日を設定します。
     * @param couponStartYm クーポン契約開始日
     */
    public void setCouponStartYm(String couponStartYm) {
        this.couponStartYm = couponStartYm;
    }

    /**
     * クーポン契約終了日を取得します。
     * @return クーポン契約終了日
     */
    public String getCouponEndYm() {
        return couponEndYm;
    }

    /**
     * クーポン契約終了日を設定します。
     * @param couponEndYm クーポン契約終了日
     */
    public void setCouponEndYm(String couponEndYm) {
        this.couponEndYm = couponEndYm;
    }

    /**
     * リンク契約フラグを取得します。
     * @return リンク契約フラグ
     */
    public String getLinkKeiyakuFlg() {
        return linkKeiyakuFlg;
    }

    /**
     * リンク契約フラグを設定します。
     * @param linkKeiyakuFlg リンク契約フラグ
     */
    public void setLinkKeiyakuFlg(String linkKeiyakuFlg) {
        this.linkKeiyakuFlg = linkKeiyakuFlg;
    }

    /**
     * 外部リンク契約開始日を取得します。
     * @return 外部リンク契約開始日
     */
    public String getLinkStartYm() {
        return linkStartYm;
    }

    /**
     * 外部リンク契約開始日を設定します。
     * @param linkStartYm 外部リンク契約開始日
     */
    public void setLinkStartYm(String linkStartYm) {
        this.linkStartYm = linkStartYm;
    }

    /**
     * 外部リンク契約開始日を取得します。
     * @return 外部リンク契約開始日
     */
    public String getLinkEndYm() {
        return linkEndYm;
    }

    /**
     * 外部リンク契約開始日を設定します。
     * @param linkEndYm 外部リンク契約開始日
     */
    public void setLinkEndYm(String linkEndYm) {
        this.linkEndYm = linkEndYm;
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

    /**
     * 契約中フラグを取得します。
     * @return 契約中フラグ
     */
    public String getKeiyakuChuuFlg() {
        return keiyakuChuuFlg;
    }

    /**
     * 契約中フラグを設定します。
     * @param keiyakuChuuFlg 契約中フラグ
     */
    public void setKeiyakuChuuFlg(String keiyakuChuuFlg) {
        this.keiyakuChuuFlg = keiyakuChuuFlg;
    }

    /**
     * リンク表示フラグを取得します。
     * @return リンク表示フラグ
     */
    public String getLinkFlg() {
        return linkFlg;
    }

    /**
     * リンク表示フラグを設定します。
     * @param linkFlg リンク表示フラグ
     */
    public void setLinkFlg(String linkFlg) {
        this.linkFlg = linkFlg;
    }
}
