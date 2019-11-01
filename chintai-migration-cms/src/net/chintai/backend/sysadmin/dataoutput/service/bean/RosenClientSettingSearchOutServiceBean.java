/*
 * $Id: RosenClientSettingSearchOutServiceBean.java 4806 2014-01-10 06:19:16Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/31     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service.bean;


/**
 * 沿線別データ元除外設定情報取得用OutServiceBean
 * @author KAMEDA Takuma
 * @version $Revision: 4806 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenClientSettingSearchOutServiceBean {

    /** 沿線コード */
    private String ensenCd;

    /** 沿線名称 */
    private String ensenName;

    /** 沿線名称かな */
    private String ensenKana;

    /** クライアントシステムタイプ */
    private String clientsystemType;


    /**
     * 沿線コードを取得します。
     * @return 沿線コード
     */
    public String getEnsenCd() {
        return ensenCd;
    }

    /**
     * 沿線コードを設定します。
     * @param ensenCd 沿線コード
     */
    public void setEnsenCd(String ensenCd) {
        this.ensenCd = ensenCd;
    }

    /**
     * 沿線名称を取得します。
     * @return 沿線名称
     */
    public String getEnsenName() {
        return ensenName;
    }

    /**
     * 沿線名称を設定します。
     * @param ensenName 沿線名称
     */
    public void setEnsenName(String ensenName) {
        this.ensenName = ensenName;
    }

    /**
     * 沿線名称かなを取得します。
     * @return 沿線名称かな
     */
    public String getEnsenKana() {
        return ensenKana;
    }

    /**
     * 沿線名称かなを設定します。
     * @param ensenKana 沿線名称かな
     */
    public void setEnsenKana(String ensenKana) {
        this.ensenKana = ensenKana;
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
