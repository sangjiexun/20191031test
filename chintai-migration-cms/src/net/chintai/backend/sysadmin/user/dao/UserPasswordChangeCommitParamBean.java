/*
 * $Id: UserPasswordChangeCommitParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/26  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao;

/**
 * パスワード変更完了ParamBean
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserPasswordChangeCommitParamBean {

    /** ユーザID */
    private String userId;

    /** 新しいパスワード */
    private String passwd;

    /** 更新ユーザID */
    private String operUserId;

    /** 更新日時 */
    private String updDt;

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
     * 新しいパスワードを取得します。
     * @return 新しいパスワード
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * 新しいパスワードを設定します。
     * @param passwd 新しいパスワード
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
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