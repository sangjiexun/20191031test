package net.chintai.backend.sysadmin.shop_bukken.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 店舗リスティング表示情報
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingInfoView implements ViewHelper {
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

    /** 店舗リスティング情報リスト */
    private List<ShopListingInfoDetailView> lstShopListingDetail;

    // 店舗リスティング情報格納用InnerClass
    public class ShopListingInfoDetailView {

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

        /** 備考 */
        private String keiyakuNote;

        /** 更新日時 */
        private String updDt;

        /** 適用月フラグ */
        private String appliedFlg;

        /** 削除可能判断フラグ */
        private String delFlg;

        /** リンク表示フラグ */
        private String linkFlg;

        /** 画面戻り先の*/
        private String checkFlg;

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
         * 適用月フラグを取得します。
         * @return 適用月フラグ
         */
        public String getAppliedFlg() {
            return appliedFlg;
        }

        /**
         * 適用月フラグを設定します。
         * @param appliedFlg 適用月フラグ
         */
        public void setAppliedFlg(String appliedFlg) {
            this.appliedFlg = appliedFlg;
        }

        /**
         * 削除可能判断フラグを取得します。
         * @return 削除可能判断フラグ
         */
        public String getDelFlg() {
            return delFlg;
        }

        /**
         * 削除可能判断フラグを設定します。
         * @param delFlg 削除可能判断フラグ
         */
        public void setDelFlg(String delFlg) {
            this.delFlg = delFlg;
        }

        /**
         * リンク表示フラグを取得します。
         * @return リンク表示フラグ
         */
        public String getLinkFlg() {
            return linkFlg;
        }

        /**
         * リンク表示フラグを設定します。
         * @param linkFlg リンク表示フラグ
         */
        public void setLinkFlg(String linkFlg) {
            this.linkFlg = linkFlg;
        }

        /**
         * 画面戻り先の削除フラグを返します。
         * @return 画面戻り先の削除フラグ
         */
        public String getCheckFlg() {
            return checkFlg;
        }

        /**
         * 画面戻り先の削除フラグを設定します。
         * @param checkFlg  画面戻り先の削除フラグ
         */
        public void setCheckFlg(String checkFlg) {
            this.checkFlg = checkFlg;
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
     * お客様設定パスワードを取得します。
     * @return お客様設定パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * お客様設定パスワードを設定します。
     * @param password お客様設定パスワード
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 契約名を返します。
     * @return 契約名
     */
    public String getKeiyakuName() {
        return keiyakuName;
    }

    /**
     * 契約名を設定します。
     * @param keiyakuName  契約名
     */
    public void setKeiyakuName(String keiyakuName) {
        this.keiyakuName = keiyakuName;
    }

    /**
     * 契約コードを返します。
     * @return 契約コード
     */
    public String getKeiyakuCd() {
        return keiyakuCd;
    }

    /**
     * 契約コードを設定します。
     * @param keiyakuCd  契約コード
     */
    public void setKeiyakuCd(String keiyakuCd) {
        this.keiyakuCd = keiyakuCd;
    }

    /**
     * 契約サブコードを返します。
     * @return 契約サブコード
     */
    public String getKeiyakuSubCd() {
        return keiyakuSubCd;
    }

    /**
     * 契約サブコードを設定します。
     * @param keiyakuSubCd  契約サブコード
     */
    public void setKeiyakuSubCd(String keiyakuSubCd) {
        this.keiyakuSubCd = keiyakuSubCd;
    }

    /**
     * 店舗リスティング情報リストを取得します。
     * @return 店舗リスティング情報リスト
     */
    public List<ShopListingInfoDetailView> getLstShopListingDetail() {
        return lstShopListingDetail;
    }

    /**
     * 店舗リスティング情報リストを設定します。
     * @param lstShopListingDetail 店舗リスティング情報リスト
     */
    public void setLstShopListingDetail(List<ShopListingInfoDetailView> lstShopListingDetail) {
        this.lstShopListingDetail = lstShopListingDetail;
    }

	public String getIsWakuDisp() {
		return isWakuDisp;
	}

	public void setIsWakuDisp(String isWakuDisp) {
		this.isWakuDisp = isWakuDisp;
	}

}
