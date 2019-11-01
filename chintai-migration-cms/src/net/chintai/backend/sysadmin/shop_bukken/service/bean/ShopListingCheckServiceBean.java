package net.chintai.backend.sysadmin.shop_bukken.service.bean;

/**
 * 店舗リスティング設定情報チェック確認
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingCheckServiceBean {
    /** 店舗コード  */
    private String shopCd;

    /** 契約コード */
    private String keiyakuCd;

    /** 契約サブコード  */
    private String keiyakuSubCd;

    /** 契約開始日時(年) */
    private String keiyakuStartYear;

    /** 契約開始日時(月) */
    private String keiyakuStartMonth;

    /** 契約開始日時(日) */
    private String keiyakuStartDay;

    /** 契約開始日時(時) */
    private String keiyakuStartHour;

    /** 契約開始日時(分) */
    private String keiyakuStartMinute;

    /** 契約開始日時(秒) */
    private String keiyakuStartSecond;

    /** 契約終了日時(年) */
    private String keiyakuEndYear;

    /** 契約終了日時(月) */
    private String keiyakuEndMonth;

    /** 契約終了日時(日) */
    private String keiyakuEndDay;

    /** 契約終了日時(時) */
    private String keiyakuEndHour;

    /** 契約終了日時(分) */
    private String keiyakuEndMinute;

    /** 契約終了日時(秒) */
    private String keiyakuEndSecond;


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
     * 契約開始日時(年)を返します。
     * @return 契約開始日時(年)
     */
    public String getKeiyakuStartYear() {
        return keiyakuStartYear;
    }

    /**
     * 契約開始日時(年)を設定します。
     * @param keiyakuStartYear  契約開始日時(年)
     */
    public void setKeiyakuStartYear(String keiyakuStartYear) {
        this.keiyakuStartYear = keiyakuStartYear;
    }

    /**
     * 契約開始日時(月)を返します。
     * @return 契約開始日時(月)
     */
    public String getKeiyakuStartMonth() {
        return keiyakuStartMonth;
    }

    /**
     * 契約開始日時(月)を設定します。
     * @param keiyakuStartMonth  契約開始日時(月)
     */
    public void setKeiyakuStartMonth(String keiyakuStartMonth) {
        this.keiyakuStartMonth = keiyakuStartMonth;
    }

    /**
     * 契約開始日時(日) を返します。
     * @return 契約開始日時(日)
     */
    public String getKeiyakuStartDay() {
        return keiyakuStartDay;
    }

    /**
     * 契約開始日時(日) を設定します。
     * @param keiyakuStartDay  契約開始日時(日)
     */
    public void setKeiyakuStartDay(String keiyakuStartDay) {
        this.keiyakuStartDay = keiyakuStartDay;
    }

    /**
     * 契約開始日時(時)を返します。
     * @return 契約開始日時(時)
     */
    public String getKeiyakuStartHour() {
        return keiyakuStartHour;
    }

    /**
     * 契約開始日時(時)を設定します。
     * @param keiyakuStartHour  契約開始日時(時)
     */
    public void setKeiyakuStartHour(String keiyakuStartHour) {
        this.keiyakuStartHour = keiyakuStartHour;
    }

    /**
     * 契約終了日時(年)を返します。
     * @return 契約終了日時(年)
     */
    public String getKeiyakuEndYear() {
        return keiyakuEndYear;
    }

    /**
     * 契約終了日時(年)を設定します。
     * @param keiyakuEndYear  契約終了日時(年)
     */
    public void setKeiyakuEndYear(String keiyakuEndYear) {
        this.keiyakuEndYear = keiyakuEndYear;
    }

    /**
     * 契約終了日時(月)を返します。
     * @return keiyakuEndMonth
     */
    public String getKeiyakuEndMonth() {
        return keiyakuEndMonth;
    }

    /**
     * 契約終了日時(月)を設定します。
     * @param keiyakuEndMonth  契約終了日時(月)
     */
    public void setKeiyakuEndMonth(String keiyakuEndMonth) {
        this.keiyakuEndMonth = keiyakuEndMonth;
    }

    /**
     * 契約終了日時(日)を返します。
     * @return 契約終了日時(日)
     */
    public String getKeiyakuEndDay() {
        return keiyakuEndDay;
    }

    /**
     * 契約終了日時(日)を設定します。
     * @param keiyakuEndDay  契約終了日時(日)
     */
    public void setKeiyakuEndDay(String keiyakuEndDay) {
        this.keiyakuEndDay = keiyakuEndDay;
    }

    /**
     * 契約終了日時(時)を返します。
     * @return 契約終了日時(時)
     */
    public String getKeiyakuEndHour() {
        return keiyakuEndHour;
    }

    /**
     * 契約終了日時(時)を設定します。
     * @param keiyakuEndHour  契約終了日時(時)
     */
    public void setKeiyakuEndHour(String keiyakuEndHour) {
        this.keiyakuEndHour = keiyakuEndHour;
    }

	public String getKeiyakuStartMinute() {
		return keiyakuStartMinute;
	}

	public void setKeiyakuStartMinute(String keiyakuStartMinute) {
		this.keiyakuStartMinute = keiyakuStartMinute;
	}

	public String getKeiyakuStartSecond() {
		return keiyakuStartSecond;
	}

	public void setKeiyakuStartSecond(String keiyakuStartSecond) {
		this.keiyakuStartSecond = keiyakuStartSecond;
	}

	public String getKeiyakuEndMinute() {
		return keiyakuEndMinute;
	}

	public void setKeiyakuEndMinute(String keiyakuEndMinute) {
		this.keiyakuEndMinute = keiyakuEndMinute;
	}

	public String getKeiyakuEndSecond() {
		return keiyakuEndSecond;
	}

	public void setKeiyakuEndSecond(String keiyakuEndSecond) {
		this.keiyakuEndSecond = keiyakuEndSecond;
	}

}
