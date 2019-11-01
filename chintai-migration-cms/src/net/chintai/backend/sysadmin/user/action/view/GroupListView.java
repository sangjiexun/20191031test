/*
 * $Id: GroupListView.java 3570 2007-12-14 08:55:47Z t-kojima $
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
 * グループ一覧Bean
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupListView implements ViewHelper {

    /** グループリスト */
    private List<GroupDetailView> groupList;

    /** 権限リスト */
    private List<AuthorityDetailView> authorityList;

    /**
     * グループリストを取得します。
     * @return グループリスト
     */
    public List<GroupDetailView> getGroupList() {
        return groupList;
    }

    /**
     * グループリストを設定します。
     * @param groupList グループリスト
     */
    public void setGroupList(List<GroupDetailView> groupList) {
        this.groupList = groupList;
    }

    /**
     * 権限リストを取得します。
     * @return 権限リスト
     */
    public List<AuthorityDetailView> getAuthorityList() {
        return authorityList;
    }

    /**
     * 権限リストを設定します。
     * @param authorityList 権限リスト
     */
    public void setAuthorityList(List<AuthorityDetailView> authorityList) {
        this.authorityList = authorityList;
    }

    /**
     * グループ詳細情報
     */
    public class GroupDetailView {

        /** グループID */
        private String groupId;

        /** グループ名 */
        private String groupName;

        /** グループの削除チェックFlag */
        private String groupDeleteCheck;

        /** 権限リスト */
        private List groupByAuthorityList;

        /**
         * グループIDを取得します。
         * @return グループID
         */
        public String getGroupId() {
            return groupId;
        }

        /**
         * グループIDを設定します。
         * @param groupId グループID
         */
        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        /**
         * グループ名を取得します。
         * @return グループ名
         */
        public String getGroupName() {
            return groupName;
        }

        /**
         * グループ名を設定します。
         * @param groupName グループ名
         */
        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        /**
         * グループの削除チェックFlagを取得します。
         * @return グループの削除チェックFlag
         */
        public String getGroupDeleteCheck() {
            return groupDeleteCheck;
        }

        /**
         * グループの削除チェックFlagを設定します。
         * @param groupDeleteCheck グループの削除チェックFlag
         */
        public void setGroupDeleteCheck(String groupDeleteCheck) {
            this.groupDeleteCheck = groupDeleteCheck;
        }

        /**
         * 権限リストを取得します。
         * @return 権限リスト
         */
        public List getGroupByAuthorityList() {
            return groupByAuthorityList;
        }

        /**
         * 権限リストを設定します。
         * @param groupByAuthorityList 権限リスト
         */
        public void setGroupByAuthorityList(List groupByAuthorityList) {
            this.groupByAuthorityList = groupByAuthorityList;
        }

        /**
         * グループの権限リスト
         */
        public class GroupByAuthorityView {

            /** 権限ID */
            private String authorityId;

            /** 権限有無 */
            private String authorityExist;

            /**
             * 権限IDを取得します。
             * @return 権限ID
             */
            public String getAuthorityId() {
                return authorityId;
            }

            /**
             * 権限IDを設定します。
             * @param authorityId 権限ID
             */
            public void setAuthorityId(String authorityId) {
                this.authorityId = authorityId;
            }

            /**
             * 権限有無を取得します。
             * @return 権限有無
             */
            public String getAuthorityExist() {
                return authorityExist;
            }

            /**
             * 権限有無を設定します。
             * @param authorityExist 権限有無
             */
            public void setAuthorityExist(String authorityExist) {
                this.authorityExist = authorityExist;
            }

        }

    }

    /**
     * 権限の詳細情報
     */
    public class AuthorityDetailView {

        /** 権限ID */
        private String authorityId;

        /** 権限名 */
        private String authorityName;

        /** 権限更新日付 */
        private String updDt;

        /** 権限更新者 */
        private String updID;

        /**
         * 権限IDを取得します。
         * @return 権限ID
         */
        public String getAuthorityId() {
            return authorityId;
        }

        /**
         * 権限IDを設定します。
         * @param authorityId 権限ID
         */
        public void setAuthorityId(String authorityId) {
            this.authorityId = authorityId;
        }

        /**
         * 権限名を取得します。
         * @return 権限名
         */
        public String getAuthorityName() {
            return authorityName;
        }

        /**
         * 権限名を設定します。
         * @param authorityName 権限名
         */
        public void setAuthorityName(String authorityName) {
            this.authorityName = authorityName;
        }

        /**
         * 権限更新日付を取得します。
         * @return 権限更新日付
         */
        public String getUpdDt() {
            return updDt;
        }

        /**
         * 権限更新日付を設定します。
         * @param updDt 権限更新日付
         */
        public void setUpdDt(String updDt) {
            this.updDt = updDt;
        }

        /**
         * 権限更新者を取得します。
         * @return 権限更新者
         */
        public String getUpdID() {
            return updID;
        }

        /**
         * 権限更新者を設定します。
         * @param updID 権限更新者
         */
        public void setUpdID(String updID) {
            this.updID = updID;
        }

    }

}
