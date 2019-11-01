/*
 * $Id: ReviewShopSearchInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.bean;

import net.chintai.backend.sysadmin.common.session.SessionSearchCondition;

/**
 * 店舗検索条件
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopSearchInServiceBean implements SessionSearchCondition {

    /** serialVersionUID */
    private static final long serialVersionUID = 3138212537878849207L;

    /** 店舗コード */
    private String shopCd;

    /** 会社名/事務所名 */
    private String companyBumon;

    /** 都道府県コード */
    private String prefCd;

    /** 有効物件数(下限) */
    private String bukkenCntFrom;

    /** 有効物件数(上限) */
    private String bukkenCntTo;

    /** データ元 */
    private String clientSystemType;

    /** 状態 */
    private String shopStatus;

    /** 初回審査返信待ち物件を1件以上保持してる */
    private String syokaiShinsaCnt;

    /** 定期審査返信待ち物件を2件以上保持してる */
    private String teikiShinsaCnt;

    /** 初回、定期審査返信待ち物件を保持していない店 */
    private String shinsaNoCnt;

    /** 返信待ち率(下限) */
    private String returnRateFrom;

    /** 返信待ち率(上限) */
    private String returnRateTo;

    /** ソートキー */
    private String sortKey;

    /** 順序 */
    private String orderBy;

    /** 表示件数 */
    private String displayNum;

    /** ページング情報 */
    private int offSet;

    private String rendoCd;

    /** 連動元 */
    private String rendoName;

    /** 免許証番号 */
    private String licNum;

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
     * 会社名/事務所名を取得します。
     * @return 会社名/事務所名
     */
    public String getCompanyBumon() {
        return companyBumon;
    }

    /**
     * 会社名/事務所名を設定します。
     * @param companyBumon 会社名/事務所名
     */
    public void setCompanyBumon(String companyBumon) {
        this.companyBumon = companyBumon;
    }

    /**
     * 都道府県コードを取得します。
     * @return 都道府県コード
     */
    public String getPrefCd() {
        return prefCd;
    }

    /**
     * 都道府県コードを設定します。
     * @param prefCd 都道府県コード
     */
    public void setPrefCd(String prefCd) {
        this.prefCd = prefCd;
    }

    /**
     * 有効物件数(下限)を取得します。
     * @return 有効物件数(下限)
     */
    public String getBukkenCntFrom() {
        return bukkenCntFrom;
    }

    /**
     * 有効物件数(下限)を設定します。
     * @param bukkenCntFrom 有効物件数(下限)
     */
    public void setBukkenCntFrom(String bukkenCntFrom) {
        this.bukkenCntFrom = bukkenCntFrom;
    }

    /**
     * 有効物件数(上限)を取得します。
     * @return 有効物件数(上限)
     */
    public String getBukkenCntTo() {
        return bukkenCntTo;
    }

    /**
     * 有効物件数(上限)を設定します。
     * @param bukkenCntTo 有効物件数(上限)
     */
    public void setBukkenCntTo(String bukkenCntTo) {
        this.bukkenCntTo = bukkenCntTo;
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
     * 初回審査返信待ち物件を1件以上保持してるを取得します。
     * @return 初回審査返信待ち物件を1件以上保持してる
     */
    public String getSyokaiShinsaCnt() {
        return syokaiShinsaCnt;
    }

    /**
     * 初回審査返信待ち物件を1件以上保持してるを設定します。
     * @param syokaiShinsaCnt 初回審査返信待ち物件を1件以上保持してる
     */
    public void setSyokaiShinsaCnt(String syokaiShinsaCnt) {
        this.syokaiShinsaCnt = syokaiShinsaCnt;
    }

    /**
     * 定期審査返信待ち物件を2件以上保持してるを取得します。
     * @return 定期審査返信待ち物件を2件以上保持してる
     */
    public String getTeikiShinsaCnt() {
        return teikiShinsaCnt;
    }

    /**
     * 定期審査返信待ち物件を2件以上保持してるを設定します。
     * @param teikiShinsaCnt 定期審査返信待ち物件を2件以上保持してる
     */
    public void setTeikiShinsaCnt(String teikiShinsaCnt) {
        this.teikiShinsaCnt = teikiShinsaCnt;
    }

    /**
     * 初回、定期審査返信待ち物件を保持していない店を取得します。
     * @return 初回、定期審査返信待ち物件を保持していない店
     */
    public String getShinsaNoCnt() {
        return shinsaNoCnt;
    }

    /**
     * 初回、定期審査返信待ち物件を保持していない店を設定します。
     * @param shinsaNoCnt 初回、定期審査返信待ち物件を保持していない店
     */
    public void setShinsaNoCnt(String shinsaNoCnt) {
        this.shinsaNoCnt = shinsaNoCnt;
    }

    /**
     * 返信待ち率(下限)を取得します。
     * @return 返信待ち率(下限)
     */
    public String getReturnRateFrom() {
        return returnRateFrom;
    }

    /**
     * 返信待ち率(下限)を設定します。
     * @param returnRateFrom 返信待ち率(下限)
     */
    public void setReturnRateFrom(String returnRateFrom) {
        this.returnRateFrom = returnRateFrom;
    }

    /**
     * 返信待ち率(上限)を取得します。
     * @return 返信待ち率(上限)
     */
    public String getReturnRateTo() {
        return returnRateTo;
    }

    /**
     * 返信待ち率(上限)を設定します。
     * @param returnRateTo 返信待ち率(上限)
     */
    public void setReturnRateTo(String returnRateTo) {
        this.returnRateTo = returnRateTo;
    }

    /**
     * ソートキーを取得します。
     * @return ソートキー
     */
    public String getSortKey() {
        return sortKey;
    }

    /**
     * ソートキーを設定します。
     * @param sortKey ソートキー
     */
    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    /**
     * 順序を取得します。
     * @return 順序
     */
    public String getOrderBy() {
        return orderBy;
    }

    /**
     * 順序を設定します。
     * @param orderBy 順序
     */
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    /**
     * 表示件数を取得します。
     * @return 表示件数
     */
    public String getDisplayNum() {
        return displayNum;
    }

    /**
     * 表示件数を設定します。
     * @param displayNum 表示件数
     */
    public void setDisplayNum(String displayNum) {
        this.displayNum = displayNum;
    }

    /**
     * ページング情報を取得します。
     * @return ページング情報
     */
    public int getOffSet() {
        return offSet;
    }

    /**
     * ページング情報を設定します。
     * @param offSet ページング情報
     */
    public void setOffSet(int offSet) {
        this.offSet = offSet;
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

}
