/*
 * $Id: RosenDetailInfoDomain.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.master.domain;

/**
 * 沿線・駅詳細(沿線詳細)Bean
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenDetailInfoDomain {

    /** 沿線タイプ */
    private String ensenType;

    /** 沿線名称 */
    private String ensenName;

    /** エリア */
    private String areaName;

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
