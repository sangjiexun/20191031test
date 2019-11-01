/*
 * $Id: ReviewBukkenStatusUpdateCommitInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/18  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.bean;

/**
 * 物件対象外設定更新
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenStatusUpdateCommitInServiceBean {
	/** 部屋キー */
	private String roomKey;

    /** 店舗コード */
    private String shopCd;

    /** 物件コード */
    private String bkCd;

    /** 部屋番号 */
    private String roomNo;

    /** 初期審査対処外フラグ */
    private String syokaiShinsaSkipFlg;

    /** 定期審査対象外フラグ */
    private String teikiShinsaSkipFlg;

    /** 自動削除対象外フラグ */
    private String autoDelSkipFlg;

    /** 備考 */
    private String shinsaSkipBikou;

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
     * 初期審査対処外フラグを取得します。
     * @return 初期審査対処外フラグ
     */
    public String getSyokaiShinsaSkipFlg() {
        return syokaiShinsaSkipFlg;
    }

    /**
     * 初期審査対処外フラグを設定します。
     * @param syokaiShinsaSkipFlg 初期審査対処外フラグ
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
