/*
 * $Id: ContractAmountMaintenanceUploadDomain.java 4661 2013-10-09 08:32:56Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.domain;



/**
 * CSVファイルアップロード情報用Domain
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopBukkenUploadDomain {

	private String reserveNo;
	private String reserveKbn;
	private String shopCd;
	private String clientsystemType;
	private String company;
	private String bumon;
	private String prefName;
	private String cityName;
	private String address1;
	private String reserveStartDt;
	private String businessHours;
	private String holiday;
	private String certifyFlg;
	private String ctStatus;
	private String ablStatus;
	private String shopStatus;
	public String getReserveNo() {
		return reserveNo;
	}
	public void setReserveNo(String reserveNo) {
		this.reserveNo = reserveNo;
	}
	public String getReserveKbn() {
		return reserveKbn;
	}
	public void setReserveKbn(String reserveKbn) {
		this.reserveKbn = reserveKbn;
	}
	public String getShopCd() {
		return shopCd;
	}
	public void setShopCd(String shopCd) {
		this.shopCd = shopCd;
	}
	public String getClientsystemType() {
		return clientsystemType;
	}
	public void setClientsystemType(String clientsystemType) {
		this.clientsystemType = clientsystemType;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getBumon() {
		return bumon;
	}
	public void setBumon(String bumon) {
		this.bumon = bumon;
	}
	public String getPrefName() {
		return prefName;
	}
	public void setPrefName(String prefName) {
		this.prefName = prefName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getReserveStartDt() {
		return reserveStartDt;
	}
	public void setReserveStartDt(String reserveStartDt) {
		this.reserveStartDt = reserveStartDt;
	}
	public String getBusinessHours() {
		return businessHours;
	}
	public void setBusinessHours(String businessHours) {
		this.businessHours = businessHours;
	}
	public String getHoliday() {
		return holiday;
	}
	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}
	public String getCertifyFlg() {
		return certifyFlg;
	}
	public void setCertifyFlg(String certifyFlg) {
		this.certifyFlg = certifyFlg;
	}
	public String getCtStatus() {
		return ctStatus;
	}
	public void setCtStatus(String ctStatus) {
		this.ctStatus = ctStatus;
	}
	public String getAblStatus() {
		return ablStatus;
	}
	public void setAblStatus(String ablStatus) {
		this.ablStatus = ablStatus;
	}
	public String getShopStatus() {
		return shopStatus;
	}
	public void setShopStatus(String shopStatus) {
		this.shopStatus = shopStatus;
	}


}
