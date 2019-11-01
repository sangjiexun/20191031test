/*
 * $Id: WebLogUpdatePageOutServiceBean.java 3853 2008-03-10 05:43:48Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.bean;

/**
 * 
 *
 * @author Kim Dong Jin
 * @version $Revision: 3853 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class WebLogUpdatePageOutServiceBean {

    /** 会社名 */
    private String company;

    /** 事務署名 */
    private String bumon;

    /** 店舗コード */
    private String shopCd;

    /** お客様設定パスワード */
    private String password;

    /** Webログ利用可否 */
    private String webLogFlg;

    /** 更新日時 */
    private String updDt;

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
     * 事務署名を取得します。
     * @return 事務署名
     */
    public String getBumon() {
        return bumon;
    }

    /**
     * 事務署名を設定します。
     * @param bumon 事務署名
     */
    public void setBumon(String bumon) {
        this.bumon = bumon;
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

    /**
     * お客様設定パスワードを取得します。
     * @return お客様設定パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * お客様設定パスワードを設定します。
     * @param password お客様設定パスワード
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Webログ利用可否を取得します。
     * @return webLogFlg Webログ利用可否
     */
    public String getWebLogFlg() {
        return webLogFlg;
    }

    /**
     * Webログ利用可否を設定します。
     * @param webLogFlg Webログ利用可否
     */
    public void setWebLogFlg(String webLogFlg) {
        this.webLogFlg = webLogFlg;
    }

    /**
     * 更新日時を取得します。
     * @return 更新日時
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 更新日時を設定します。
     * @param updDt 更新日時
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }
}
