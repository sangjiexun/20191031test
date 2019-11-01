/*
 * $Id: TodofukenDomain.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/09/11  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.common.tags.domain;

/**
 * 都道府県検索結果を格納するクラス。
 * 
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TodofukenDomain {

    /** エリア名称 */
    private String areaName;

    /** 都道府県コード */
    private String prefCd;

    /** 都道府県名称 */
    private String prefName;

    /**
     * デフォルトコンストラクタ
     */
    public TodofukenDomain() {
    }

    /**
     * エリア名称を取得します。
     * @return エリア名称
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * エリア名称を設定します。
     * @param areaName エリア名称
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 都道府県コードを取得します。
     * @return 都道府県コード
     */
    public String getPrefCd() {
        return prefCd;
    }

    /**
     * 都道府県コードを設定します。
     * @param prefCd 都道府県コード
     */
    public void setPrefCd(String prefCd) {
        this.prefCd = prefCd;
    }

    /**
     * 都道府県名称を取得します。
     * @return 都道府県名称
     */
    public String getPrefName() {
        return prefName;
    }

    /**
     * 都道府県名称を設定します。
     * @param prefName 都道府県名称
     */
    public void setPrefName(String prefName) {
        this.prefName = prefName;
    }
}
