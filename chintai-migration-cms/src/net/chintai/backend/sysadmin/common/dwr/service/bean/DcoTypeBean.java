/*
 * $Id: DcoTypeBean.java 4773 2014-01-09 08:06:59Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/11/08     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.common.dwr.service.bean;


/**
 * 連携対象マスタ検索サービス用Bean
 * @author KAMEDA Takuma
 * @version $Revision: 4773 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class DcoTypeBean {

    /** 他社データ連携種類 */
    private String dcoType;

    /** 連携対象会社名 */
    private String dcoName;

    /**
     * 他社データ連携出力設定用BeanのConstructor
     * @param dcoType
     * @param dcoName
     */
    public DcoTypeBean(String dcoType, String dcoName){
        this.dcoType = dcoType;
        this.dcoName = dcoName;
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

    /**
     * 連携対象会社名を取得します。
     * @return 連携対象会社名
     */
    public String getDcoName() {
        return dcoName;
    }

    /**
     * 連携対象会社名を設定します。
     * @param dcoName 連携対象会社名
     */
    public void setDcoName(String dcoName) {
        this.dcoName = dcoName;
    }


}
