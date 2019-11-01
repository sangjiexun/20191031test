/*
 * $Id: UserUpdateCommitParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/25  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao;

/**
 * ユーザ更新完了Bean
 *
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserUpdateCommitParamBean {

    /** ユーザID */
    private String userId;

    /** 名前 */
    private String userName;

    /** グループ */
    private String groupId;

    /** 説明 */
    private String userNote;

    /** CHINTAI問い合せ管理 アカウントシーケンス */
    private String cjnAccountSeq;

    /** 更新日時 */
    private String updDt;

    /** 更新ユーザID */
    private String operUserId;

    /** レコード登録プログラムID */
    private String pgName;

    private String isCjnAccount;

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
     * 更新ユーザIDを取得します。
     * @return 更新ユーザID
     */
    public String getOperUserId() {
        return operUserId;
    }

    /**
     * 更新ユーザIDを設定します。
     * @param operUserId 更新ユーザID
     */
    public void setOperUserId(String operUserId) {
        this.operUserId = operUserId;
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
     * CHINTAI問い合せ管理 アカウントシーケンスを取得します。
     * @return CHINTAI問い合せ管理 アカウントシーケンス
     */
    public String getCjnAccountSeq() {
        return cjnAccountSeq;
    }

    /**
     * CHINTAI問い合せ管理 アカウントシーケンスを設定します。
     * @param cjnAccountSeq CHINTAI問い合せ管理 アカウントシーケンス
     */
    public void setCjnAccountSeq(String cjnAccountSeq) {
        this.cjnAccountSeq = cjnAccountSeq;
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

	/**
	 * @return isCjnAccount
	 */
	public String getIsCjnAccount() {
		return isCjnAccount;
	}

	/**
	 * @param isCjnAccount セットする isCjnAccount
	 */
	public void setIsCjnAccount(String isCjnAccount) {
		this.isCjnAccount = isCjnAccount;
	}
}