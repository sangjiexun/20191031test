/*
 * $Id: UserUpdateConfirmOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/26  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service.bean;

/**
 * ユーザ管理Bean
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserUpdateConfirmOutServiceBean {

    /** グループ */
    private String groupName;

    /**
     * グループを取得します。
     * @return グループ
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * グループを設定します。
     * @param groupName グループ
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
