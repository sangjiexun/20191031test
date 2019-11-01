/*
 * $Id: AspGroupSearchParamBean.java 3769 2008-01-21 10:41:43Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/26  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

/**
 * 不動産ASPグループ照会Bean
 * @author Yang-EunMi
 * @version $Revision: 3769 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspGroupSearchParamBean {

    /** 店舗コード */
    private String shopCd;

    /** グループ店舗コード */
    private String groupshopCd;

    /** 有効物件数CHINTAI */
    private String chintaiBukkenCountTableName;

    /**
     * 店舗コードを設定します。
     * @return shopCd
     */
    public String getShopCd() {
        return shopCd;
    }

    /**
     * 店舗コードを取得します。
     * @param shopCd
     */
    public void setShopCd(String shopCd) {
        this.shopCd = shopCd;
    }

    /**
     * グループ店舗コードを取得します。
     * @return グループ店舗コード
     */
    public String getGroupshopCd() {
        return groupshopCd;
    }

    /**
     * グループ店舗コードを設定します。
     * @param groupshopCd グループ店舗コード
     */
    public void setGroupshopCd(String groupshopCd) {
        this.groupshopCd = groupshopCd;
    }

    /**
     * 有効物件数CHINTAIを取得します。
     * @return 有効物件数CHINTAI
     */
    public String getChintaiBukkenCountTableName() {
        return chintaiBukkenCountTableName;
    }

    /**
     * 有効物件数CHINTAIを設定します。
     * @param chintaiBukkenCountTableName 有効物件数CHINTAI
     */
    public void setChintaiBukkenCountTableName(String chintaiBukkenCountTableName) {
        this.chintaiBukkenCountTableName = chintaiBukkenCountTableName;
    }

}
