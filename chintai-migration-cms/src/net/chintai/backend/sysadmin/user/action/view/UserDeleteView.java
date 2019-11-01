/*
 * $Id: UserDeleteView.java 3570 2007-12-14 08:55:47Z t-kojima $
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
 * ユーザ削除確認Bean
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserDeleteView implements ViewHelper {

    /** ユーザIDのリスト */
    private List<UserDeleteDetailView> userDeleteList;

    public class UserDeleteDetailView {

        /** ユーザID */
        private String userId;

        /** 更新日時 */
        private String updDt;

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
         * 更新日時を取得します。
         * @return 更新日時
         */
        public String getUpdDt() {
            return updDt;
        }

        /**
         * 更新日時を設定します。
         * @param updDt 更新日時
         */
        public void setUpdDt(String updDt) {
            this.updDt = updDt;
        }
    }

    /**
     * ユーザIDのリストを取得します。
     * @return ユーザIDのリスト
     */
    public List<UserDeleteDetailView> getUserDeleteList() {
        return userDeleteList;
    }

    /**
     * ユーザIDのリストを設定します。
     * @param userDeleteList ユーザIDのリスト
     */
    public void setUserDeleteList(List<UserDeleteDetailView> userDeleteList) {
        this.userDeleteList = userDeleteList;
    }
}
