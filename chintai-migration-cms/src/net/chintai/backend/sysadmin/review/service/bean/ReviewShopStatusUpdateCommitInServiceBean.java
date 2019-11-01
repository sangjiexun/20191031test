/*
 * $Id: ReviewShopStatusUpdateCommitInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/17  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.service.bean;

/**
 * 店舗対象外設定更新
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopStatusUpdateCommitInServiceBean {

    /** 店舗コード */
    private String shopCd;

    /** 初回審査対象外 */
    private String syokaiShinsaSkipFlg;

    /** 定期審査対象外 */
    private String teikiShinsaSkipFlg;

    /** メール送信対象外 */
    private String mailSendSkipFlg;

    /** 自動削除対象外 */
    private String autoDelSkipFlg;

    /** 審査対象外備考 */
    private String shinsaSkipBikou;

    /** 最終更新日時 */
    private String updDt;

    /** 更新者ID */
    private String updId;

    /** プログラムID */
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
     * 初回審査対象外を取得します。
     * @return 初回審査対象外
     */
    public String getSyokaiShinsaSkipFlg() {
        return syokaiShinsaSkipFlg;
    }

    /**
     * 初回審査対象外を設定します。
     * @param syokaiShinsaSkipFlg 初回審査対象外
     */
    public void setSyokaiShinsaSkipFlg(String syokaiShinsaSkipFlg) {
        this.syokaiShinsaSkipFlg = syokaiShinsaSkipFlg;
    }

    /**
     * 定期審査対象外を取得します。
     * @return 定期審査対象外
     */
    public String getTeikiShinsaSkipFlg() {
        return teikiShinsaSkipFlg;
    }

    /**
     * 定期審査対象外を設定します。
     * @param teikiShinsaSkipFlg 定期審査対象外
     */
    public void setTeikiShinsaSkipFlg(String teikiShinsaSkipFlg) {
        this.teikiShinsaSkipFlg = teikiShinsaSkipFlg;
    }

    /**
     * メール送信対象外を取得します。
     * @return メール送信対象外
     */
    public String getMailSendSkipFlg() {
        return mailSendSkipFlg;
    }

    /**
     * メール送信対象外を設定します。
     * @param mailSendSkipFlg メール送信対象外
     */
    public void setMailSendSkipFlg(String mailSendSkipFlg) {
        this.mailSendSkipFlg = mailSendSkipFlg;
    }

    /**
     * 自動削除対象外を取得します。
     * @return 自動削除対象外
     */
    public String getAutoDelSkipFlg() {
        return autoDelSkipFlg;
    }

    /**
     * 自動削除対象外を設定します。
     * @param autoDelSkipFlg 自動削除対象外
     */
    public void setAutoDelSkipFlg(String autoDelSkipFlg) {
        this.autoDelSkipFlg = autoDelSkipFlg;
    }

    /**
     * 審査対象外備考を取得します。
     * @return 審査対象外備考
     */
    public String getShinsaSkipBikou() {
        return shinsaSkipBikou;
    }

    /**
     * 審査対象外備考を設定します。
     * @param shinsaSkipBikou 審査対象外備考
     */
    public void setShinsaSkipBikou(String shinsaSkipBikou) {
        this.shinsaSkipBikou = shinsaSkipBikou;
    }

    /**
     * 最終更新日時を取得します。
     * @return 最終更新日時
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 最終更新日時を設定します。
     * @param updDt 最終更新日時
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
     * 更新者IDを取得します。
     * @return 更新者ID
     */
    public String getUpdId() {
        return updId;
    }

    /**
     * 更新者IDを設定します。
     * @param updId 更新者ID
     */
    public void setUpdId(String updId) {
        this.updId = updId;
    }

    /**
     * プログラムIDを取得します。
     * @return プログラムID
     */
    public String getUpdPg() {
        return updPg;
    }

    /**
     * プログラムIDを設定します。
     * @param updPg プログラムID
     */
    public void setUpdPg(String updPg) {
        this.updPg = updPg;
    }

}
