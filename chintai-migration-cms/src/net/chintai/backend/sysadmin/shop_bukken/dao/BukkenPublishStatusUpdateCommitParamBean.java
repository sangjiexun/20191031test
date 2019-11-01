 /* $Id: BukkenPublishStatusUpdateCommitParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/03  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

/**
 * 物件掲載状態変完了ParamBean
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BukkenPublishStatusUpdateCommitParamBean {

    /** 店舗コード */
    private String shopCd;

    /** 物件コード */
    private String bkCd;

    /** 部屋連番 */
    private String roomNo;

    /** 更新プログラム */
    private String updPg;

    /** 更新者ID */
    private String operUserId;

    /** 物件管理テーブル最終更新日時 */
    private String bukkenKanriLastUpdate;

    /** 部屋PK */
    private String roomKey;

    /** 物件ステータス */
    private String bukkenStatus;

    /** 物件履歴連番 */
    private Long pkBukkenRireki;

    /**
     * 店舗コードを取得します。
     * @return 店舗コード
     */
    public String getShopCd() {
        return shopCd;
    }

    /**
     * 店舗コードを設定します。
     * @param shopCd 店舗コード
     */
    public void setShopCd(String shopCd) {
        this.shopCd = shopCd;
    }

    /**
     * 物件コードを取得します。
     * @return 物件コード
     */
    public String getBkCd() {
        return bkCd;
    }

    /**
     * 物件コードを設定します。
     * @param bkCd 物件コード
     */
    public void setBkCd(String bkCd) {
        this.bkCd = bkCd;
    }

    /**
     * 部屋連番を取得します。
     * @return 部屋連番
     */
    public String getRoomNo() {
        return roomNo;
    }

    /**
     * 部屋連番を設定します。
     * @param roomNo 部屋連番
     */
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    /**
     * 更新プログラムを取得します。
     * @return 更新プログラム
     */
    public String getUpdPg() {
        return updPg;
    }

    /**
     * 更新プログラムを設定します。
     * @param updPg 更新プログラム
     */
    public void setUpdPg(String updPg) {
        this.updPg = updPg;
    }

    /**
     * 更新者IDを取得します。
     * @return 更新者ID
     */
    public String getOperUserId() {
        return operUserId;
    }

    /**
     * 更新者IDを設定します。
     * @param operUserId 更新者ID
     */
    public void setOperUserId(String operUserId) {
        this.operUserId = operUserId;
    }

    /**
     * 物件管理テーブルの最終更新日時を返します。
     * @return bukkenKanriLastUpdate
     */
    public String getBukkenKanriLastUpdate() {
        return bukkenKanriLastUpdate;
    }

    /**
     * 物件管理テーブルの最終更新日時を設定します。
     * @param bukkenKanriLastUpdate  bukkenKanriLastUpdate
     */
    public void setBukkenKanriLastUpdate(String bukkenKanriLastUpdate) {
        this.bukkenKanriLastUpdate = bukkenKanriLastUpdate;
    }

    /**
     * 部屋PKを返します。
     * @return 部屋連番
     */
    public String getRoomKey() {
        return roomKey;
    }

    /**
     * 部屋PKを設定します。
     * @param roomKey  部屋連番
     */
    public void setRoomKey(String roomKey) {
        this.roomKey = roomKey;
    }

    /**
     * 物件ステータスを返します。
     * @return 物件ステータス
     */
    public String getBukkenStatus() {
        return bukkenStatus;
    }

    /**
     * 物件ステータスを設定します。
     * @param bukkenStatus  物件ステータス
     */
    public void setBukkenStatus(String bukkenStatus) {
        this.bukkenStatus = bukkenStatus;
    }

    /**
     * 物件履歴連番を返します。
     * @return 物件履歴連番
     */
    public Long getPkBukkenRireki() {
        return pkBukkenRireki;
    }

    /**
     * 物件履歴連番を設定します。
     * @param pkBukkenRireki  物件履歴連番
     */
    public void setPkBukkenRireki(Long pkBukkenRireki) {
        this.pkBukkenRireki = pkBukkenRireki;
    }



}