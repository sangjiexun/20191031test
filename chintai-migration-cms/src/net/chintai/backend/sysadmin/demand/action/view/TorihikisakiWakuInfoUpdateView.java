/*
 * $Id: TorihikisakiWakuInfoUpdateView.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/09  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action.view;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 取引先物件枠情報更新
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuInfoUpdateView implements ViewHelper {

    /** 不動産会社名 */
    private String fudousanName;

    /** 不動産会社コード */
    private String fudousanCd;

    /** 取引先名 */
    private String torihikisakiName;

    /** 取引先コード */
    private String torihikisakiCd;

    /** 取引先シーケンス番号 */
    private String torihikisakiSeq;

    /** 郵便番号 */
    private String zipCd;

    /** 都道府県コード */
    private String prefCd;

    /** 都道府県名 */
    private String prefName;

    /** 住所１ */
    private String address1;

    /** 住所２ */
    private String address2;

    /** 電話番号 */
    private String tel;

    /** ファックス番号 */
    private String fax;

    /** 担当者名 */
    private String tantou;

    /** 取引先支社コード */
    private String shisyaCd;

    /** 取引先支社名称 */
    private String shisya;

    /** 登録日 */
    private String insDt;

    /** 最終更新日時 */
    private String updDt;

    /** 物件枠(ラジオボタン) */
    private String bukkenCnt;

    /** 物件枠(テキスト) */
    private String bukkenCntNote;

    /** リスティング枠(ラジオボタン) */
    private String tokusenCnt;

    /** リスティング枠(テキスト) */
    private String tokusenCntNote;

    /** 適用月 */
    private String startYm;

    /** 適用月(画面表示用) */
    private String startYmForDisplay;

    /** 取引先テーブルの最終更新日付 */
    private String torihikisakiUpdDt;

    /**
     * 不動産会社名を取得します。
     * @return 不動産会社名
     */
    public String getFudousanName() {
        return fudousanName;
    }

    /**
     * 不動産会社名を設定します。
     * @param fudousanName 不動産会社名
     */
    public void setFudousanName(String fudousanName) {
        this.fudousanName = fudousanName;
    }

    /**
     * 不動産会社コードを取得します。
     * @return 不動産会社コード
     */
    public String getFudousanCd() {
        return fudousanCd;
    }

    /**
     * 不動産会社コードを設定します。
     * @param fudousanCd 不動産会社コード
     */
    public void setFudousanCd(String fudousanCd) {
        this.fudousanCd = fudousanCd;
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
     * 取引先コードを取得します。
     * @return 取引先コード
     */
    public String getTorihikisakiCd() {
        return torihikisakiCd;
    }

    /**
     * 取引先コードを設定します。
     * @param torihikisakiCd 取引先コード
     */
    public void setTorihikisakiCd(String torihikisakiCd) {
        this.torihikisakiCd = torihikisakiCd;
    }

    /**
     * 取引先シーケンス番号を取得します。
     * @return 取引先シーケンス番号
     */
    public String getTorihikisakiSeq() {
        return torihikisakiSeq;
    }

    /**
     * 取引先シーケンス番号を設定します。
     * @param torihikisakiSeq 取引先シーケンス番号
     */
    public void setTorihikisakiSeq(String torihikisakiSeq) {
        this.torihikisakiSeq = torihikisakiSeq;
    }

    /**
     * 郵便番号を取得します。
     * @return 郵便番号
     */
    public String getZipCd() {
        return zipCd;
    }

    /**
     * 郵便番号を設定します。
     * @param zipCd 郵便番号
     */
    public void setZipCd(String zipCd) {
        this.zipCd = zipCd;
    }

    /**
     * 都道府県コードを取得します。
     * @return 都道府県コード
     */
    public String getPrefCd() {
        return prefCd;
    }

    /**
     * 都道府県コードを設定します。
     * @param prefCd 都道府県コード
     */
    public void setPrefCd(String prefCd) {
        this.prefCd = prefCd;
    }

    /**
     * 都道府県名を取得します。
     * @return 都道府県名
     */
    public String getPrefName() {
        return prefName;
    }

    /**
     * 都道府県名を設定します。
     * @param prefName 都道府県名
     */
    public void setPrefName(String prefName) {
        this.prefName = prefName;
    }

    /**
     * 住所１を取得します。
     * @return 住所１
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * 住所１を設定します。
     * @param address1 住所１
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * 住所２を取得します。
     * @return 住所２
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * 住所２を設定します。
     * @param address2 住所２
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * 電話番号を取得します。
     * @return 電話番号
     */
    public String getTel() {
        return tel;
    }

    /**
     * 電話番号を設定します。
     * @param tel 電話番号
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * ファックス番号を取得します。
     * @return ファックス番号
     */
    public String getFax() {
        return fax;
    }

    /**
     * ファックス番号を設定します。
     * @param fax ファックス番号
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * 担当者名を取得します。
     * @return 担当者名
     */
    public String getTantou() {
        return tantou;
    }

    /**
     * 担当者名を設定します。
     * @param tantou 担当者名
     */
    public void setTantou(String tantou) {
        this.tantou = tantou;
    }

    /**
     * 取引先支社コードを取得します。
     * @return 取引先支社コード
     */
    public String getShisyaCd() {
        return shisyaCd;
    }

    /**
     * 取引先支社コードを設定します。
     * @param shisyaCd 取引先支社コード
     */
    public void setShisyaCd(String shisyaCd) {
        this.shisyaCd = shisyaCd;
    }

    /**
     * 取引先支社名称を取得します。
     * @return 取引先支社名称
     */
    public String getShisya() {
        return shisya;
    }

    /**
     * 取引先支社名称を設定します。
     * @param shisya 取引先支社名称
     */
    public void setShisya(String shisya) {
        this.shisya = shisya;
    }

    /**
     * 登録日を取得します。
     * @return 登録日
     */
    public String getInsDt() {
        return insDt;
    }

    /**
     * 登録日を設定します。
     * @param insDt 登録日
     */
    public void setInsDt(String insDt) {
        this.insDt = insDt;
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
     * 物件枠(ラジオボタン)を取得します。
     * @return 物件枠(ラジオボタン)
     */
    public String getBukkenCnt() {
        return bukkenCnt;
    }

    /**
     * 物件枠(ラジオボタン)を設定します。
     * @param bukkenCnt 物件枠(ラジオボタン)
     */
    public void setBukkenCnt(String bukkenCnt) {
        this.bukkenCnt = bukkenCnt;
    }

    /**
     * 物件枠(テキスト)を取得します。
     * @return 物件枠(テキスト)
     */
    public String getBukkenCntNote() {
        return bukkenCntNote;
    }

    /**
     * 物件枠(テキスト)を設定します。
     * @param bukkenCntNote 物件枠(テキスト)
     */
    public void setBukkenCntNote(String bukkenCntNote) {
        this.bukkenCntNote = bukkenCntNote;
    }

    /**
     * リスティング枠(ラジオボタン)を取得します。
     * @return リスティング枠(ラジオボタン)
     */
    public String getTokusenCnt() {
        return tokusenCnt;
    }

    /**
     * リスティング枠(ラジオボタン)を設定します。
     * @param tokusenCnt リスティング枠(ラジオボタン)
     */
    public void setTokusenCnt(String tokusenCnt) {
        this.tokusenCnt = tokusenCnt;
    }

    /**
     * リスティング枠(テキスト)を取得します。
     * @return リスティング枠(テキスト)
     */
    public String getTokusenCntNote() {
        return tokusenCntNote;
    }

    /**
     * リスティング枠(テキスト)を設定します。
     * @param tokusenCntNote リスティング枠(テキスト)
     */
    public void setTokusenCntNote(String tokusenCntNote) {
        this.tokusenCntNote = tokusenCntNote;
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
     * 適用月(画面表示用)を取得します。
     * @return 適用月(画面表示用)
     */
    public String getStartYmForDisplay() {
        return startYmForDisplay;
    }

    /**
     * 適用月(画面表示用)を設定します。
     * @param startYmForDisplay 適用月(画面表示用)
     */
    public void setStartYmForDisplay(String startYmForDisplay) {
        this.startYmForDisplay = startYmForDisplay;
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
