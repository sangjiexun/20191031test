/*
 * $Id: GroupAddView.java 3570 2007-12-14 08:55:47Z t-kojima $
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
 * グループ登録Bean
 *
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupAddView implements ViewHelper {

    /** グループID */
    private String groupName;

    /** 権限リスト */
    private List<AuthorityListDetailView> authorityList;

    /**
     * グループIDを取得します。
     * @return グループID
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * グループIDを設定します。
     * @param groupName グループID
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * 権限リストを取得します。
     * @return 権限リスト
     */
    public List<AuthorityListDetailView> getAuthorityList() {
        return authorityList;
    }

    /**
     * 権限リストを設定します。
     * @param authorityList 権限リスト
     */
    public void setAuthorityList(List<AuthorityListDetailView> authorityList) {
        this.authorityList = authorityList;
    }

    public class AuthorityListDetailView {

        /** 権限ID */
        private String authorityId;

        /** 権限名 */
        private String authorityName;

        /** 権限有無 */
        private String authorityExist;

        /** 権限更新日付 */
        private String updDt;

        /** 権限更新者 */
        private String updID;

        /**
         * 権限IDを取得します。
         * @return authorityId 権限ID
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
         * 権限更新日付取得します。
         * @return updDt
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
         * 権限更新者IDを取得します。
         * @return updID
         */
        public String getUpdID() {
            return updID;
        }

        /**
         * 権限更新者IDを設定します。
         * @param updID 権限更新者ID
         */
        public void setUpdID(String updID) {
            this.updID = updID;
        }

    }

}
