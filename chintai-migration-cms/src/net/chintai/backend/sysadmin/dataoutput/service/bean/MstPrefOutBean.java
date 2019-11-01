/*
 * $Id: MstPrefOutBean.java 4805 2014-01-10 05:54:22Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2014/01/07     BGT)亀田       E-0053_スマイティ用データ抽出　市区・駅対応 dcoName追加
 */
package net.chintai.backend.sysadmin.dataoutput.service.bean;


/**
 * MstPref情報のoutBean
 *
 * @author e-ishii
 * @version $Revision: 4805 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MstPrefOutBean {

    /** 都道府県コード */
    private String prefcd;

    /** 都道府県名 */
    private String prefname;

    /** 他社データ連携種類名 */
    private String dcoName;

    /**
     * 都道府県コードを取得します。
     * @return 都道府県コード
     */
    public String getPrefcd() {
        return prefcd;
    }

    /**
     * 都道府県コードを設定します。
     * @param prefcd 都道府県コード
     */
    public void setPrefcd(String prefcd) {
        this.prefcd = prefcd;
    }

    /**
     * 都道府県名を取得します。
     * @return 都道府県名
     */
    public String getPrefname() {
        return prefname;
    }

    /**
     * 都道府県名を設定します。
     * @param prefname 都道府県名
     */
    public void setPrefname(String prefname) {
        this.prefname = prefname;
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
