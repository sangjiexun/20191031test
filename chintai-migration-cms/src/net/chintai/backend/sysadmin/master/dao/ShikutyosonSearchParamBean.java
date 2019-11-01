/*
 * $Id: ShikutyosonSearchParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.master.dao;

/**
 * 市区町村検索Bean
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShikutyosonSearchParamBean {

    /** 郵便番号 */
    private String zipCd;

    /** 住所（都道府県） */
    private String pref;

    /** 住所（市区町村） */
    private String city;

    /**
     * 郵便番号を取得します。
     * @return 郵便番号
     */
    public String getZipCd() {
        return zipCd;
    }

    /**
     * 郵便番号を設定します。
     * @param zipCd 郵便番号
     */
    public void setZipCd(String zipCd) {
        this.zipCd = zipCd;
    }

    /**
     * 住所（都道府県）を取得します。
     * @return 住所（都道府県）
     */
    public String getPref() {
        return pref;
    }

    /**
     * 住所（都道府県）を設定します。
     * @param pref 住所（都道府県）
     */
    public void setPref(String pref) {
        this.pref = pref;
    }

    /**
     * 住所（市区町村）を取得します。
     * @return 住所（市区町村）
     */
    public String getCity() {
        return city;
    }

    /**
     * 住所（市区町村）を設定します。
     * @param city 住所（市区町村）
     */
    public void setCity(String city) {
        this.city = city;
    }

}
