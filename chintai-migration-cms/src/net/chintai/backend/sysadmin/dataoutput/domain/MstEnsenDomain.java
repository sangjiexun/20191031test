/*
 * $Id: MstEnsenDomain.java 4800 2014-01-10 05:02:50Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/31     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.domain;


/**
 * MST_ENSEN用Domain
 * @author KAMEDA Takuma
 * @version $Revision: 4800 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MstEnsenDomain {

    /** 沿線コード */
    private String ensenCd;

    /** 沿線名称 */
    private String ensenName;

    /** 沿線名称かな */
    private String ensenKana;

    /** エリア名称 */
    private String areaName;

    /** 沿線タイプ */
    private String ensenType;

    /** 他社データ連携種類名 */
    private String dcoName;

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
     * エリア名称を取得します。
     * @return エリア名称
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * エリア名称を設定します。
     * @param areaName エリア名称
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

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
     * 他社データ連携種類名を取得します。
     * @return 他社データ連携種類名
     */
    public String getDcoName() {
        return dcoName;
    }

    /**
     * 他社データ連携種類名を設定します。
     * @param dcoName 他社データ連携種類名
     */
    public void setDcoName(String dcoName) {
        this.dcoName = dcoName;
    }


}
