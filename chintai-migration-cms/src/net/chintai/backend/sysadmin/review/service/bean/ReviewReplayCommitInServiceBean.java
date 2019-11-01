/*
 * $Id: ReviewReplayCommitInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/22  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.bean;

/**
 * 返信入力更新
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewReplayCommitInServiceBean {

    /** 店舗コード */
    private String shopCd;

    /** 物件コード */
    private String bkCd;

    /** 部屋連番 */
    private String roomNo;

    /** 警告履歴連番 */
    private String warningRirekiSeq;

    /** 新築 */
    private String shinchikuFlg;

    /** 空室となった年 */
    private String vacantYmd;

    /** 最終条件確認年 */
    private String lastConfirmYmd;

    /** 処理内容 */
    private String syoriKbn;

    /** その他ご意見など */
    private String bikou;

    /** 警告コード */
    private String warningCd;

    /** 最終更新日時(Web審査履歴テーブル) */
    private String updDt;

    /** 最終更新日時(物件管理テーブル) */
    private String kanriUpdDt;

    /** 更新プログラム */
    private String updPg;

    /** 更新者ID */
    private String updId;

    /** 部屋キー*/
    private String roomKey;

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
     * 警告履歴連番を取得します。
     * @return 警告履歴連番
     */
    public String getWarningRirekiSeq() {
        return warningRirekiSeq;
    }

    /**
     * 警告履歴連番を設定します。
     * @param warningRirekiSeq 警告履歴連番
     */
    public void setWarningRirekiSeq(String warningRirekiSeq) {
        this.warningRirekiSeq = warningRirekiSeq;
    }

    /**
     * 新築を取得します。
     * @return 新築
     */
    public String getShinchikuFlg() {
        return shinchikuFlg;
    }

    /**
     * 新築を設定します。
     * @param shinchikuFlg 新築
     */
    public void setShinchikuFlg(String shinchikuFlg) {
        this.shinchikuFlg = shinchikuFlg;
    }

    /**
     * 空室となった年を取得します。
     * @return 空室となった年
     */
    public String getVacantYmd() {
        return vacantYmd;
    }

    /**
     * 空室となった年を設定します。
     * @param vacantYmd 空室となった年
     */
    public void setVacantYmd(String vacantYmd) {
        this.vacantYmd = vacantYmd;
    }

    /**
     * 最終条件確認年を取得します。
     * @return 最終条件確認年
     */
    public String getLastConfirmYmd() {
        return lastConfirmYmd;
    }

    /**
     * 最終条件確認年を設定します。
     * @param lastConfirmYmd 最終条件確認年
     */
    public void setLastConfirmYmd(String lastConfirmYmd) {
        this.lastConfirmYmd = lastConfirmYmd;
    }

    /**
     * 処理内容を取得します。
     * @return 処理内容
     */
    public String getSyoriKbn() {
        return syoriKbn;
    }

    /**
     * 処理内容を設定します。
     * @param syoriKbn 処理内容
     */
    public void setSyoriKbn(String syoriKbn) {
        this.syoriKbn = syoriKbn;
    }

    /**
     * その他ご意見などを取得します。
     * @return その他ご意見など
     */
    public String getBikou() {
        return bikou;
    }

    /**
     * その他ご意見などを設定します。
     * @param bikou その他ご意見など
     */
    public void setBikou(String bikou) {
        this.bikou = bikou;
    }

    /**
     * 警告コードを取得します。
     * @return 警告コード
     */
    public String getWarningCd() {
        return warningCd;
    }

    /**
     * 警告コードを設定します。
     * @param warningCd 警告コード
     */
    public void setWarningCd(String warningCd) {
        this.warningCd = warningCd;
    }

    /**
     * 最終更新日時(Web審査履歴テーブル)を取得します。
     * @return 最終更新日時(Web審査履歴テーブル)
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 最終更新日時(Web審査履歴テーブル)を設定します。
     * @param updDt 最終更新日時(Web審査履歴テーブル)
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
     * 最終更新日時(物件管理テーブル)を取得します。
     * @return 最終更新日時(物件管理テーブル)
     */
    public String getKanriUpdDt() {
        return kanriUpdDt;
    }

    /**
     * 最終更新日時(物件管理テーブル)を設定します。
     * @param kanriUpdDt 最終更新日時(物件管理テーブル)
     */
    public void setKanriUpdDt(String kanriUpdDt) {
        this.kanriUpdDt = kanriUpdDt;
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


}
