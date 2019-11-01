/*
 * $Id: ShisyaNameSearchDomain.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/03  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.domain;

/**
 * 支社名称検索結果
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShisyaNameSearchDomain {

    /** 支社名称 */
    private String shisyaName;

    /**
     * 支社名称を取得します。
     * @return 支社名称
     */
    public String getShisyaName() {
        return shisyaName;
    }

    /**
     * 支社名称を設定します。
     * @param shisyaName 支社名称
     */
    public void setShisyaName(String shisyaName) {
        this.shisyaName = shisyaName;
    }
}
