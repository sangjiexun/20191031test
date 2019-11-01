package net.chintai.backend.sysadmin.shop_bukken.action.view;

import java.util.List;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 契約明細詳細(契約数量あり)情報更新
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountUpdateView implements ViewHelper {

    /** 会社名 */
    private String company;

    /** 事務所名 */
    private String bumon;

    /** 店舗コード */
    private String shopCd;

    /** お客様設定パスワード */
    private String password;

    /** 契約コード */
    private String keiyakuCd;

    /** 契約サブコード */
    private String keiyakuSubCd;

    /** 契約名 */
    private String keiyakuName;

    /** 適用開始日 */
    private String appStartDt;

    /** 枠数(ラジオボタン) */
    private String wakuCnt;

    /** 枠数(テキスト) */
    private String wakuCntNote;

    /** 適用枠数データ */
    private List<Long> listAmount;

    /** Validation用 桁数*/
    private Long numLength;

    /** 表示用適用開始年月日時*/
    private String startYmdh;

    /** Validation用 桁数*/
    private Long amountLenth;

    /** Validation用のチェックタイプ*/
    private String wakuCntChecker;

    /** Validation用の更新可能開始日時*/
    private String updateAppStartDt;

    /** 店舗管理テーブル更新日時 */
    private String shopKanriUpdDt;

    /** テキストボックスフラグ*/
    private String textBoxFlg;

    /** テキストボックス名*/
    private String textBoxName;

    /** 最大値*/
    private String maxNum;

    /**
     * 会社名を返します。
     * @return 会社名
     */
    public String getCompany() {
        return company;
    }

    /**
     * 会社名を設定します。
     * @param company  会社名
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 事務所名を返します。
     * @return 事務所名
     */
    public String getBumon() {
        return bumon;
    }

    /**
     * 事務所名を設定します。
     * @param bumon  事務所名
     */
    public void setBumon(String bumon) {
        this.bumon = bumon;
    }

    /**
     * 店舗コードを返します。
     * @return 店舗コード
     */
    public String getShopCd() {
        return shopCd;
    }

    /**
     * 店舗コードを設定します。
     * @param shopCd  店舗コード
     */
    public void setShopCd(String shopCd) {
        this.shopCd = shopCd;
    }

    /**
     * お客様設定パスワードを返します。
     * @return お客様設定パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * お客様設定パスワードを設定します。
     * @param password  お客様設定パスワード
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 契約コードを返します。
     * @return 契約コード
     */
    public String getKeiyakuCd() {
        return keiyakuCd;
    }

    /**
     * 契約コードを設定します。
     * @param keiyakuCd  契約コード
     */
    public void setKeiyakuCd(String keiyakuCd) {
        this.keiyakuCd = keiyakuCd;
    }

    /**
     * 契約サブコードを返します。
     * @return 契約サブコード
     */
    public String getKeiyakuSubCd() {
        return keiyakuSubCd;
    }

    /**
     * 契約サブコードを設定します。
     * @param keiyakuSubCd  契約サブコード
     */
    public void setKeiyakuSubCd(String keiyakuSubCd) {
        this.keiyakuSubCd = keiyakuSubCd;
    }

    /**
     * 契約名を返します。
     * @return 契約名
     */
    public String getKeiyakuName() {
        return keiyakuName;
    }

    /**
     * 契約名を設定します。
     * @param keiyakuName  契約名
     */
    public void setKeiyakuName(String keiyakuName) {
        this.keiyakuName = keiyakuName;
    }

    /**
     * 適用開始日を返します。
     * @return 適用開始日
     */
    public String getAppStartDt() {
        return appStartDt;
    }

    /**
     * 適用開始日を設定します。
     * @param appStartDt  適用開始日
     */
    public void setAppStartDt(String appStartDt) {
        this.appStartDt = appStartDt;
    }

    /**
     * 枠数(ラジオボタン)を返します。
     * @return 枠数(ラジオボタン)
     */
    public String getWakuCnt() {
        return wakuCnt;
    }

    /**
     * 枠数(ラジオボタン)を設定します。
     * @param wakuCnt  枠数(ラジオボタン)
     */
    public void setWakuCnt(String wakuCnt) {
        this.wakuCnt = wakuCnt;
    }

    /**
     * 枠数(テキスト)を返します。
     * @return 枠数(テキスト)
     */
    public String getWakuCntNote() {
        return wakuCntNote;
    }

    /**
     * 枠数(テキスト)を設定します。
     * @param wakuCntNote  枠数(テキスト)
     */
    public void setWakuCntNote(String wakuCntNote) {
        this.wakuCntNote = wakuCntNote;
    }

    /**
     * 適用枠数データを返します。
     * @return 適用枠数データ
     */
    public List<Long> getListAmount() {
        return listAmount;
    }

    /**
     * 適用枠数データを設定します。
     * @param applyWakuList  適用枠数データ
     */
    public void setListAmount(List<Long> listAmount) {
        this.listAmount = listAmount;
    }

    /**
     * Validation用 桁数を返します。
     * @return Validation用 桁数
     */
    public Long getNumLength() {
        return numLength;
    }

    /**
     * Validation用 桁数を設定します。
     * @param numLength  Validation用 桁数
     */
    public void setNumLength(Long numLength) {
        this.numLength = numLength;
    }

    /**
     * 表示用適用開始年月日時を返します。
     * @return 表示用適用開始年月日時
     */
    public String getStartYmdh() {
        return startYmdh;
    }

    /**
     * 表示用適用開始年月日時を設定します。
     * @param startYmdh  表示用適用開始年月日時
     */
    public void setStartYmdh(String startYmdh) {
        this.startYmdh = startYmdh;
    }

    /**
     * Validation用 桁数を返します。
     * @return Validation用 桁数
     */
    public Long getAmountLenth() {
        return amountLenth;
    }

    /**
     * Validation用 桁数を設定します。
     * @param numLength  Validation用 桁数
     */
    public void setAmountLenth(Long amountLenth) {
        this.amountLenth = amountLenth;
    }

    /**
     * Validation用のチェックタイプを返します。
     * @return Validation用のチェックタイプ
     */
    public String getWakuCntChecker() {
        return wakuCntChecker;
    }

    /**
     * Validation用のチェックタイプを設定します。
     * @param wakuCntChecker  Validation用のチェックタイプ
     */
    public void setWakuCntChecker(String wakuCntChecker) {
        this.wakuCntChecker = wakuCntChecker;
    }

    /**
     * Validation用の更新可能開始日時を返します。
     * @return Validation用の更新可能開始日時
     */
    public String getUpdateAppStartDt() {
        return updateAppStartDt;
    }

    /**
     * Validation用の更新可能開始日時を設定します。
     * @param updateAppStartDt  Validation用の更新可能開始日時
     */
    public void setUpdateAppStartDt(String updateAppStartDt) {
        this.updateAppStartDt = updateAppStartDt;
    }

    /**
     *  店舗管理テーブル更新日時を返します。
     * @return  店舗管理テーブル更新日時
     */
    public String getShopKanriUpdDt() {
        return shopKanriUpdDt;
    }

    /**
     *  店舗管理テーブル更新日時を設定します。
     * @param shopKanriUpdDt   店舗管理テーブル更新日時
     */
    public void setShopKanriUpdDt(String shopKanriUpdDt) {
        this.shopKanriUpdDt = shopKanriUpdDt;
    }

    /**
     * テキストボックスフラグを返します。
     * @return textBoxFlg
     */
    public String getTextBoxFlg() {
        return textBoxFlg;
    }

    /**
     * テキストボックスフラグを設定します。
     * @param textBoxFlg  textBoxFlg
     */
    public void setTextBoxFlg(String textBoxFlg) {
        this.textBoxFlg = textBoxFlg;
    }

    /**
     * テキストボックス名を返します。
     * @return textBoxName
     */
    public String getTextBoxName() {
        return textBoxName;
    }

    /**
     * テキストボックス名を設定します。
     * @param textBoxName  textBoxName
     */
    public void setTextBoxName(String textBoxName) {
        this.textBoxName = textBoxName;
    }

    /**
     * maxNumを返します。
     * @return maxNum
     */
    public String getMaxNum() {
        return maxNum;
    }

    /**
     * を設定します。
     * @param maxNum  maxNum
     */
    public void setMaxNum(String maxNum) {
        this.maxNum = maxNum;
    }

}
