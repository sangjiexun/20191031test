/*
 * $Id: ShisyaNameSearchInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/03  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.bean;

/**
 * 支社名称検索条件
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShisyaNameSearchInServiceBean {

    /** 支社コード */
    private String shisyaCd;

    /**
     * 支社コードを取得します。
     * @return 支社コード
     */
    public String getShisyaCd() {
        return shisyaCd;
    }

    /**
     * 支社コードを設定します。
     * @param shisyaCd 支社コード
     */
    public void setShisyaCd(String shisyaCd) {
        this.shisyaCd = shisyaCd;
    }
}
