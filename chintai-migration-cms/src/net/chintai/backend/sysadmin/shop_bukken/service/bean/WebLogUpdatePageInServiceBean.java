/*
 * $Id: WebLogUpdatePageInServiceBean.java 3853 2008-03-10 05:43:48Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.bean;

/**
 * Webログ利用可否画面に遷移InServiceBean
 *
 * @author Kim Dong Jin
 * @version $Revision: 3853 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class WebLogUpdatePageInServiceBean {

    /** 店舗コード */
    private String shopCd;

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
}