/*
 * $Id: ShopListingEkiParamBean.java 4246 2009-03-23 09:00:00Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/12     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.dao;

/**
 * 店舗リスティング駅テーブルパラメータ。
 *
 * @author Lee Hosup
 * @version $Revision: 4246 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingEkiParamBean {

    /** シーケンス */
    private String shopListingEkiSeq;

    /** 店舗コード */
    private String shopCd;

    /** 沿線コード */
    private String ensenCd;

    /** 駅コード */
    private String ekiCd;

    /** Web掲載フラグ */
    private String webUpFlg;

    /** 登録プログラム名 */
    private String insPg;

    /** 登録者ID */
    private String insId;

    /** 更新プログラム名 */
    private String updPg;

    /** 更新者ID */
    private String updId;

    /**
     * シーケンスを取得します。
     * @return シーケンス
     */
    public String getShopListingEkiSeq() {
        return shopListingEkiSeq;
    }

    /**
     * シーケンスを設定します。
     * @param shopListingEkiSeq シーケンス
     */
    public void setShopListingEkiSeq(String shopListingEkiSeq) {
        this.shopListingEkiSeq = shopListingEkiSeq;
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
     * 沿線コードを取得します。
     * @return 沿線コード
     */
    public String getEnsenCd() {
        return ensenCd;
    }

    /**
     * 沿線コードを設定します。
     * @param ensenCd 沿線コード
     */
    public void setEnsenCd(String ensenCd) {
        this.ensenCd = ensenCd;
    }

    /**
     * 駅コードを取得します。
     * @return 駅コード
     */
    public String getEkiCd() {
        return ekiCd;
    }

    /**
     * 駅コードを設定します。
     * @param ekiCd 駅コード
     */
    public void setEkiCd(String ekiCd) {
        this.ekiCd = ekiCd;
    }

    /**
     * Web掲載フラグを取得します。
     * @return Web掲載フラグ
     */
    public String getWebUpFlg() {
        return webUpFlg;
    }

    /**
     * Web掲載フラグを設定します。
     * @param webUpFlg Web掲載フラグ
     */
    public void setWebUpFlg(String webUpFlg) {
        this.webUpFlg = webUpFlg;
    }

    /**
     * 登録プログラム名を取得します。
     * @return 登録プログラム名
     */
    public String getInsPg() {
        return insPg;
    }

    /**
     * 登録プログラム名を設定します。
     * @param insPg 登録プログラム名
     */
    public void setInsPg(String insPg) {
        this.insPg = insPg;
    }

    /**
     * 登録者IDを取得します。
     * @return 登録者ID
     */
    public String getInsId() {
        return insId;
    }

    /**
     * 登録者IDを設定します。
     * @param insId 登録者ID
     */
    public void setInsId(String insId) {
        this.insId = insId;
    }

    /**
     * 更新プログラム名を取得します。
     * @return 更新プログラム名
     */
    public String getUpdPg() {
        return updPg;
    }

    /**
     * 更新プログラム名を設定します。
     * @param updPg 更新プログラム名
     */
    public void setUpdPg(String updPg) {
        this.updPg = updPg;
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

}
