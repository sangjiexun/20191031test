package net.chintai.backend.sysadmin.shop_bukken.service.bean;

/**
 * 店舗リスティング設定情報(更新ページ用)
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingUpdatePageOutServiceBean {

    /** 会社名 */
    private String company;

    /** 事務所名 */
    private String bumon;

    /** 店舗コード */
    private String shopCd;

    /** お客様設定パスワード */
    private String password;

    /** 契約番号 */
    private String keiyakuNo;

    /** 契約コード*/
    private String keiyakuCd;

    /** 契約オプションコード */
    private String keiyakuSubCd;

    /** 備考 */
    private String keiyakuNote;

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

    /** 更新日時 */
    private String updDt;

    /** Validation用 日付項目*/
    private String nowDate;

    /** 予約元区分 */
    private String reserveKbn;

    /** 物件枠 */
    private String wakuCnt;

    /** 契約開始日時 */
    private String keiyakuStartDt;


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
     * 事務所名を返します。
     * @return 事務所名
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
     * 契約番号を返します。
     * @return keiyakuNo
     */
    public String getKeiyakuNo() {
        return keiyakuNo;
    }

    /**
     * 契約番号を設定します。
     * @param keiyakuNo  契約番号
     */
    public void setKeiyakuNo(String keiyakuNo) {
        this.keiyakuNo = keiyakuNo;
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
     *  契約オプションコードを返します。
     * @return  契約オプションコード
     */
    public String getKeiyakuSubCd() {
        return keiyakuSubCd;
    }

    /**
     *  契約オプションコードを設定します。
     * @param keiyakuSubCd   契約オプションコード
     */
    public void setKeiyakuSubCd(String keiyakuSubCd) {
        this.keiyakuSubCd = keiyakuSubCd;
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

    /**
     * Validation用 日付項目を返します。
     * @return Validation用 日付項目
     */
    public String getNowDate() {
        return nowDate;
    }

    /**
     * Validation用 日付項目を設定します。
     * @param nowDate  Validation用 日付項目
     */
    public void setNowDate(String nowDate) {
        this.nowDate = nowDate;
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

	public String getKeiyakuStartDt() {
		return keiyakuStartDt;
	}

	public void setKeiyakuStartDt(String keiyakuStartDt) {
		this.keiyakuStartDt = keiyakuStartDt;
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
