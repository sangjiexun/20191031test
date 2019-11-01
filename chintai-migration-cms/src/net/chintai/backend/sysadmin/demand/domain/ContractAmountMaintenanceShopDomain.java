/*
 * $Id: ContractAmountMaintenanceUploadDomain.java 4661 2013-10-09 08:32:56Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 *
 */
package net.chintai.backend.sysadmin.demand.domain;



/**
 * CSVファイルアップロード情報用Domain
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountMaintenanceShopDomain {

    /** 店舗コード */
    private String shopCd;

    /** 店舗管理テーブル更新日時 */
    private String shopKanriUpdDt;

    /**
     * 店舗コードを返します。
     *
     * @return 店舗コード
     */
    public String getShopCd() {
        return shopCd;
    }

    /**
     * 店舗コードを設定します。
     *
     * @param shopCd
     *            店舗コード
     */
    public void setShopCd(String shopCd) {
        this.shopCd = shopCd;
    }

    /**
     * 店舗管理テーブル更新日時を返します。
     *
     * @return 店舗管理テーブル更新日時
     */
    public String getShopKanriUpdDt() {
        return shopKanriUpdDt;
    }

    /**
     * 店舗管理テーブル更新日時を設定します。
     *
     * @param shopKanriUpdDt
     *            店舗管理テーブル更新日時
     */
    public void setShopKanriUpdDt(String shopKanriUpdDt) {
        this.shopKanriUpdDt = shopKanriUpdDt;
    }


}
