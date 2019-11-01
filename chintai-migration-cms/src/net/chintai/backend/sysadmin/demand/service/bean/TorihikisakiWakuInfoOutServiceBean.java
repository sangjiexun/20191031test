/*
 * $Id: TorihikisakiWakuInfoOutServiceBean.java 3576 2007-12-14 11:39:18Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/08  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.bean;

/**
 * 取引先物件枠情報
 *
 * @author lee-hosup
 * @version $Revision: 3576 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuInfoOutServiceBean {

    /** 適用月 */
    private String startYm;

    /** 物件枠 */
    private String bukkenCnt;

    /** 物件リスティング */
    private String tokusenCnt;

    /** 最終更新日 */
    private String updDt;

    /** 適用月フラグ */
    private String appliedFlg;

    /** 削除可能判断フラグ */
    private String delFlg;

    /** リンク表示フラグ */
    private String linkFlg;

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

    /**
     * 適用月フラグを取得します。
     * @return 適用月フラグ
     */
    public String getAppliedFlg() {
        return appliedFlg;
    }

    /**
     * 適用月フラグを設定します。
     * @param appliedFlg 適用月フラグ
     */
    public void setAppliedFlg(String appliedFlg) {
        this.appliedFlg = appliedFlg;
    }

    /**
     * 削除可能判断フラグを取得します。
     * @return 削除可能判断フラグ
     */
    public String getDelFlg() {
        return delFlg;
    }

    /**
     * 削除可能判断フラグを設定します。
     * @param delFlg 削除可能判断フラグ
     */
    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg;
    }

    /**
     * リンク表示フラグを取得します。
     * @return リンク表示フラグ
     */
    public String getLinkFlg() {
        return linkFlg;
    }

    /**
     * リンク表示フラグを設定します。
     * @param linkFlg リンク表示フラグ
     */
    public void setLinkFlg(String linkFlg) {
        this.linkFlg = linkFlg;
    }

}
