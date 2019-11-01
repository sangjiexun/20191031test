package net.chintai.backend.sysadmin.shop_bukken.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 契約明細詳細(契約数量あり)設定情報
 *
 * @author
 * @version $Revision: $ Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountDeleteView implements ViewHelper {

    /** 会社名 */
    private String company;

    /** 事務所名 */
    private String bumon;

    /** 店舗コード */
    private String shopCd;

    /** お客様設定パスワード */
    private String password;

    /** 契約コード */
    private String keiyakuCd;

    /** 契約サブコード */
    private String keiyakuSubCd;

    /** 契約名 */
    private String keiyakuName;

    /** 店舗管理テーブル更新日時 */
    private String shopKanriUpdDt;

    /**
     * 会社名を返します。
     *
     * @return 会社名
     */
    public String getCompany() {
        return company;
    }

    /**
     * 会社名を設定します。
     *
     * @param company
     *            会社名
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 事務所名を返します。
     *
     * @return 事務所名
     */
    public String getBumon() {
        return bumon;
    }

    /**
     * 事務所名を設定します。
     *
     * @param bumon
     *            事務所名
     */
    public void setBumon(String bumon) {
        this.bumon = bumon;
    }

    /**
     * 店舗コードを返します。
     *
     * @return 店舗コード
     */
    public String getShopCd() {
        return shopCd;
    }

    /**
     * 店舗コードを設定します。
     *
     * @param shopCd
     *            店舗コード
     */
    public void setShopCd(String shopCd) {
        this.shopCd = shopCd;
    }

    /**
     * お客様設定パスワードを返します。
     *
     * @return お客様設定パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * お客様設定パスワードを設定します。
     *
     * @param password
     *            お客様設定パスワード
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 契約コードを返します。
     *
     * @return 契約コード
     */
    public String getKeiyakuCd() {
        return keiyakuCd;
    }

    /**
     * 契約コードを設定します。
     *
     * @param keiyakuCd
     *            契約コード
     */
    public void setKeiyakuCd(String keiyakuCd) {
        this.keiyakuCd = keiyakuCd;
    }

    /**
     * 契約サブコードを返します。
     *
     * @return 契約サブコード
     */
    public String getKeiyakuSubCd() {
        return keiyakuSubCd;
    }

    /**
     * 契約サブコードを設定します。
     *
     * @param keiyakuSubCd
     *            契約サブコード
     */
    public void setKeiyakuSubCd(String keiyakuSubCd) {
        this.keiyakuSubCd = keiyakuSubCd;
    }

    /**
     * 契約名を返します。
     *
     * @return 契約名
     */
    public String getKeiyakuName() {
        return keiyakuName;
    }

    /**
     * 契約名を設定します。
     *
     * @param keiyakuName
     *            契約名
     */
    public void setKeiyakuName(String keiyakuName) {
        this.keiyakuName = keiyakuName;
    }

    /** 契約明細詳細(契約数量あり)情報リスト */
    private List<ContractAmountDeleteDetailView> detailList;

    public class ContractAmountDeleteDetailView {

        /** 適用年月日時 */
        private String appStartDt;

        /** 適用年月日時(画面表示用) */
        private String startYmdh;

        /** 枠数 */
        private String wakuCnt;

        /** 最終更新自日時 */
        private String updDt;

        /**
         * 適用年月日時(画面表示用)を返します。
         *
         * @return 適用年月日時(画面表示用)
         */
        public String getStartYmdh() {
            return startYmdh;
        }

        /**
         * 適用年月日時(画面表示用)を設定します。
         *
         * @param startYmdhForDisplay
         *            適用年月日時(画面表示用)
         */
        public void setStartYmdh(String startYmdh) {
            this.startYmdh = startYmdh;
        }

        /**
         * 適用年月日時を返します。
         *
         * @return 適用年月日時
         */
        public String getAppStartDt() {
            return appStartDt;
        }

        /**
         * 適用年月日時を設定します。
         *
         * @param startYmdh
         *            適用年月日時
         */
        public void setAppStartDt(String appStartDt) {
            this.appStartDt = appStartDt;
        }

        /**
         * 枠数を返します。
         *
         * @return wakuCnt
         */
        public String getWakuCnt() {
            return wakuCnt;
        }

        /**
         * 枠数を設定します。
         *
         * @param wakuCnt
         *            枠数
         */
        public void setWakuCnt(String wakuCnt) {
            this.wakuCnt = wakuCnt;
        }

        /**
         * 最終更新自日時を返します。
         *
         * @return 最終更新自日時
         */
        public String getUpdDt() {
            return updDt;
        }

        /**
         * 最終更新自日時を設定します。
         *
         * @param updDt
         *            最終更新自日時
         */
        public void setUpdDt(String updDt) {
            this.updDt = updDt;
        }
    }

    /**
     * 契約明細詳細(契約数量あり)情報リストを取得します。
     *
     * @return 契約明細詳細(契約数量あり)情報リスト
     */
    public List<ContractAmountDeleteDetailView> getDetailList() {
        return detailList;
    }

    /**
     * 契約明細詳細(契約数量あり)情報リストを設定します。
     *
     * @param detailList
     *            契約明細詳細(契約数量あり)情報リスト
     */
    public void setDetailList(List<ContractAmountDeleteDetailView> detailList) {
        this.detailList = detailList;
    }

    /**
     *  店舗管理テーブル更新日時を返します。
     * @return  店舗管理テーブル更新日時
     */
    public String getShopKanriUpdDt() {
        return shopKanriUpdDt;
    }

    /**
     *  店舗管理テーブル更新日時を設定します。
     * @param shopKanriUpdDt   店舗管理テーブル更新日時
     */
    public void setShopKanriUpdDt(String shopKanriUpdDt) {
        this.shopKanriUpdDt = shopKanriUpdDt;
    }

}
