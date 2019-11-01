/*
 * $Id: ShikutyosonClientSettingDomain.java 4800 2014-01-10 05:02:50Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/12/27     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.domain;


/**
 * 市区町村データ元出力設定取得用Domain
 * @author KAMEDA Takuma
 * @version $Revision: 4800 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShikutyosonClientSettingDomain {

    /** 全国都道府県JISコード */
    private String cityCd;

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
