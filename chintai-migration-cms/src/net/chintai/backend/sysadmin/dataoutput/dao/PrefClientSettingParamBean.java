/*
 * $Id: PrefClientSettingParamBean.java 4743 2013-11-05 08:53:59Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/24     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.dao;


/**
 * 都道府県別データ元出力設定データ取得用ParamBean
 * @author KAMEDA Takuma
 * @version $Revision: 4743 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class PrefClientSettingParamBean {

    /** 他社データ連携種類 */
    private String dcoType;

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
