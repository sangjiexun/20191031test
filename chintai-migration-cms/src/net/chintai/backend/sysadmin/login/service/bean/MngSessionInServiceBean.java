/*
 * LoginServiceBean.java
 * ---------------------------------------------------------
 * 更新日      更新者     内容
 * ---------------------------------------------------------
 * 2007/06/15  BGT)児島   新規作成
 * 2007/08/08  BGT)児島   グループIDを削除
 */
package net.chintai.backend.sysadmin.login.service.bean;

/**
 * セッション情報管理の Bean
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MngSessionInServiceBean {

    /** シーケンス */
    private Long sidId;

    /** ユーザＩＤ */
    private String userId;

    /** ログインキー */
    private int loginKey;

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
     * @param sidId  シーケンス
     */
    public void setSid(Long sidId) {
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
    public int getLoginKey() {
        return loginKey;
    }

    /**
     * ログインキーを設定します。
     * @param loginKey  ログインキー
     */
    public void setLoginKey(int loginKey) {
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
