/*
 * $Id: MobileMaintenanceListInfo.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 * 2007/11/13  BGT)楊恩美     修正
 * 
 */
package net.chintai.backend.sysadmin.master.domain;

/**
 * 携帯ゲーム対応機種メンテナンス検索Bean
 * 
 * @author JavaBeans Code Generator
 * @author yang-eunmi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MobileMaintenanceListInfo {

    /** SEQ */
    private String dlSeq;

    /** 商品コード */
    private String itemCd;

    /** キャリア */
    private String carrierType;

    /** 機種名 */
    private String userAgent;

    /** ファイル名 */
    private String fileName;

    /** ファイルタイプ※ezwebのみ */
    private String discription;

    /** 最終更新日時 */
    private String updDt;

    /**
     * キャリアを取得します。
     * @return キャリア
     */
    public String getCarrierType() {
        return carrierType;
    }

    /**
     * キャリアを設定します。
     * @param carrierType キャリア
     */
    public void setCarrierType(String carrierType) {
        this.carrierType = carrierType;
    }

    /**
     * ファイルタイプ※ezwebのみを取得します。
     * @return ファイルタイプ※ezwebのみ
     */
    public String getDiscription() {
        return discription;
    }

    /**
     * ファイルタイプ※ezwebのみを設定します。
     * @param discription ファイルタイプ※ezwebのみ
     */
    public void setDiscription(String discription) {
        this.discription = discription;
    }

    /**
     * SEQを取得します。
     * @return SEQ
     */
    public String getDlSeq() {
        return dlSeq;
    }

    /**
     * SEQを設定します。
     * @param dlSeq SEQ
     */
    public void setDlSeq(String dlSeq) {
        this.dlSeq = dlSeq;
    }

    /**
     * ファイル名を取得します。
     * @return ファイル名
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * ファイル名を設定します。
     * @param fileName ファイル名
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 商品コードを取得します。
     * @return 商品コード
     */
    public String getItemCd() {
        return itemCd;
    }

    /**
     * 商品コードを設定します。
     * @param itemCd 商品コード
     */
    public void setItemCd(String itemCd) {
        this.itemCd = itemCd;
    }

    /**
     * 最終更新日時を取得します。
     * @return 最終更新日時
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 最終更新日時を設定します。
     * @param updDt 最終更新日時
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
     * 機種名を取得します。
     * @return 機種名
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * 機種名を設定します。
     * @param userAgent 機種名
     */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

}
