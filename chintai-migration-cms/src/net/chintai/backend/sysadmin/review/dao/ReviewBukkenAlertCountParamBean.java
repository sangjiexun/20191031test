/*
 * $Id: ReviewBukkenAlertCountParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/09/28  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao;

import java.util.List;

/**
 * 警告対象物件の検索条件を格納するクラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenAlertCountParamBean {

    /** 店舗コード */
    private String shopCd;

    /** 会社名/事務所名 */
    private String companyBumon;

    /** 都道府県 */
    private String prefCd;

    /** 警告日(年)(下限) */
    private String sendDtFrom;

    /** 警告日(日)(上限) */
    private String sendDtTo;

    /** 警告内容 */
    private List<String> warningCd;

    /** ソートキー */
    private String sortKey;

    /** 順序 */
    private String orderBy;

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
     * 都道府県を取得します。
     * @return 都道府県
     */
    public String getPrefCd() {
        return prefCd;
    }

    /**
     * 都道府県を設定します。
     * @param prefCd 都道府県
     */
    public void setPrefCd(String prefCd) {
        this.prefCd = prefCd;
    }

    /**
     * 警告日(年)(下限)を取得します。
     * @return 警告日(年)(下限)
     */
    public String getSendDtFrom() {
        return sendDtFrom;
    }

    /**
     * 警告日(年)(下限)を設定します。
     * @param sendDtFrom 警告日(年)(下限)
     */
    public void setSendDtFrom(String sendDtFrom) {
        this.sendDtFrom = sendDtFrom;
    }

    /**
     * 警告日(日)(上限)を取得します。
     * @return 警告日(日)(上限)
     */
    public String getSendDtTo() {
        return sendDtTo;
    }

    /**
     * 警告日(日)(上限)を設定します。
     * @param sendDtTo 警告日(日)(上限)
     */
    public void setSendDtTo(String sendDtTo) {
        this.sendDtTo = sendDtTo;
    }

    /**
     * 警告内容を取得します。
     * @return 警告内容
     */
    public List<String> getWarningCd() {
        return warningCd;
    }

    /**
     * 警告内容を設定します。
     * @param warningCd 警告内容
     */
    public void setWarningCd(List<String> warningCd) {
        this.warningCd = warningCd;
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

}
