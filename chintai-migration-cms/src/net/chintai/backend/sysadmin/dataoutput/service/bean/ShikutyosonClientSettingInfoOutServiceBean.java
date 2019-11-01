/*
 * $Id: ShikutyosonClientSettingInfoOutServiceBean.java 4806 2014-01-10 06:19:16Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/12/27     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service.bean;


/**
 * 市区町村別データ元出力設定表示用OutBean
 * @author KAMEDA Takuma
 * @version $Revision: 4806 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShikutyosonClientSettingInfoOutServiceBean {

    /** 全国都道府県JISコード */
    private String cityCd;

    /** 市区町村名 */
    private String cityName;

    /** クライアントシステムタイプ */
    private String clientsystemType;

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
     * クライアントシステムタイプを取得します。
     * @return クライアントシステムタイプ
     */
    public String getClientsystemType() {
        return clientsystemType;
    }

    /**
     * クライアントシステムタイプを設定します。
     * @param clientsystemType クライアントシステムタイプ
     */
    public void setClientsystemType(String clientsystemType) {
        this.clientsystemType = clientsystemType;
    }

}
