/*
 * $Id: MediaInfoWebRegisterCompleteInServiceBean.java 4247 2009-03-23 09:15:01Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/15     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_listing.service.bean;

/**
 * 出稿情報本番反映完了サービスビーン。
 *
 * @author Lee Hosup
 * @version $Revision: 4247 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MediaInfoWebRegisterCompleteInServiceBean {

    /** 店舗コード */
    private String shopCd;

    /** 最終更新日時 */
    private String updDt;

    /** 更新プログラム名 */
    private String updPg;

    /** 更新者ID */
    private String updId;

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
