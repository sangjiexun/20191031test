/*
 * $Id: ShikutyosonPostSearchInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.master.service.bean;

/**
 * 市区町村メンテナンス検索情報条件（郵便番号）Bean
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShikutyosonPostSearchInServiceBean {

    /** 郵便番号 */
    private String zipCd;

    /**
     * 郵便番号を取得します。
     * @return 郵便番号
     */
	public String getZipCd() {
	    return zipCd;
	}

	/**
	 * 郵便番号を設定します。
	 * @param zipCd 郵便番号
	 */
	public void setZipCd(String zipCd) {
	    this.zipCd = zipCd;
	}

}
