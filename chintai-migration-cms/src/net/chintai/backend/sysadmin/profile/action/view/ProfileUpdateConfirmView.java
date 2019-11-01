/*
 * $Id: ProfileUpdateConfirmView.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.profile.action.view;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * ユーザ情報更新内容確認
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ProfileUpdateConfirmView implements ViewHelper {

    /** ユーザID */
    private String userId;

    /** 名前 */
    private String userName;

    /** グループ */
    private String groupName;

    /** 説明 */
    private String description;

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
     * 名前を取得します。
     * @return 名前
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 名前を設定します。
     * @param userName 名前
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * グループを取得します。
     * @return グループ
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * グループを設定します。
     * @param groupName グループ
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * 説明を取得します。
     * @return 説明
     */
    public String getDescription() {
        return description;
    }

    /**
     * 説明を設定します。
     * @param description 説明
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
