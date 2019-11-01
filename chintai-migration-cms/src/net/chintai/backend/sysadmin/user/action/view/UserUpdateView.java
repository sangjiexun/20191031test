/*
 * $Id: UserUpdateView.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.user.action.view;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * ユーザ情報編集確認Bean
 *
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserUpdateView implements ViewHelper {

    /** ユーザID */
    private String userId;

    /** 名前 */
    private String userName;

    /** グループID */
    private String groupId;

    /** グループ名 */
    private String groupName;

    /** 説明 */
    private String userNote;

    /** 更新日時 */
    private String updDt;

    private String cjnAccountSeq;

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
     * グループIDを取得します。
     * @return グループID
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * グループIDを設定します。
     * @param groupId グループID
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
     * グループ名を取得します。
     * @return グループ名
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * グループ名を設定します。
     * @param groupName グループ名
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

	/**
	 * @return cjnAccountSeq
	 */
	public String getCjnAccountSeq() {
		return cjnAccountSeq;
	}

	/**
	 * @param cjnAccountSeq セットする cjnAccountSeq
	 */
	public void setCjnAccountSeq(String cjnAccountSeq) {
		this.cjnAccountSeq = cjnAccountSeq;
	}
}