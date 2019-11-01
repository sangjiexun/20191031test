/*
 * $Id: KeiyakuRegisterView.java 4282 2009-07-06 12:17:41Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/24  BGT)李昊燮     新規作成
 * 2009/07/06  BGT)李昊燮     エイブルリニューアル検討支援対応
 */
package net.chintai.backend.sysadmin.shop_listing.action.view;

/**
 * 契約情報登録ViewHelper
 *
 * @author Lee Hosup
 * @version $Revision: 4282 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class KeiyakuRegisterView extends ShopBasicInfoView {

    /** 契約種別 */
    private String keiyakuShubetsu;

    /** 基本契約フラグ */
    private String kihonKeiyakuFlg;

    /** 基本契約期間：開始年 */
    private String keiyakuStartYear;

    /** 基本契約期間：開始月 */
    private String keiyakuStartMonth;

    /** 基本契約期間：開始年月 */
    private String keiyakuStartYm;

    /** 基本契約期間：終了年 */
    private String keiyakuEndYear;

    /** 基本契約期間：終了月 */
    private String keiyakuEndMonth;

    /** 基本契約期間：終了年月 */
    private String keiyakuEndYm;

    /** クーポン契約フラグ */
    private String couponKeiyakuFlg;

    /** クーポン発行：開始年 */
    private String couponStartYear;

    /** クーポン発行：開始年月 */
    private String couponStartYm;

    /** クーポン発行：開始月 */
    private String couponStartMonth;

    /** クーポン発行：終了年 */
    private String couponEndYear;

    /** クーポン発行：終了年月 */
    private String couponEndYm;

    /** クーポン発行：終了月 */
    private String couponEndMonth;

    /** 外部リンク契約フラグ */
    private String linkKeiyakuFlg;

    /** 外部リンク表示：開始年 */
    private String linkStartYear;

    /** 外部リンク表示：開始月 */
    private String linkStartMonth;

    /** 外部リンク表示：開始年月 */
    private String linkStartYm;

    /** 外部リンク表示：開始年 */
    private String linkEndYear;

    /** 外部リンク表示：開始月 */
    private String linkEndMonth;

    /** 外部リンク表示：開始年月 */
    private String linkEndYm;

    /** 現在日付 */
    private String today;

    /** 備考 */
    private String note;

    /** 出稿対象駅上限数 */
    private String ekiCnt;

    /** 出稿対象市区町村上限数 */
    private String cityCnt;

    /** 最終更新日 */
    private String updDt;

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
     * 基本契約期間：開始年を取得します。
     * @return 基本契約期間：開始年
     */
    public String getKeiyakuStartYear() {
        return keiyakuStartYear;
    }

    /**
     * 基本契約期間：開始年を設定します。
     * @param keiyakuStartYear 基本契約期間：開始年
     */
    public void setKeiyakuStartYear(String keiyakuStartYear) {
        this.keiyakuStartYear = keiyakuStartYear;
    }

    /**
     * 基本契約期間：開始月を取得します。
     * @return 基本契約期間：開始月
     */
    public String getKeiyakuStartMonth() {
        return keiyakuStartMonth;
    }

    /**
     * 基本契約期間：開始月を設定します。
     * @param keiyakuStartMonth 基本契約期間：開始月
     */
    public void setKeiyakuStartMonth(String keiyakuStartMonth) {
        this.keiyakuStartMonth = keiyakuStartMonth;
    }

    /**
     * 基本契約期間：開始年月を取得します。
     * @return 基本契約期間：開始年月
     */
    public String getKeiyakuStartYm() {
        return keiyakuStartYm;
    }

    /**
     * 基本契約期間：開始年月を設定します。
     * @param keiyakuStartYm 基本契約期間：開始年月
     */
    public void setKeiyakuStartYm(String keiyakuStartYm) {
        this.keiyakuStartYm = keiyakuStartYm;
    }

    /**
     * 基本契約期間：終了年を取得します。
     * @return 基本契約期間：終了年
     */
    public String getKeiyakuEndYear() {
        return keiyakuEndYear;
    }

    /**
     * 基本契約期間：終了年を設定します。
     * @param keiyakuEndYear 基本契約期間：終了年
     */
    public void setKeiyakuEndYear(String keiyakuEndYear) {
        this.keiyakuEndYear = keiyakuEndYear;
    }

    /**
     * 基本契約期間：終了月を取得します。
     * @return 基本契約期間：終了月
     */
    public String getKeiyakuEndMonth() {
        return keiyakuEndMonth;
    }

    /**
     * 基本契約期間：終了月を設定します。
     * @param keiyakuEndMonth 基本契約期間：終了月
     */
    public void setKeiyakuEndMonth(String keiyakuEndMonth) {
        this.keiyakuEndMonth = keiyakuEndMonth;
    }

    /**
     * 基本契約期間：終了年月を取得します。
     * @return 基本契約期間：終了年月
     */
    public String getKeiyakuEndYm() {
        return keiyakuEndYm;
    }

    /**
     * 基本契約期間：終了年月を設定します。
     * @param keiyakuEndYm 基本契約期間：終了年月
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
     * クーポン発行：開始年を取得します。
     * @return クーポン発行：開始年
     */
    public String getCouponStartYear() {
        return couponStartYear;
    }

    /**
     * クーポン発行：開始年を設定します。
     * @param couponStartYear クーポン発行：開始年
     */
    public void setCouponStartYear(String couponStartYear) {
        this.couponStartYear = couponStartYear;
    }

    /**
     * クーポン発行：開始年月を取得します。
     * @return クーポン発行：開始年月
     */
    public String getCouponStartYm() {
        return couponStartYm;
    }

    /**
     * クーポン発行：開始年月を設定します。
     * @param couponStartYm クーポン発行：開始年月
     */
    public void setCouponStartYm(String couponStartYm) {
        this.couponStartYm = couponStartYm;
    }

    /**
     * クーポン発行：開始月を取得します。
     * @return クーポン発行：開始月
     */
    public String getCouponStartMonth() {
        return couponStartMonth;
    }

    /**
     * クーポン発行：開始月を設定します。
     * @param couponStartMonth クーポン発行：開始月
     */
    public void setCouponStartMonth(String couponStartMonth) {
        this.couponStartMonth = couponStartMonth;
    }

    /**
     * クーポン発行：終了年を取得します。
     * @return クーポン発行：終了年
     */
    public String getCouponEndYear() {
        return couponEndYear;
    }

    /**
     * クーポン発行：終了年を設定します。
     * @param couponEndYear クーポン発行：終了年
     */
    public void setCouponEndYear(String couponEndYear) {
        this.couponEndYear = couponEndYear;
    }

    /**
     * クーポン発行：終了年月を取得します。
     * @return クーポン発行：終了年月
     */
    public String getCouponEndYm() {
        return couponEndYm;
    }

    /**
     * クーポン発行：終了年月を設定します。
     * @param couponEndYm クーポン発行：終了年月
     */
    public void setCouponEndYm(String couponEndYm) {
        this.couponEndYm = couponEndYm;
    }

    /**
     * クーポン発行：終了月を取得します。
     * @return クーポン発行：終了月
     */
    public String getCouponEndMonth() {
        return couponEndMonth;
    }

    /**
     * クーポン発行：終了月を設定します。
     * @param couponEndMonth クーポン発行：終了月
     */
    public void setCouponEndMonth(String couponEndMonth) {
        this.couponEndMonth = couponEndMonth;
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
     * 外部リンク表示：開始年を取得します。
     * @return 外部リンク表示：開始年
     */
    public String getLinkStartYear() {
        return linkStartYear;
    }

    /**
     * 外部リンク表示：開始年を設定します。
     * @param linkStartYear 外部リンク表示：開始年
     */
    public void setLinkStartYear(String linkStartYear) {
        this.linkStartYear = linkStartYear;
    }

    /**
     * 外部リンク表示：開始月を取得します。
     * @return 外部リンク表示：開始月
     */
    public String getLinkStartMonth() {
        return linkStartMonth;
    }

    /**
     * 外部リンク表示：開始月を設定します。
     * @param linkStartMonth 外部リンク表示：開始月
     */
    public void setLinkStartMonth(String linkStartMonth) {
        this.linkStartMonth = linkStartMonth;
    }

    /**
     * 外部リンク表示：開始年月を取得します。
     * @return 外部リンク表示：開始年月
     */
    public String getLinkStartYm() {
        return linkStartYm;
    }

    /**
     * 外部リンク表示：開始年月を設定します。
     * @param linkStartYm 外部リンク表示：開始年月
     */
    public void setLinkStartYm(String linkStartYm) {
        this.linkStartYm = linkStartYm;
    }

    /**
     * 外部リンク表示：開始年を取得します。
     * @return 外部リンク表示：開始年
     */
    public String getLinkEndYear() {
        return linkEndYear;
    }

    /**
     * 外部リンク表示：開始年を設定します。
     * @param linkEndYear 外部リンク表示：開始年
     */
    public void setLinkEndYear(String linkEndYear) {
        this.linkEndYear = linkEndYear;
    }

    /**
     * 外部リンク表示：開始月を取得します。
     * @return 外部リンク表示：開始月
     */
    public String getLinkEndMonth() {
        return linkEndMonth;
    }

    /**
     * 外部リンク表示：開始月を設定します。
     * @param linkEndMonth 外部リンク表示：開始月
     */
    public void setLinkEndMonth(String linkEndMonth) {
        this.linkEndMonth = linkEndMonth;
    }

    /**
     * 外部リンク表示：開始年月を取得します。
     * @return 外部リンク表示：開始年月
     */
    public String getLinkEndYm() {
        return linkEndYm;
    }

    /**
     * 外部リンク表示：開始年月を設定します。
     * @param linkEndYm 外部リンク表示：開始年月
     */
    public void setLinkEndYm(String linkEndYm) {
        this.linkEndYm = linkEndYm;
    }

    /**
     * 現在日付を取得します。
     * @return 現在日付
     */
    public String getToday() {
        return today;
    }

    /**
     * 現在日付を設定します。
     * @param today 現在日付
     */
    public void setToday(String today) {
        this.today = today;
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
