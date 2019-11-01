package net.chintai.backend.sysadmin.shop_bukken.service.bean;

/**
 * @author io
 *
 */
public class BukkenInfoTantouShopOutServiceBean {

	/** 店舗コード */
    private String shopcd;

    /** 会社名 */
    private String company;

    /** 事務署名 */
    private String bumon;

	/**
	 * @return shopcd
	 */
	public String getShopcd() {
		return shopcd;
	}

	/**
	 * @param shopcd セットする shopcd
	 */
	public void setShopcd(String shopcd) {
		this.shopcd = shopcd;
	}

	/**
	 * @return company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company セットする company
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * @return bumon
	 */
	public String getBumon() {
		return bumon;
	}

	/**
	 * @param bumon セットする bumon
	 */
	public void setBumon(String bumon) {
		this.bumon = bumon;
	}


}