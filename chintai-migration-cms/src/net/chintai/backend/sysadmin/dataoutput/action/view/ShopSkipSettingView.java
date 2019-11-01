package net.chintai.backend.sysadmin.dataoutput.action.view;

import net.chintai.backend.sysadmin.common.ViewHelper;


/**
 * 店舗別出力設定Form用Bean
 * @author watanabe
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopSkipSettingView implements ViewHelper{
	/** 他社データ連携種類 */
	private String dcoType;

	/** 連携対象会社名 */
	private String dcoName;

	/** 処理区分 */
	private String procName;

	/** アップロード確認済みフラグ */
	private String acceptFlg;

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

	/**
	 * 処理区分を取得します。
	 * @return 処理区分
	 */
	public String getProcName() {
		return procName;
	}

	/**
	 * 処理区分を設定します。
	 * @param procName 処理区分
	 */
	public void setProcName(String procName) {
		this.procName = procName;
	}

	/**
	 * アップロード確認済みフラグを取得します。
	 * @return アップロード確認済みフラグ
	 */
	public String getAcceptFlg() {
		return acceptFlg;
	}

	/**
	 * アップロード確認済みフラグを設定します。
	 * @param acceptFlg アップロード確認済みフラグ
	 */
	public void setAcceptFlg(String acceptFlg) {
		this.acceptFlg = acceptFlg;
	}

}
