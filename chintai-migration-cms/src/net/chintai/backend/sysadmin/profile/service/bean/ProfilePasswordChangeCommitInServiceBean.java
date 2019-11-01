/*
 * $Id: ProfilePasswordChangeCommitInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/04  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.profile.service.bean;

import net.chintai.backend.sysadmin.common.util.CryptUtil;

/**
 * プロフィールパスワード変更完了InServiceBean
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ProfilePasswordChangeCommitInServiceBean {

    /** ユーザID */
    private String userId;

    /** 現在のパスワード */
    private String oldPasswd;

    /** ユーザパスワード */
    private String passwd;

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
     * 現在のパスワードを設定します。
     * @return 現在のパスワード
     */
    public String getOldPasswd() {
        return oldPasswd;
    }

    /**
     * 現在のパスワードを取得します。
     * @param oldPasswd 現在のパスワード
     */
    public void setOldPasswd(String oldPasswd) {
        this.oldPasswd = oldPasswd;
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
        this.passwd = CryptUtil.md5digest(passwd);
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