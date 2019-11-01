package net.chintai.backend.sysadmin.shop_bukken.dao;

/**
 * 取引先枠情報更新
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountUpdateCommitParamBean {

    /** 店舗コード  */
    private String shopCd;

    /** 契約コード */
    private String keiyakuCd;

    /** 契約サブコード  */
    private String keiyakuSubCd;

    /** 適用月 */
    private String appStartDt;

    /** 物件枠 */
    private String wakuCnt;

    /** 物件枠(手入力) */
    private String wakuCntNote;

    /** 更新者ID */
    private String updId;

    /** プログラム名 */
    private String updPg;

    /** 取引先テーブルの最終更新日付 */
    private String torihikisakiUpdDt;


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
     * 契約サブコードを返します。
     * @return 契約サブコード
     */
    public String getKeiyakuSubCd() {
        return keiyakuSubCd;
    }

    /**
     * 契約サブコードを設定します。
     * @param keiyakuSubCd  契約サブコード
     */
    public void setKeiyakuSubCd(String keiyakuSubCd) {
        this.keiyakuSubCd = keiyakuSubCd;
    }

    /**
     * 適用月を取得します。
     * @return 適用月
     */
    public String getAppStartDt() {
        return appStartDt;
    }

    /**
     * 適用月を設定します。
     * @param startYm 適用月
     */
    public void setAppStartDt(String appStartDt) {
        this.appStartDt = appStartDt;
    }

    /**
     * 枠数(ラジオボタン)を返します。
     * @return 枠数(ラジオボタン)
     */
    public String getWakuCnt() {
        return wakuCnt;
    }

    /**
     * 枠数(ラジオボタン)を設定します。
     * @param wakuCnt  枠数(ラジオボタン)
     */
    public void setWakuCnt(String wakuCnt) {
        this.wakuCnt = wakuCnt;
    }

    /**
     * 枠数(テキスト)を返します。
     * @return 枠数(テキスト)
     */
    public String getWakuCntNote() {
        return wakuCntNote;
    }

    /**
     * 枠数(テキスト)を設定します。
     * @param wakuCntNote  枠数(テキスト)
     */
    public void setWakuCntNote(String wakuCntNote) {
        this.wakuCntNote = wakuCntNote;
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
     * プログラム名を取得します。
     * @return プログラム名
     */
    public String getUpdPg() {
        return updPg;
    }

    /**
     * プログラム名を設定します。
     * @param updPg プログラム名
     */
    public void setUpdPg(String updPg) {
        this.updPg = updPg;
    }

	/**
	 * 取引先テーブルの最終更新日付を取得します。
	 * @return 取引先テーブルの最終更新日付
	 */
	public String getTorihikisakiUpdDt() {
	    return torihikisakiUpdDt;
	}

	/**
	 * 取引先テーブルの最終更新日付を設定します。
	 * @param torihikisakiUpdDt 取引先テーブルの最終更新日付
	 */
	public void setTorihikisakiUpdDt(String torihikisakiUpdDt) {
	    this.torihikisakiUpdDt = torihikisakiUpdDt;
	}

}
