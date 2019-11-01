/*
 * $Id: ReviewShopStatusUpdateView.java 3906 2008-05-27 06:00:19Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/12  BGT)李昊燮     新規作成
 * 2008/05/27  BGT)李昊燮     変数名ctStatus/ablStatusをctFlg/ablFlgに修正
 */
package net.chintai.backend.sysadmin.review.action.view;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 店舗対象外設定機能の画面(共用)
 * @author Lee Hosup
 * @version $Revision: 3906 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopStatusUpdateView implements ViewHelper {

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

    /** テータ元 */
    private String clientSystemType;

    /** 連絡方法 */
    private String fmKbn;

    /** 有効物件数 */
    private String bukkenCnt;

    /** 初回審査返信待ち物件数 */
    private String syokaiShinsaCnt;

    /** 定期審査返信待ち物件数 */
    private String teikiShinsaCnt;

    /** 返信待ち率 */
    private String returnRate;

    /** 初回審査対象外フラグ */
    private String syokaiShinsaSkipFlg;

    /** 定期審査対象外フラグ */
    private String teikiShinsaSkipFlg;

    /** メール送信対象外フラグ */
    private String mailSendSkipFlg;

    /** 自動削除対象外フラグ */
    private String autoDelSkipFlg;

    /** 備考 */
    private String shinsaSkipBikou;

    /** 最終更新日 */
    private String updDt;

    private String ctStatus;

    private String ablStatus;

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
     * テータ元を取得します。
     * @return テータ元
     */
    public String getClientSystemType() {
        return clientSystemType;
    }

    /**
     * テータ元を設定します。
     * @param clientSystemType テータ元
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
     * 初回審査返信待ち物件数を取得します。
     * @return 初回審査返信待ち物件数
     */
    public String getSyokaiShinsaCnt() {
        return syokaiShinsaCnt;
    }

    /**
     * 初回審査返信待ち物件数を設定します。
     * @param syokaiShinsaCnt 初回審査返信待ち物件数
     */
    public void setSyokaiShinsaCnt(String syokaiShinsaCnt) {
        this.syokaiShinsaCnt = syokaiShinsaCnt;
    }

    /**
     * 定期審査返信待ち物件数を取得します。
     * @return 定期審査返信待ち物件数
     */
    public String getTeikiShinsaCnt() {
        return teikiShinsaCnt;
    }

    /**
     * 定期審査返信待ち物件数を設定します。
     * @param teikiShinsaCnt 定期審査返信待ち物件数
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
     * 初回審査対象外フラグを取得します。
     * @return 初回審査対象外フラグ
     */
    public String getSyokaiShinsaSkipFlg() {
        return syokaiShinsaSkipFlg;
    }

    /**
     * 初回審査対象外フラグを設定します。
     * @param syokaiShinsaSkipFlg 初回審査対象外フラグ
     */
    public void setSyokaiShinsaSkipFlg(String syokaiShinsaSkipFlg) {
        this.syokaiShinsaSkipFlg = syokaiShinsaSkipFlg;
    }

    /**
     * 定期審査対象外フラグを取得します。
     * @return 定期審査対象外フラグ
     */
    public String getTeikiShinsaSkipFlg() {
        return teikiShinsaSkipFlg;
    }

    /**
     * 定期審査対象外フラグを設定します。
     * @param teikiShinsaSkipFlg 定期審査対象外フラグ
     */
    public void setTeikiShinsaSkipFlg(String teikiShinsaSkipFlg) {
        this.teikiShinsaSkipFlg = teikiShinsaSkipFlg;
    }

    /**
     * メール送信対象外フラグを取得します。
     * @return メール送信対象外フラグ
     */
    public String getMailSendSkipFlg() {
        return mailSendSkipFlg;
    }

    /**
     * メール送信対象外フラグを設定します。
     * @param mailSendSkipFlg メール送信対象外フラグ
     */
    public void setMailSendSkipFlg(String mailSendSkipFlg) {
        this.mailSendSkipFlg = mailSendSkipFlg;
    }

    /**
     * 自動削除対象外フラグを取得します。
     * @return 自動削除対象外フラグ
     */
    public String getAutoDelSkipFlg() {
        return autoDelSkipFlg;
    }

    /**
     * 自動削除対象外フラグを設定します。
     * @param autoDelSkipFlg 自動削除対象外フラグ
     */
    public void setAutoDelSkipFlg(String autoDelSkipFlg) {
        this.autoDelSkipFlg = autoDelSkipFlg;
    }

    /**
     * 備考を取得します。
     * @return 備考
     */
    public String getShinsaSkipBikou() {
        return shinsaSkipBikou;
    }

    /**
     * 備考を設定します。
     * @param shinsaSkipBikou 備考
     */
    public void setShinsaSkipBikou(String shinsaSkipBikou) {
        this.shinsaSkipBikou = shinsaSkipBikou;
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
