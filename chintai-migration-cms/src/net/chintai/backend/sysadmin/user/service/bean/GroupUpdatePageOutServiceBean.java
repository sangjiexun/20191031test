/*
 * $Id: GroupUpdatePageOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)沈鍾沿     新規作成
 * 
 */
package net.chintai.backend.sysadmin.user.service.bean;

/**
 * グループ設定変更確認Bean
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupUpdatePageOutServiceBean {

    /** グループID */
    private String groupId;

    /** グループ名 */
    private String groupName;

    /** グループ変更日付 */
    private String groupUpdDt;

    /** 権限ID */
    private String authorityId;

    /** 権限名 */
    private String authorityName;

    /** 権限更新日付 */
    private String authorityUpdDt;

    /** 権限更新者 */
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
     * グループ変更日付を取得します。
     * @return groupUpdDt グループ変更日付
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
     * @return authorityUpdId 権限更新者Id
     */
    public String getAuthorityUpdId() {
        return authorityUpdId;
    }

    /**
     * 権限更新者Idを設定します。
     * @param authorityUpdId 権限更新者Id
     */
    public void setauthorityUpdId(String authorityUpdId) {
        this.authorityUpdId = authorityUpdId;
    }

}
