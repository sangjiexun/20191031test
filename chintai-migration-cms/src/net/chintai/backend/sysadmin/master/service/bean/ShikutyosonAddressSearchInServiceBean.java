/*
 * $Id: ShikutyosonAddressSearchInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.master.service.bean;

/**
 * 市区町村メンテナンス検索情報条件（名称）Bean
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShikutyosonAddressSearchInServiceBean {

    /** 都道府県コード */
    private String pref;

    /** 市区町村コード */
    private String city;

    /**
     * 都道府県コードを取得します。
     * @return 都道府県コード
     */
    public String getPref() {
        return pref;
    }

    /**
     * 都道府県コードを設定します。
     * @param pref 都道府県コード
     */
    public void setPref(String pref) {
        this.pref = pref;
    }

    /**
     * 市区町村コードを取得します。
     * @return 市区町村コード
     */
    public String getCity() {
        return city;
    }

    /**
     * 市区町村コードを設定します。
     * @param city 市区町村コード
     */
    public void setCity(String city) {
        this.city = city;
    }

}
