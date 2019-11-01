/*
 * $Id: ReviewShopSearchDomain.java 3911 2008-05-27 07:09:06Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)李昊燮   新規作成
 * 2008/05/27  BGT)李昊燮   変数名ctStatus/ablStatusをctFlg/ablFlgに修正
 */
package net.chintai.backend.sysadmin.review.domain;

/**
 * 店舗検索結果
 *
 * @author lee-hosup
 * @version $Revision: 3911 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopSearchDomain {

    /** 審査設定名称 */
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

    /** 連絡方法 */
    private String fmKbn;

    /** 店舗対象外設定(初期審査) */
    private String syokaiShinsaSkipFlg;

    /** 店舗対象外設定(定期審査) */
    private String teikiShinsaSkipFlg;

    /** 店舗対象外設定（メール送信） */
    private String mailSendSkipFlg;

    /** 店舗対象外設定（自動削除） */
    private String autoDelSkipFlg;

    /** 有効物件数 */
    private String bukkenCnt;

    /** 返信待ち物件数(初期審査) */
    private String syokaiShinsaCnt;

    /** 返信待ち物件数(定期審査) */
    private String teikiShinsaCnt;

    /** 返信待ち率 */
    private String returnRate;

    private String rendoCd;

    /** 連動元 */
    private String rendoName;

    /** 免許証番号 */
    private String licNum;

    private String ctStatus;

    private String ablStatus;

    /**
     * 審査設定名称を取得します。
     * @return 審査設定名称
     */
    public String getShopCd() {
        return shopCd;
    }

    /**
     * 審査設定名称を設定します。
     * @param shopCd 審査設定名称
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
     * 店舗対象外設定(初期審査)を取得します。
     * @return 店舗対象外設定(初期審査)
     */
    public String getSyokaiShinsaSkipFlg() {
        return syokaiShinsaSkipFlg;
    }

    /**
     * 店舗対象外設定(初期審査)を設定します。
     * @param syokaiShinsaSkipFlg 店舗対象外設定(初期審査)
     */
    public void setSyokaiShinsaSkipFlg(String syokaiShinsaSkipFlg) {
        this.syokaiShinsaSkipFlg = syokaiShinsaSkipFlg;
    }

    /**
     * 店舗対象外設定(定期審査)を取得します。
     * @return 店舗対象外設定(定期審査)
     */
    public String getTeikiShinsaSkipFlg() {
        return teikiShinsaSkipFlg;
    }

    /**
     * 店舗対象外設定(定期審査)を設定します。
     * @param teikiShinsaSkipFlg 店舗対象外設定(定期審査)
     */
    public void setTeikiShinsaSkipFlg(String teikiShinsaSkipFlg) {
        this.teikiShinsaSkipFlg = teikiShinsaSkipFlg;
    }

    /**
     * 店舗対象外設定（メール送信）を取得します。
     * @return 店舗対象外設定（メール送信）
     */
    public String getMailSendSkipFlg() {
        return mailSendSkipFlg;
    }

    /**
     * 店舗対象外設定（メール送信）を設定します。
     * @param mailSendSkipFlg 店舗対象外設定（メール送信）
     */
    public void setMailSendSkipFlg(String mailSendSkipFlg) {
        this.mailSendSkipFlg = mailSendSkipFlg;
    }

    /**
     * 店舗対象外設定（自動削除）を取得します。
     * @return 店舗対象外設定（自動削除）
     */
    public String getAutoDelSkipFlg() {
        return autoDelSkipFlg;
    }

    /**
     * 店舗対象外設定（自動削除）を設定します。
     * @param autoDelSkipFlg 店舗対象外設定（自動削除）
     */
    public void setAutoDelSkipFlg(String autoDelSkipFlg) {
        this.autoDelSkipFlg = autoDelSkipFlg;
    }

    /**
     * 有効物件数を取得します。
     * @return 有効物件数
     */
    public String getBukkenCnt() {
        return bukkenCnt;
    }

    /**
     * 有効物件数を設定します。
     * @param bukkenCnt 有効物件数
     */
    public void setBukkenCnt(String bukkenCnt) {
        this.bukkenCnt = bukkenCnt;
    }

    /**
     * 返信待ち物件数(初期審査)を取得します。
     * @return 返信待ち物件数(初期審査)
     */
    public String getSyokaiShinsaCnt() {
        return syokaiShinsaCnt;
    }

    /**
     * 返信待ち物件数(初期審査)を設定します。
     * @param syokaiShinsaCnt 返信待ち物件数(初期審査)
     */
    public void setSyokaiShinsaCnt(String syokaiShinsaCnt) {
        this.syokaiShinsaCnt = syokaiShinsaCnt;
    }

    /**
     * 返信待ち物件数(定期審査)を取得します。
     * @return 返信待ち物件数(定期審査)
     */
    public String getTeikiShinsaCnt() {
        return teikiShinsaCnt;
    }

    /**
     * 返信待ち物件数(定期審査)を設定します。
     * @param teikiShinsaCnt 返信待ち物件数(定期審査)
     */
    public void setTeikiShinsaCnt(String teikiShinsaCnt) {
        this.teikiShinsaCnt = teikiShinsaCnt;
    }

    /**
     * 返信待ち率を取得します。
     * @return 返信待ち率
     */
    public String getReturnRate() {
        return returnRate;
    }

    /**
     * 返信待ち率を設定します。
     * @param returnRate 返信待ち率
     */
    public void setReturnRate(String returnRate) {
        this.returnRate = returnRate;
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
	 * @return licNum
	 */
	public String getLicNum() {
		return licNum;
	}

	/**
	 * @param licNum セットする licNum
	 */
	public void setLicNum(String licNum) {
		this.licNum = licNum;
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

}
