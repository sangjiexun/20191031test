/*
 * $Id: PrefNameSearchOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/26  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.bean;

/**
 * 都道府県名称検索結果
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class PrefNameSearchOutServiceBean {

    /** 都道府県名称 */
    private String prefName;

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
