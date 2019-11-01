package net.chintai.backend.sysadmin.shop_bukken.service.bean;

/**
 * 契約明細詳細(契約数量あり)設定情報更新
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountAddCommitInServiceBean {


    /** 店舗コード  */
    private String shopCd;

    /** 契約コード */
    private String keiyakuCd;

    /** 契約サブコード  */
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

    /** 契約終了日時(年) */
    private String keiyakuEndYear;

    /** 契約終了日時(月) */
    private String keiyakuEndMonth;

    /** 契約終了日時(日) */
    private String keiyakuEndDay;

    /** 契約終了日時(時) */
    private String keiyakuEndHour;

    /** 枠数 */
    private String wakuCnt;

    /** 物件枠(手入力) */
    private String wakuCntNote;

    /** ユーザID */
    private String userId;

    /** プログラム名 */
    private String pgName;

    /** 店舗管理テーブル更新日時 */
    private String shopKanriUpdDt;

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
     * 枠数を取得します。
     * @return 物件枠
     */
    public String getWakuCnt() {
        return wakuCnt;
    }

    /**
     * 枠数を設定します。
     * @param bukkenCnt 物件枠
     */
    public void setWakuCnt(String wakuCnt) {
        this.wakuCnt = wakuCnt;
    }

    /**
     * 物件枠(手入力)を取得します。
     * @return 物件枠(手入力)
     */
    public String getWakuCntNote() {
        return wakuCntNote;
    }

    /**
     * 物件枠(手入力)を設定します。
     * @param bukkenCntNote 物件枠(手入力)
     */
    public void setwakuCntNote(String wakuCntNote) {
        this.wakuCntNote = wakuCntNote;
    }


    /**
     * ユーザIDを取得します。
     * @return ユーザID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * ユーザIDを設定します。
     * @param userId ユーザID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * プログラム名を取得します。
     * @return プログラム名
     */
    public String getPgName() {
        return pgName;
    }

    /**
     * プログラム名を設定します。
     * @param pgName プログラム名
     */
    public void setPgName(String pgName) {
        this.pgName = pgName;
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

	public String getKeiyakuNote() {
		return keiyakuNote;
	}

	public void setKeiyakuNote(String keiyakuNote) {
		this.keiyakuNote = keiyakuNote;
	}

	public String getKeiyakuStartYear() {
		return keiyakuStartYear;
	}

	public void setKeiyakuStartYear(String keiyakuStartYear) {
		this.keiyakuStartYear = keiyakuStartYear;
	}

	public String getKeiyakuStartMonth() {
		return keiyakuStartMonth;
	}

	public void setKeiyakuStartMonth(String keiyakuStartMonth) {
		this.keiyakuStartMonth = keiyakuStartMonth;
	}

	public String getKeiyakuStartDay() {
		return keiyakuStartDay;
	}

	public void setKeiyakuStartDay(String keiyakuStartDay) {
		this.keiyakuStartDay = keiyakuStartDay;
	}

	public String getKeiyakuStartHour() {
		return keiyakuStartHour;
	}

	public void setKeiyakuStartHour(String keiyakuStartHour) {
		this.keiyakuStartHour = keiyakuStartHour;
	}

	public String getKeiyakuEndYear() {
		return keiyakuEndYear;
	}

	public void setKeiyakuEndYear(String keiyakuEndYear) {
		this.keiyakuEndYear = keiyakuEndYear;
	}

	public String getKeiyakuEndMonth() {
		return keiyakuEndMonth;
	}

	public void setKeiyakuEndMonth(String keiyakuEndMonth) {
		this.keiyakuEndMonth = keiyakuEndMonth;
	}

	public String getKeiyakuEndDay() {
		return keiyakuEndDay;
	}

	public void setKeiyakuEndDay(String keiyakuEndDay) {
		this.keiyakuEndDay = keiyakuEndDay;
	}

	public String getKeiyakuEndHour() {
		return keiyakuEndHour;
	}

	public void setKeiyakuEndHour(String keiyakuEndHour) {
		this.keiyakuEndHour = keiyakuEndHour;
	}

	public void setWakuCntNote(String wakuCntNote) {
		this.wakuCntNote = wakuCntNote;
	}

}
