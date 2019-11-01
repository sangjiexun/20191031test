package net.chintai.backend.sysadmin.shop_bukken.service.bean;

import java.util.List;

/**
 * 店舗リスティング契約内容
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingInfoOutServiceBean {

    /** 店舗コード */
    private String shopCd;

    /** 契約コード */
    private String keiyakuCd;

    /** 契約オプションコード */
    private String keiyakuSubCd;

    /** 会社名 */
    private String company;

    /** 事務所名 */
    private String bumon;

    /** お客様設定パスワード */
    private String password;

    /** 契約名 */
    private String keiyakuName;

    /** 契約コメント */
    private String keiyakuCommnet;

    /** 契約情報 */
    private List<ShopListingData> lstShopListingData;

    /** 店舗管理テーブル更新日時 */
    private String shopKanriUpdDt;

    /** 枠リスト */
    private List<String> listAmount;

    /** 枠の桁数*/
    private Integer amountLenth;

    /** 枠使用フラグ*/
    private String amountFlg;

    /** テキストボックスフラグ*/
    private String textBoxFlg;

    /** テキストボックス名*/
    private String textBoxName;

    /**
     * 店舗コードを返します。
     * @return 店舗コード
     */
    public String getShopCd() {
        return shopCd;
    }

    /**
     * 店舗コードを設定します。
     * @param shopCd  店舗コード
     */
    public void setShopCd(String shopCd) {
        this.shopCd = shopCd;
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
     * 契約オプションコードを返します。
     * @return 契約オプションコード
     */
    public String getKeiyakuSubCd() {
        return keiyakuSubCd;
    }

    /**
     * 契約オプションコードを設定します。
     * @param keiyakuSubCd  契約オプションコード
     */
    public void setKeiyakuSubCd(String keiyakuSubCd) {
        this.keiyakuSubCd = keiyakuSubCd;
    }

    /**
     * 会社名を返します。
     * @return 会社名
     */
    public String getCompany() {
        return company;
    }

    /**
     * 会社名を設定します。
     * @param company  会社名
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * bumonを返します。
     * @return bumon
     */
    public String getBumon() {
        return bumon;
    }

    /**
     * 事務所名を設定します。
     * @param bumon  事務所名
     */
    public void setBumon(String bumon) {
        this.bumon = bumon;
    }

    /**
     * お客様設定パスワードを返します。
     * @return お客様設定パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * お客様設定パスワードを設定します。
     * @param password  お客様設定パスワード
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
     * 契約コメントを返します。
     * @return 契約コメント
     */
    public String getKeiyakuCommnet() {
        return keiyakuCommnet;
    }

    /**
     * 契約コメントを設定します。
     * @param keiyakuCommnet  契約コメント
     */
    public void setKeiyakuCommnet(String keiyakuCommnet) {
        this.keiyakuCommnet = keiyakuCommnet;
    }

    /**
     * 契約情報を返します。
     * @return 契約情報
     */
    public List<ShopListingData> getLstShopListingData() {
        return lstShopListingData;
    }

    /**
     * 契約情報を設定します。
     * @param lstShopListingData  契約情報
     */
    public void setLstShopListingData(List<ShopListingData> lstShopListingData) {
        this.lstShopListingData = lstShopListingData;
    }

    /**
     * 店舗リスティング詳細情報
     * @author m-kashiyama
     */
    public class ShopListingData{

        /** 契約番号 */
        private Long keiyakuNo;

        /** 契約開始日時 */
        private String keiyakuStartDt;

        /** 契約終了日時 */
        private String keiyakuEndDt;

        /** 更新日時 */
        private String updDt;

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
         * 更新日時を返します。
         * @return updDt
         */
        public String getUpdDt() {
            return updDt;
        }

        /**
         * 更新日時を設定します。
         * @param updDt  更新日時
         */
        public void setUpdDt(String updDt) {
            this.updDt = updDt;
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

	public List<String> getListAmount() {
		return listAmount;
	}

	public void setListAmount(List<String> listAmount) {
		this.listAmount = listAmount;
	}

	public Integer getAmountLenth() {
		return amountLenth;
	}

	public void setAmountLenth(Integer amountLenth) {
		this.amountLenth = amountLenth;
	}

	public String getAmountFlg() {
		return amountFlg;
	}

	public void setAmountFlg(String amountFlg) {
		this.amountFlg = amountFlg;
	}

	public String getTextBoxFlg() {
		return textBoxFlg;
	}

	public void setTextBoxFlg(String textBoxFlg) {
		this.textBoxFlg = textBoxFlg;
	}

	public String getTextBoxName() {
		return textBoxName;
	}

	public void setTextBoxName(String textBoxName) {
		this.textBoxName = textBoxName;
	}
}
