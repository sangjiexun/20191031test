/*
 * $Id: ShopBindSearchInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/09  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.bean;

import net.chintai.backend.sysadmin.common.session.SessionSearchCondition;

/**
 * 店舗コード紐付検索条件
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopBindSearchInServiceBean implements SessionSearchCondition {

    /** serialVersionUID */
    private static final long serialVersionUID = 593935527400282954L;

    /** 店舗コード */
    private String shopCd;

    /** 不動産会社名 */
    private String company;

    /** 店舗名 */
    private String bumon;

    /** ページング情報 */
    private int offSet;

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
     * 不動産会社名を取得します。
     * @return 不動産会社名
     */
    public String getCompany() {
        return company;
    }

    /**
     * 不動産会社名を設定します。
     * @param company 不動産会社名
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 店舗名を取得します。
     * @return 店舗名
     */
    public String getBumon() {
        return bumon;
    }

    /**
     * 店舗名を設定します。
     * @param bumon 店舗名
     */
    public void setBumon(String bumon) {
        this.bumon = bumon;
    }

    /**
     * ページング情報を取得します。
     * @return ページング情報
     */
    public int getOffSet() {
        return offSet;
    }

    /**
     * ページング情報を設定します。
     * @param offSet ページング情報
     */
    public void setOffSet(int offSet) {
        this.offSet = offSet;
    }

}
