/*
 * $Id: ShopBindSearchView.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/09  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;
import net.chintai.backend.sysadmin.common.pager.PagerCondition;
import net.chintai.backend.sysadmin.common.pager.PagerViewHelper;

/**
 * 店舗コード紐付
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopBindSearchView extends PagerViewHelper {

    /** 店舗コード(検索条件) */
    private String shopCd;

    /** 会社名(検索条件) */
    private String company;

    /** 店舗名(検索条件) */
    private String bumon;

    /** 検索結果リスト */
    private List<ShopBindSearchDetailView> detailList;

    /**
     * スーパークラスからのコンストラクター
     * @param condition
     */
    public ShopBindSearchView(PagerCondition condition) {
        super(condition);
    }

    // 検索結果格納用InnerClass
    public class ShopBindSearchDetailView implements ViewHelper {

        /** 店舗コード */
        private String shopCd;

        /** 会社名 */
        private String company;

        /** 店舗名 */
        private String bumon;

        /** 不動産会社コード */
        private String fudousanCd;

        /** 不動産会社名 */
        private String fudousanName;

        /** 取引先コード */
        private String torihikisakiCd;

        /** 取引先名 */
        private String torihikisakiName;

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
         * 店舗名を取得します。
         * @return 店舗名
         */
        public String getBumon() {
            return bumon;
        }

        /**
         * 店舗名を設定します。
         * @param bumon 店舗名
         */
        public void setBumon(String bumon) {
            this.bumon = bumon;
        }

        /**
         * 不動産会社コードを取得します。
         * @return 不動産会社コード
         */
        public String getFudousanCd() {
            return fudousanCd;
        }

        /**
         * 不動産会社コードを設定します。
         * @param fudousanCd 不動産会社コード
         */
        public void setFudousanCd(String fudousanCd) {
            this.fudousanCd = fudousanCd;
        }

        /**
         * 不動産会社名を取得します。
         * @return 不動産会社名
         */
        public String getFudousanName() {
            return fudousanName;
        }

        /**
         * 不動産会社名を設定します。
         * @param fudousanName 不動産会社名
         */
        public void setFudousanName(String fudousanName) {
            this.fudousanName = fudousanName;
        }

        /**
         * 取引先コードを取得します。
         * @return 取引先コード
         */
        public String getTorihikisakiCd() {
            return torihikisakiCd;
        }

        /**
         * 取引先コードを設定します。
         * @param torihikisakiCd 取引先コード
         */
        public void setTorihikisakiCd(String torihikisakiCd) {
            this.torihikisakiCd = torihikisakiCd;
        }

        /**
         * 取引先名を取得します。
         * @return 取引先名
         */
        public String getTorihikisakiName() {
            return torihikisakiName;
        }

        /**
         * 取引先名を設定します。
         * @param torihikisakiName 取引先名
         */
        public void setTorihikisakiName(String torihikisakiName) {
            this.torihikisakiName = torihikisakiName;
        }

    }

    /**
     * 店舗コード(検索条件)を取得します。
     * @return 店舗コード(検索条件)
     */
    public String getShopCd() {
        return shopCd;
    }

    /**
     * 店舗コード(検索条件)を設定します。
     * @param shopCd 店舗コード(検索条件)
     */
    public void setShopCd(String shopCd) {
        this.shopCd = shopCd;
    }

    /**
     * 会社名(検索条件)を取得します。
     * @return 会社名(検索条件)
     */
    public String getCompany() {
        return company;
    }

    /**
     * 会社名(検索条件)を設定します。
     * @param company 会社名(検索条件)
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 店舗名(検索条件)を取得します。
     * @return 店舗名(検索条件)
     */
    public String getBumon() {
        return bumon;
    }

    /**
     * 店舗名(検索条件)を設定します。
     * @param bumon 店舗名(検索条件)
     */
    public void setBumon(String bumon) {
        this.bumon = bumon;
    }

    /**
     * 検索結果リストを取得します。
     * @return 検索結果リスト
     */
    public List<ShopBindSearchDetailView> getDetailList() {
        return detailList;
    }

    /**
     * 検索結果リストを設定します。
     * @param detailList 検索結果リスト
     */
    public void setDetailList(List<ShopBindSearchDetailView> detailList) {
        this.detailList = detailList;
    }

}
