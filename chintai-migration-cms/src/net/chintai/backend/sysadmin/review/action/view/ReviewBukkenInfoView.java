/*
 * $Id: ReviewBukkenInfoView.java 3903 2008-05-27 05:45:13Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/12  BGT)李昊燮     新規作成
 * 2008/05/27  BGT)李昊燮     変数（連続掲載日数、Web審査掲載起算日）追加
 */
package net.chintai.backend.sysadmin.review.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.action.view.BukkenInfoView;
import net.chintai.backend.sysadmin.shop_bukken.action.view.BukkenInfoView.TantouShopListDetailView;

/**
 * 物件詳細ビュー
 *
 * @author Lee Hosup
 * @version $Revision: 3903 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenInfoView extends BukkenInfoView {

    /** 初期審査対象外フラグ */
    private String syokaiSkipFlg;

    /** 定期審査対象外フラグ */
    private String teikiSkipFlg;

    /** 自動削除フラグ */
    private String autoDelSkipflg;

    /** 物件対象外設定備考 */
    private String shinsaSkipBikou;

    /** CHINTAI.NET掲載状況 */
    private String bukkenStatusShinsa;

    /** CHINTAI.NET掲載状況備考 */
    private String shinsaBukkenStatusBikou;

    /** 警告コード */
    private String warningCd;

    /** 状態区分 */
    private String statusKbn;

    /** 処理区分 */
    private String syoriKbn;

    /** 警告日 */
    private String sendDt;

    /** 審査履歴リスト */
    private List<ReviewBukkenInfoDetailView> detailList;

    /** 初回審査自動削除予定日 */
    private String syokaiAutoDelDt;

    /** 定期審査自動削除予定日 */
    private String teikiAutoDelDt;

    /** Web審査掲載起算日 */
    private String shinsaStartDt;

    /** 連続掲載日数 */
    private String elapsedDays;

    private String roomKey;

    private String changeSourceKbn;

    private String ensencd;
    private String otherTransName;
    private String otherTransPlatform;

    /** 店舗リスト（取扱店） */
    private List<TantouShopListDetailView> tantouShopList;

    /**
     * コンストラクター
     */
    public ReviewBukkenInfoView() {
    }

    /**
     * 初期審査対象外フラグを取得します。
     * @return 初期審査対象外フラグ
     */
    public String getSyokaiSkipFlg() {
        return syokaiSkipFlg;
    }

    /**
     * 初期審査対象外フラグを設定します。
     * @param syokaiSkipFlg 初期審査対象外フラグ
     */
    public void setSyokaiSkipFlg(String syokaiSkipFlg) {
        this.syokaiSkipFlg = syokaiSkipFlg;
    }

    /**
     * 定期審査対象外フラグを取得します。
     * @return 定期審査対象外フラグ
     */
    public String getTeikiSkipFlg() {
        return teikiSkipFlg;
    }

    /**
     * 定期審査対象外フラグを設定します。
     * @param teikiSkipFlg 定期審査対象外フラグ
     */
    public void setTeikiSkipFlg(String teikiSkipFlg) {
        this.teikiSkipFlg = teikiSkipFlg;
    }

    /**
     * 自動削除フラグを取得します。
     * @return 自動削除フラグ
     */
    public String getAutoDelSkipflg() {
        return autoDelSkipflg;
    }

    /**
     * 自動削除フラグを設定します。
     * @param autoDelSkipflg 自動削除フラグ
     */
    public void setAutoDelSkipflg(String autoDelSkipflg) {
        this.autoDelSkipflg = autoDelSkipflg;
    }

    /**
     * 物件対象外設定備考を取得します。
     * @return 物件対象外設定備考
     */
    public String getShinsaSkipBikou() {
        return shinsaSkipBikou;
    }

    /**
     * 物件対象外設定備考を設定します。
     * @param shinsaSkipBikou 物件対象外設定備考
     */
    public void setShinsaSkipBikou(String shinsaSkipBikou) {
        this.shinsaSkipBikou = shinsaSkipBikou;
    }

    /**
     * CHINTAI.NET掲載状況を取得します。
     * @return CHINTAI.NET掲載状況
     */
    public String getBukkenStatusShinsa() {
        return bukkenStatusShinsa;
    }

    /**
     * CHINTAI.NET掲載状況を設定します。
     * @param bukkenStatusShinsa CHINTAI.NET掲載状況
     */
    public void setBukkenStatusShinsa(String bukkenStatusShinsa) {
        this.bukkenStatusShinsa = bukkenStatusShinsa;
    }

    /**
     * CHINTAI.NET掲載状況備考を取得します。
     * @return CHINTAI.NET掲載状況備考
     */
    public String getShinsaBukkenStatusBikou() {
        return shinsaBukkenStatusBikou;
    }

    /**
     * CHINTAI.NET掲載状況備考を設定します。
     * @param shinsaBukkenStatusBikou CHINTAI.NET掲載状況備考
     */
    public void setShinsaBukkenStatusBikou(String shinsaBukkenStatusBikou) {
        this.shinsaBukkenStatusBikou = shinsaBukkenStatusBikou;
    }

    /**
     * 警告コードを取得します。
     * @return 警告コード
     */
    public String getWarningCd() {
        return warningCd;
    }

    /**
     * 警告コードを設定します。
     * @param warningCd 警告コード
     */
    public void setWarningCd(String warningCd) {
        this.warningCd = warningCd;
    }

    /**
     * 状態区分を取得します。
     * @return 状態区分
     */
    public String getStatusKbn() {
        return statusKbn;
    }

    /**
     * 状態区分を設定します。
     * @param statusKbn 状態区分
     */
    public void setStatusKbn(String statusKbn) {
        this.statusKbn = statusKbn;
    }

    /**
     * 処理区分を取得します。
     * @return 処理区分
     */
    public String getSyoriKbn() {
        return syoriKbn;
    }

    /**
     * 処理区分を設定します。
     * @param syoriKbn 処理区分
     */
    public void setSyoriKbn(String syoriKbn) {
        this.syoriKbn = syoriKbn;
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

    public class ReviewBukkenInfoDetailView {

        /** 警告日 */
        private String sendDt;

        /** 返信日 */
        private String syoriDt;

        /** 警告内容 */
        private String warningName;

        /** 状態区分 */
        private String statusKbn;

        /** 空室になった年月日 */
        private String vacantYmd;

        /** 新築フラグ */
        private String shinchikuFlg;

        /** 最終条件確認年月日 */
        private String lastConfirmYmd;

        /** 処理区分 */
        private String syoriKbn;

        /** 備考 */
        private String bikou;

        /** Web審査警告履歴連番 */
        private String warningRirekiSeq;

        /** 警告日 */
        private String warningDt;

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
         * 返信日を取得します。
         * @return 返信日
         */
        public String getSyoriDt() {
            return syoriDt;
        }

        /**
         * 返信日を設定します。
         * @param syoriDt 返信日
         */
        public void setSyoriDt(String syoriDt) {
            this.syoriDt = syoriDt;
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
         * 状態区分を取得します。
         * @return 状態区分
         */
        public String getStatusKbn() {
            return statusKbn;
        }

        /**
         * 状態区分を設定します。
         * @param statusKbn 状態区分
         */
        public void setStatusKbn(String statusKbn) {
            this.statusKbn = statusKbn;
        }

        /**
         * 空室になった年月日を取得します。
         * @return 空室になった年月日
         */
        public String getVacantYmd() {
            return vacantYmd;
        }

        /**
         * 空室になった年月日を設定します。
         * @param vacantYmd 空室になった年月日
         */
        public void setVacantYmd(String vacantYmd) {
            this.vacantYmd = vacantYmd;
        }

        /**
         * 新築フラグを取得します。
         * @return 新築フラグ
         */
        public String getShinchikuFlg() {
            return shinchikuFlg;
        }

        /**
         * 新築フラグを設定します。
         * @param shinchikuFlg 新築フラグ
         */
        public void setShinchikuFlg(String shinchikuFlg) {
            this.shinchikuFlg = shinchikuFlg;
        }

        /**
         * 最終条件確認年月日を取得します。
         * @return 最終条件確認年月日
         */
        public String getLastConfirmYmd() {
            return lastConfirmYmd;
        }

        /**
         * 最終条件確認年月日を設定します。
         * @param lastConfirmYmd 最終条件確認年月日
         */
        public void setLastConfirmYmd(String lastConfirmYmd) {
            this.lastConfirmYmd = lastConfirmYmd;
        }

        /**
         * 処理区分を取得します。
         * @return 処理区分
         */
        public String getSyoriKbn() {
            return syoriKbn;
        }

        /**
         * 処理区分を設定します。
         * @param syoriKbn 処理区分
         */
        public void setSyoriKbn(String syoriKbn) {
            this.syoriKbn = syoriKbn;
        }

        /**
         * 備考を取得します。
         * @return 備考
         */
        public String getBikou() {
            return bikou;
        }

        /**
         * 備考を設定します。
         * @param bikou 備考
         */
        public void setBikou(String bikou) {
            this.bikou = bikou;
        }

        /**
         * Web審査警告履歴連番を取得します。
         * @return Web審査警告履歴連番
         */
        public String getWarningRirekiSeq() {
            return warningRirekiSeq;
        }

        /**
         * Web審査警告履歴連番を設定します。
         * @param warningRirekiSeq Web審査警告履歴連番
         */
        public void setWarningRirekiSeq(String warningRirekiSeq) {
            this.warningRirekiSeq = warningRirekiSeq;
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

    }

    /**
     * 審査履歴リストを取得します。
     * @return 審査履歴リスト
     */
    public List<ReviewBukkenInfoDetailView> getDetailList() {
        return detailList;
    }

    /**
     * 審査履歴リストを設定します。
     * @param detailList 審査履歴リスト
     */
    public void setDetailList(List<ReviewBukkenInfoDetailView> detailList) {
        this.detailList = detailList;
    }

    /**
     * 初回審査自動削除予定日を取得します。
     * @return 初回審査自動削除予定日
     */
    public String getSyokaiAutoDelDt() {
        return syokaiAutoDelDt;
    }

    /**
     * 初回審査自動削除予定日を設定します。
     * @param syokaiAutoDelDt 初回審査自動削除予定日
     */
    public void setSyokaiAutoDelDt(String syokaiAutoDelDt) {
        this.syokaiAutoDelDt = syokaiAutoDelDt;
    }

    /**
     * 定期審査自動削除予定日を取得します。
     * @return 定期審査自動削除予定日
     */
    public String getTeikiAutoDelDt() {
        return teikiAutoDelDt;
    }

    /**
     * 定期審査自動削除予定日を設定します。
     * @param teikiAutoDelDt 定期審査自動削除予定日
     */
    public void setTeikiAutoDelDt(String teikiAutoDelDt) {
        this.teikiAutoDelDt = teikiAutoDelDt;
    }

    /**
     * 連続掲載日数を取得します。
     * @return 連続掲載日数
     */
    public String getElapsedDays() {
        return elapsedDays;
    }

    /**
	 * @return tantouShopList
	 */
	public List<TantouShopListDetailView> getTantouShopList() {
		return tantouShopList;
	}

	/**
	 * @param tantouShopList セットする tantouShopList
	 */
	public void setTantouShopList(List<TantouShopListDetailView> tantouShopList) {
		this.tantouShopList = tantouShopList;
	}

	/**
     * 連続掲載日数を設定します。
     * @param elapsedDays 連続掲載日数
     */
    public void setElapsedDays(String elapsedDays) {
        this.elapsedDays = elapsedDays;
    }

    /**
     * Web審査掲載起算日を取得します。
     * @return Web審査掲載起算日
     */
    public String getShinsaStartDt() {
        return shinsaStartDt;
    }

    /**
     * Web審査掲載起算日を設定します。
     * @param shinsaStartDt Web審査掲載起算日
     */
    public void setShinsaStartDt(String shinsaStartDt) {
        this.shinsaStartDt = shinsaStartDt;
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
	 * @return ensencd
	 */
	public String getEnsencd() {
		return ensencd;
	}

	/**
	 * @param ensencd セットする ensencd
	 */
	public void setEnsencd(String ensencd) {
		this.ensencd = ensencd;
	}

	/**
	 * @return otherTransName
	 */
	public String getOtherTransName() {
		return otherTransName;
	}

	/**
	 * @param otherTransName セットする otherTransName
	 */
	public void setOtherTransName(String otherTransName) {
		this.otherTransName = otherTransName;
	}

	/**
	 * @return otherTransPlatform
	 */
	public String getOtherTransPlatform() {
		return otherTransPlatform;
	}

	/**
	 * @param otherTransPlatform セットする otherTransPlatform
	 */
	public void setOtherTransPlatform(String otherTransPlatform) {
		this.otherTransPlatform = otherTransPlatform;
	}

}
