/*
 * $Id: EnsenListParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/10/16   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.common.dwr.dao;

/**
 * 沿線リスト取得のためのパラメータを保持するBean。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class EnsenListParamBean {

    /** エリアコード */
    private String areaCode;

    /** 沿線タイプ */
    private String ensenType;

    /**
     * エリアコードを取得します。
     * @return エリアコード
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * エリアコードを設定します。
     * @param areaCode エリアコード
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
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
