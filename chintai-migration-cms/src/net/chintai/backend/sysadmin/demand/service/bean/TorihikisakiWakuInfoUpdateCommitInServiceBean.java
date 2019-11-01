/*
 * $Id: TorihikisakiWakuInfoUpdateCommitInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/10  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.bean;

/**
 * 取引先枠情報更新
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuInfoUpdateCommitInServiceBean {

    /** 取引先シーケンス番号 */
    private int torihikisakiSeq;

    /** 適用月 */
    private String startYm;

    /** 物件枠 */
    private String bukkenCnt;

    /** 物件枠(手入力) */
    private String bukkenCntNote;

    /** リスティング枠 */
    private String tokusenCnt;

    /** リスティング枠(手入力) */
    private String tokusenCntNote;

    /** 更新者ID */
    private String updId;

    /** プログラム名 */
    private String updPg;

    /** 取引先テーブルの最終更新日付 */
    private String torihikisakiUpdDt;

    /**
     * 取引先シーケンス番号を取得します。
     * @return 取引先シーケンス番号
     */
    public int getTorihikisakiSeq() {
        return torihikisakiSeq;
    }

    /**
     * 取引先シーケンス番号を設定します。
     * @param torihikisakiSeq 取引先シーケンス番号
     */
    public void setTorihikisakiSeq(int torihikisakiSeq) {
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
    public String getBukkenCnt() {
        return bukkenCnt;
    }

    /**
     * 物件枠を設定します。
     * @param bukkenCnt 物件枠
     */
    public void setBukkenCnt(String bukkenCnt) {
        this.bukkenCnt = bukkenCnt;
    }

    /**
     * 物件枠(手入力)を取得します。
     * @return 物件枠(手入力)
     */
    public String getBukkenCntNote() {
        return bukkenCntNote;
    }

    /**
     * 物件枠(手入力)を設定します。
     * @param bukkenCntNote 物件枠(手入力)
     */
    public void setBukkenCntNote(String bukkenCntNote) {
        this.bukkenCntNote = bukkenCntNote;
    }

    /**
     * リスティング枠を取得します。
     * @return リスティング枠
     */
    public String getTokusenCnt() {
        return tokusenCnt;
    }

    /**
     * リスティング枠を設定します。
     * @param tokusenCnt リスティング枠
     */
    public void setTokusenCnt(String tokusenCnt) {
        this.tokusenCnt = tokusenCnt;
    }

    /**
     * リスティング枠(手入力)を取得します。
     * @return リスティング枠(手入力)
     */
    public String getTokusenCntNote() {
        return tokusenCntNote;
    }

    /**
     * リスティング枠(手入力)を設定します。
     * @param tokusenCntNote リスティング枠(手入力)
     */
    public void setTokusenCntNote(String tokusenCntNote) {
        this.tokusenCntNote = tokusenCntNote;
    }

    /**
     * 更新者IDを取得します。
     * @return 更新者ID
     */
    public String getUpdId() {
        return updId;
    }

    /**
     * 更新者IDを設定します。
     * @param updId 更新者ID
     */
    public void setUpdId(String updId) {
        this.updId = updId;
    }

    /**
     * プログラム名を取得します。
     * @return プログラム名
     */
    public String getUpdPg() {
        return updPg;
    }

    /**
     * プログラム名を設定します。
     * @param updPg プログラム名
     */
    public void setUpdPg(String updPg) {
        this.updPg = updPg;
    }

    /**
     * 取引先テーブルの最終更新日付を取得します。
     * @return 取引先テーブルの最終更新日付
     */
    public String getTorihikisakiUpdDt() {
        return torihikisakiUpdDt;
    }

    /**
     * 取引先テーブルの最終更新日付を設定します。
     * @param torihikisakiUpdDt 取引先テーブルの最終更新日付
     */
    public void setTorihikisakiUpdDt(String torihikisakiUpdDt) {
        this.torihikisakiUpdDt = torihikisakiUpdDt;
    }

}
