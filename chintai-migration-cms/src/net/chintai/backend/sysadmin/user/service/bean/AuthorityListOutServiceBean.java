/*
 * $Id: AuthorityListOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/18  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service.bean;

/**
 * グループの権限一覧Bean
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AuthorityListOutServiceBean {

    /** 権限ID */
    private String authorityId;

    /** 権限名 */
    private String authorityName;

    /** 権限更新日付 */
    private String updDt;

    /** 権限更新者 */
    private String updID;

    /**
     * デフォルトコンストラクタ。
     */
    public AuthorityListOutServiceBean() {
    }

    /**
     * 権限IDを取得します。
     * @return authorityId 権限ID
     */
    public String getAuthorityId() {
        return authorityId;
    }

    /**
     * 権限IDを設定します。
     * @param authorityId 権限ID
     */
    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
    }

    /**
     * 権限名を取得します。
     * @return authorityName 権限名
     */
    public String getAuthorityName() {
        return authorityName;
    }

    /**
     * 権限名を設定します。
     * @param authorityName 権限名
     */
    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    /**
     * 権限更新日付取得します。
     * @return updDt
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 権限更新日付を設定します。
     * @param updDt 権限更新日付
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
     * 権限更新者IDを取得します。
     * @return updID
     */
    public String getUpdID() {
        return updID;
    }

    /**
     * 権限更新者IDを設定します。
     * @param updID 権限更新者ID
     */
    public void setUpdID(String updID) {
        this.updID = updID;
    }

}
