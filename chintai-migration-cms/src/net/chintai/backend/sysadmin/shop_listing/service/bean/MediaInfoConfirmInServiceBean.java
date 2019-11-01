/*
 * $Id: MediaInfoConfirmInServiceBean.java 4247 2009-03-23 09:15:01Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/12     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service.bean;

/**
 * 出稿情報確認サービスビーン。
 *
 * @author Lee Hosup
 * @version $Revision: 4247 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MediaInfoConfirmInServiceBean {

    /** 店舗コード */
    private String shopCd;

    /** 駅選択値 */
    private String selectEkiValue;

    /** 市区町村選択値 */
    private String selectCityValue;

    /** アピールアイコン選択 */
    private String[] chkAppeal;

    /** リスティング選択 */
    private String[] chkListing;

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
     * 駅選択値を取得します。
     * @return 駅選択値
     */
    public String getSelectEkiValue() {
        return selectEkiValue;
    }

    /**
     * 駅選択値を設定します。
     * @param selectEkiValue 駅選択値
     */
    public void setSelectEkiValue(String selectEkiValue) {
        this.selectEkiValue = selectEkiValue;
    }

    /**
     * 市区町村選択値を取得します。
     * @return 市区町村選択値
     */
    public String getSelectCityValue() {
        return selectCityValue;
    }

    /**
     * 市区町村選択値を設定します。
     * @param selectCityValue 市区町村選択値
     */
    public void setSelectCityValue(String selectCityValue) {
        this.selectCityValue = selectCityValue;
    }

    /**
     * アピールアイコン選択を取得します。
     * @return アピールアイコン選択
     */
    public String[] getChkAppeal() {
        return chkAppeal;
    }

    /**
     * アピールアイコン選択を設定します。
     * @param chkAppeal アピールアイコン選択
     */
    public void setChkAppeal(String[] chkAppeal) {
        this.chkAppeal = chkAppeal;
    }

    /**
     * リスティング選択を取得します。
     * @return リスティング選択
     */
    public String[] getChkListing() {
        return chkListing;
    }

    /**
     * リスティング選択を設定します。
     * @param chkListing リスティング選択
     */
    public void setChkListing(String[] chkListing) {
        this.chkListing = chkListing;
    }

}
