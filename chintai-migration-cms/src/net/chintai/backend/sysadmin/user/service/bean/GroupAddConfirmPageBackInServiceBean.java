/*
 * $Id: GroupAddConfirmPageBackInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/27  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service.bean;

/**
 * グループ追加確認の戻る用InServiceBean
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupAddConfirmPageBackInServiceBean {

    /** グループID */
    private String groupName;

    /** 権限ID */
    private String[] authorityId;

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
