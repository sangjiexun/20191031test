package net.chintai.backend.sysadmin.shop_bukken.service.bean;

/**
 * CSVダウンロード
 *
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CsvDownloadColumnInServiceBean {
	private String tableName;
	private String[] excludeColumns;

	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String[] getExcludeColumns() {
		return excludeColumns;
	}
	public void setExcludeColumns(String[] excludeColumns) {
		this.excludeColumns = excludeColumns;
	}
}