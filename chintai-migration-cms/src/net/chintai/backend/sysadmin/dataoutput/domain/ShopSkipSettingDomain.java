package net.chintai.backend.sysadmin.dataoutput.domain;

/**
 * 店舗別除外設定取得用domain
 * @author watanabe
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopSkipSettingDomain {
	/** 店舗コード */
	private String shopCd;

	/** 会社名 */
	private String company;

	/** 店舗名称 */
	private String bumon;

	/** 免許証番号 */
	private String licNum;

	/** 都道府県名 */
	private String prefName;

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
	 * 会社名を取得します。
	 * @return 会社名
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * 会社名を設定します。
	 * @param company 会社名
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * 店舗名称を取得します。
	 * @return 店舗名称
	 */
	public String getBumon() {
		return bumon;
	}

	/**
	 * 店舗名称を設定します。
	 * @param bumon 店舗名称
	 */
	public void setBumon(String bumon) {
		this.bumon = bumon;
	}

	/**
	 * 免許証番号を取得します。
	 * @return 免許証番号
	 */
	public String getLicNum() {
		return licNum;
	}

	/**
	 * 免許証番号を設定します。
	 * @param licNum 免許証番号
	 */
	public void setLicNum(String licNum) {
		this.licNum = licNum;
	}

	/**
	 * 都道府県名を取得します。
	 * @return 都道府県名
	 */
	public String getPrefName() {
		return prefName;
	}

	/**
	 * 都道府県名を設定します。
	 * @param prefName 都道府県名
	 */
	public void setPrefName(String prefName) {
		this.prefName = prefName;
	}

}
