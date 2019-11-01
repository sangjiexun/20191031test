/*
 * $Id: GroupUpdatePageView.java 3570 2007-12-14 08:55:47Z t-kojima $
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
 * グループ変更ページビューアBean
 *
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupUpdatePageView implements ViewHelper {

    /** グループID */
    private String groupId;

    /** グループ名 */
    private String groupName;

    /** グループ変更日付 */
    private String groupUpdDt;

    /** グループ,権限List */
    private List<GroupAuthorityDetailView> groupAuthorityList;

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
     * グループ変更日付を取得します。
     * @return グループ変更日付
     */
    public String getGroupUpdDt() {
        return groupUpdDt;
    }

    /**
     * グループ変更日付を設定します。
     * @param groupUpdDt グループ変更日付
     */
    public void setGroupUpdDt(String groupUpdDt) {
        this.groupUpdDt = groupUpdDt;
    }

    /**
     * グループ名を設定します。
     * @param groupName グループ名
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * グループ,権限Listを取得します。
     * @return グループ,権限List
     */
    public List<GroupAuthorityDetailView> getGroupAuthorityList() {
        return groupAuthorityList;
    }

    /**
     * グループ,権限Listを設定します。
     * @param groupAuthorityList グループ,権限List
     */
    public void setGroupAuthorityList(List<GroupAuthorityDetailView> groupAuthorityList) {
        this.groupAuthorityList = groupAuthorityList;
    }

    public class GroupAuthorityDetailView {

        /** グループID */
        private String groupId;

        /** グループ名 */
        private String groupName;

        /** 権限ID */
        private String authorityId;

        /** 権限名 */
        private String authorityName;

        /** 権限更新日付 */
        private String authorityUpdDt;

        /** グループ更新者 */
        private String authorityUpdId;

        /** 権限有無 */
        private String authorityExist;

        /**
         * 権限有無を取得します。
         * @return authorityExist 権限有無
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

        /**
         * 権限Idを取得します。
         * @return authorityId 権限Id
         */
        public String getAuthorityId() {
            return authorityId;
        }

        /**
         * 権限Idを設定します。
         * @param authorityId 権限Id
         */
        public void setAuthorityId(String authorityId) {
            this.authorityId = authorityId;
        }

        /**
         * 権限名を取得します。
         * @return authorityName 権限名
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
         * グループIdを取得します。
         * @return groupId グループId
         */
        public String getGroupId() {
            return groupId;
        }

        /**
         * グループIdを設定します。
         * @param groupId グループId
         */
        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        /**
         * グループ名を取得します。
         * @return groupName グループ名
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
         * 権限更新日付を取得します。
         * @return authorityUpdDt 権限更新日付
         */
        public String getAuthorityUpdDt() {
            return authorityUpdDt;
        }

        /**
         * 権限更新日付を設定します。
         * @param authorityUpdDt 権限更新日付
         */
        public void setAuthorityUpdDt(String authorityUpdDt) {
            this.authorityUpdDt = authorityUpdDt;
        }

        /**
         * 権限更新者Idを取得します。
         * @return authorityUpdId
         */
        public String getAuthorityUpdId() {
            return authorityUpdId;
        }

        /**
         * 権限更新者Idを設定します。
         * @param authorityUpdId
         */
        public void setAuthorityUpdId(String authorityUpdId) {
            this.authorityUpdId = authorityUpdId;
        }

    }

}
