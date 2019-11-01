/*
 * $Id: ReviewShopMediaCountView.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/12  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.review.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;
import net.chintai.backend.sysadmin.common.pager.PagerCondition;
import net.chintai.backend.sysadmin.common.pager.PagerViewHelper;

/**
 * 店舗別出稿状況集計結果
 * 
 * @author Lee Hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopMediaCountView extends PagerViewHelper {

    /** 検索開始年 */
    private String sumYmdFromYear;

    /** 検索開始月 */
    private String sumYmdFromMonth;

    /** 店舗コード */
    private String shopCd;

    /** 会社名/事務所名 */
    private String companyBumon;

    /** 都道府県コード */
    private String prefCd;

    /** 出力先 */
    private String outPut;

    /** 集計結果リスト */
    private List<ReviewShopMediaCountDetailView> shopMediaCntList;

    /** 集計時点日時 */
    private String cntTime;

    /** 集計年月リスト */
    private List dateList;

    /**
     * スーパークラスからのコンストラクター
     * @param condition
     */
    public ReviewShopMediaCountView(PagerCondition condition) {
        super(condition);

    }

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
     * 都道府県コードを取得します。
     * @return 都道府県コード
     */
    public String getPrefCd() {
        return prefCd;
    }

    /**
     * 都道府県コードを設定します。
     * @param prefCd 都道府県コード
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
     * 集計結果リストを取得します。
     * @return 集計結果リスト
     */
    public List<ReviewShopMediaCountDetailView> getShopMediaCntList() {
        return shopMediaCntList;
    }

    /**
     * 集計結果リストを設定します。
     * @param shopMediaCntList 集計結果リスト
     */
    public void setShopMediaCntList(List<ReviewShopMediaCountDetailView> shopMediaCntList) {
        this.shopMediaCntList = shopMediaCntList;
    }

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

    public class ReviewShopMediaCountDetailView implements ViewHelper {

        /** 店舗コード */
        private String shopCd;

        /** 会社名 */
        private String company;

        /** 事務所名 */
        private String bumon;

        /** 初回警告対象件数リスト */
        private List<String> syokaiCntList;

        /** 初回警告対象外件数リスト */
        private List<String> syokaiSkipList;

        /** 初回停止件数リスト */
        private List<String> syokaiAutoDelList;

        /** 定期警告対象件数リスト */
        private List<String> teikiCntList;

        /** 定期停止件数リスト */
        private List<String> teikiAutoDelList;

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
         * 初回警告対象件数リストを取得します。
         * @return 初回警告対象件数リスト
         */
        public List<String> getSyokaiCntList() {
            return syokaiCntList;
        }

        /**
         * 初回警告対象件数リストを設定します。
         * @param syokaiCntList 初回警告対象件数リスト
         */
        public void setSyokaiCntList(List<String> syokaiCntList) {
            this.syokaiCntList = syokaiCntList;
        }

        /**
         * 初回警告対象外件数リストを取得します。
         * @return 初回警告対象外件数リスト
         */
        public List<String> getSyokaiSkipList() {
            return syokaiSkipList;
        }

        /**
         * 初回警告対象外件数リストを設定します。
         * @param syokaiSkipList 初回警告対象外件数リスト
         */
        public void setSyokaiSkipList(List<String> syokaiSkipList) {
            this.syokaiSkipList = syokaiSkipList;
        }

        /**
         * 初回停止件数リストを取得します。
         * @return 初回停止件数リスト
         */
        public List<String> getSyokaiAutoDelList() {
            return syokaiAutoDelList;
        }

        /**
         * 初回停止件数リストを設定します。
         * @param syokaiAutoDelList 初回停止件数リスト
         */
        public void setSyokaiAutoDelList(List<String> syokaiAutoDelList) {
            this.syokaiAutoDelList = syokaiAutoDelList;
        }

        /**
         * 定期警告対象件数リストを取得します。
         * @return 定期警告対象件数リスト
         */
        public List<String> getTeikiCntList() {
            return teikiCntList;
        }

        /**
         * 定期警告対象件数リストを設定します。
         * @param teikiCntList 定期警告対象件数リスト
         */
        public void setTeikiCntList(List<String> teikiCntList) {
            this.teikiCntList = teikiCntList;
        }

        /**
         * 定期停止件数リストを取得します。
         * @return 定期停止件数リスト
         */
        public List<String> getTeikiAutoDelList() {
            return teikiAutoDelList;
        }

        /**
         * 定期停止件数リストを設定します。
         * @param teikiAutoDelList 定期停止件数リスト
         */
        public void setTeikiAutoDelList(List<String> teikiAutoDelList) {
            this.teikiAutoDelList = teikiAutoDelList;
        }

    }

    /**
     * 集計年月リストを取得します。
     * @return 集計年月リスト
     */
    public List getDateList() {
        return dateList;
    }

    /**
     * 集計年月リストを設定します。
     * @param dateList 集計年月リスト
     */
    public void setDateList(List dateList) {
        this.dateList = dateList;
    }
}
