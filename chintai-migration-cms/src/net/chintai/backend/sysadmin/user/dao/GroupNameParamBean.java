/*
 * $Id: GroupNameParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/26  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao;

/**
 * ユーザグループ名を取得ParamBean
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupNameParamBean {

    /** グループ */
    private String groupId;

    /**
     * グループを取得します。
     * @return グループID
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * グループを設定します。
     * @param groupId グループID
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}