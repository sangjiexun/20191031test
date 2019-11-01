/*
 * $Id: ContractAmountMaintenanceDownloadDomain.java 4700 2013-10-25 02:49:00Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 *
 */
package net.chintai.backend.sysadmin.demand.domain;


/**
 * CSVファイル出力結果用Domain
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountMaintenanceDownloadDomain {

	/** 契約管理番号 */
	private String keiyakuNo;

    /** 店舗コード */
    private String shopCd;

    /** 会社名*/
    private String companyMei;

    /** 部門名*/
    private String bumonMei;

    /** 契約名*/
    private String keiyakuName;

    /** 契約コード*/
    private String keiyakuCd;

    /** 契約オプションコード*/
    private String keiyakuSubCd;

    /** 適用開始日*/
    private String keiyakuStartDt;

    /** 契約終了日時*/
    private String keiyakuEndDt;

    /** 契約数*/
    private String keiyakuAmount;

    /**
     * 店舗コードを返します。
     * @return 店舗コード
     */
    public String getShopCd() {
        return shopCd;
    }

    /**
     * 店舗コードを設定します。
     * @param shopCd  店舗コード
     */
    public void setShopCd(String shopCd) {
        this.shopCd = shopCd;
    }

    /**
     * 会社名を返します。
     * @return 会社名
     */
    public String getCompanyMei() {
        return companyMei;
    }

    /**
     * 会社名を設定します。
     * @param companyMei  会社名
     */
    public void setCompanyMei(String companyMei) {
        this.companyMei = companyMei;
    }

    /**
     * 部門名を返します。
     * @return 部門名
     */
    public String getBumonMei() {
        return bumonMei;
    }

    /**
     * 部門名を設定します。
     * @param bumonMei  部門名
     */
    public void setBumonMei(String bumonMei) {
        this.bumonMei = bumonMei;
    }

    /**
     * 契約名を返します。
     * @return 契約名
     */
    public String getKeiyakuName() {
        return keiyakuName;
    }

    /**
     * 契約名を設定します。
     * @param keiyakuName  契約名
     */
    public void setKeiyakuName(String keiyakuName) {
        this.keiyakuName = keiyakuName;
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
     * 契約オプションコードを返します。
     * @return 契約オプションコード
     */
    public String getKeiyakuSubCd() {
        return keiyakuSubCd;
    }

    /**
     * 契約オプションコードを設定します。
     * @param keiyakuSubCd  契約オプションコード
     */
    public void setKeiyakuSubCd(String keiyakuSubCd) {
        this.keiyakuSubCd = keiyakuSubCd;
    }

    /**
     * 契約数を返します。
     * @return 契約数
     */
    public String getKeiyakuAmount() {
        return keiyakuAmount;
    }

    /**
     * 契約数を設定します。
     * @param keiyakuAmount  契約数
     */
    public void setKeiyakuAmount(String keiyakuAmount) {
        this.keiyakuAmount = keiyakuAmount;
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

	public String getKeiyakuNo() {
		return keiyakuNo;
	}

	public void setKeiyakuNo(String keiyakuNo) {
		this.keiyakuNo = keiyakuNo;
	}



}
