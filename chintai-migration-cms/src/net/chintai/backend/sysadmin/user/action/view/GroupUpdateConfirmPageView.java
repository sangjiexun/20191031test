/*
 * $Id: GroupUpdateConfirmPageView.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/25  BGT)沈鍾沿     新規作成
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
public class GroupUpdateConfirmPageView implements ViewHelper {

    /** グループID */
    private String groupId;

    /** グループ名 */
    private String groupName;

    /** グループ更新日付 */
    private String groupUpdDt;

    /** 権限リスト */
    private List<GroupByAuthorityDetailView> groupByAuthorityList;

    /**
     * グループIDを取得します。
     * @return groupId グループID
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
     * グループ更新日付を取得します。
     * @return groupUpdDt グループ更新日付
     */
    public String getGroupUpdDt() {
        return groupUpdDt;
    }

    /**
     * グループ更新日付を設定します。
     * @param groupUpdDt グループ更新日付
     */
    public void setGroupUpdDt(String groupUpdDt) {
        this.groupUpdDt = groupUpdDt;
    }

    /**
     * 権限リストを取得します。
     * @return groupByAuthorityList 権限リスト
     */
    public List<GroupByAuthorityDetailView> getGroupByAuthorityList() {
        return groupByAuthorityList;
    }

    /**
     * 権限リストを設定します。
     * @param groupByAuthorityList 権限リスト
     */
    public void setGroupByAuthorityList(List<GroupByAuthorityDetailView> groupByAuthorityList) {
        this.groupByAuthorityList = groupByAuthorityList;
    }

    public class GroupByAuthorityDetailView {

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
         * 権限更新日付を取得します。
         * @return updDt 権限更新日付
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
         * @return updID 権限更新者
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