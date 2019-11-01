/*
 * $Id: GroupUpdateCommitInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)沈鍾沿       新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service.bean;

/**
 * グループ設定変更完了Bean
 *
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupUpdateCommitInServiceBean {

    /** グループID */
    private int groupId;

    /** グループ名 */
    private String groupName;

    /** グループ更新日付 */
    private String groupUpdDt;

    /** 利用可能な機能 */
    private String[] authorityId;

    /** 更新者ID */
    private String updId;

    private String pgName;

    /**
     * グループIDを取得します。
     * @return グループID
     */
    public int getGroupId() {
        return groupId;
    }

    /**
     * グループIDを設定します。
     * @param groupId グループID
     */
    public void setGroupId(int groupId) {
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
     * グループ更新日付を取得します。
     * @return グループ更新日付
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
     * 利用可能な機能を取得します。
     * @return 利用可能な機能
     */
    public String[] getAuthorityId() {
        return authorityId;
    }

    /**
     * 利用可能な機能を設定します。
     * @param authorityId 利用可能な機能
     */
    public void setAuthorityId(String[] authorityId) {
        this.authorityId = authorityId;
    }

    /**
     * 更新者IDを取得します。
     * @return 更新者ID
     */
    public String getUpdId() {
        return updId;
    }

    /**
     * 更新者IDを設定します。
     * @param updId 更新者ID
     */
    public void setUpdId(String updId) {
        this.updId = updId;
    }

	/**
	 * @return pgName
	 */
	public String getPgName() {
		return pgName;
	}

	/**
	 * @param pgName セットする pgName
	 */
	public void setPgName(String pgName) {
		this.pgName = pgName;
	}

}
