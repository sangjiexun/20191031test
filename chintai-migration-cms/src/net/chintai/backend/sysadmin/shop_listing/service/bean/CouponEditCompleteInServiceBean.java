/*
 * $Id: CouponEditCompleteInServiceBean.java 4247 2009-03-23 09:15:01Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/05     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service.bean;

/**
 * クーポン情報登録用
 *
 * @author Lee Hosup
 * @version $Revision: 4247 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CouponEditCompleteInServiceBean {

    /** 店舗コード */
    private String shopCd;

    /** クーポン情報Seq */
    private String[] couponSeqs;

    /** 開始年配列 */
    private String[] startYears;

    /** 開始月配列 */
    private String[] startMonths;

    /** 開始日配列 */
    private String[] startDays;

    /** 終了年配列 */
    private String[] endYears;

    /** 終了月配列 */
    private String[] endMonths;

    /** 終了日配列 */
    private String[] endDays;

    /** 利用対象：プルダウン選択値 */
    private String[] riyouTaisyo;

    /** 利用対象：手入力値 */
    private String[] riyouTaisyoCustom;

    /** 利用対象：タイプ */
    private String[] riyouTaisyoType;

    /** 特典：プルダウン選択値 */
    private String[] tokuten;

    /** 特典：手入力値 */
    private String[] tokutenCustom;

    /** 特典：タイプ */
    private String[] tokutenType;

    /** 提示条件：プルダウン選択値 */
    private String[] jouken;

    /** 提示条件：手入力値 */
    private String[] joukenCustom;

    /** 提示条件：タイプ */
    private String[] joukenType;

    /** 表示順配列 */
    private String[] sortKeys;

    /** 非表示配列 */
    private String[] delFlgs;

    /** 更新日配列 */
    private String[] updDt;

    /** 登録プログラム名 */
    private String insPg;

    /** 登録者ID */
    private String insId;

    /** 更新プログラム名 */
    private String updPg;

    /** 更新者ID */
    private String updId;

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
     * クーポン情報Seqを取得します。
     * @return クーポン情報Seq
     */
    public String[] getCouponSeqs() {
        return couponSeqs;
    }

    /**
     * クーポン情報Seqを設定します。
     * @param couponSeqs クーポン情報Seq
     */
    public void setCouponSeqs(String[] couponSeqs) {
        this.couponSeqs = couponSeqs;
    }

    /**
     * 開始年配列を取得します。
     * @return 開始年配列
     */
    public String[] getStartYears() {
        return startYears;
    }

    /**
     * 開始年配列を設定します。
     * @param startYears 開始年配列
     */
    public void setStartYears(String[] startYears) {
        this.startYears = startYears;
    }

    /**
     * 開始月配列を取得します。
     * @return 開始月配列
     */
    public String[] getStartMonths() {
        return startMonths;
    }

    /**
     * 開始月配列を設定します。
     * @param startMonths 開始月配列
     */
    public void setStartMonths(String[] startMonths) {
        this.startMonths = startMonths;
    }

    /**
     * 開始日配列を取得します。
     * @return 開始日配列
     */
    public String[] getStartDays() {
        return startDays;
    }

    /**
     * 開始日配列を設定します。
     * @param startDays 開始日配列
     */
    public void setStartDays(String[] startDays) {
        this.startDays = startDays;
    }

    /**
     * 終了年配列を取得します。
     * @return 終了年配列
     */
    public String[] getEndYears() {
        return endYears;
    }

    /**
     * 終了年配列を設定します。
     * @param endYears 終了年配列
     */
    public void setEndYears(String[] endYears) {
        this.endYears = endYears;
    }

    /**
     * 終了月配列を取得します。
     * @return 終了月配列
     */
    public String[] getEndMonths() {
        return endMonths;
    }

    /**
     * 終了月配列を設定します。
     * @param endMonths 終了月配列
     */
    public void setEndMonths(String[] endMonths) {
        this.endMonths = endMonths;
    }

    /**
     * 終了日配列を取得します。
     * @return 終了日配列
     */
    public String[] getEndDays() {
        return endDays;
    }

    /**
     * 終了日配列を設定します。
     * @param endDays 終了日配列
     */
    public void setEndDays(String[] endDays) {
        this.endDays = endDays;
    }

    /**
     * 利用対象：プルダウン選択値を取得します。
     * @return 利用対象：プルダウン選択値
     */
    public String[] getRiyouTaisyo() {
        return riyouTaisyo;
    }

    /**
     * 利用対象：プルダウン選択値を設定します。
     * @param riyouTaisyo 利用対象：プルダウン選択値
     */
    public void setRiyouTaisyo(String[] riyouTaisyo) {
        this.riyouTaisyo = riyouTaisyo;
    }

    /**
     * 利用対象：手入力値を取得します。
     * @return 利用対象：手入力値
     */
    public String[] getRiyouTaisyoCustom() {
        return riyouTaisyoCustom;
    }

    /**
     * 利用対象：手入力値を設定します。
     * @param riyouTaisyoCustom 利用対象：手入力値
     */
    public void setRiyouTaisyoCustom(String[] riyouTaisyoCustom) {
        this.riyouTaisyoCustom = riyouTaisyoCustom;
    }

    /**
     * 利用対象：タイプを取得します。
     * @return 利用対象：タイプ
     */
    public String[] getRiyouTaisyoType() {
        return riyouTaisyoType;
    }

    /**
     * 利用対象：タイプを設定します。
     * @param riyouTaisyoType 利用対象：タイプ
     */
    public void setRiyouTaisyoType(String[] riyouTaisyoType) {
        this.riyouTaisyoType = riyouTaisyoType;
    }

    /**
     * 特典：プルダウン選択値を取得します。
     * @return 特典：プルダウン選択値
     */
    public String[] getTokuten() {
        return tokuten;
    }

    /**
     * 特典：プルダウン選択値を設定します。
     * @param tokuten 特典：プルダウン選択値
     */
    public void setTokuten(String[] tokuten) {
        this.tokuten = tokuten;
    }

    /**
     * 特典：手入力値を取得します。
     * @return 特典：手入力値
     */
    public String[] getTokutenCustom() {
        return tokutenCustom;
    }

    /**
     * 特典：手入力値を設定します。
     * @param tokutenCustom 特典：手入力値
     */
    public void setTokutenCustom(String[] tokutenCustom) {
        this.tokutenCustom = tokutenCustom;
    }

    /**
     * 特典：タイプを取得します。
     * @return 特典：タイプ
     */
    public String[] getTokutenType() {
        return tokutenType;
    }

    /**
     * 特典：タイプを設定します。
     * @param tokutenType 特典：タイプ
     */
    public void setTokutenType(String[] tokutenType) {
        this.tokutenType = tokutenType;
    }

    /**
     * 提示条件：プルダウン選択値を取得します。
     * @return 提示条件：プルダウン選択値
     */
    public String[] getJouken() {
        return jouken;
    }

    /**
     * 提示条件：プルダウン選択値を設定します。
     * @param jouken 提示条件：プルダウン選択値
     */
    public void setJouken(String[] jouken) {
        this.jouken = jouken;
    }

    /**
     * 提示条件：手入力値を取得します。
     * @return 提示条件：手入力値
     */
    public String[] getJoukenCustom() {
        return joukenCustom;
    }

    /**
     * 提示条件：手入力値を設定します。
     * @param joukenCustom 提示条件：手入力値
     */
    public void setJoukenCustom(String[] joukenCustom) {
        this.joukenCustom = joukenCustom;
    }

    /**
     * 提示条件：タイプを取得します。
     * @return 提示条件：タイプ
     */
    public String[] getJoukenType() {
        return joukenType;
    }

    /**
     * 提示条件：タイプを設定します。
     * @param joukenType 提示条件：タイプ
     */
    public void setJoukenType(String[] joukenType) {
        this.joukenType = joukenType;
    }

    /**
     * 表示順配列を取得します。
     * @return 表示順配列
     */
    public String[] getSortKeys() {
        return sortKeys;
    }

    /**
     * 表示順配列を設定します。
     * @param sortKeys 表示順配列
     */
    public void setSortKeys(String[] sortKeys) {
        this.sortKeys = sortKeys;
    }

    /**
     * 非表示配列を取得します。
     * @return 非表示配列
     */
    public String[] getDelFlgs() {
        return delFlgs;
    }

    /**
     * 非表示配列を設定します。
     * @param delFlgs 非表示配列
     */
    public void setDelFlgs(String[] delFlgs) {
        this.delFlgs = delFlgs;
    }

    /**
     * 更新日配列を取得します。
     * @return 更新日配列
     */
    public String[] getUpdDt() {
        return updDt;
    }

    /**
     * 更新日配列を設定します。
     * @param updDt 更新日配列
     */
    public void setUpdDt(String[] updDt) {
        this.updDt = updDt;
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

}
