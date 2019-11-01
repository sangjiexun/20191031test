/*
 * $Id: UserPasswordChangeInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.user.service.bean;

/**
 * パスワード変更完了Bean
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserPasswordChangeInServiceBean {

    /** ユーザID */
    private String userId;

    /** 新しいパスワード */
    private String passwd;

    /** 更新ユーザID */
    private String operUserId;

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

}
