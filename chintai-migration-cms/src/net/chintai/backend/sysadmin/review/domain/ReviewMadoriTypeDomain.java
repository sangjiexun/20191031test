/*
 * $Id: ReviewMadoriTypeDomain.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/26  BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.review.domain;

/**
 * 間取りタイプ設定内容照会
 * 
 * @author Lee Hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewMadoriTypeDomain {

    /** 分類 */
    private String madoriTypeName;

    /** 抽出範囲 */
    private String madori;

    /** 有効期間 */
    private String minBukkenCnt;

    /** 有効範囲の上限 */
    private String maxChinryo;

    /** 有効範囲の下限 */
    private String minChinryo;

    /**
     * 分類を取得します。
     * @return 分類
     */
    public String getMadoriTypeName() {
        return madoriTypeName;
    }

    /**
     * 分類を設定します。
     * @param madoriTypeName 分類
     */
    public void setMadoriTypeName(String madoriTypeName) {
        this.madoriTypeName = madoriTypeName;
    }

    /**
     * 抽出範囲を取得します。
     * @return 抽出範囲
     */
    public String getMadori() {
        return madori;
    }

    /**
     * 抽出範囲を設定します。
     * @param madori 抽出範囲
     */
    public void setMadori(String madori) {
        this.madori = madori;
    }

    /**
     * 有効期間を取得します。
     * @return 有効期間
     */
    public String getMinBukkenCnt() {
        return minBukkenCnt;
    }

    /**
     * 有効期間を設定します。
     * @param minBukkenCnt 有効期間
     */
    public void setMinBukkenCnt(String minBukkenCnt) {
        this.minBukkenCnt = minBukkenCnt;
    }

    /**
     * 有効範囲の上限を取得します。
     * @return 有効範囲の上限
     */
    public String getMaxChinryo() {
        return maxChinryo;
    }

    /**
     * 有効範囲の上限を設定します。
     * @param maxChinryo 有効範囲の上限
     */
    public void setMaxChinryo(String maxChinryo) {
        this.maxChinryo = maxChinryo;
    }

    /**
     * 有効範囲の下限を取得します。
     * @return 有効範囲の下限
     */
    public String getMinChinryo() {
        return minChinryo;
    }

    /**
     * 有効範囲の下限を設定します。
     * @param minChinryo 有効範囲の下限
     */
    public void setMinChinryo(String minChinryo) {
        this.minChinryo = minChinryo;
    }

}
