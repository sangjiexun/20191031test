/*
 * $Id: GroupUpdateConfirmPageInService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/26  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service.bean;

/**
 * グループ変更確認用InServiceBean
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupUpdateConfirmPageInService {

    /** グループID */
    private String groupId;

    /** グループID */
    private String groupName;

    /** グループ更新日付 */
    private String groupUpdDt;

    /** 権限ID */
    private String[] authorityId;

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
     * 権限IDを取得します。
     * @return authorityId 権限ID
     */
    public String[] getAuthorityId() {
        return authorityId;
    }

    /**
     * 権限IDを設定します。
     * @param authorityId 権限ID
     */
    public void setAuthorityId(String[] authorityId) {
        this.authorityId = authorityId;
    }

}
