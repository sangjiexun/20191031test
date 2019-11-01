/*
 * $Id: UserListView.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.user.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * ユーザ管理Bean
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserListView implements ViewHelper {

    /** ユーザリスト */
    private List<UserListDetailView> userList;

    /**
     * ユーザリストを取得します。
     * @return ユーザリスト
     */
    public List<UserListDetailView> getUserList() {
        return userList;
    }

    /**
     * ユーザリストを設定します。
     * @param userList ユーザリスト
     */
    public void setUserList(List<UserListDetailView> userList) {
        this.userList = userList;
    }

    public class UserListDetailView {

        /** ユーザID */
        private String userId;

        /** 名前 */
        private String userName;

        /** グループ */
        private String groupName;

        /** 説明 */
        private String userNote;

        /** チェックボックスの状態 */
        private String check;

        /** 削除不可の状態 */
        private String disabled;

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
        public String getUserNote() {
            return userNote;
        }

        /**
         * 説明を設定します。
         * @param userNote 説明
         */
        public void setUserNote(String userNote) {
            this.userNote = userNote;
        }

        /**
         * チェックボックスの状態を取得します。
         * @return チェックボックスの状態
         */
        public String getCheck() {
            return check;
        }

        /**
         * チェックボックスの状態を設定します。
         * @param check チェックボックスの状態
         */
        public void setCheck(String check) {
            this.check = check;
        }

        /**
         * 削除不可の状態を取得します。
         * @return 削除不可の状態
         */
        public String getDisabled() {
            return disabled;
        }

        /**
         * 削除不可の状態を設定します。
         * @param disabled 削除不可の状態
         */
        public void setDisabled(String disabled) {
            this.disabled = disabled;
        }
    }
}