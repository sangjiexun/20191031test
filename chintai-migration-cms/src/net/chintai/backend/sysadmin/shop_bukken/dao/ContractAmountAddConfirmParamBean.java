package net.chintai.backend.sysadmin.shop_bukken.dao;


/**
* 契約明細詳細(契約数量あり)設定情報新規登録確認
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountAddConfirmParamBean {
    /** 店舗コード  */
    private String shopCd;

    /** 契約コード */
    private String keiyakuCd;

    /** 契約サブコード  */
    private String keiyakuSubCd;

    /** 適用年 */
    private String applyYear;

    /** 適用月 */
    private String applyMonth;

    /** 適用日 */
    private String applyDay;

    /** 適用時間 */
    private String applyHour;

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
     * 契約コードを返します。
     * @return 契約コード
     */
    public String getKeiyakuCd() {
        return keiyakuCd;
    }

    /**
     * 契約コードを設定します。
     * @param keiyakuCd  契約コード
     */
    public void setKeiyakuCd(String keiyakuCd) {
        this.keiyakuCd = keiyakuCd;
    }

    /**
     * 契約サブコードを返します。
     * @return 契約サブコード
     */
    public String getKeiyakuSubCd() {
        return keiyakuSubCd;
    }

    /**
     * 契約サブコードを設定します。
     * @param keiyakuSubCd  契約サブコード
     */
    public void setKeiyakuSubCd(String keiyakuSubCd) {
        this.keiyakuSubCd = keiyakuSubCd;
    }

    /**
     * 適用年を取得します。
     * @return 適用年
     */
    public String getApplyYear() {
        return applyYear;
    }

    /**
     * 適用年を設定します。
     * @param applyYear 適用年
     */
    public void setApplyYear(String applyYear) {
        this.applyYear = applyYear;
    }

    /**
     * 適用月を取得します。
     * @return 適用月
     */
    public String getApplyMonth() {
        return applyMonth;
    }

    /**
     * 適用月を設定します。
     * @param applyMonth 適用月
     */
    public void setApplyMonth(String applyMonth) {
        this.applyMonth = applyMonth;
    }

    /**
     * 適用日を返します。
     * @return 適用日
     */
    public String getApplyDay() {
        return applyDay;
    }

    /**
     * 適用日を設定します。
     * @param applyDay  適用日
     */
    public void setApplyDay(String applyDay) {
        this.applyDay = applyDay;
    }

    /**
     * 適用時間を返します。
     * @return 適用時間
     */
    public String getApplyHour() {
        return applyHour;
    }

    /**
     * 適用時間を設定します。
     * @param applyHour  適用時間
     */
    public void setApplyHour(String applyHour) {
        this.applyHour = applyHour;
    }

}