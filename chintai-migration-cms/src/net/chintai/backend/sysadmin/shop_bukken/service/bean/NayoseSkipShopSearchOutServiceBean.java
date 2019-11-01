package net.chintai.backend.sysadmin.shop_bukken.service.bean;

import net.chintai.backend.sysadmin.common.session.SessionSearchCondition;


public class NayoseSkipShopSearchOutServiceBean implements SessionSearchCondition {


    /** 店舗コード */
    private String shopcd;

    /** 会社名 */
    private String company;

    /** 事務所名 */
    private String bumon;

    /** 登録日 */
    private String insDt;

    /**
     * 店舗コードを取得します。
     * @return 店舗コード
     */
    public String getShopcd() {
        return shopcd;
    }

    /**
     * 店舗コードを設定します。
     * @param shopcd 店舗コード
     */
    public void setShopcd(String shopcd) {
        this.shopcd = shopcd;
    }

    /**
     * 会社名を取得します。
     * @return 会社名
     */
    public String getCompany() {
        return company;
    }

    /**
     * 会社名を設定します。
     * @param company 会社名
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 事務所名を取得します。
     * @return 事務所名
     */
    public String getBumon() {
        return bumon;
    }

    /**
     * 事務所名を設定します。
     * @param bumon 事務所名
     */
    public void setBumon(String bumon) {
        this.bumon = bumon;
    }

    /**
     * 登録日を取得します。
     * @return 登録日
     */
    public String getInsDt() {
        return insDt;
    }

    /**
     * 登録日を設定します。
     * @param insDt 登録日
     */
    public void setInsDt(String insDt) {
        this.insDt = insDt;
    }


}
