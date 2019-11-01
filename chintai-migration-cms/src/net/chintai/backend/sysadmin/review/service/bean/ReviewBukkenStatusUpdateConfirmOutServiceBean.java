/*
 * $Id: ReviewBukkenStatusUpdateConfirmOutServiceBean.java 3912 2008-05-27 08:06:03Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/18  BGT)李昊燮   新規作成
 * 2008/05/27  BGT)李昊燮   変数名ctStatus/ablStatusをctFlg/ablFlgに修正
 */
package net.chintai.backend.sysadmin.review.service.bean;

/**
 * 物件対象外設定変更確認画面用情報
 *
 * @author lee-hosup
 * @version $Revision: 3912 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenStatusUpdateConfirmOutServiceBean {
	/** 部屋キー */
    private String roomKey;

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

    /** データ元 */
    private String clientSystemType;

    /** 管理コード */
    private String kanriCd;

    /** 状態 */
    private String bkStatus;

    /** 物件名称 */
    private String bkName;

    /** CHINTAI.NET掲載状態 */
    private String bukkenStatusShinsa;

    /** 警告対象 */
    private String warningCd;

    /** 区分 */
    private String statusKbn;

    /** 処理区分 */
    private String syoriKbn;

    /** 初回審査自動削除予定日 */
    private String syokaiAutoDelDt;

    /** 定期審査自動削除予定日 */
    private String teikiAutoDelDt;

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
     * 物件名称を取得します。
     * @return 物件名称
     */
    public String getBkName() {
        return bkName;
    }

    /**
     * 物件名称を設定します。
     * @param bkName 物件名称
     */
    public void setBkName(String bkName) {
        this.bkName = bkName;
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
     * 警告対象を取得します。
     * @return 警告対象
     */
    public String getWarningCd() {
        return warningCd;
    }

    /**
     * 警告対象を設定します。
     * @param warningCd 警告対象
     */
    public void setWarningCd(String warningCd) {
        this.warningCd = warningCd;
    }

    /**
     * 区分を取得します。
     * @return 区分
     */
    public String getStatusKbn() {
        return statusKbn;
    }

    /**
     * 区分を設定します。
     * @param statusKbn 区分
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
