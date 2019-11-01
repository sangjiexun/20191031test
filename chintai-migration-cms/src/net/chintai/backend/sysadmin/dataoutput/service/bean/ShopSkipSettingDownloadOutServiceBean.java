package net.chintai.backend.sysadmin.dataoutput.service.bean;

import java.util.List;

/**
 * 店舗別除外設定ダウンロードoutServiceBean
 * @author watanabe
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopSkipSettingDownloadOutServiceBean {
	/** ダウンロードリスト */
	private List<String[]> downloadList;

	/**
	 * ダウンロードリストを取得します。
	 * @return ダウンロードリスト
	 */
	public List<String[]> getDownloadList() {
		return downloadList;
	}

	/**
	 * ダウンロードリストを設定します。
	 * @param downloadList ダウンロードリスト
	 */
	public void setDownloadList(List<String[]> downloadList) {
		this.downloadList = downloadList;
	}

}
