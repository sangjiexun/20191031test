/*
 * $Id: BukkenRirekiInfoCsvDownloadInServiceBean.java 3922 2008-05-27 09:38:05Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2008/05/27  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.bean;

/**
 * CSVダウンロード
 *
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CsvDownloadInServiceBean {
	private String[] pkBukkenRireki;

	public String[] getPkBukkenRireki() {
		return pkBukkenRireki;
	}

	public void setPkBukkenRireki(String[] pkBukkenRireki) {
		this.pkBukkenRireki = pkBukkenRireki;
	}


}