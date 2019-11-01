/*
 * $Id: UserDeleteConfirmParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.user.dao;

/**
 * ユーザ削除
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserDeleteConfirmParamBean {

    /** ユーザIDのリスト */
    private String[] userCheckId;

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

}
