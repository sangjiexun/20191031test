/*
 * $Id: UserDeleteConfirmOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.user.service.bean;

/**
 * ユーザ削除確認Bean
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserDeleteConfirmOutServiceBean {

    /** ユーザIDのリスト */
    private String userId;

    /** ユーザ名 */
    private String userName;

    /** 更新日時 */
    private String updDt;

    /**
	 * ユーザIDのリストを取得します。
	 * @return ユーザIDのリスト
	 */
	public String getUserId() {
	    return userId;
	}

	/**
	 * ユーザIDのリストを設定します。
	 * @param userId ユーザIDのリスト
	 */
	public void setUserId(String userId) {
	    this.userId = userId;
	}

	/**
	 * ユーザ名を取得します。
	 * @return ユーザ名
	 */
	public String getUserName() {
	    return userName;
	}

	/**
	 * ユーザ名を設定します。
	 * @param userName ユーザ名
	 */
	public void setUserName(String userName) {
	    this.userName = userName;
	}

	/**
	 * 更新日時を取得します。
	 * @return 更新日時
	 */
	public String getUpdDt() {
	    return updDt;
	}

	/**
	 * 更新日時を設定します。
	 * @param updDt 更新日時
	 */
	public void setUpdDt(String updDt) {
	    this.updDt = updDt;
	}

}
