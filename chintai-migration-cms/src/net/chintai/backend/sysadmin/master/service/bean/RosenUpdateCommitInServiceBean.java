/*
 * $Id: RosenUpdateCommitInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.master.service.bean;

import java.util.List;

/**
 * 沿線・駅更新情報Bean
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenUpdateCommitInServiceBean {

    /** 登録・更新者ID */
    private String operUserId;

    /** 登録・更新PG名 */
    private String pgName;

    /** アップロードリスト */
    private List<String[]> uploadList;

    /**
	 * 登録・更新者IDを取得します。
	 * @return 登録・更新者ID
	 */
	public String getOperUserId() {
	    return operUserId;
	}

	/**
	 * 登録・更新者IDを設定します。
	 * @param operUserId 登録・更新者ID
	 */
	public void setOperUserId(String operUserId) {
	    this.operUserId = operUserId;
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
}