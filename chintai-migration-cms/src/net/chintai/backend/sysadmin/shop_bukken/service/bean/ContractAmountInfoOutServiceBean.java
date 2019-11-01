package net.chintai.backend.sysadmin.shop_bukken.service.bean;

import java.util.List;

/**
 * 契約明細（数量あり）詳細
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountInfoOutServiceBean {

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

    /** 枠リスト */
    private List<String> listAmount;

    /** 枠の桁数*/
    private Integer amountLenth;

    /** 枠使用フラグ*/
    private String amountFlg;

    /** テキストボックスフラグ*/
    private String textBoxFlg;

    /** テキストボックス名*/
    private String textBoxName;


    /** 店舗管理テーブル更新日時 */
    private String shopKanriUpdDt;

    /**
     * 会社名を取得します。
     * @return 会社名
     */
    public String getCompany() {
        return company;
    }

    /**
     * 会社名を設定します。
     * @param company 会社名
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 事務所名を取得します。
     * @return 事務所名
     */
    public String getBumon() {
        return bumon;
    }

    /**
     * 事務所名を設定します。
     * @param bumon 事務所名
     */
    public void setBumon(String bumon) {
        this.bumon = bumon;
    }

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
     * お客様設定パスワードを取得します。
     * @return お客様設定パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * お客様設定パスワードを設定します。
     * @param password お客様設定パスワード
     */
    public void setPassword(String password) {
        this.password = password;
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
     * 枠リストを返します。
     * @return 枠数文字列
     */
    public List<String> getListAmount() {
        return listAmount;
    }

    /**
     *  枠リストを設定します。
     * @param strAmountList  枠数文字列
     */
    public void setListAmount(List<String> listAmount) {
        this.listAmount = listAmount;
    }

    /**
     * 枠の桁数を返します。
     * @return amountLenth
     */
    public Integer getAmountLenth() {
        return amountLenth;
    }

    /**
     * 枠の桁数を設定します。
     * @param amountLenth  枠の桁数
     */
    public void setAmountLenth(Integer amountLenth) {
        this.amountLenth = amountLenth;
    }

    /**
     * 契約数量使用フラグを返します。
     * @return 契約数量使用フラグ
     */
    public String getAmountFlg() {
        return amountFlg;
    }

    /**
     * 契約数量使用フラグを設定します。
     * @param amountFlg  契約数量使用フラグ
     */
    public void setAmountFlg(String amountFlg) {
        this.amountFlg = amountFlg;
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

}
