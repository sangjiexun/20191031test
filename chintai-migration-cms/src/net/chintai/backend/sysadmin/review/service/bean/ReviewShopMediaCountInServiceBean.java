/*
 * $Id: ReviewShopMediaCountInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/05  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.bean;

import net.chintai.backend.sysadmin.common.session.SessionSearchCondition;

/**
 * 店舗別出稿状況集計条件
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopMediaCountInServiceBean implements SessionSearchCondition {

    /** serialVersionUID */
    private static final long serialVersionUID = -5137175348205964685L;

    /** 検索開始年 */
    private String sumYmdFromYear;

    /** 検索開始月 */
    private String sumYmdFromMonth;

    /** 店舗コード */
    private String shopCd;

    /** 会社名/事務所名 */
    private String companyBumon;

    /** 都道府県 */
    private String prefCd;

    /** 出力先 */
    private String outPut;

    /** ページング情報 */
    private int offSet;

    /**
     * 検索開始年を取得します。
     * @return 検索開始年
     */
    public String getSumYmdFromYear() {
        return sumYmdFromYear;
    }

    /**
     * 検索開始年を設定します。
     * @param sumYmdFromYear 検索開始年
     */
    public void setSumYmdFromYear(String sumYmdFromYear) {
        this.sumYmdFromYear = sumYmdFromYear;
    }

    /**
     * 検索開始月を取得します。
     * @return 検索開始月
     */
    public String getSumYmdFromMonth() {
        return sumYmdFromMonth;
    }

    /**
     * 検索開始月を設定します。
     * @param sumYmdFromMonth 検索開始月
     */
    public void setSumYmdFromMonth(String sumYmdFromMonth) {
        this.sumYmdFromMonth = sumYmdFromMonth;
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
     * ページング情報を取得します。
     * @return ページング情報
     */
    public int getOffSet() {
        return offSet;
    }

    /**
     * ページング情報を設定します。
     * @param offSet ページング情報
     */
    public void setOffSet(int offSet) {
        this.offSet = offSet;
    }

}
