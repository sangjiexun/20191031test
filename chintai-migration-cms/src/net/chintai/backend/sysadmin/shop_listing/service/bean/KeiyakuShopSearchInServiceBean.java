/*
 * $Id: KeiyakuShopSearchInServiceBean.java 4247 2009-03-23 09:15:01Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/02/17     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service.bean;

import net.chintai.backend.sysadmin.common.session.SessionSearchCondition;

/**
 * 契約店舗検索条件
 *
 * @author Lee Hosup
 * @version $Revision: 4247 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class KeiyakuShopSearchInServiceBean implements SessionSearchCondition {

    /** serialVersionUID */
    private static final long serialVersionUID = -8415679439010989637L;

    /** 店舗コード */
    private String shopCd;

    /** 会社名/事務所名 */
    private String companyBumon;

    /** 都道府県コード */
    private String prefCd;

    /** データ元 */
    private String clientSystemType;

    /** 状態 */
    private String shopStatus;

    /** 基本契約状態:契約中 */
    private String keiyaku;

    /** 基本契約状態:未契約 */
    private String mikeiyaku;

    /** 基本契約状態:契約期限切れ */
    private String kigengire;

    /** ソートキー */
    private String sortKey;

    /** 順序 */
    private String orderBy;

    /** 表示件数 */
    private String displayNum;

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
     * 会社名/事務所名を取得します。
     * @return 会社名/事務所名
     */
    public String getCompanyBumon() {
        return companyBumon;
    }

    /**
     * 会社名/事務所名を設定します。
     * @param companyBumon 会社名/事務所名
     */
    public void setCompanyBumon(String companyBumon) {
        this.companyBumon = companyBumon;
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
     * データ元を取得します。
     * @return データ元
     */
    public String getClientSystemType() {
        return clientSystemType;
    }

    /**
     * データ元を設定します。
     * @param clientSystemType データ元
     */
    public void setClientSystemType(String clientSystemType) {
        this.clientSystemType = clientSystemType;
    }

    /**
     * 状態を取得します。
     * @return 状態
     */
    public String getShopStatus() {
        return shopStatus;
    }

    /**
     * 状態を設定します。
     * @param shopStatus 状態
     */
    public void setShopStatus(String shopStatus) {
        this.shopStatus = shopStatus;
    }

    /**
     * 基本契約状態:契約中を取得します。
     * @return 基本契約状態:契約中
     */
    public String getKeiyaku() {
        return keiyaku;
    }

    /**
     * 基本契約状態:契約中を設定します。
     * @param keiyaku 基本契約状態:契約中
     */
    public void setKeiyaku(String keiyaku) {
        this.keiyaku = keiyaku;
    }

    /**
     * 基本契約状態:未契約を取得します。
     * @return 基本契約状態:未契約
     */
    public String getMikeiyaku() {
        return mikeiyaku;
    }

    /**
     * 基本契約状態:未契約を設定します。
     * @param mikeiyaku 基本契約状態:未契約
     */
    public void setMikeiyaku(String mikeiyaku) {
        this.mikeiyaku = mikeiyaku;
    }

    /**
     * 基本契約状態:契約期限切れを取得します。
     * @return 基本契約状態:契約期限切れ
     */
    public String getKigengire() {
        return kigengire;
    }

    /**
     * 基本契約状態:契約期限切れを設定します。
     * @param kigengire 基本契約状態:契約期限切れ
     */
    public void setKigengire(String kigengire) {
        this.kigengire = kigengire;
    }

    /**
     * ソートキーを取得します。
     * @return ソートキー
     */
    public String getSortKey() {
        return sortKey;
    }

    /**
     * ソートキーを設定します。
     * @param sortKey ソートキー
     */
    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    /**
     * 順序を取得します。
     * @return 順序
     */
    public String getOrderBy() {
        return orderBy;
    }

    /**
     * 順序を設定します。
     * @param orderBy 順序
     */
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    /**
     * 表示件数を取得します。
     * @return 表示件数
     */
    public String getDisplayNum() {
        return displayNum;
    }

    /**
     * 表示件数を設定します。
     * @param displayNum 表示件数
     */
    public void setDisplayNum(String displayNum) {
        this.displayNum = displayNum;
    }

}
