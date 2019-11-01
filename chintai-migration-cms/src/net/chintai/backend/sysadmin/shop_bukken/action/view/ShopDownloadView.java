/*
 * $Id: ContractAmountMaintenanceView.java 4654 2013-10-09 08:13:01Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.action.view;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.pager.PagerViewHelper;


/**
 * 物件枠数・物件リスティング枠数のCSVダウンロード・アップロード画面表示用View
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopDownloadView extends PagerViewHelper {

    /** 担当支社コード */
    private String shisyaCd;

    /** 店舗コード */
    private String shopCd;

    /** 会社名部署名 */
    private String kaishaMeiBushoMei;

    /**
     * スーパークラスからのコンストラクター
     * @param condition
     */
    public ShopDownloadView(BasePagerCondition condition) {
        super(condition);    }

    /**
     * 担当支社コードを取得します。
     * @return 担当支社コード
     */
    public String getShisyaCd() {
        return shisyaCd;
    }

    /**
     * 担当支社コードを設定します。
     * @param shisyaCd 担当支社コード
     */
    public void setShisyaCd(String shisyaCd) {
        this.shisyaCd = shisyaCd;
    }

    /**
     * 店舗コードを返します。
     * @return 店舗コード
     */
    public String getShopCd() {
        return shopCd;
    }

    /**
     * 店舗コードを設定します。
     * @param shopCd  店舗コード
     */
    public void setShopCd(String shopCd) {
        this.shopCd = shopCd;
    }

    /**
     * 会社名部署名を返します。
     * @return 会社名部署名
     */
    public String getKaishaMeiBushoMei() {
        return kaishaMeiBushoMei;
    }

    /**
     * 会社名部署名を設定します。
     * @param kaishaMeiBushoMei  会社名部署名
     */
    public void setKaishaMeiBushoMei(String kaishaMeiBushoMei) {
        this.kaishaMeiBushoMei = kaishaMeiBushoMei;
    }



}
