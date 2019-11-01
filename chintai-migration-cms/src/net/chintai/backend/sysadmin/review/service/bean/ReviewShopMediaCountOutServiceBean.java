/*
 * $Id: ReviewShopMediaCountOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/05  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.bean;

/**
 * 店舗別出稿状況集計一覧
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopMediaCountOutServiceBean {

    /** 集計時点日時 */
    private String cntTime;

    /** 店舗コード */
    private String shopCd;

    /** 会社名 */
    private String company;

    /** 事務所名 */
    private String bumon;

    /** 種別 */
    private String shinsaCd;

    /** 検索開始年月の集計件数 */
    private String cnt1;

    /** 検索開始年+1月の集計件数 */
    private String cnt2;

    /** 検索開始年+2月の集計件数 */
    private String cnt3;

    /** 検索開始年+3月の集計件数 */
    private String cnt4;

    /** 検索開始年+4月の集計件数 */
    private String cnt5;

    /** 検索開始年+5月の集計件数 */
    private String cnt6;

    /** 検索開始年+6月の集計件数 */
    private String cnt7;

    /** 検索開始年+7月の集計件数 */
    private String cnt8;

    /** 検索開始年+8月の集計件数 */
    private String cnt9;

    /** 検索開始年+9月の集計件数 */
    private String cnt10;

    /** 検索開始年+10月の集計件数 */
    private String cnt11;

    /** 検索開始年+11月の集計件数 */
    private String cnt12;

    /** 初回警告対象 */
    private String syokaiShinsaCnt;

    /** 初回警告対象外 */
    private String syokaiShinsaSkipCnt;

    /** 初回停止 */
    private String syokaiShinsaDelCnt;

    /** 定期警告対象 */
    private String teikiShinsaCnt;

    /** 定期停止 */
    private String teikiShinsaDelCnt;

    /** 警告日 */
    private String sendDt;

    /**
     * 集計時点日時を取得します。
     * @return 集計時点日時
     */
    public String getCntTime() {
        return cntTime;
    }

    /**
     * 集計時点日時を設定します。
     * @param cntTime 集計時点日時
     */
    public void setCntTime(String cntTime) {
        this.cntTime = cntTime;
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
     * 会社名を取得します。
     * @return 会社名
     */
    public String getCompany() {
        return company;
    }

    /**
     * 会社名を設定します。
     * @param company 会社名
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 事務所名を取得します。
     * @return 事務所名
     */
    public String getBumon() {
        return bumon;
    }

    /**
     * 事務所名を設定します。
     * @param bumon 事務所名
     */
    public void setBumon(String bumon) {
        this.bumon = bumon;
    }

    /**
     * 種別を取得します。
     * @return 種別
     */
    public String getShinsaCd() {
        return shinsaCd;
    }

    /**
     * 種別を設定します。
     * @param shinsaCd 種別
     */
    public void setShinsaCd(String shinsaCd) {
        this.shinsaCd = shinsaCd;
    }

    /**
     * 検索開始年月の集計件数を取得します。
     * @return 検索開始年月の集計件数
     */
    public String getCnt1() {
        return cnt1;
    }

    /**
     * 検索開始年月の集計件数を設定します。
     * @param cnt1 検索開始年月の集計件数
     */
    public void setCnt1(String cnt1) {
        this.cnt1 = cnt1;
    }

    /**
     * 検索開始年+1月の集計件数を取得します。
     * @return 検索開始年+1月の集計件数
     */
    public String getCnt2() {
        return cnt2;
    }

    /**
     * 検索開始年+1月の集計件数を設定します。
     * @param cnt2 検索開始年+1月の集計件数
     */
    public void setCnt2(String cnt2) {
        this.cnt2 = cnt2;
    }

    /**
     * 検索開始年+2月の集計件数を取得します。
     * @return 検索開始年+2月の集計件数
     */
    public String getCnt3() {
        return cnt3;
    }

    /**
     * 検索開始年+2月の集計件数を設定します。
     * @param cnt3 検索開始年+2月の集計件数
     */
    public void setCnt3(String cnt3) {
        this.cnt3 = cnt3;
    }

    /**
     * 検索開始年+3月の集計件数を取得します。
     * @return 検索開始年+3月の集計件数
     */
    public String getCnt4() {
        return cnt4;
    }

    /**
     * 検索開始年+3月の集計件数を設定します。
     * @param cnt4 検索開始年+3月の集計件数
     */
    public void setCnt4(String cnt4) {
        this.cnt4 = cnt4;
    }

    /**
     * 検索開始年+4月の集計件数を取得します。
     * @return 検索開始年+4月の集計件数
     */
    public String getCnt5() {
        return cnt5;
    }

    /**
     * 検索開始年+4月の集計件数を設定します。
     * @param cnt5 検索開始年+4月の集計件数
     */
    public void setCnt5(String cnt5) {
        this.cnt5 = cnt5;
    }

    /**
     * 検索開始年+5月の集計件数を取得します。
     * @return 検索開始年+5月の集計件数
     */
    public String getCnt6() {
        return cnt6;
    }

    /**
     * 検索開始年+5月の集計件数を設定します。
     * @param cnt6 検索開始年+5月の集計件数
     */
    public void setCnt6(String cnt6) {
        this.cnt6 = cnt6;
    }

    /**
     * 検索開始年+6月の集計件数を取得します。
     * @return 検索開始年+6月の集計件数
     */
    public String getCnt7() {
        return cnt7;
    }

    /**
     * 検索開始年+6月の集計件数を設定します。
     * @param cnt7 検索開始年+6月の集計件数
     */
    public void setCnt7(String cnt7) {
        this.cnt7 = cnt7;
    }

    /**
     * 検索開始年+7月の集計件数を取得します。
     * @return 検索開始年+7月の集計件数
     */
    public String getCnt8() {
        return cnt8;
    }

    /**
     * 検索開始年+7月の集計件数を設定します。
     * @param cnt8 検索開始年+7月の集計件数
     */
    public void setCnt8(String cnt8) {
        this.cnt8 = cnt8;
    }

    /**
     * 検索開始年+8月の集計件数を取得します。
     * @return 検索開始年+8月の集計件数
     */
    public String getCnt9() {
        return cnt9;
    }

    /**
     * 検索開始年+8月の集計件数を設定します。
     * @param cnt9 検索開始年+8月の集計件数
     */
    public void setCnt9(String cnt9) {
        this.cnt9 = cnt9;
    }

    /**
     * 検索開始年+9月の集計件数を取得します。
     * @return 検索開始年+9月の集計件数
     */
    public String getCnt10() {
        return cnt10;
    }

    /**
     * 検索開始年+9月の集計件数を設定します。
     * @param cnt10 検索開始年+9月の集計件数
     */
    public void setCnt10(String cnt10) {
        this.cnt10 = cnt10;
    }

    /**
     * 検索開始年+10月の集計件数を取得します。
     * @return 検索開始年+10月の集計件数
     */
    public String getCnt11() {
        return cnt11;
    }

    /**
     * 検索開始年+10月の集計件数を設定します。
     * @param cnt11 検索開始年+10月の集計件数
     */
    public void setCnt11(String cnt11) {
        this.cnt11 = cnt11;
    }

    /**
     * 検索開始年+11月の集計件数を取得します。
     * @return 検索開始年+11月の集計件数
     */
    public String getCnt12() {
        return cnt12;
    }

    /**
     * 検索開始年+11月の集計件数を設定します。
     * @param cnt12 検索開始年+11月の集計件数
     */
    public void setCnt12(String cnt12) {
        this.cnt12 = cnt12;
    }

    /**
     * 初回警告対象を取得します。
     * @return 初回警告対象
     */
    public String getSyokaiShinsaCnt() {
        return syokaiShinsaCnt;
    }

    /**
     * 初回警告対象を設定します。
     * @param syokaiShinsaCnt 初回警告対象
     */
    public void setSyokaiShinsaCnt(String syokaiShinsaCnt) {
        this.syokaiShinsaCnt = syokaiShinsaCnt;
    }

    /**
     * 初回警告対象外を取得します。
     * @return 初回警告対象外
     */
    public String getSyokaiShinsaSkipCnt() {
        return syokaiShinsaSkipCnt;
    }

    /**
     * 初回警告対象外を設定します。
     * @param syokaiShinsaSkipCnt 初回警告対象外
     */
    public void setSyokaiShinsaSkipCnt(String syokaiShinsaSkipCnt) {
        this.syokaiShinsaSkipCnt = syokaiShinsaSkipCnt;
    }

    /**
     * 初回停止を取得します。
     * @return 初回停止
     */
    public String getSyokaiShinsaDelCnt() {
        return syokaiShinsaDelCnt;
    }

    /**
     * 初回停止を設定します。
     * @param syokaiShinsaDelCnt 初回停止
     */
    public void setSyokaiShinsaDelCnt(String syokaiShinsaDelCnt) {
        this.syokaiShinsaDelCnt = syokaiShinsaDelCnt;
    }

    /**
     * 定期警告対象を取得します。
     * @return 定期警告対象
     */
    public String getTeikiShinsaCnt() {
        return teikiShinsaCnt;
    }

    /**
     * 定期警告対象を設定します。
     * @param teikiShinsaCnt 定期警告対象
     */
    public void setTeikiShinsaCnt(String teikiShinsaCnt) {
        this.teikiShinsaCnt = teikiShinsaCnt;
    }

    /**
     * 定期停止を取得します。
     * @return 定期停止
     */
    public String getTeikiShinsaDelCnt() {
        return teikiShinsaDelCnt;
    }

    /**
     * 定期停止を設定します。
     * @param teikiShinsaDelCnt 定期停止
     */
    public void setTeikiShinsaDelCnt(String teikiShinsaDelCnt) {
        this.teikiShinsaDelCnt = teikiShinsaDelCnt;
    }

    /**
     * 警告日を取得します。
     * @return 警告日
     */
    public String getSendDt() {
        return sendDt;
    }

    /**
     * 警告日を設定します。
     * @param sendDt 警告日
     */
    public void setSendDt(String sendDt) {
        this.sendDt = sendDt;
    }

}
