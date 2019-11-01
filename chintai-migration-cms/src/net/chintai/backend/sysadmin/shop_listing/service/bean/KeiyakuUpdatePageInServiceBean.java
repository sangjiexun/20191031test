/*
 * $Id: KeiyakuUpdatePageInServiceBean.java 4247 2009-03-23 09:15:01Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/12     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service.bean;

/**
 * 基本契約編集画面ServiceBean。
 *
 * @author Lee Hosup
 * @version $Revision: 4247 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class KeiyakuUpdatePageInServiceBean {

    /** シーケンス */
    private String pkShopListingSeq;

    /** 店舗コード */
    private String shopCd;

    /**
     * シーケンスを取得します。
     * @return シーケンス
     */
    public String getPkShopListingSeq() {
        return pkShopListingSeq;
    }

    /**
     * シーケンスを設定します。
     * @param pkShopListingSeq シーケンス
     */
    public void setPkShopListingSeq(String pkShopListingSeq) {
        this.pkShopListingSeq = pkShopListingSeq;
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

}
