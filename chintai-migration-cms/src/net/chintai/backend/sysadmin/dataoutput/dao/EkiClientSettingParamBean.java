/*
 * $Id: EkiClientSettingParamBean.java 4792 2014-01-10 02:47:00Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/12/18     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.dao;


/**
 * 他社データ連携駅除外設定取得用ParamBean
 * @author KAMEDA Takuma
 * @version $Revision: 4792 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class EkiClientSettingParamBean {

    /** 沿線コード */
    private String ensenCd;

    /** 他社データ連携種類 */
    private String dcoType;

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
     * 他社データ連携種類を取得します。
     * @return 他社データ連携種類
     */
    public String getDcoType() {
        return dcoType;
    }

    /**
     * 他社データ連携種類を設定します。
     * @param dcoType 他社データ連携種類
     */
    public void setDcoType(String dcoType) {
        this.dcoType = dcoType;
    }
}
