/*
 * $Id: GroupDeleteCommitParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/27  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao;


/**
 * グループ削除完了ParamBean
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupDeleteCommitParamBean {

    /** グループID */
    private String groupId;

    /** グループ最新更新日時 */
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
     * グループ最新更新日時を取得します。
     * @return グループ最新更新日時
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * グループ最新更新日時を設定します。
     * @param updDt グループ最新更新日時
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

}
