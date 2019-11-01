/*
 * $Id: TorihikisakiWakuInfoDomain.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/27  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.domain;

/**
 * 物件枠設定情報
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuInfoDomain {

    /** 適用月 */
    private String startYm;

    /** 物件枠 */
    private String bukkenCnt;

    /** 物件リスティング */
    private String tokusenCnt;

    /** 最終更新日 */
    private String updDt;

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
     * 物件リスティングを取得します。
     * @return 物件リスティング
     */
    public String getTokusenCnt() {
        return tokusenCnt;
    }

    /**
     * 物件リスティングを設定します。
     * @param tokusenCnt 物件リスティング
     */
    public void setTokusenCnt(String tokusenCnt) {
        this.tokusenCnt = tokusenCnt;
    }

    /**
     * 最終更新日を取得します。
     * @return 最終更新日
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 最終更新日を設定します。
     * @param updDt 最終更新日
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

}
