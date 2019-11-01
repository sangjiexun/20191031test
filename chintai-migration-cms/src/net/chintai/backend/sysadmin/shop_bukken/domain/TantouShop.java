/*
 * Bukken.java
 * ---------------------------------------------------------
 * 更新日      更新者     内容
 * ---------------------------------------------------------
 * 2007/07/19  BGT)児島   新規作成
 * 2008/05/27  BGT)李昊燮 「削除状態」判断用項目追加
 *                        (WEB審査物件ステータス,エイブル期間切れフラグ,CHINTAI期間切れフラグ)
 * 2009/08/02  BGT)李昊燮 物件詳細の所要時間と 各金額の単位表示方法修正対応
 */
package net.chintai.backend.sysadmin.shop_bukken.domain;


/**
 * 店舗データを表すBean
 * @author io
 *
 */
public class TantouShop {
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