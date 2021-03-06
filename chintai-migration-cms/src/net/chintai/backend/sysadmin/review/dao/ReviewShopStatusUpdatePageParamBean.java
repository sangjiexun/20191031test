/*
 * $Id: ReviewShopStatusUpdatePageParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/16  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao;

/**
 * 店舗情報検索条件
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopStatusUpdatePageParamBean {

    /** 店舗コード */
    private String shopCd;

    /** 現在有効な物件サマリテーブル名 */
    private String validTableName;

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
     * 現在有効な物件サマリテーブル名を取得します。
     * @return 現在有効な物件サマリテーブル名
     */
    public String getValidTableName() {
        return validTableName;
    }

    /**
     * 現在有効な物件サマリテーブル名を設定します。
     * @param validTableName 現在有効な物件サマリテーブル名
     */
    public void setValidTableName(String validTableName) {
        this.validTableName = validTableName;
    }

}