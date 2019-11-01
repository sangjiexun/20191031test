/*
 * $Id: UserAddCommitInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service.bean;

/**
 * ユーザ登録完了Bean
 *
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserAddCommitInServiceBean {

    /** ユーザID */
    private String userId;

    /** パスワード */
    private String passwd;

    /** 名前 */
    private String userName;

    /** グループ */
    private String groupId;

    /** 説明 */
    private String userNote;

    /** 登録ユーザID */
    private String operUserId;

    /** レコード登録プログラムID */
    private String pgName;

    /**
     * ユーザIDを取得します。
     * @return ユーザID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * ユーザIDを設定します。
     * @param userId ユーザID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * パスワードを取得します。
     * @return パスワード
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * パスワードを設定します。
     * @param passwd パスワード
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * 名前を取得します。
     * @return 名前
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 名前を設定します。
     * @param userName 名前
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * グループを取得します。
     * @return グループ
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * グループを設定します。
     * @param groupId グループ
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * 説明を取得します。
     * @return 説明
     */
    public String getUserNote() {
        return userNote;
    }

    /**
     * 説明を設定します。
     * @param userNote 説明
     */
    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }

    /**
     * 登録ユーザIDを取得します。
     * @return 登録ユーザID
     */
    public String getOperUserId() {
        return operUserId;
    }

    /**
     * 登録ユーザIDを設定します。
     * @param operUserId 登録ユーザID
     */
    public void setOperUserId(String operUserId) {
        this.operUserId = operUserId;
    }

	/**
	 * @return pgName
	 */
	public String getPgName() {
		return pgName;
	}

	/**
	 * @param pgName セットする pgName
	 */
	public void setPgName(String pgName) {
		this.pgName = pgName;
	}

}
