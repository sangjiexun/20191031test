package net.chintai.backend.sysadmin.demand.dao;


/**
* 日付チェックBEAN
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountMaintenanceKikanChkBean {
    /** 店舗コード  */
    private String shopCd;

    /** 契約コード */
    private String keiyakuCd;

    /** 契約サブコード  */
    private String keiyakuSubCd;

    /** 契約開始日時  */
    private String keiyakuStartDt;

    /** 契約終了日時  */
    private String keiyakuEndDt;

    /** 契約番号*/
    private String keiyakuNo;

    /** 契約開始年月日 */
    private String keiyakuStartYMDH;

    /** 契約終了年月日 */
    private String keiyakuEndYMDH;


	public String getShopCd() {
		return shopCd;
	}

	public void setShopCd(String shopCd) {
		this.shopCd = shopCd;
	}

	public String getKeiyakuCd() {
		return keiyakuCd;
	}

	public void setKeiyakuCd(String keiyakuCd) {
		this.keiyakuCd = keiyakuCd;
	}

	public String getKeiyakuSubCd() {
		return keiyakuSubCd;
	}

	public void setKeiyakuSubCd(String keiyakuSubCd) {
		this.keiyakuSubCd = keiyakuSubCd;
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

	public String getKeiyakuStartYMDH() {
		return keiyakuStartYMDH;
	}

	public void setKeiyakuStartYMDH(String keiyakuStartYMDH) {
		this.keiyakuStartYMDH = keiyakuStartYMDH;
	}

	public String getKeiyakuEndYMDH() {
		return keiyakuEndYMDH;
	}

	public void setKeiyakuEndYMDH(String keiyakuEndYMDH) {
		this.keiyakuEndYMDH = keiyakuEndYMDH;
	}

	public String getKeiyakuStartDt() {
		return keiyakuStartDt;
	}

	public void setKeiyakuStartDt(String keiyakuStartDt) {
		this.keiyakuStartDt = keiyakuStartDt;
	}


}