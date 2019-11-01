package net.chintai.backend.sysadmin.shop_bukken.dao;

/**
 * 不動産ASP設定登録完了で検索情報を保有するParamBean。
 *
 * @author
 * @version
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspShopContractInfoParameterBean {

    /** 店舗コード */
    private String shopCd;

    /**
     * 店舗コードを取得します。
     * @return shopCd 店舗コード
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
