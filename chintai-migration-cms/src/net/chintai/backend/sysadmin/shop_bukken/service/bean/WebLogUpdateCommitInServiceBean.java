/*
 * $Id: WebLogUpdateCommitInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.bean;

/**
 * Webログ利用可否InServiceBean
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class WebLogUpdateCommitInServiceBean {

    /** 店舗コード */
    private String shopCd;

    /** Webログ利用可否 */
    private String webLogFlg;

    /** 更新日時 */
    private String updDt;

    /** 更新者ID */
    private String operUserId;

    /** 最終更新プログラムID */
    private String updPg;

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
     * Webログ利用可否を取得します。
     * @return Webログ利用可否
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

    /**
     * 更新者IDを取得します。
     * @return 更新者ID
     */
    public String getOperUserId() {
        return operUserId;
    }

    /**
     * 更新者IDを設定します。
     * @param operUserId 更新者ID
     */
    public void setOperUserId(String operUserId) {
        this.operUserId = operUserId;
    }

    /**
     * 最終更新プログラムIDを取得します。
     * @return 最終更新プログラムID
     */
    public String getUpdPg() {
        return updPg;
    }

    /**
     * 最終更新プログラムIDを設定します。
     * @param updPg 最終更新プログラムID
     */
    public void setUpdPg(String updPg) {
        this.updPg = updPg;
    }

}