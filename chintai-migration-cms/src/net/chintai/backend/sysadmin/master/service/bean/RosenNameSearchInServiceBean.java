/*
 * $Id: RosenSearchInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service.bean;

import net.chintai.backend.sysadmin.common.session.SessionSearchCondition;

/**
 * 沿線・駅検索条件Bean
 *
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenNameSearchInServiceBean implements SessionSearchCondition {

	private static final long serialVersionUID = 1346643344844803254L;
	/** 沿線名 */
    private String ensenNameParam;

    /** 駅名 */
    private String ekiNameParam;

	/**
	 * @return ensenNameParam
	 */
	public String getEnsenNameParam() {
		return ensenNameParam;
	}

	/**
	 * @param ensenNameParam セットする ensenNameParam
	 */
	public void setEnsenNameParam(String ensenNameParam) {
		this.ensenNameParam = ensenNameParam;
	}

	/**
	 * @return ekiNameParam
	 */
	public String getEkiNameParam() {
		return ekiNameParam;
	}

	/**
	 * @param ekiNameParam セットする ekiNameParam
	 */
	public void setEkiNameParam(String ekiNameParam) {
		this.ekiNameParam = ekiNameParam;
	}


}
