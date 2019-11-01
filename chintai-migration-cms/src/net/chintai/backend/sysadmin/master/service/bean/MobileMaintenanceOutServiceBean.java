/*
 * $Id: MobileMaintenanceOutServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/13  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service.bean;

/**
 * 携帯ゲーム対応機種メンテナンスoutServiceBean
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MobileMaintenanceOutServiceBean {

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
     * ファイル名を設定します。
     * @return ファイル名
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * ファイル名を取得します。
     * @param fileName ファイル名
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
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
     * 商品コードを設定します。
     * @return 商品コード
     */
    public String getItemCd() {
        return itemCd;
    }

    /**
     * 商品コードを取得します。
     * @param itemCd 商品コード
     */
    public void setItemCd(String itemCd) {
        this.itemCd = itemCd;
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
     * 機種名を設定します。
     * @return 機種名
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * 機種名を取得します。
     * @param userAgent 機種名
     */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
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

}
