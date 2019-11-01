/*
 * $Id: OperationLoggingParamBean.java,v 1.2 2007/10/10 05:55:51 t-kojima Exp $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/10/10   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.login.dao;

/**
 * セッション情報をテーブルに格納します。
 *
 * @author
 * @version $Revision:  $
 */
public class MngSessionParamBean {

    /** シーケンス */
    private Long sidId;

    /** ユーザＩＤ */
    private String userId;

    /** ログインキー */
    private String loginKey;

    /** 操作実施者のユーザID */
    private String operUserId;

    /** 更新プログラムID*/
    private String pgName;


    /**
     * シーケンスを返します。
     * @return シーケンス
     */
    public Long getSidId() {
        return sidId;
    }

    /**
     * シーケンスを設定します。
     * @param sid  シーケンス
     */
    public void setSidId(Long sidId) {
        this.sidId = sidId;
    }

    /**
     * ユーザＩＤを取得します。
     * @return ユーザＩＤ
     */
    public String getUserId() {
        return userId;
    }

    /**
     * ユーザＩＤを設定します。
     * @param userId  ユーザＩＤ
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * ログインキーを取得します。
     * @return ログインキー
     */
    public String getLoginKey() {
        return loginKey;
    }

    /**
     * ログインキーを設定します。
     * @param loginKey  ログインキー
     */
    public void setLoginKey(String loginKey) {
        this.loginKey = loginKey;
    }

    /**
     * 操作実施者のユーザIDを取得します。
     * @return 操作実施者のユーザID
     */
    public String getOperUserId() {
        return operUserId;
    }

    /**
     * 操作実施者のユーザIDを設定します。
     * @param operUserId 操作実施者のユーザID
     */
    public void setOperUserId(String operUserId) {
        this.operUserId = operUserId;
    }

    /**
     * 更新プログラムIDを取得します。
     * @return 更新プログラムID
     */
	public String getPgName() {
		return pgName;
	}

    /**
     * 更新プログラムIDを設定します。
     * @param operUserId 更新プログラムID
     */
	public void setPgName(String pgName) {
		this.pgName = pgName;
	}

}
