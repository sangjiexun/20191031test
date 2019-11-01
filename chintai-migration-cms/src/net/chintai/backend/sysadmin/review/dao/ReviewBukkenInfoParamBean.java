/*
 * $Id: ReviewBukkenInfoParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/15  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao;

/**
 * 物件詳細検索条件
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenInfoParamBean {
	/** 部屋キー */
    private String roomKey;

    /** 店舗コード */
    private String shopCd;

    /** 物件コード */
    private String bkCd;

    /** 部屋連番 */
    private String roomNo;

    /** 初回審査自動削除期間 */
    private int syokaiAutoDel;

    /** 定期審査自動削除期間 */
    private int teikiAutoDel;

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
     * 部屋連番を取得します。
     * @return 部屋連番
     */
    public String getRoomNo() {
        return roomNo;
    }

    /**
     * 部屋連番を設定します。
     * @param roomNo 部屋連番
     */
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

	/**
	 * 初回審査自動削除期間を取得します。
	 * @return 初回審査自動削除期間
	 */
	public int getSyokaiAutoDel() {
	    return syokaiAutoDel;
	}

	/**
	 * 初回審査自動削除期間を設定します。
	 * @param syokaiAutoDel 初回審査自動削除期間
	 */
	public void setSyokaiAutoDel(int syokaiAutoDel) {
	    this.syokaiAutoDel = syokaiAutoDel;
	}

	/**
	 * 定期審査自動削除期間を取得します。
	 * @return 定期審査自動削除期間
	 */
	public int getTeikiAutoDel() {
	    return teikiAutoDel;
	}

	/**
	 * 定期審査自動削除期間を設定します。
	 * @param teikiAutoDel 定期審査自動削除期間
	 */
	public void setTeikiAutoDel(int teikiAutoDel) {
	    this.teikiAutoDel = teikiAutoDel;
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

}
