/*
 * $Id: ShikutyosonAddCommitDomain.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.master.domain;

/**
 * 市区町村の登録Bean
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShikutyosonAddCommitDomain {

    /** 市区町村 */
    private String cityName;

    /**
     * 市区町村を取得します。
     * @return 市区町村
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 市区町村を設定します。
     * @param cityName 市区町村
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

}
