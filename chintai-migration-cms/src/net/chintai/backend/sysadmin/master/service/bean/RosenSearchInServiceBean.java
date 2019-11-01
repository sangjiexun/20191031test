/*
 * $Id: RosenSearchInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 
 */
package net.chintai.backend.sysadmin.master.service.bean;

import net.chintai.backend.sysadmin.common.session.SessionSearchCondition;

/**
 * 沿線・駅検索条件Bean
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenSearchInServiceBean implements SessionSearchCondition {

    /** serialVersionUID */
    private static final long serialVersionUID = 8781423434095824467L;

    /** エリア */
    private String areaCd;

    /** 沿線タイプ */
    private String ensenType;

    /**
     * エリアを取得します。
     * @return エリア
     */
    public String getAreaCd() {
        return areaCd;
    }

    /**
     * エリアを設定します。
     * @param areaCd エリア
     */
    public void setAreaCd(String areaCd) {
        this.areaCd = areaCd;
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

}
