/*
 * $Id: ContractAmountMaintenanceUploadDomain.java 4661 2013-10-09 08:32:56Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 *
 */
package net.chintai.backend.sysadmin.demand.domain;



/**
 * CSVファイルアップロード情報用Domain
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountMaintenanceUploadDomain {
	/** 契約管理番号 */
	private String keiyakuNo;

    /** 店舗コード */
    private String shopCd;

    /** 契約名*/
    private String keiyakuName;

    /** 契約コード*/
    private String keiyakuCd;

    /** 契約オプションコード*/
    private String keiyakuSubCd;

    /** 契約開始日時*/
    private String keiyakuStartDt;

    /** 契約終了日時*/
    private String keiyakuEndDt;

    /** 契約数*/
    private String keiyakuAmount;
    /** 処理対象行番号(エラーメッセージ用) */
    private String lineNumber;

    /** 処理区分 */
    private String syoriKbn;

    /** 更新ユーザID */
    private String operUserId;

    /** 更新プログラム名 */
    private String pgName;


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

    /**
     *  処理対象行番号(エラーメッセージ用)を返します。
     * @return  処理対象行番号(エラーメッセージ用)
     */
    public String getLineNumber() {
        return lineNumber;
    }

    /**
     *  処理対象行番号(エラーメッセージ用)を設定します。
     * @param lineNumber   処理対象行番号(エラーメッセージ用)
     */
    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    /**
     * 処理区分を返します。
     * @return 処理区分
     */
    public String getSyoriKbn() {
        return syoriKbn;
    }

    /**
     * 処理区分を設定します。
     * @param syoriKbn  処理区分
     */
    public void setSyoriKbn(String syoriKbn) {
        this.syoriKbn = syoriKbn;
    }


    /**
     * 更新ユーザIDを取得します。
     * @return 更新ユーザID
     */
    public String getOperUserId() {
        return operUserId;
    }

    /**
     * 更新ユーザIDを設定します。
     * @param operUserId 更新ユーザID
     */
    public void setOperUserId(String operUserId) {
        this.operUserId = operUserId;
    }

    /**
     * 更新プログラム名を取得します。
     * @return 更新プログラム名
     */
    public String getPgName() {
        return pgName;
    }

    /**
     * 更新プログラム名を設定します。
     * @param pgName 更新プログラム名
     */
    public void setPgName(String pgName) {
        this.pgName = pgName;
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
