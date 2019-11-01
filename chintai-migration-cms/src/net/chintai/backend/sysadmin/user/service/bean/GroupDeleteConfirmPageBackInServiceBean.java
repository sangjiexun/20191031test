/*
 * $Id: GroupDeleteConfirmPageBackInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/27  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service.bean;

/**
 * グループ削除確認の戻る用InServiceBean
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupDeleteConfirmPageBackInServiceBean {

    /** グループID */
    private String[] groupId;

    /**
     * グループIDを取得します。
     * @return グループID
     */
    public String[] getGroupId() {
        return groupId;
    }

    /**
     * グループIDを設定します。
     * @param groupId グループID
     */
    public void setGroupId(String[] groupId) {
        this.groupId = groupId;
    }

}
