/*
 * $Id: Group.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/18  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.domain;

/**
 * グループのクラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class Group {

    /** グループID */
    private int groupId;

    /** グループ名 */
    private String groupName;

    /** 権限ID */
    private String authorityId;

    /** グループ登録者ID */
    private String insID;

    /** グループ登録日付 */
    private String insDt;

    /** グループ更新者 */
    private String updID;

    /** グループ更新日付 */
    private String updDt;

    /** グループ登録PG */
    private String pgName;

    /**
     * デフォルトコンストラクタ。
     */
    public Group() {

    }
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
     * 権限IDを取得します。
     * @return 権限ID
     */
    public String getAuthorityId() {
        return authorityId;
    }

    /**
     * 権限ID
     * @param authorityId 権限ID
     */
    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
    }

    /**
     * グループ登録者IDを取得します。
     * @return グループ登録者ID
     */
    public String getInsID() {
        return insID;
    }

    /**
     * グループ登録者IDを設定します。
     * @param insID グループ登録者ID
     */
    public void setInsID(String insID) {
        this.insID = insID;
    }

    /**
     * グループ登録日付を取得します。
     * @return グループ登録日付
     */
    public String getInsDt() {
        return insDt;
    }

    /**
     * グループ登録日付を設定します。
     * @param insDt グループ登録日付
     */
    public void setInsDt(String insDt) {
        this.insDt = insDt;
    }

    /**
     * グループ更新者を取得します。
     * @return グループ更新者ID
     */
    public String getUpdID() {
        return updID;
    }

    /**
     * グループ更新者を設定します。
     * @param updID グループ更新者ID
     */
    public void setUpdID(String updID) {
        this.updID = updID;
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
