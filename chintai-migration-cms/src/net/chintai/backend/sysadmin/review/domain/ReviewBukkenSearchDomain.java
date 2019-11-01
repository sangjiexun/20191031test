/*
 * $Id: ReviewBukkenSearchDomain.java 3911 2008-05-27 07:09:06Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/09  BGT)李昊燮   新規作成
 * 2008/05/27  BGT)李昊燮   変数名ctStatus/ablStatusをctFlg/ablFlgに修正
 *                          連続掲載日数項目追加
 */
package net.chintai.backend.sysadmin.review.domain;

/**
 * 物件検索結果
 *
 * @author lee-hosup
 * @version $Revision: 3911 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenSearchDomain {
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

    /** 状態 */
    private String shopStatus;

    /** 会社名 */
    private String company;

    /** 事務所名 */
    private String bumon;

    /** CHINTAI掲載 */
    private String ctKeisaiFlg;

    /** エイブル掲載 */
    private String ablKeisaiFlg;

    /** 物件対象外設定 */
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
    private String elapsedDays;

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
     * 物件対象外設定を取得します。
     * @return 物件対象外設定
     */
    public String getClientSystemType() {
        return clientSystemType;
    }

    /**
     * 物件対象外設定を設定します。
     * @param clientSystemType 物件対象外設定
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
     * @return elapsedDays
     */
    public String getElapsedDays() {
        return elapsedDays;
    }

    /**
     * 連続掲載日数を設定します。
     * @param elapsedDays 設定する elapsedDays
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
