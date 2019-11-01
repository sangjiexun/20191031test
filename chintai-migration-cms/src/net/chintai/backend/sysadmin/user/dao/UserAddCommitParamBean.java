/*
 * $Id: UserAddCommitParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/20  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao;

/**
 * ユーザ登録完了ParamBean
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserAddCommitParamBean {

    /** ユーザID */
    private String userId;

    /** ユーザパスワード */
    private String passwd;

    /** 名前 */
    private String userName;

    /** グループID */
    private String groupId;

    /** CHINTAI問い合せ管理 アカウントシーケンス */
    private String cjnAccountSeq;

    /** CHINTAI問い合せ管理 アカウント種別 */
    private String cjnAccountType;

    /** 説明 */
    private String userNote;

    /** 登録者ID */
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
        if (groupId.equals("0")) {
            this.cjnAccountType = "1";
        } else {
            this.cjnAccountType = "0";
        }
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
     * 登録者IDを取得します。
     * @return 登録者ID
     */
    public String getOperUserId() {
        return operUserId;
    }

    /**
     * 登録者IDを設定します。
     * @param operUserId 登録者ID
     */
    public void setOperUserId(String operUserId) {
        this.operUserId = operUserId;
    }

    /**
     * ユーザパスワードを取得します。
     * @return ユーザパスワード
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * ユーザパスワードを設定します。
     * @param passwd ユーザパスワード
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
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
     * CHINTAI問い合せ管理 アカウント種別を取得します。
     * @return CHINTAI問い合せ管理 アカウント種別
     */
    public String getCjnAccountType() {
        return cjnAccountType;
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
	 * @param cjnAccountType セットする cjnAccountType
	 */
	public void setCjnAccountType(String cjnAccountType) {
		this.cjnAccountType = cjnAccountType;
	}
}