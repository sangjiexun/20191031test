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
 * 登録機能マスタ
 *
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MstInsPgInServiceBean {
	private String pg;
	private String referencePriority;
	public String getPg() {
		return pg;
	}
	public void setPg(String pg) {
		this.pg = pg;
	}
	public String getReferencePriority() {
		return referencePriority;
	}
	public void setReferencePriority(String referencePriority) {
		this.referencePriority = referencePriority;
	}
}