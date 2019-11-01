/*
 * $Id: EkiClientSettingInfoOutServiceBean.java 4803 2014-01-10 05:38:20Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/12/18     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service.bean;


/**
 * 駅別データ元出力設定表示用OutBean
 * @author KAMEDA Takuma
 * @version $Revision: 4803 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class EkiClientSettingInfoOutServiceBean {

    /** 駅コード */
    private String ekiCd;

    /** 駅名 */
    private String ekiName;

    /** クライアントシステムタイプ */
    private String clientsystemType;

    /**
     * 駅コードを取得します。
     * @return 駅コード
     */
    public String getEkiCd() {
        return ekiCd;
    }

    /**
     * 駅コードを設定します。
     * @param ekiCd 駅コード
     */
    public void setEkiCd(String ekiCd) {
        this.ekiCd = ekiCd;
    }

    /**
     * 駅名を取得します。
     * @return 駅名
     */
    public String getEkiName() {
        return ekiName;
    }

    /**
     * 駅名を設定します。
     * @param ekiName 駅名
     */
    public void setEkiName(String ekiName) {
        this.ekiName = ekiName;
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
