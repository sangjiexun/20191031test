/*
 * $Id: User.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者     内容
 * ---------------------------------------------------------
 * 2007/06/15  BGT)児島   新規作成
 * 
 */
package net.chintai.backend.sysadmin.login.domain;

/**
 * ユーザーテーブルを表すクラス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class User {

    /** ユーザーID */
    private String userId;

    /** ユーザー名 */
    private String userName;

    /** パスワード */
    private String password;

    /** ユーザーの説明 */
    private String description;

    /**
     * デフォルトコンストラクタ。
     */
    public User() {
    }

    /**
     * ユーザーIDを取得します。
     * @return ユーザーID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * ユーザーIDを設定します。
     * @param userId ユーザーID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * ユーザー名を取得します。
     * @return ユーザー名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * ユーザー名を設定します。
     * @param userName ユーザー名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * パスワードを取得します。
     * @return パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * パスワードを設定します。
     * @param password パスワード
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * ユーザーの説明を取得します。
     * @return ユーザーの説明
     */
    public String getDescription() {
        return description;
    }

    /**
     * ユーザーの説明を設定します。
     * @param description ユーザーの説明
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
