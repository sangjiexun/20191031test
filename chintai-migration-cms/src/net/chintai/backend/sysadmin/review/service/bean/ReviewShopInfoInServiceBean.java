/*
 * $Id: ReviewShopInfoInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/12  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.bean;

/**
 * 店舗詳細情報の検索条件
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopInfoInServiceBean {

    /** 店舗コード */
    private String shopCd;

    /**
     * ReviewShopInfoInServiceBean.javaを取得
     * @return shopCd
     */
    public String getShopCd() {
        return shopCd;
    }

    /**
     * shopCdを設定する
     * @param shopCd
     */
    public void setShopCd(String shopCd) {
        this.shopCd = shopCd;
    }

}
