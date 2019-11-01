package net.chintai.backend.sysadmin.shop_bukken.domain;

/**
 * 登録機能マスタ
 *
 */
public class MstInsPg {
    private String pg;
    private String systemCategoryName;
    private String pgName;
    private String referencePriority;
	public String getPg() {
		return pg;
	}
	public void setPg(String pg) {
		this.pg = pg;
	}
	public String getSystemCategoryName() {
		return systemCategoryName;
	}
	public void setSystemCategoryName(String systemCategoryName) {
		this.systemCategoryName = systemCategoryName;
	}
	public String getPgName() {
		return pgName;
	}
	public void setPgName(String pgName) {
		this.pgName = pgName;
	}
	public String getReferencePriority() {
		return referencePriority;
	}
	public void setReferencePriority(String referencePriority) {
		this.referencePriority = referencePriority;
	}
}