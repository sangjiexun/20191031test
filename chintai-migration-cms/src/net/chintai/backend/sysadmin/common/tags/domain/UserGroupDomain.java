/*
 * $Id: UserGroupDomain.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/09/20  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.common.tags.domain;

/**
 * ユーザグループ検索結果を格納するクラス。
 * 
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserGroupDomain {

    /** グループID */
    private int id;

    /** グループ名称 */
    private String name;

    /**
     * デフォルトコンストラクタ
     */
    public UserGroupDomain() {
    }

    /**
     * グループIDを取得します。
     * @return グループID
     */
    public int getId() {
        return id;
    }

    /**
     * グループIDを設定します。
     * @param id グループID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * グループ名称を取得します。
     * @return グループ名称
     */
    public String getName() {
        return name;
    }

    /**
     * グループ名称を設定します。
     * @param name グループ名称
     */
    public void setName(String name) {
        this.name = name;
    }

}
