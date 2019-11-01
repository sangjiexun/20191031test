/*
 * $Id: TorihikisakiRegisterView.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/27  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 取引先新規登録
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiRegisterView implements ViewHelper {

    /** 不動産会社名 */
    private String fudousanName;

    /** 不動産会社コード */
    private String fudousanCd;

    /** 取引先名 */
    private String torihikisakiName;

    /** 郵便番号１ */
    private String zipCd1;

    /** 郵便番号２ */
    private String zipCd2;

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
    private String shisyaName;

    /** 適用年 */
    private String applyYear;

    /** 適用月 */
    private String applyMonth;

    /** 物件枠(ラジオボタン) */
    private String bukkenCnt;

    /** 物件枠(テキスト) */
    private String bukkenCntNote;

    /** リスティング枠(ラジオボタン) */
    private String tokusenCnt;

    /** リスティング枠(テキスト) */
    private String tokusenCntNote;

    /** 適用年プルダウン用データ */
    private List<String[]> applyYearList;

    /** 適用月プルダウン用データ */
    private List<String[]> applyMonthList;

    /** 現在日付 */
    private String nowDate;

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
     * 郵便番号１を取得します。
     * @return 郵便番号１
     */
    public String getZipCd1() {
        return zipCd1;
    }

    /**
     * 郵便番号１を設定します。
     * @param zipCd1 郵便番号１
     */
    public void setZipCd1(String zipCd1) {
        this.zipCd1 = zipCd1;
    }

    /**
     * 郵便番号２を取得します。
     * @return 郵便番号２
     */
    public String getZipCd2() {
        return zipCd2;
    }

    /**
     * 郵便番号２を設定します。
     * @param zipCd2 郵便番号２
     */
    public void setZipCd2(String zipCd2) {
        this.zipCd2 = zipCd2;
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
    public String getShisyaName() {
        return shisyaName;
    }

    /**
     * 取引先支社名称を設定します。
     * @param shisyaName 取引先支社名称
     */
    public void setShisyaName(String shisyaName) {
        this.shisyaName = shisyaName;
    }

    /**
     * 適用年を取得します。
     * @return 適用年
     */
    public String getApplyYear() {
        return applyYear;
    }

    /**
     * 適用年を設定します。
     * @param applyYear 適用年
     */
    public void setApplyYear(String applyYear) {
        this.applyYear = applyYear;
    }

    /**
     * 適用月を取得します。
     * @return 適用月
     */
    public String getApplyMonth() {
        return applyMonth;
    }

    /**
     * 適用月を設定します。
     * @param applyMonth 適用月
     */
    public void setApplyMonth(String applyMonth) {
        this.applyMonth = applyMonth;
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
     * 適用年プルダウン用データを取得します。
     * @return 適用年プルダウン用データ
     */
    public List<String[]> getApplyYearList() {
        return applyYearList;
    }

    /**
     * 適用年プルダウン用データを設定します。
     * @param applyYearList 適用年プルダウン用データ
     */
    public void setApplyYearList(List<String[]> applyYearList) {
        this.applyYearList = applyYearList;
    }

    /**
     * 適用月プルダウン用データを取得します。
     * @return 適用月プルダウン用データ
     */
    public List<String[]> getApplyMonthList() {
        return applyMonthList;
    }

    /**
     * 適用月プルダウン用データを設定します。
     * @param applyMonthList 適用月プルダウン用データ
     */
    public void setApplyMonthList(List<String[]> applyMonthList) {
        this.applyMonthList = applyMonthList;
    }

	/**
	 * 現在日付を取得します。
	 * @return 現在日付
	 */
	public String getNowDate() {
	    return nowDate;
	}

	/**
	 * 現在日付を設定します。
	 * @param nowDate 現在日付
	 */
	public void setNowDate(String nowDate) {
	    this.nowDate = nowDate;
	}

}
