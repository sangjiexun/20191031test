/*
 * $Id: TorihikisakiWakuMaintenanceUploadParamBean.java 4657 2013-10-09 08:23:00Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/01     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

import java.util.Date;



/**
 * 物件枠数・物件リスティング枠数のCSVアップロード検索用Bean
 * @author KAMEDA Takuma
 * @version $Revision: 4657 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuMaintenanceUploadParamBean {

    /** 取引先シーケンス */
    private String torihikisakiSeq;

    /** 適用月 */
    private String startYm;

    /** 物件枠 */
    private String bukkenCount;

    /** 物件リスティング */
    private String tokusenCount;

    /** 更新ユーザID */
    private String operUserId;

    /** 更新プログラム名 */
    private String pgName;

    /** 更新日時 */
    private Date updDt;

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

    /**
     * 更新ユーザIDを取得します。
     * @return 更新ユーザID
     */
    public String getOperUserId() {
        return operUserId;
    }

    /**
     * 更新ユーザIDを設定します。
     * @param operUserId 更新ユーザID
     */
    public void setOperUserId(String operUserId) {
        this.operUserId = operUserId;
    }

    /**
     * 更新プログラム名を取得します。
     * @return 更新プログラム名
     */
    public String getPgName() {
        return pgName;
    }

    /**
     * 更新プログラム名を設定します。
     * @param pgName 更新プログラム名
     */
    public void setPgName(String pgName) {
        this.pgName = pgName;
    }

    /**
     * 更新日時を取得します。
     * @return 更新日時
     */
    public Date getUpdDt() {
        return updDt;
    }

    /**
     * 更新日時を設定します。
     * @param updDt 更新日時
     */
    public void setUpdDt(Date updDt) {
        this.updDt = updDt;
    }


}
