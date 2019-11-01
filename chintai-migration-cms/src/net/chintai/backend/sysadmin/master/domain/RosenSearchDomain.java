/*
 * $Id: RosenSearchDomain.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.master.domain;

/**
 * 沿線・駅照会Bean
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenSearchDomain {

    /** 沿線コード */
    private String ensenCd;

    /** 沿線名称 */
    private String ensenName;

    /** タイプ */
    private String ensenType;

    /** エリアコード */
    private String areaCd;

    /** エリア */
    private String areaName;

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
     * タイプを取得します。
     * @return タイプ
     */
    public String getEnsenType() {
        return ensenType;
    }

    /**
     * タイプを設定します。
     * @param ensenType タイプ
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
     * エリアを取得します。
     * @return エリア
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * エリアを設定します。
     * @param areaName エリア
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

}
