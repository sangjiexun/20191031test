/*
 * $Id: AuthParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/08/08     BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.common.dao;

/**
 * アクセス権限認証DAOの検索パラメータを取扱うBean。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AuthParamBean {

    /** ユーザID */
    private String userId;

    /** 権限ID */
    private String authorityId;

    /**
     * ユーザIDを取得します。
     * @return ユーザID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * ユーザIDを設定します。
     * @param userId ユーザID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 権限IDを取得します。
     * @return 権限ID
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
}
