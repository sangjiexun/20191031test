package net.chintai.backend.sysadmin.shop_bukken.action.view;

import net.chintai.backend.sysadmin.common.ViewHelper;

/**
 * 契約明細設定（数量なし）更新ViewHelper
 *
 * @author m-kashiyama
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractNormalUpdateView implements ViewHelper {

    /** 会社名 */
    private String company;

    /** 事務署名 */
    private String bumon;

    /** 店舗コード */
    private String shopCd;

    /** お客様設定パスワード */
    private String password;

    /** 更新日時 */
    private String updDt;

    /** 契約名 */
    private String keiyakuName;

    /** 契約コメント */
    private String keiyakuComment;

    /** 契約フラグ */
    private String KeiyakuFlag;

    /** 契約コード */
    private String keiyakuCd;

    /** 契約サブコード  */
    private String keiyakuSubCd;

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
     * 事務署名を取得します。
     * @return 事務署名
     */
    public String getBumon() {
        return bumon;
    }

    /**
     * 事務署名を設定します。
     * @param bumon 事務署名
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
     * 更新日時を取得します。
     * @return 更新日時
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 更新日時を設定します。
     * @param updDt 更新日時
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
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
     * 契約コメントを返します。
     * @return 契約コメント
     */
    public String getKeiyakuComment() {
        return keiyakuComment;
    }

    /**
     * 契約コメントを設定します。
     * @param keiyakuComment  契約コメント
     */
    public void setKeiyakuComment(String keiyakuComment) {
        this.keiyakuComment = keiyakuComment;
    }

    /**
     * 契約フラグを返します。
     * @return keiyakuFlag
     */
    public String getKeiyakuFlag() {
        return KeiyakuFlag;
    }

    /**
     * 契約フラグを設定します。
     * @param keiyakuFlag  契約フラグ
     */
    public void setKeiyakuFlag(String keiyakuFlag) {
        KeiyakuFlag = keiyakuFlag;
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
}