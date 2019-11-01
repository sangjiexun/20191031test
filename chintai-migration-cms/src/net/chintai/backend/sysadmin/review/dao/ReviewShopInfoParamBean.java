/*
 * $Id: ReviewShopInfoParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/12  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao;

/**
 * 店舗詳細検索条件
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopInfoParamBean {

    /** 店舗コード */
    private String shopCd;

    /** 現在有効な物件サマリテーブル名 */
    private String validTableName;

    /**
     * ReviewShopInfoParamBean.javaを取得
     * @return shopCd
     */
    public String getShopCd() {
        return shopCd;
    }

    /**
     * 店舗コードを設定する
     * @param shopCd
     */
    public void setShopCd(String shopCd) {
        this.shopCd = shopCd;
    }

    /**
     * 店舗コードを取得
     * @return validTableName
     */
    public String getValidTableName() {
        return validTableName;
    }

    /**
     * 現在有効な物件サマリテーブル名を設定する
     * @param validTableName
     */
    public void setValidTableName(String validTableName) {
        this.validTableName = validTableName;
    }

}
