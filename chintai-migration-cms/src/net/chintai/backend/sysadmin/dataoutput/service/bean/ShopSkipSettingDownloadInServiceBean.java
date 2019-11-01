package net.chintai.backend.sysadmin.dataoutput.service.bean;

/**
 * 除外店舗のCSVダウンロード用InServiceBean
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopSkipSettingDownloadInServiceBean {
	/** 他社データ連携種類 */
	private String dcoType;

	/** 連携対象会社名 */
	private String dcoName;

	/**
	 * 他社データ連携種類を取得します。
	 * @return 他社データ連携種類
	 */
	public String getDcoType() {
		return dcoType;
	}

	/**
	 * 他社データ連携種類を設定します。
	 * @param dcoType 他社データ連携種類
	 */
	public void setDcoType(String dcoType) {
		this.dcoType = dcoType;
	}

	/**
	 * 連携対象会社名を取得します。
	 * @return 連携対象会社名
	 */
	public String getDcoName() {
		return dcoName;
	}

	/**
	 * 連携対象会社名を設定します。
	 * @param dcoName 連携対象会社名
	 */
	public void setDcoName(String dcoName) {
		this.dcoName = dcoName;
	}

}
