/*
 * $Id: GroupListOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)沈鍾沿     新規作成
 * 
 */
package net.chintai.backend.sysadmin.user.service.bean;

/**
 * グループ一覧Bean
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupListOutServiceBean {

    /** グループID */
    private String groupId;

    /** グループ名 */
    private String groupName;

    /** 利用可能な機能 */
    private String authorityId;

    /** グループ更新日付 */
    private String updDt;

    /** グループ更新者 */
    private String updID;

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
     * 利用可能な機能を取得します。
     * @return 利用可能な機能
     */
    public String getAuthorityId() {
        return authorityId;
    }

    /**
     * 利用可能な機能を設定します。
     * @param authorityId 利用可能な機能
     */
    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
    }

    /**
     * グループ更新日付を取得します。
     * @return グループ更新日付
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * グループ更新日付を設定します。
     * @param updDt グループ更新日付
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
     * グループ更新者を取得します。
     * @return グループ更新者
     */
    public String getUpdID() {
        return updID;
    }

    /**
     * グループ更新者を設定します。
     * @param updID グループ更新者
     */
    public void setUpdID(String updID) {
        this.updID = updID;
    }

}
