/*
 * $Id: UserDomain.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.user.domain;

/**
 * ユーザ
 *
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserDomain {

    /** ユーザID */
    private String userId;

    /** ユーザIDチェック */
    private int idCount;

    /** 名前 */
    private String userName;

    /** 操作ID */
    private String contentsId;

    /** 操作名 */
    private String contentsName;

    /** 更新日時 */
    private String updDt;

    /** グループID */
    private String groupId;

    /** グループ名 */
    private String groupName;

    /** 利用可能な機能 */
    private String authorityId;

    /** 説明 */
    private String userNote;

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
     * 操作IDを取得します。
     * @return 操作ID
     */
    public String getContentsId() {
        return contentsId;
    }

    /**
     * 操作IDを設定します。
     * @param contentsId 操作ID
     */
    public void setContentsId(String contentsId) {
        this.contentsId = contentsId;
    }

    /**
     * 操作名を取得します。
     * @return 操作名
     */
    public String getContentsName() {
        return contentsName;
    }

    /**
     * 操作名を設定します。
     * @param contentsName 操作名
     */
    public void setContentsName(String contentsName) {
        this.contentsName = contentsName;
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
     * 利用可能な機能を取得します。
     * @return 利用可能な機能
     */
    public String getAuthorityId() {
        return authorityId;
    }

    /**
     * 利用可能な機能を設定します。
     * @param authorityId 利用可能な機能
     */
    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
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
     * ユーザIDチェックを取得します。
     * @return ユーザIDチェック
     */
    public int getIdCount() {
        return idCount;
    }

    /**
     * ユーザIDチェックを設定します。
     * @param idCount ユーザIDチェック
     */
    public void setIdCount(int idCount) {
        this.idCount = idCount;
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
