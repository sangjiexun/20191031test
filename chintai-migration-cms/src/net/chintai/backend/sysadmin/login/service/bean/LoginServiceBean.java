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
 * ログインチェックロジックの Bean
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class LoginServiceBean {

    /** ユーザID */
    private String userId;

    /** パスワード */
    private String password;

    /** ユーザ名 */
    private String userName;

    /**
     * デフォルトコンストラクタ。
     */
    public LoginServiceBean() {
        userId = "";
        password = "";
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
     * ユーザ名を取得します。
     * @return ユーザ名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * ユーザ名を設定します。
     * @param userName ユーザ名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
