/*
 * $Id: UserDeleteCommitInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service.bean;

/**
 * ユーザ削除完了Bean
 *
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserDeleteCommitInServiceBean {

    /** ユーザIDのリスト */
    private String[] userCheckId;

    /** 更新日時 */
    private String[] updDt;

    /** 更新者ID */
    private String operUserId;

    /** レコード登録プログラムID */
    private String pgName;

    /**
     * ユーザIDのリストを取得します。
     * @return ユーザIDのリスト
     */
    public String[] getUserCheckId() {
        return userCheckId;
    }

    /**
     * ユーザIDのリストを設定します。
     * @param userCheckId ユーザIDのリスト
     */
    public void setUserCheckId(String[] userCheckId) {
        this.userCheckId = userCheckId;
    }

    /**
     * 更新日時を取得します。
     * @return 更新日時
     */
    public String[] getUpdDt() {
        return updDt;
    }

    /**
     * 更新日時を設定します。
     * @param updDt 更新日時
     */
    public void setUpdDt(String[] updDt) {
        this.updDt = updDt;
    }

    /**
     * 更新者IDを取得します。
     * @return 更新者ID
     */
    public String getOperUserId() {
        return operUserId;
    }

    /**
     * 更新者IDを設定します。
     * @param operUserId 更新者ID
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