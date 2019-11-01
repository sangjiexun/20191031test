/*
 * $Id: ReviewBukkenAlertCountView.java 3936 2008-05-28 05:06:55Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/13  BGT)李昊燮     新規作成
 * 2008/05/27  BGT)李昊燮     変数名ctStatus/ablStatusをctFlg/ablFlgに修正
 */
package net.chintai.backend.sysadmin.review.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;
import net.chintai.backend.sysadmin.common.pager.PagerCondition;
import net.chintai.backend.sysadmin.common.pager.PagerViewHelper;

/**
 * 警告対象物件集計結果画面
 * @author Lee Hosup
 * @version $Revision: 3936 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenAlertCountView extends PagerViewHelper {

    /**
     * コンストラクター
     * @param condition
     */
    public ReviewBukkenAlertCountView(PagerCondition condition) {
        super(condition);
    }

    /** 店舗コード */
    private String shopCd;

    /** 会社名/事務所名 */
    private String companyBumon;

    /** 都道府県 */
    private String prefCd;

    /** 警告日(年)(下限) */
    private String fromYear;

    /** 警告日(月)(下限) */
    private String fromMonth;

    /** 警告日(日)(下限) */
    private String fromDay;

    /** 警告日(年)(上限) */
    private String toYear;

    /** 警告日(月)(上限) */
    private String toMonth;

    /** 警告日(日)(上限) */
    private String toDay;

    /** 平均家賃基準該当物件 */
    private String warningCd0;

    /** 連続掲載該当物件 */
    private String warningCd1;

    /** 連続掲載かつ問合せ数該当物件 */
    private String warningCd2;

    /** ソートキー */
    private String sortKey;

    /** 順序 */
    private String orderBy;

    /** 出力先 */
    private String outPut;

    /** 検索結果リスト */
    private List<ReviewBukkenAlertCountDetailView> bukkenAlertList;

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
     * 警告日(年)(下限)を取得します。
     * @return 警告日(年)(下限)
     */
    public String getFromYear() {
        return fromYear;
    }

    /**
     * 警告日(年)(下限)を設定します。
     * @param fromYear 警告日(年)(下限)
     */
    public void setFromYear(String fromYear) {
        this.fromYear = fromYear;
    }

    /**
     * 警告日(月)(下限)を取得します。
     * @return 警告日(月)(下限)
     */
    public String getFromMonth() {
        return fromMonth;
    }

    /**
     * 警告日(月)(下限)を設定します。
     * @param fromMonth 警告日(月)(下限)
     */
    public void setFromMonth(String fromMonth) {
        this.fromMonth = fromMonth;
    }

    /**
     * 警告日(日)(下限)を取得します。
     * @return 警告日(日)(下限)
     */
    public String getFromDay() {
        return fromDay;
    }

    /**
     * 警告日(日)(下限)を設定します。
     * @param fromDay 警告日(日)(下限)
     */
    public void setFromDay(String fromDay) {
        this.fromDay = fromDay;
    }

    /**
     * 警告日(年)(上限)を取得します。
     * @return 警告日(年)(上限)
     */
    public String getToYear() {
        return toYear;
    }

    /**
     * 警告日(年)(上限)を設定します。
     * @param toYear 警告日(年)(上限)
     */
    public void setToYear(String toYear) {
        this.toYear = toYear;
    }

    /**
     * 警告日(月)(上限)を取得します。
     * @return 警告日(月)(上限)
     */
    public String getToMonth() {
        return toMonth;
    }

    /**
     * 警告日(月)(上限)を設定します。
     * @param toMonth 警告日(月)(上限)
     */
    public void setToMonth(String toMonth) {
        this.toMonth = toMonth;
    }

    /**
     * 警告日(日)(上限)を取得します。
     * @return 警告日(日)(上限)
     */
    public String getToDay() {
        return toDay;
    }

    /**
     * 警告日(日)(上限)を設定します。
     * @param toDay 警告日(日)(上限)
     */
    public void setToDay(String toDay) {
        this.toDay = toDay;
    }

    /**
     * 平均家賃基準該当物件を取得します。
     * @return 平均家賃基準該当物件
     */
    public String getWarningCd0() {
        return warningCd0;
    }

    /**
     * 平均家賃基準該当物件を設定します。
     * @param warningCd0 平均家賃基準該当物件
     */
    public void setWarningCd0(String warningCd0) {
        this.warningCd0 = warningCd0;
    }

    /**
     * 連続掲載該当物件を取得します。
     * @return 連続掲載該当物件
     */
    public String getWarningCd1() {
        return warningCd1;
    }

    /**
     * 連続掲載該当物件を設定します。
     * @param warningCd1 連続掲載該当物件
     */
    public void setWarningCd1(String warningCd1) {
        this.warningCd1 = warningCd1;
    }

    /**
     * 連続掲載かつアクセス数該当物件を取得します。
     * @return 連続掲載かつアクセス数該当物件
     */
    public String getWarningCd2() {
        return warningCd2;
    }

    /**
     * 連続掲載かつアクセス数該当物件を設定します。
     * @param warningCd2 連続掲載かつアクセス数該当物件
     */
    public void setWarningCd2(String warningCd2) {
        this.warningCd2 = warningCd2;
    }

    /**
     * ソートキーを取得します。
     * @return ソートキー
     */
    public String getSortKey() {
        return sortKey;
    }

    /**
     * ソートキーを設定します。
     * @param sortKey ソートキー
     */
    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    /**
     * 出力先を取得します。
     * @return outPut 出力先
     */
    public String getOutput() {
        return outPut;
    }

    /**
     * 出力先を設定します。
     * @param outPut 出力先
     */
    public void setOutput(String outPut) {
        this.outPut = outPut;
    }

    /**
     * 順序を取得します。
     * @return 順序
     */
    public String getOrderBy() {
        return orderBy;
    }

    /**
     * 順序を設定します。
     * @param orderBy 順序
     */
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
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

    public class ReviewBukkenAlertCountDetailView implements ViewHelper {

        /** 警告日 */
        private String sendDt;

        /** 店舗コード */
        private String shopCd;

        /** 店舗状態 */
        private String shopStatus;

        /** 会社名 */
        private String company;

        /** 事務所名 */
        private String bumon;

        /** CHINTAI掲載 */
        private String ctKeisaiFlg;

        /** エイブル掲載 */
        private String ablKeisaiFlg;

        /** データ元 */
        private String clientSystemType;

        /** 物件コード */
        private String bkCd;

        /** 部屋番号 */
        private String roomCd;

        /** 状態 */
        private String statusKbn;

        /** 警告内容 */
        private String warningName;

        private String ctStatus;

        private String ablStatus;

        private String warningDt;

        private String rendoName;



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
         * 店舗状態を取得します。
         * @return 店舗状態
         */
        public String getShopStatus() {
            return shopStatus;
        }

        /**
         * 店舗状態を設定します。
         * @param shopStatus 店舗状態
         */
        public void setShopStatus(String shopStatus) {
            this.shopStatus = shopStatus;
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
		 * @return ctKeisaiFlg
		 */
		public String getCtKeisaiFlg() {
			return ctKeisaiFlg;
		}

		/**
		 * @param ctKeisaiFlg セットする ctKeisaiFlg
		 */
		public void setCtKeisaiFlg(String ctKeisaiFlg) {
			this.ctKeisaiFlg = ctKeisaiFlg;
		}

		/**
		 * @return ablKeisaiFlg
		 */
		public String getAblKeisaiFlg() {
			return ablKeisaiFlg;
		}

		/**
		 * @param ablKeisaiFlg セットする ablKeisaiFlg
		 */
		public void setAblKeisaiFlg(String ablKeisaiFlg) {
			this.ablKeisaiFlg = ablKeisaiFlg;
		}

		/**
         * データ元を取得します。
         * @return データ元
         */
        public String getClientSystemType() {
            return clientSystemType;
        }

        /**
         * データ元を設定します。
         * @param clientSystemType データ元
         */
        public void setClientSystemType(String clientSystemType) {
            this.clientSystemType = clientSystemType;
        }

        /**
         * 物件コードを取得します。
         * @return 物件コード
         */
        public String getBkCd() {
            return bkCd;
        }

        /**
         * 物件コードを設定します。
         * @param bkCd 物件コード
         */
        public void setBkCd(String bkCd) {
            this.bkCd = bkCd;
        }

        /**
         * 部屋番号を取得します。
         * @return 部屋番号
         */
        public String getRoomCd() {
            return roomCd;
        }

        /**
         * 部屋番号を設定します。
         * @param roomCd 部屋番号
         */
        public void setRoomCd(String roomCd) {
            this.roomCd = roomCd;
        }

        /**
         * 状態を取得します。
         * @return 状態
         */
        public String getStatusKbn() {
            return statusKbn;
        }

        /**
         * 状態を設定します。
         * @param statusKbn 状態
         */
        public void setStatusKbn(String statusKbn) {
            this.statusKbn = statusKbn;
        }

        /**
         * 警告内容を取得します。
         * @return 警告内容
         */
        public String getWarningName() {
            return warningName;
        }

        /**
         * 警告内容を設定します。
         * @param warningName 警告内容
         */
        public void setWarningName(String warningName) {
            this.warningName = warningName;
        }

		/**
		 * @return ctStatus
		 */
		public String getCtStatus() {
			return ctStatus;
		}

		/**
		 * @param ctStatus セットする ctStatus
		 */
		public void setCtStatus(String ctStatus) {
			this.ctStatus = ctStatus;
		}

		/**
		 * @return ablStatus
		 */
		public String getAblStatus() {
			return ablStatus;
		}

		/**
		 * @param ablStatus セットする ablStatus
		 */
		public void setAblStatus(String ablStatus) {
			this.ablStatus = ablStatus;
		}

		/**
		 * @return warningDt
		 */
		public String getWarningDt() {
			return warningDt;
		}

		/**
		 * @param warningDt セットする warningDt
		 */
		public void setWarningDt(String warningDt) {
			this.warningDt = warningDt;
		}

		/**
		 * @return rendoName
		 */
		public String getRendoName() {
			return rendoName;
		}

		/**
		 * @param rendoName セットする rendoName
		 */
		public void setRendoName(String rendoName) {
			this.rendoName = rendoName;
		}

    }

    /**
     * 検索結果リストを取得します。
     * @return 検索結果リスト
     */
    public List<ReviewBukkenAlertCountDetailView> getBukkenAlertList() {
        return bukkenAlertList;
    }

    /**
     * 検索結果リストを設定します。
     * @param bukkenAlertList 検索結果リスト
     */
    public void setBukkenAlertList(List<ReviewBukkenAlertCountDetailView> bukkenAlertList) {
        this.bukkenAlertList = bukkenAlertList;
    }

}
