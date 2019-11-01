/*
 * $Id: RosenClientSettingParamBean.java 4792 2014-01-10 02:47:00Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/31     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.dao;


/**
 * 他社データ連携沿線除外設定検索用ParamBean
 * @author KAMEDA Takuma
 * @version $Revision: 4792 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenClientSettingParamBean {

    /** 沿線タイプ */
    private String ensenType;
    
    /** エリアコード */
    private String areaCd;

    /** 他社データ連携種類 */
    private String dcoType;

    /**
     * 沿線タイプを取得します。
     * @return 沿線タイプ
     */
    public String getEnsenType() {
        return ensenType;
    }

    /**
     * 沿線タイプを設定します。
     * @param ensenType 沿線タイプ
     */
    public void setEnsenType(String ensenType) {
        this.ensenType = ensenType;
    }

    /**
     * エリアコードを取得します。
     * @return エリアコード
     */
    public String getAreaCd() {
        return areaCd;
    }

    /**
     * エリアコードを設定します。
     * @param areaCd エリアコード
     */
    public void setAreaCd(String areaCd) {
        this.areaCd = areaCd;
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
