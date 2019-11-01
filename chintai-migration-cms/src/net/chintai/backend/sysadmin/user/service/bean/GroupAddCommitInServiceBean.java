/*
 * $Id: GroupAddCommitInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)沈鍾沿       新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service.bean;

/**
 * グループ登録完了Bean
 *
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupAddCommitInServiceBean {

    /** グループID */
    private String groupName;

    /** 権限ID */
    private String[] authorityId;

    /** 登録者ID */
    private String operUserId;

    /** レコード登録プログラムID */
    private String pgName;

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

    /**
     * 登録者IDを取得します。
     * @return operUserId 登録者ID
     */
    public String getOperUserId() {
        return operUserId;
    }

    /**
     * 登録者IDを設定します。
     * @param operUserId 登録者ID
     */
    public void setOperUserId(String operUserId) {
        this.operUserId = operUserId;
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
