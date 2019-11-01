/*
 * $Id: ShikutyosonAddParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/14  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.master.dao;

/**
 * 市区町村登録paramBean
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShikutyosonAddParamBean {

    /** 全国都道府県JISコード */
    private String cityCd;

    /** 市区町村名 */
    private String cityName;

    /** 郵便番号（7桁） */
    private String zipCd;

    /** 旧郵便番号（3～5桁） */
    private String oldZipCd;

    /** 市区町村以下の町域名 */
    private String address;

    /** 登録プログラムID */
    private String insPg;

    /** 登録者 */
    private String insId;

    /** 更新プログラムID */
    private String updPg;

    /** 更新者 */
    private String updId;

    /**
     * 全国都道府県JISコードを取得します。
     * @return 全国都道府県JISコード
     */
    public String getCityCd() {
        return cityCd;
    }

    /**
     * 全国都道府県JISコードを設定します。
     * @param cityCd 全国都道府県JISコード
     */
    public void setCityCd(String cityCd) {
        this.cityCd = cityCd;
    }

    /**
     * 登録プログラムIDを設定します。
     * @return 登録プログラムID
     */
    public String getInsPg() {
        return insPg;
    }

    /**
     * 登録プログラムIDを取得します。
     * @param insPg 登録プログラムID
     */
    public void setInsPg(String insPg) {
        this.insPg = insPg;
    }

    /**
     * 登録者を取得します。
     * @return 登録者
     */
    public String getInsId() {
        return insId;
    }

    /**
     * 登録者を設定します。
     * @param insId 登録者
     */
    public void setInsId(String insId) {
        this.insId = insId;
    }

    /**
     * 更新プログラムIDを設定します。
     * @return 更新プログラムID
     */
    public String getUpdPg() {
        return updPg;
    }

    /**
     * 更新プログラムIDを取得します。
     * @param updPg 更新プログラムID
     */
    public void setUpdPg(String updPg) {
        this.updPg = updPg;
    }

    /**
     * 市区町村以下の町域名を設定します。
     * @return 市区町村以下の町域名
     */
    public String getAddress() {
        return address;
    }

    /**
     * 市区町村以下の町域名を取得します。
     * @param address 市区町村以下の町域名
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 旧郵便番号（3～5桁）を設定します。
     * @return 旧郵便番号（3～5桁）
     */
    public String getOldZipCd() {
        return oldZipCd;
    }

    /**
     * 旧郵便番号（3～5桁）を取得します。
     * @param oldZipCd 旧郵便番号（3～5桁）
     */
    public void setOldZipCd(String oldZipCd) {
        this.oldZipCd = oldZipCd;
    }

    /**
     * 市区町村名を取得します。
     * @return 市区町村名
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 市区町村名を設定します。
     * @param cityName 市区町村名
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * 郵便番号（7桁）を設定します。
     * @return 郵便番号（7桁）
     */
    public String getZipCd() {
        return zipCd;
    }

    /**
     * 郵便番号（7桁）を取得します。
     * @param zipCd 郵便番号（7桁）
     */
    public void setZipCd(String zipCd) {
        this.zipCd = zipCd;
    }

    /**
     * 更新者を取得します。
     * @return 更新者
     */
    public String getUpdId() {
        return updId;
    }

    /**
     * 更新者を設定します。
     * @param updId 更新者
     */
    public void setUpdId(String updId) {
        this.updId = updId;
    }
}
