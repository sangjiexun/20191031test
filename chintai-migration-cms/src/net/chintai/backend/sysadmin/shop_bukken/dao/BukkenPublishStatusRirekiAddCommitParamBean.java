package net.chintai.backend.sysadmin.shop_bukken.dao;

/**
 * 物件掲載状態変完了ParamBean
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class BukkenPublishStatusRirekiAddCommitParamBean {

    /** 物件履歴連番 */
    private Long pkBukkenRireki;

    /** 作成依頼連番 */
    private Integer creReqSeq;

    /** 部屋キー */
    private String roomKey;

    /** 汎用番号 */
    private String commonNo;

    /** 処理依頼区分 */
    private String syoriReqKbn;

    /** テーブル名 */
    private String creReqTable;

    /** カラム名 */
    private String creReqCol;

    /** 値 */
    private String creReqVal;

    /** 依頼区分 */
    private String reqKbn;

    /** 更新プログラム */
    private String updPg;

    /** 更新者ID */
    private String operUserId;

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

    /**
     * 作成依頼連番を返します。
     * @return 作成依頼連番
     */
    public Integer getCreReqSeq() {
        return creReqSeq;
    }

    /**
     * 作成依頼連番を設定します。
     * @param creReqSeq  作成依頼連番
     */
    public void setCreReqSeq(Integer creReqSeq) {
        this.creReqSeq = creReqSeq;
    }

    /**
     * 部屋キーを返します。
     * @return 部屋キー
     */
    public String getRoomKey() {
        return roomKey;
    }

    /**
     * 部屋キーを設定します。
     * @param roomKey  部屋キー
     */
    public void setRoomKey(String roomKey) {
        this.roomKey = roomKey;
    }

    /**
     * 汎用番号を返します。
     * @return 汎用番号
     */
    public String getCommonNo() {
        return commonNo;
    }

    /**
     * 汎用番号を設定します。
     * @param commonNo  汎用番号
     */
    public void setCommonNo(String commonNo) {
        this.commonNo = commonNo;
    }

    /**
     * 処理依頼区分を返します。
     * @return 処理依頼区分
     */
    public String getSyoriReqKbn() {
        return syoriReqKbn;
    }

    /**
     * 処理依頼区分を設定します。
     * @param syoriReqKbn  処理依頼区分
     */
    public void setSyoriReqKbn(String syoriReqKbn) {
        this.syoriReqKbn = syoriReqKbn;
    }

    /**
     * テーブル名を返します。
     * @return テーブル名
     */
    public String getCreReqTable() {
        return creReqTable;
    }

    /**
     * テーブル名を設定します。
     * @param creReqTable  テーブル名
     */
    public void setCreReqTable(String creReqTable) {
        this.creReqTable = creReqTable;
    }

    /**
     * カラム名を返します。
     * @return カラム名
     */
    public String getCreReqCol() {
        return creReqCol;
    }

    /**
     * カラム名を設定します。
     * @param creReqCol  カラム名
     */
    public void setCreReqCol(String creReqCol) {
        this.creReqCol = creReqCol;
    }

    /**
     * 値を返します。
     * @return 値
     */
    public String getCreReqVal() {
        return creReqVal;
    }

    /**
     * 値を設定します。
     * @param creReqVal  値
     */
    public void setCreReqVal(String creReqVal) {
        this.creReqVal = creReqVal;
    }

    /**
     * 依頼区分を返します。
     * @return 依頼区分
     */
    public String getReqKbn() {
        return reqKbn;
    }

    /**
     * 依頼区分を設定します。
     * @param reqKbn  依頼区分
     */
    public void setReqKbn(String reqKbn) {
        this.reqKbn = reqKbn;
    }

    /**
     * 作成プログラムＩＤを返します。
     * @return 作成プログラムＩＤ
     */
    public String getUpdPg() {
        return updPg;
    }

    /**
     * 作成プログラムＩＤを設定します。
     * @param updPg  作成プログラムＩＤ
     */
    public void setUpdPg(String updPg) {
        this.updPg = updPg;
    }

    /**
     * 更新者IDを返します。
     * @return 更新者ID
     */
    public String getOperUserId() {
        return operUserId;
    }

    /**
     * 更新者IDを設定します。
     * @param operUserId  更新者ID
     */
    public void setOperUserId(String operUserId) {
        this.operUserId = operUserId;
    }

}