/*
 * $Id: ReviewBukkenSearchView.java 3904 2008-05-27 05:49:28Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/12  BGT)李昊燮     新規作成
 * 2008/05/27  BGT)李昊燮     変数名ctStatus/ablStatusをctFlg/ablFlgに修正
 *                            変数（連続掲載日数、Web審査掲載起算日）追加
 */
package net.chintai.backend.sysadmin.review.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.PagerCondition;
import net.chintai.backend.sysadmin.common.pager.PagerViewHelper;

/**
 * 物件検索結果一覧用
 * @author Lee Hosup
 * @version $Revision: 3904 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenSearchView extends PagerViewHelper {
	/** 部屋キー */
    private String roomKey;

    /** 店舗コード */
    private String shopCd;

    /** 会社名/事務所名 */
    private String companyBumon;

    /** 状態 */
    private String shopStatus;

    /** 物件コード (物件) */
    private String bkCd;

    /** 部屋連番 */
    private String roomNo;

    /** 問い合せ番号 */
    private String uketsukeCd;

    /** 都道府県 */
    private String prefCd;

    /** 警告日(下限) */
    private String sendDtFrom;

    /** 警告日(上限) */
    private String sendDtTo;

    /** 警告日(年)(上限) */
    private String fromYear;

    /** 警告日(月)(上限) */
    private String fromMonth;

    /** 警告日(日)(上限) */
    private String fromDay;

    /** 警告日(年)(下限) */
    private String toYear;

    /** 警告日(月)(下限) */
    private String toMonth;

    /** 警告日(日)(下限) */
    private String toDay;

    /** 平均家賃基準該当物件(返信なし) */
    private String warningCd01statusKbn01;

    /** 平均家賃基準該当物件(返信あり:非公開) */
    private String warningCd01statusKbn02;

    /** 平均家賃基準該当物件(返信なし:問題なし) */
    private String warningCd01statusKbn03;

    /** 平均家賃基準該当物件(警告対象外) */
    private String warningCd01statusKbn04;

    /** 連続掲載該当物件(返信なし) */
    private String warningCd02statusKbn01;

    /** 連続掲載該当物件(返信あり:非公開) */
    private String warningCd02statusKbn02;

    /** 連続掲載該当物件(返信なし:問題なし) */
    private String warningCd02statusKbn03;

    /** 連続掲載該当物件(警告対象外) */
    private String warningCd02statusKbn04;

    /** 連続掲載かつアクセス該当物件(返信なし) */
    private String warningCd03statusKbn01;

    /** 連続掲載かつアクセス該当物件(返信あり:非公開) */
    private String warningCd03statusKbn02;

    /** 連続掲載かつアクセス該当物件(返信なし:問題なし) */
    private String warningCd03statusKbn03;

    /** 連続掲載かつアクセス該当物件(警告対象外) */
    private String warningCd03statusKbn04;

    /** 連続掲載日数(下限) */
    private String shinsaStartDtFrom;

    /** 連続掲載日数(上限) */
    private String shinsaStartDtTo;

    private String rendoName;


    /** 検索結果リスト */
    private List<ReviewBukkenSearchDetailView> bukkenList;

    /**
     * コンストラクター
     * @param condition
     */
    public ReviewBukkenSearchView(PagerCondition condition) {
        super(condition);
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
     * 状態を取得します。
     * @return 状態
     */
    public String getShopStatus() {
        return shopStatus;
    }

    /**
     * 状態を設定します。
     * @param shopStatus 状態
     */
    public void setShopStatus(String shopStatus) {
        this.shopStatus = shopStatus;
    }

    /**
     * 物件コード (物件)を取得します。
     * @return 物件コード (物件)
     */
    public String getBkCd() {
        return bkCd;
    }

    /**
     * 物件コード (物件)を設定します。
     * @param bkCd 物件コード (物件)
     */
    public void setBkCd(String bkCd) {
        this.bkCd = bkCd;
    }

    /**
     * 部屋連番を取得します。
     * @return 部屋連番
     */
    public String getRoomNo() {
        return roomNo;
    }

    /**
     * 部屋連番を設定します。
     * @param roomNo 部屋連番
     */
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    /**
     * 問い合せ番号を取得します。
     * @return 問い合せ番号
     */
    public String getUketsukeCd() {
        return uketsukeCd;
    }

    /**
     * 問い合せ番号を設定します。
     * @param uketsukeCd 問い合せ番号
     */
    public void setUketsukeCd(String uketsukeCd) {
        this.uketsukeCd = uketsukeCd;
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
     * 警告日(下限)を取得します。
     * @return 警告日(下限)
     */
    public String getSendDtFrom() {
        return sendDtFrom;
    }

    /**
     * 警告日(下限)を設定します。
     * @param sendDtFrom 警告日(下限)
     */
    public void setSendDtFrom(String sendDtFrom) {
        this.sendDtFrom = sendDtFrom;
    }

    /**
     * 警告日(上限)を取得します。
     * @return 警告日(上限)
     */
    public String getSendDtTo() {
        return sendDtTo;
    }

    /**
     * 警告日(上限)を設定します。
     * @param sendDtTo 警告日(上限)
     */
    public void setSendDtTo(String sendDtTo) {
        this.sendDtTo = sendDtTo;
    }

    /**
     * 警告日(年)(上限)を取得します。
     * @return 警告日(年)(上限)
     */
    public String getFromYear() {
        return fromYear;
    }

    /**
     * 警告日(年)(上限)を設定します。
     * @param fromYear 警告日(年)(上限)
     */
    public void setFromYear(String fromYear) {
        this.fromYear = fromYear;
    }

    /**
     * 警告日(月)(上限)を取得します。
     * @return 警告日(月)(上限)
     */
    public String getFromMonth() {
        return fromMonth;
    }

    /**
     * 警告日(月)(上限)を設定します。
     * @param fromMonth 警告日(月)(上限)
     */
    public void setFromMonth(String fromMonth) {
        this.fromMonth = fromMonth;
    }

    /**
     * 警告日(日)(上限)を取得します。
     * @return 警告日(日)(上限)
     */
    public String getFromDay() {
        return fromDay;
    }

    /**
     * 警告日(日)(上限)を設定します。
     * @param fromDay 警告日(日)(上限)
     */
    public void setFromDay(String fromDay) {
        this.fromDay = fromDay;
    }

    /**
     * 警告日(年)(下限)を取得します。
     * @return 警告日(年)(下限)
     */
    public String getToYear() {
        return toYear;
    }

    /**
     * 警告日(年)(下限)を設定します。
     * @param toYear 警告日(年)(下限)
     */
    public void setToYear(String toYear) {
        this.toYear = toYear;
    }

    /**
     * 警告日(月)(下限)を取得します。
     * @return 警告日(月)(下限)
     */
    public String getToMonth() {
        return toMonth;
    }

    /**
     * 警告日(月)(下限)を設定します。
     * @param toMonth 警告日(月)(下限)
     */
    public void setToMonth(String toMonth) {
        this.toMonth = toMonth;
    }

    /**
     * 警告日(日)(下限)を取得します。
     * @return 警告日(日)(下限)
     */
    public String getToDay() {
        return toDay;
    }

    /**
     * 警告日(日)(下限)を設定します。
     * @param toDay 警告日(日)(下限)
     */
    public void setToDay(String toDay) {
        this.toDay = toDay;
    }

    /**
     * 平均家賃基準該当物件(返信なし)を取得します。
     * @return 平均家賃基準該当物件(返信なし)
     */
    public String getWarningCd01statusKbn01() {
        return warningCd01statusKbn01;
    }

    /**
     * 平均家賃基準該当物件(返信なし)を設定します。
     * @param warningCd01statusKbn01 平均家賃基準該当物件(返信なし)
     */
    public void setWarningCd01statusKbn01(String warningCd01statusKbn01) {
        this.warningCd01statusKbn01 = warningCd01statusKbn01;
    }

    /**
     * 平均家賃基準該当物件(返信あり:非公開)を取得します。
     * @return 平均家賃基準該当物件(返信あり:非公開)
     */
    public String getWarningCd01statusKbn02() {
        return warningCd01statusKbn02;
    }

    /**
     * 平均家賃基準該当物件(返信あり:非公開)を設定します。
     * @param warningCd01statusKbn02 平均家賃基準該当物件(返信あり:非公開)
     */
    public void setWarningCd01statusKbn02(String warningCd01statusKbn02) {
        this.warningCd01statusKbn02 = warningCd01statusKbn02;
    }

    /**
     * 平均家賃基準該当物件(返信なし:問題なし)を取得します。
     * @return 平均家賃基準該当物件(返信なし:問題なし)
     */
    public String getWarningCd01statusKbn03() {
        return warningCd01statusKbn03;
    }

    /**
     * 平均家賃基準該当物件(返信なし:問題なし)を設定します。
     * @param warningCd01statusKbn03 平均家賃基準該当物件(返信なし:問題なし)
     */
    public void setWarningCd01statusKbn03(String warningCd01statusKbn03) {
        this.warningCd01statusKbn03 = warningCd01statusKbn03;
    }

    /**
     * 平均家賃基準該当物件(警告対象外)を取得します。
     * @return 平均家賃基準該当物件(警告対象外)
     */
    public String getWarningCd01statusKbn04() {
        return warningCd01statusKbn04;
    }

    /**
     * 平均家賃基準該当物件(警告対象外)を設定します。
     * @param warningCd01statusKbn04 平均家賃基準該当物件(警告対象外)
     */
    public void setWarningCd01statusKbn04(String warningCd01statusKbn04) {
        this.warningCd01statusKbn04 = warningCd01statusKbn04;
    }

    /**
     * 連続掲載該当物件(返信なし)を取得します。
     * @return 連続掲載該当物件(返信なし)
     */
    public String getWarningCd02statusKbn01() {
        return warningCd02statusKbn01;
    }

    /**
     * 連続掲載該当物件(返信なし)を設定します。
     * @param warningCd02statusKbn01 連続掲載該当物件(返信なし)
     */
    public void setWarningCd02statusKbn01(String warningCd02statusKbn01) {
        this.warningCd02statusKbn01 = warningCd02statusKbn01;
    }

    /**
     * 連続掲載該当物件(返信あり:非公開)を取得します。
     * @return 連続掲載該当物件(返信あり:非公開)
     */
    public String getWarningCd02statusKbn02() {
        return warningCd02statusKbn02;
    }

    /**
     * 連続掲載該当物件(返信あり:非公開)を設定します。
     * @param warningCd02statusKbn02 連続掲載該当物件(返信あり:非公開)
     */
    public void setWarningCd02statusKbn02(String warningCd02statusKbn02) {
        this.warningCd02statusKbn02 = warningCd02statusKbn02;
    }

    /**
     * 連続掲載該当物件(返信なし:問題なし)を取得します。
     * @return 連続掲載該当物件(返信なし:問題なし)
     */
    public String getWarningCd02statusKbn03() {
        return warningCd02statusKbn03;
    }

    /**
     * 連続掲載該当物件(返信なし:問題なし)を設定します。
     * @param warningCd02statusKbn03 連続掲載該当物件(返信なし:問題なし)
     */
    public void setWarningCd02statusKbn03(String warningCd02statusKbn03) {
        this.warningCd02statusKbn03 = warningCd02statusKbn03;
    }

    /**
     * 連続掲載該当物件(警告対象外)を取得します。
     * @return 連続掲載該当物件(警告対象外)
     */
    public String getWarningCd02statusKbn04() {
        return warningCd02statusKbn04;
    }

    /**
     * 連続掲載該当物件(警告対象外)を設定します。
     * @param warningCd02statusKbn04 連続掲載該当物件(警告対象外)
     */
    public void setWarningCd02statusKbn04(String warningCd02statusKbn04) {
        this.warningCd02statusKbn04 = warningCd02statusKbn04;
    }

    /**
     * 連続掲載かつアクセス該当物件(返信なし)を取得します。
     * @return 連続掲載かつアクセス該当物件(返信なし)
     */
    public String getWarningCd03statusKbn01() {
        return warningCd03statusKbn01;
    }

    /**
     * 連続掲載かつアクセス該当物件(返信なし)を設定します。
     * @param warningCd03statusKbn01 連続掲載かつアクセス該当物件(返信なし)
     */
    public void setWarningCd03statusKbn01(String warningCd03statusKbn01) {
        this.warningCd03statusKbn01 = warningCd03statusKbn01;
    }

    /**
     * 連続掲載かつアクセス該当物件(返信あり:非公開)を取得します。
     * @return 連続掲載かつアクセス該当物件(返信あり:非公開)
     */
    public String getWarningCd03statusKbn02() {
        return warningCd03statusKbn02;
    }

    /**
     * 連続掲載かつアクセス該当物件(返信あり:非公開)を設定します。
     * @param warningCd03statusKbn02 連続掲載かつアクセス該当物件(返信あり:非公開)
     */
    public void setWarningCd03statusKbn02(String warningCd03statusKbn02) {
        this.warningCd03statusKbn02 = warningCd03statusKbn02;
    }

    /**
     * 連続掲載かつアクセス該当物件(返信なし:問題なし)を取得します。
     * @return 連続掲載かつアクセス該当物件(返信なし:問題なし)
     */
    public String getWarningCd03statusKbn03() {
        return warningCd03statusKbn03;
    }

    /**
     * 連続掲載かつアクセス該当物件(返信なし:問題なし)を設定します。
     * @param warningCd03statusKbn03 連続掲載かつアクセス該当物件(返信なし:問題なし)
     */
    public void setWarningCd03statusKbn03(String warningCd03statusKbn03) {
        this.warningCd03statusKbn03 = warningCd03statusKbn03;
    }

    /**
     * 連続掲載かつアクセス該当物件(警告対象外)を取得します。
     * @return 連続掲載かつアクセス該当物件(警告対象外)
     */
    public String getWarningCd03statusKbn04() {
        return warningCd03statusKbn04;
    }

    /**
     * 連続掲載かつアクセス該当物件(警告対象外)を設定します。
     * @param warningCd03statusKbn04 連続掲載かつアクセス該当物件(警告対象外)
     */
    public void setWarningCd03statusKbn04(String warningCd03statusKbn04) {
        this.warningCd03statusKbn04 = warningCd03statusKbn04;
    }

    /**
     * 連続掲載日数(下限)を取得します。
     * @return 連続掲載日数(下限)
     */
    public String getShinsaStartDtFrom() {
        return shinsaStartDtFrom;
    }


    /**
     * 連続掲載日数(下限)を設定します。
     * @param shinsaStartDtFrom 連続掲載日数(下限)
     */
    public void setShinsaStartDtFrom(String shinsaStartDtFrom) {
        this.shinsaStartDtFrom = shinsaStartDtFrom;
    }


    /**
     * 連続掲載日数(上限)を取得します。
     * @return 連続掲載日数(上限)
     */
    public String getShinsaStartDtTo() {
        return shinsaStartDtTo;
    }


    /**
     * 連続掲載日数(上限)を設定します。
     * @param shinsaStartDtTo 連続掲載日数(上限)
     */
    public void setShinsaStartDtTo(String shinsaStartDtTo) {
        this.shinsaStartDtTo = shinsaStartDtTo;
    }


    public class ReviewBukkenSearchDetailView {
    	/** 部屋キー */
        private String roomKey;

        /** 管理コード */
        private String kanriCd;

        /** 状態 */
        private String bkStatus;

        /** 問い合せ番号 */
        private String uketsukeCd;

        /** 店舗コード */
        private String shopCd;

        /** 物件コード (物件) */
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

        /** 連絡方法 */
        private String fmKbn;

        /** 初回審査(物件対象外設定) */
        private String syokaiShinsaSkipFlg;

        /** 定期審査(物件対象外設定) */
        private String teikiShinsaSkipFlg;

        /** 自動削除(物件対象外設定) */
        private String autoDelSkipFlg;

        /** CHINTAI.NET掲載状態 */
        private String bukkenStatusShinsa;

        /** 警告対象(初回審査) */
        private String syokaiWarningCd;

        /** 返信内容(初回審査) */
        private String syokaiSyoriKbn;

        /** 警告対象(定期審査) */
        private String teikiWarningCd;

        /** 返信内容(定期審査) */
        private String teikiSyoriKbn;

        /** 連続掲載日数 */
        private String elapsedDays ;

        /** ＣＨＩＮＴＡＩ掲載停止日時 */
        private String ctStopDt;

        /** エイブル掲載停止日時 */
        private String ablStopDt;

        private String funcId;

        private String ctStatus;

        private String ablStatus;

        private String changeSourceKbn;

        private String rendoName;

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
         * 管理コードを取得します。
         * @return 管理コード
         */
        public String getKanriCd() {
            return kanriCd;
        }

        /**
         * 管理コードを設定します。
         * @param kanriCd 管理コード
         */
        public void setKanriCd(String kanriCd) {
            this.kanriCd = kanriCd;
        }

        /**
         * 状態を取得します。
         * @return 状態
         */
        public String getBkStatus() {
            return bkStatus;
        }

        /**
         * 状態を設定します。
         * @param bkStatus 状態
         */
        public void setBkStatus(String bkStatus) {
            this.bkStatus = bkStatus;
        }

        /**
         * 問い合せ番号を取得します。
         * @return 問い合せ番号
         */
        public String getUketsukeCd() {
            return uketsukeCd;
        }

        /**
         * 問い合せ番号を設定します。
         * @param uketsukeCd 問い合せ番号
         */
        public void setUketsukeCd(String uketsukeCd) {
            this.uketsukeCd = uketsukeCd;
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
         * 物件コード (物件)を取得します。
         * @return 物件コード (物件)
         */
        public String getShopStatus() {
            return shopStatus;
        }

        /**
         * 物件コード (物件)を設定します。
         * @param shopStatus 物件コード (物件)
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
         * 連絡方法を取得します。
         * @return 連絡方法
         */
        public String getFmKbn() {
            return fmKbn;
        }

        /**
         * 連絡方法を設定します。
         * @param fmKbn 連絡方法
         */
        public void setFmKbn(String fmKbn) {
            this.fmKbn = fmKbn;
        }

        /**
         * 初回審査(物件対象外設定)を取得します。
         * @return 初回審査(物件対象外設定)
         */
        public String getSyokaiShinsaSkipFlg() {
            return syokaiShinsaSkipFlg;
        }

        /**
         * 初回審査(物件対象外設定)を設定します。
         * @param syokaiShinsaSkipFlg 初回審査(物件対象外設定)
         */
        public void setSyokaiShinsaSkipFlg(String syokaiShinsaSkipFlg) {
            this.syokaiShinsaSkipFlg = syokaiShinsaSkipFlg;
        }

        /**
         * 定期審査(物件対象外設定)を取得します。
         * @return 定期審査(物件対象外設定)
         */
        public String getTeikiShinsaSkipFlg() {
            return teikiShinsaSkipFlg;
        }

        /**
         * 定期審査(物件対象外設定)を設定します。
         * @param teikiShinsaSkipFlg 定期審査(物件対象外設定)
         */
        public void setTeikiShinsaSkipFlg(String teikiShinsaSkipFlg) {
            this.teikiShinsaSkipFlg = teikiShinsaSkipFlg;
        }

        /**
         * 自動削除(物件対象外設定)を取得します。
         * @return 自動削除(物件対象外設定)
         */
        public String getAutoDelSkipFlg() {
            return autoDelSkipFlg;
        }

        /**
         * 自動削除(物件対象外設定)を設定します。
         * @param autoDelSkipFlg 自動削除(物件対象外設定)
         */
        public void setAutoDelSkipFlg(String autoDelSkipFlg) {
            this.autoDelSkipFlg = autoDelSkipFlg;
        }

        /**
         * CHINTAI.NET掲載状態を取得します。
         * @return CHINTAI.NET掲載状態
         */
        public String getBukkenStatusShinsa() {
            return bukkenStatusShinsa;
        }

        /**
         * CHINTAI.NET掲載状態を設定します。
         * @param bukkenStatusShinsa CHINTAI.NET掲載状態
         */
        public void setBukkenStatusShinsa(String bukkenStatusShinsa) {
            this.bukkenStatusShinsa = bukkenStatusShinsa;
        }

        /**
         * 警告対象(初回審査)を取得します。
         * @return 警告対象(初回審査)
         */
        public String getSyokaiWarningCd() {
            return syokaiWarningCd;
        }

        /**
         * 警告対象(初回審査)を設定します。
         * @param syokaiWarningCd 警告対象(初回審査)
         */
        public void setSyokaiWarningCd(String syokaiWarningCd) {
            this.syokaiWarningCd = syokaiWarningCd;
        }

        /**
         * 返信内容(初回審査)を取得します。
         * @return 返信内容(初回審査)
         */
        public String getSyokaiSyoriKbn() {
            return syokaiSyoriKbn;
        }

        /**
         * 返信内容(初回審査)を設定します。
         * @param syokaiSyoriKbn 返信内容(初回審査)
         */
        public void setSyokaiSyoriKbn(String syokaiSyoriKbn) {
            this.syokaiSyoriKbn = syokaiSyoriKbn;
        }

        /**
         * 警告対象(定期審査)を取得します。
         * @return 警告対象(定期審査)
         */
        public String getTeikiWarningCd() {
            return teikiWarningCd;
        }

        /**
         * 警告対象(定期審査)を設定します。
         * @param teikiWarningCd 警告対象(定期審査)
         */
        public void setTeikiWarningCd(String teikiWarningCd) {
            this.teikiWarningCd = teikiWarningCd;
        }

        /**
         * 返信内容(定期審査)を取得します。
         * @return 返信内容(定期審査)
         */
        public String getTeikiSyoriKbn() {
            return teikiSyoriKbn;
        }

        /**
         * 返信内容(定期審査)を設定します。
         * @param teikiSyoriKbn 返信内容(定期審査)
         */
        public void setTeikiSyoriKbn(String teikiSyoriKbn) {
            this.teikiSyoriKbn = teikiSyoriKbn;
        }

        /**
         * 連続掲載日数を取得します。
         * @return 連続掲載日数
         */
        public String getElapsedDays() {
            return elapsedDays;
        }

        /**
         * 連続掲載日数を設定します。
         * @param elapsedDays 連続掲載日数
         */
        public void setElapsedDays(String elapsedDays) {
            this.elapsedDays = elapsedDays;
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
		 * @return ctStopDt
		 */
		public String getCtStopDt() {
			return ctStopDt;
		}

		/**
		 * @param ctStopDt セットする ctStopDt
		 */
		public void setCtStopDt(String ctStopDt) {
			this.ctStopDt = ctStopDt;
		}

		/**
		 * @return ablStopDt
		 */
		public String getAblStopDt() {
			return ablStopDt;
		}

		/**
		 * @param ablStopDt セットする ablStopDt
		 */
		public void setAblStopDt(String ablStopDt) {
			this.ablStopDt = ablStopDt;
		}

		/**
		 * @return funcId
		 */
		public String getFuncId() {
			return funcId;
		}

		/**
		 * @param funcId セットする funcId
		 */
		public void setFuncId(String funcId) {
			this.funcId = funcId;
		}

		/**
		 * @return roomKey
		 */
		public String getRoomKey() {
			return roomKey;
		}

		/**
		 * @param roomKey セットする roomKey
		 */
		public void setRoomKey(String roomKey) {
			this.roomKey = roomKey;
		}

		/**
		 * @return changeSourceKbn
		 */
		public String getChangeSourceKbn() {
			return changeSourceKbn;
		}

		/**
		 * @param changeSourceKbn セットする changeSourceKbn
		 */
		public void setChangeSourceKbn(String changeSourceKbn) {
			this.changeSourceKbn = changeSourceKbn;
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
    public List<ReviewBukkenSearchDetailView> getBukkenList() {
        return bukkenList;
    }

    /**
     * 検索結果リストを設定します。
     * @param bukkenList 検索結果リスト
     */
    public void setBukkenList(List<ReviewBukkenSearchDetailView> bukkenList) {
        this.bukkenList = bukkenList;
    }

	/**
	 * @return roomKey
	 */
	public String getRoomKey() {
		return roomKey;
	}

	/**
	 * @param roomKey セットする roomKey
	 */
	public void setRoomKey(String roomKey) {
		this.roomKey = roomKey;
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
