package net.chintai.backend.sysadmin.shop_bukken.dao;

/**
 * 契約明細詳細(契約数量あり)設定情報更新
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountAddCommitParamBean {

    /** 契約NO */
    private String keiyakuNo;

    /** 店舗コード  */
    private String shopCd;

    /** 契約コード */
    private String keiyakuCd;

    /** 契約管理オプションコード  */
    private String keiyakuSubCd;

    /** 備考 */
    private String keiyakuNote;

    /** 契約開始日時 */
    private String keiyakuStartDt;

    /** 契約終了日時 */
    private String keiyakuEndDt;

    /** 物件枠 */
    private String wakuCnt;

    /** 物件枠(手入力) */
    private String wakuCntNote;

    /** ユーザID */
    private String userId;

    /** プログラム名 */
    private String pgName;

    /**
     * 契約NOを返します。
     * @return 契約NO
     */
    public String getKeiyakuNo() {
        return keiyakuNo;
    }

    /**
     * 契約NOを設定します。
     * @param keiyakuNo  契約NO
     */
    public void setKeiyakuNo(String keiyakuNo) {
        this.keiyakuNo = keiyakuNo;
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
     * 契約管理オプションコードを返します。
     * @return 契約管理オプションコード
     */
    public String getKeiyakuSubCd() {
        return keiyakuSubCd;
    }

    /**
     * 契約管理オプションコードを設定します。
     * @param keiyakuCd  契約管理オプションコード
     */
    public void setKeiyakuSubCd(String keiyakuSubCd) {
        this.keiyakuSubCd = keiyakuSubCd;
    }

    /**
     * 物件枠を取得します。
     * @return 物件枠
     */
    public String getWakuCnt() {
        return wakuCnt;
    }

    /**
     * 物件枠を設定します。
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
    public void setWakuCntNote(String wakuCntNote) {
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

	public String getKeiyakuNote() {
		return keiyakuNote;
	}

	public void setKeiyakuNote(String keiyakuNote) {
		this.keiyakuNote = keiyakuNote;
	}

	public String getKeiyakuStartDt() {
		return keiyakuStartDt;
	}

	public void setKeiyakuStartDt(String keiyakuStartDt) {
		this.keiyakuStartDt = keiyakuStartDt;
	}

	public String getKeiyakuEndDt() {
		return keiyakuEndDt;
	}

	public void setKeiyakuEndDt(String keiyakuEndDt) {
		this.keiyakuEndDt = keiyakuEndDt;
	}

}
