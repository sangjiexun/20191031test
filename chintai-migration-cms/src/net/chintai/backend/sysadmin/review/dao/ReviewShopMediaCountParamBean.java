/*
 * $Id: ReviewShopMediaCountParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/05  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao;

/**
 * 店舗別出稿状況集計検索
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopMediaCountParamBean {

    /** 店舗コード */
    private String shopCd;

    /** 会社名/事務所名 */
    private String companyBumon;

    /** 都道府県 */
    private String prefCd;

    /** 検索開始年月 */
    private String sumYmdFrom;

    /** 出力先 */
    private String outPut;

    /** 検索終了年月 */
    private String sumYmdTo;

    /** 検索年月詳細 */
    private String[] dates;

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
     * 会社名/事務所名を取得します。
     * @return 会社名/事務所名
     */
    public String getCompanyBumon() {
        return companyBumon;
    }

    /**
     * 会社名/事務所名を設定します。
     * @param companyBumon 会社名/事務所名
     */
    public void setCompanyBumon(String companyBumon) {
        this.companyBumon = companyBumon;
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
     * 検索開始年月を取得します。
     * @return 検索開始年月
     */
    public String getSumYmdFrom() {
        return sumYmdFrom;
    }

    /**
     * 検索開始年月を設定します。
     * @param sumYmdFrom 検索開始年月
     */
    public void setSumYmdFrom(String sumYmdFrom) {
        this.sumYmdFrom = sumYmdFrom;
    }

    /**
     * 出力先を取得します。
     * @return 出力先
     */
    public String getOutPut() {
        return outPut;
    }

    /**
     * 出力先を設定します。
     * @param outPut 出力先
     */
    public void setOutPut(String outPut) {
        this.outPut = outPut;
    }

    /**
     * 検索終了年月を取得します。
     * @return 検索終了年月
     */
    public String getSumYmdTo() {
        return sumYmdTo;
    }

    /**
     * 検索終了年月を設定します。
     * @param sumYmdTo 検索終了年月
     */
    public void setSumYmdTo(String sumYmdTo) {
        this.sumYmdTo = sumYmdTo;
    }

    /**
     * 検索年月詳細を取得します。
     * @return 検索年月詳細
     */
    public String[] getDates() {
        return dates;
    }

    /**
     * 検索年月詳細を設定します。
     * @param dates 検索年月詳細
     */
    public void setDates(String[] dates) {
        this.dates = dates;
    }

}
