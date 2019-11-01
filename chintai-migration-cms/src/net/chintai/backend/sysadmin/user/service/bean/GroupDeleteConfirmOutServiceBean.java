/*
 * $Id: GroupDeleteConfirmOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)沈鍾沿     新規作成
 * 
 */
package net.chintai.backend.sysadmin.user.service.bean;

/**
 * グループ削除確認Bean
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupDeleteConfirmOutServiceBean {

    /** グループID */
    private String groupId;

    /** グループ名のリスト */
    private String groupName;

    /** グループ更新日付 */
    private String updDt;

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
     * グループ名のリストを取得します。
     * @return グループ名のリスト
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * グループ名のリストを設定します。
     * @param groupName グループ名のリスト
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

}
