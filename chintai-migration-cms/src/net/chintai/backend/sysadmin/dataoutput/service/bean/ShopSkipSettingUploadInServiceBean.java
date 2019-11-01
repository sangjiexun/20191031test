package net.chintai.backend.sysadmin.dataoutput.service.bean;

import java.util.List;

/**
 * 店舗別除外設定アップロード用inServiceBean
 * @author watanabe
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopSkipSettingUploadInServiceBean {
	/** アップロードリスト */
	private List<String[]> uploadList;

	/** 他社データ連携種類 */
	private String dcoType;

	/** 登録・更新者ID */
	private String userId;

	/** 登録・更新PG名 */
	private String pgName;

	/**
	 * アップロードリストを取得します。
	 * @return アップロードリスト
	 */
	public List<String[]> getUploadList() {
		return uploadList;
	}

	/**
	 * アップロードリストを設定します。
	 * @param uploadList アップロードリスト
	 */
	public void setUploadList(List<String[]> uploadList) {
		this.uploadList = uploadList;
	}

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
	 * 登録・更新者IDを取得します。
	 * @return 登録・更新者ID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 登録・更新者IDを設定します。
	 * @param userId 登録・更新者ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 登録・更新PG名を取得します。
	 * @return 登録・更新PG名
	 */
	public String getPgName() {
		return pgName;
	}

	/**
	 * 登録・更新PG名を設定します。
	 * @param pgName 登録・更新PG名
	 */
	public void setPgName(String pgName) {
		this.pgName = pgName;
	}

}

