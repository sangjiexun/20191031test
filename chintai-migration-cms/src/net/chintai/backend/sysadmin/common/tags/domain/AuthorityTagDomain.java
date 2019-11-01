/*
 * $Id: AuthorityTagDomain.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/19  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.common.tags.domain;

/**
 * 操作内容プルダウン
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AuthorityTagDomain {

    /** 操作ID */
    private String authorityId;

    /** 操作名称 */
    private String authorityName;

    /**
     * 操作IDを取得します。
     * @return 操作ID
     */
    public String getAuthorityId() {
        return authorityId;
    }

    /**
     * 操作IDを設定します。
     * @param authorityId 操作ID
     */
    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
    }

    /**
     * 操作名称を取得します。
     * @return 操作名称
     */
    public String getAuthorityName() {
        return authorityName;
    }

    /**
     * 操作名称を設定します。
     * @param authorityName 操作名称
     */
    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

}
