/*
 * $Id: ProfilePasswordCheckParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/26  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.profile.dao;

/**
 * プロフィールパスワードチェックParamBean
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ProfilePasswordCheckParamBean {

    /** ユーザID */
    private String userId;

    /** 現在のパスワード */
    private String oldPasswd;

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
     * 現在のパスワードを取得します。
     * @return 現在のパスワード
     */
    public String getOldPasswd() {
        return oldPasswd;
    }

    /**
     * 現在のパスワードを設定します。
     * @param oldPasswd 現在のパスワード
     */
    public void setOldPasswd(String oldPasswd) {
        this.oldPasswd = oldPasswd;
    }
}