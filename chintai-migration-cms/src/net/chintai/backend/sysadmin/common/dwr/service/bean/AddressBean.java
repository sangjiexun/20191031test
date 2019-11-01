/*
 * $Id: AddressBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/26  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.common.dwr.service.bean;

/**
 * 消費者検索の市区町村以下の町域名
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AddressBean {

    /** 郵便番号 */
    private String zipCode;

    /** 市区町村以下の町域名 */
    private String address;

    /**
     * 消費者検索の市区町村以下の町域名BeanのConstructor
     * @param zipCode 郵便番号
     * @param address 市区町村以下の町域名
     */
    public AddressBean(String zipCode, String address) {
        this.zipCode = zipCode;
        this.address = address;
    }

    /**
     * 市区町村以下の町域名を取得します。
     * @return address 市区町村以下の町域名
     */
    public String getAddress() {
        return address;
    }

    /**
     * 市区町村以下の町域名を設定します。
     * @param address 市区町村以下の町域名
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 郵便番号を取得します。
     * @return zipCode 郵便番号
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * 郵便番号を設定します。
     * @param zipCode 郵便番号
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}