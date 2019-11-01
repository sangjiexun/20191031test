/*
 * $Id: TorihikisakiWakuMaintenanceDownloadOutServiceBean.java 4700 2013-10-25 02:49:00Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/09/18     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.bean;


/**
 * 物件枠数・物件リスティング枠数のCSVダウンロード用OutServiceBean
 * @author KAMEDA Takuma
 * @version $Revision: 4700 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuMaintenanceDownloadOutServiceBean {

    /** 取引先シーケンス */
    private String torihikisakiSeq;

    /** 取引先コード(不動産会社コード - 取引先コード) */
    private String torihikisakiCd;

    /** 不動産会社名 */
    private String fudousanKaisyaName;

    /** 取引先名 */
    private String torihikisakiName;

    /** 適用月 */
    private String startYm;

    /** 物件枠 */
    private String bukkenCount;

    /** 物件リスティング */
    private String tokusenCount;

    /**
     * 取引先シーケンスを取得します。
     * @return 取引先シーケンス
     */
    public String getTorihikisakiSeq() {
        return torihikisakiSeq;
    }

    /**
     * 取引先シーケンスを設定します。
     * @param torihikisakiSeq 取引先シーケンス
     */
    public void setTorihikisakiSeq(String torihikisakiSeq) {
        this.torihikisakiSeq = torihikisakiSeq;
    }

    /**
     * 取引先コード(不動産会社コード - 取引先コード)を取得します。
     * @return 取引先コード(不動産会社コード - 取引先コード)
     */
    public String getTorihikisakiCd() {
        return torihikisakiCd;
    }

    /**
     * 取引先コード(不動産会社コード - 取引先コード)を設定します。
     * @param torihikisakiCd 取引先コード(不動産会社コード - 取引先コード)
     */
    public void setTorihikisakiCd(String torihikisakiCd) {
        this.torihikisakiCd = torihikisakiCd;
    }

    /**
     * 不動産会社名を取得します。
     * @return 不動産会社名
     */
    public String getFudousanKaisyaName() {
        return fudousanKaisyaName;
    }

    /**
     * 不動産会社名を設定します。
     * @param fudousanKaisyaName 不動産会社名
     */
    public void setFudousanKaisyaName(String fudousanKaisyaName) {
        this.fudousanKaisyaName = fudousanKaisyaName;
    }

    /**
     * 取引先名を取得します。
     * @return 取引先名
     */
    public String getTorihikisakiName() {
        return torihikisakiName;
    }

    /**
     * 取引先名を設定します。
     * @param torihikisakiName 取引先名
     */
    public void setTorihikisakiName(String torihikisakiName) {
        this.torihikisakiName = torihikisakiName;
    }

    /**
     * 適用月を取得します。
     * @return 適用月
     */
    public String getStartYm() {
        return startYm;
    }

    /**
     * 適用月を設定します。
     * @param startYm 適用月
     */
    public void setStartYm(String startYm) {
        this.startYm = startYm;
    }

    /**
     * 物件枠を取得します。
     * @return 物件枠
     */
    public String getBukkenCount() {
        return bukkenCount;
    }

    /**
     * 物件枠を設定します。
     * @param bukkenCount 物件枠
     */
    public void setBukkenCount(String bukkenCount) {
        this.bukkenCount = bukkenCount;
    }

    /**
     * 物件リスティングを取得します。
     * @return 物件リスティング
     */
    public String getTokusenCount() {
        return tokusenCount;
    }

    /**
     * 物件リスティングを設定します。
     * @param tokusenCount 物件リスティング
     */
    public void setTokusenCount(String tokusenCount) {
        this.tokusenCount = tokusenCount;
    }

}
