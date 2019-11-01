package net.chintai.backend.sysadmin.shop_bukken.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 店舗リスティング設定情報
 *
 * @author
 * @version $Revision: $ Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingDeleteView implements ViewHelper {
	private String isWakuDisp;

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

    /** 予約元区分 */
    private String reserveKbn;

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

    /** 店舗リスティング情報リスト */
    private List<ShopListingDeleteDetailView> detailList;

    public class ShopListingDeleteDetailView {

        /** 契約番号 */
        private Long keiyakuNo;

        /** 契約開始日時 */
        private String keiyakuStartDt;

        /** 契約終了日時 */
        private String keiyakuEndDt;

        /** 契約開始日時表示用 */
        private String keiyakuStartYmForDisplay;

        /** 契約終了日時表示用 */
        private String keiyakuEndYmForDisplay;

        /** 更新日時 */
        private String updDt;

        /** 備考 */
        private String keiyakuNote;

        /** 予約元区分 */
        private String reserveKbn;

        /** 物件枠 */
        private String wakuCnt;

        /**
         * 契約番号を返します。
         * @return keiyakuNo
         */
        public Long getKeiyakuNo() {
            return keiyakuNo;
        }

        /**
         * 契約番号を設定します。
         * @param keiyakuNo  契約番号
         */
        public void setKeiyakuNo(Long keiyakuNo) {
            this.keiyakuNo = keiyakuNo;
        }

        /**
         * 契約開始日時を返します。
         * @return 契約開始日時
         */
        public String getKeiyakuStartDt() {
            return keiyakuStartDt;
        }

        /**
         * 契約開始日時を設定します。
         * @param keiyakuStartDt  契約開始日時
         */
        public void setKeiyakuStartDt(String keiyakuStartDt) {
            this.keiyakuStartDt = keiyakuStartDt;
        }

        /**
         * 契約終了日時を返します。
         * @return 契約終了日時
         */
        public String getKeiyakuEndDt() {
            return keiyakuEndDt;
        }

        /**
         * 契約終了日時を設定します。
         * @param keiyakuEndDt  keiyakuEndDt
         */
        public void setKeiyakuEndDt(String keiyakuEndDt) {
            this.keiyakuEndDt = keiyakuEndDt;
        }

        /**
         * 契約開始日時表示用を返します。
         * @return 契約開始日時表示用
         */
        public String getKeiyakuStartYmForDisplay() {
            return keiyakuStartYmForDisplay;
        }

        /**
         * 契約開始日時表示用を設定します。
         * @param keiyakuStartYmForDisplay  契約開始日時表示用
         */
        public void setKeiyakuStartYmForDisplay(String keiyakuStartYmForDisplay) {
            this.keiyakuStartYmForDisplay = keiyakuStartYmForDisplay;
        }

        /**
         * 契約終了日時表示用を返します。
         * @return 契約終了日時表示用
         */
        public String getKeiyakuEndYmForDisplay() {
            return keiyakuEndYmForDisplay;
        }

        /**
         * 契約終了日時表示用を設定します。
         * @param keiyakuEndYmForDisplay  契約終了日時表示用
         */
        public void setKeiyakuEndYmForDisplay(String keiyakuEndYmForDisplay) {
            this.keiyakuEndYmForDisplay = keiyakuEndYmForDisplay;
        }

        /**
         * 最終更新日を取得します。
         * @return 最終更新日
         */
        public String getUpdDt() {
            return updDt;
        }

        /**
         * 最終更新日を設定します。
         * @param updDt 最終更新日
         */
        public void setUpdDt(String updDt) {
            this.updDt = updDt;
        }

        /**
         * 備考を返します。
         * @return 備考
         */
        public String getKeiyakuNote() {
            return keiyakuNote;
        }

        /**
         * 備考を設定します。
         * @param keiyakuNote  備考
         */
        public void setKeiyakuNote(String keiyakuNote) {
            this.keiyakuNote = keiyakuNote;
        }

		public String getReserveKbn() {
			return reserveKbn;
		}

		public void setReserveKbn(String reserveKbn) {
			this.reserveKbn = reserveKbn;
		}

		public String getWakuCnt() {
			return wakuCnt;
		}

		public void setWakuCnt(String wakuCnt) {
			this.wakuCnt = wakuCnt;
		}

    }

    /**
     * 店舗リスティング情報リストを取得します。
     *
     * @return 店舗リスティング情報リスト
     */
    public List<ShopListingDeleteDetailView> getDetailList() {
        return detailList;
    }

    /**
     * 店舗リスティング情報リストを設定します。
     *
     * @param detailList
     *            店舗リスティング情報リスト
     */
    public void setDetailList(List<ShopListingDeleteDetailView> detailList) {
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

	public String getReserveKbn() {
		return reserveKbn;
	}

	public void setReserveKbn(String reserveKbn) {
		this.reserveKbn = reserveKbn;
	}

	public String getIsWakuDisp() {
		return isWakuDisp;
	}

	public void setIsWakuDisp(String isWakuDisp) {
		this.isWakuDisp = isWakuDisp;
	}

}
