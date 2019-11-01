package net.chintai.backend.sysadmin.shop_bukken.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 契約明細詳細(契約数量あり)情報
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountInfoView implements ViewHelper {

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

    /** 物件枠情報リスト */
    private List<ContractAmountInfoDetailView> wakuInfoList;

    // 物件枠情報格納用InnerClass
    public class ContractAmountInfoDetailView {

        /** 物件枠 */
        private String wakuCnt;

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

		public String getWakuCnt() {
			return wakuCnt;
		}

		public void setWakuCnt(String wakuCnt) {
			this.wakuCnt = wakuCnt;
		}

		public Long getKeiyakuNo() {
			return keiyakuNo;
		}

		public void setKeiyakuNo(Long keiyakuNo) {
			this.keiyakuNo = keiyakuNo;
		}

		public String getKeiyakuStartDt() {
			return keiyakuStartDt;
		}

		public void setKeiyakuStartDt(String keiyakuStartDt) {
			this.keiyakuStartDt = keiyakuStartDt;
		}

		public String getKeiyakuEndDt() {
			return keiyakuEndDt;
		}

		public void setKeiyakuEndDt(String keiyakuEndDt) {
			this.keiyakuEndDt = keiyakuEndDt;
		}

		public String getKeiyakuStartYmForDisplay() {
			return keiyakuStartYmForDisplay;
		}

		public void setKeiyakuStartYmForDisplay(String keiyakuStartYmForDisplay) {
			this.keiyakuStartYmForDisplay = keiyakuStartYmForDisplay;
		}

		public String getKeiyakuEndYmForDisplay() {
			return keiyakuEndYmForDisplay;
		}

		public void setKeiyakuEndYmForDisplay(String keiyakuEndYmForDisplay) {
			this.keiyakuEndYmForDisplay = keiyakuEndYmForDisplay;
		}

		public String getKeiyakuNote() {
			return keiyakuNote;
		}

		public void setKeiyakuNote(String keiyakuNote) {
			this.keiyakuNote = keiyakuNote;
		}

		public String getUpdDt() {
			return updDt;
		}

		public void setUpdDt(String updDt) {
			this.updDt = updDt;
		}

		public String getAppliedFlg() {
			return appliedFlg;
		}

		public void setAppliedFlg(String appliedFlg) {
			this.appliedFlg = appliedFlg;
		}

		public String getDelFlg() {
			return delFlg;
		}

		public void setDelFlg(String delFlg) {
			this.delFlg = delFlg;
		}

		public String getLinkFlg() {
			return linkFlg;
		}

		public void setLinkFlg(String linkFlg) {
			this.linkFlg = linkFlg;
		}

		public String getCheckFlg() {
			return checkFlg;
		}

		public void setCheckFlg(String checkFlg) {
			this.checkFlg = checkFlg;
		}

		public String getReserveKbn() {
			return reserveKbn;
		}

		public void setReserveKbn(String reserveKbn) {
			this.reserveKbn = reserveKbn;
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
     * 物件枠情報リストを取得します。
     * @return 物件枠情報リスト
     */
    public List<ContractAmountInfoDetailView> getWakuInfoList() {
        return wakuInfoList;
    }

    /**
     * 物件枠情報リストを設定します。
     * @param wakuInfoList 物件枠情報リスト
     */
    public void setWakuInfoList(List<ContractAmountInfoDetailView> wakuInfoList) {
        this.wakuInfoList = wakuInfoList;
    }
}
