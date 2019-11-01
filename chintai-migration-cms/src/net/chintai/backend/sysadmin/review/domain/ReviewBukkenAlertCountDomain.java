/*
 * $Id: ReviewBukkenAlertCountDomain.java 3911 2008-05-27 07:09:06Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/09/28  BGT)李昊燮   新規作成
 * 2008/05/27  BGT)李昊燮     変数名ctStatus/ablStatusをctFlg/ablFlgに修正
 */
package net.chintai.backend.sysadmin.review.domain;

/**
 * 警告対象物件集計検索結果
 *
 * @author lee-hosup
 * @version $Revision: 3911 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenAlertCountDomain {

    /** 警告日 */
    private String sendDt;

    /** 店舗コード */
    private String shopCd;

    /** 店舗状態 */
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

    /** 物件コード */
    private String bkCd;

    /** 部屋番号 */
    private String roomCd;

    /** 状態 */
    private String statusKbn;

    /** 警告内容 */
    private String warningName;

    private String ctStatus;

    private String ablStatus;

    private String warningDt;

    private String rendoCd;

    private String rendoName;

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
     * 店舗状態を取得します。
     * @return 店舗状態
     */
    public String getShopStatus() {
        return shopStatus;
    }

    /**
     * 店舗状態を設定します。
     * @param shopStatus 店舗状態
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
     * 物件コードを取得します。
     * @return 物件コード
     */
    public String getBkCd() {
        return bkCd;
    }

    /**
     * 物件コードを設定します。
     * @param bkCd 物件コード
     */
    public void setBkCd(String bkCd) {
        this.bkCd = bkCd;
    }

    /**
     * 部屋番号を取得します。
     * @return 部屋番号
     */
    public String getRoomCd() {
        return roomCd;
    }

    /**
     * 部屋番号を設定します。
     * @param roomCd 部屋番号
     */
    public void setRoomCd(String roomCd) {
        this.roomCd = roomCd;
    }

    /**
     * 状態を取得します。
     * @return 状態
     */
    public String getStatusKbn() {
        return statusKbn;
    }

    /**
     * 状態を設定します。
     * @param statusKbn 状態
     */
    public void setStatusKbn(String statusKbn) {
        this.statusKbn = statusKbn;
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

	/**
	 * @return rendoCd
	 */
	public String getRendoCd() {
		return rendoCd;
	}

	/**
	 * @param rendoCd セットする rendoCd
	 */
	public void setRendoCd(String rendoCd) {
		this.rendoCd = rendoCd;
	}

}
