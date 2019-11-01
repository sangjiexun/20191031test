package net.chintai.backend.sysadmin.shop_bukken.domain;

/**
 * @author io
 *
 */
public class ColumnComments {

	/** カラム名（英語） */
    private String columnName;

    /** カラム名（日本語） */
    private String comments;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}