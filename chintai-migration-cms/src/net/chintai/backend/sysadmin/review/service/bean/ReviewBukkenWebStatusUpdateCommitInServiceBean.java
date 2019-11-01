/*
 * $Id: ReviewBukkenWebStatusUpdateCommitInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/19  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.bean;

/**
 * CHINTAI.NET掲載情報更新
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenWebStatusUpdateCommitInServiceBean {
	/** 部屋キー */
	private String roomKey;

    /** 店舗コード */
    private String shopCd;

    /** 物件コード */
    private String bkCd;

    /** 部屋番号 */
    private String roomNo;

    /** CHINTAI.NET掲載状態(画面選択値) */
    private String bukkenStatusShinsaInput;

    /** CHINTAI.NET掲載状態備考 */
    private String shinsaBukkenStatusBikou;

    /** 最終更新日時 */
    private String updDt;

    /** 更新者ID */
    private String updId;

    /** 更新プログラム */
    private String updPg;

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
     * 部屋番号を取得します。
     * @return 部屋番号
     */
    public String getRoomNo() {
        return roomNo;
    }

    /**
     * 部屋番号を設定します。
     * @param roomNo 部屋番号
     */
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    /**
     * CHINTAI.NET掲載状態(画面選択値)を取得します。
     * @return CHINTAI.NET掲載状態(画面選択値)
     */
    public String getBukkenStatusShinsaInput() {
        return bukkenStatusShinsaInput;
    }

    /**
     * CHINTAI.NET掲載状態(画面選択値)を設定します。
     * @param bukkenStatusShinsaInput CHINTAI.NET掲載状態(画面選択値)
     */
    public void setBukkenStatusShinsaInput(String bukkenStatusShinsaInput) {
        this.bukkenStatusShinsaInput = bukkenStatusShinsaInput;
    }

    /**
     * CHINTAI.NET掲載状態備考を取得します。
     * @return CHINTAI.NET掲載状態備考
     */
    public String getShinsaBukkenStatusBikou() {
        return shinsaBukkenStatusBikou;
    }

    /**
     * CHINTAI.NET掲載状態備考を設定します。
     * @param shinsaBukkenStatusBikou CHINTAI.NET掲載状態備考
     */
    public void setShinsaBukkenStatusBikou(String shinsaBukkenStatusBikou) {
        this.shinsaBukkenStatusBikou = shinsaBukkenStatusBikou;
    }

    /**
     * 最終更新日時を取得します。
     * @return 最終更新日時
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 最終更新日時を設定します。
     * @param updDt 最終更新日時
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
     * 更新者IDを取得します。
     * @return 更新者ID
     */
    public String getUpdId() {
        return updId;
    }

    /**
     * 更新者IDを設定します。
     * @param updId 更新者ID
     */
    public void setUpdId(String updId) {
        this.updId = updId;
    }

    /**
     * 更新プログラムを取得します。
     * @return 更新プログラム
     */
    public String getUpdPg() {
        return updPg;
    }

    /**
     * 更新プログラムを設定します。
     * @param updPg 更新プログラム
     */
    public void setUpdPg(String updPg) {
        this.updPg = updPg;
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
