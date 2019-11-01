package net.chintai.backend.sysadmin.shop_bukken.service.bean;

/**
 * 契約明細設定（数量なし）完了InServiceBean
 *
 * @author m-kashiyama
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractNormalUpdateCommitInServiceBean {

    /** 店舗コード */
    private String shopCd;

    /** 更新日時 */
    private String updDt;

    /** 更新者ID */
    private String operUserId;

    /** 最終更新プログラムID */
    private String updPg;

    /** 契約フラグ */
    private String KeiyakuFlag;

    /** 契約コード */
    private String keiyakuCd;

    /** 契約サブコード  */
    private String keiyakuSubCd;

    /** 店舗管理テーブル更新日時 */
    private String shopKanriUpdDt;

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
     *  契約フラグを返します。
     * @return  契約フラグ
     */
    public String getKeiyakuFlag() {
        return KeiyakuFlag;
    }

    /**
     *  契約フラグを設定します。
     * @param keiyakuFlag   契約フラグ
     */
    public void setKeiyakuFlag(String keiyakuFlag) {
        KeiyakuFlag = keiyakuFlag;
    }

    /**
     *  店舗管理テーブル更新日時を返します。
     * @return  店舗管理テーブル更新日時
     */
    public String getShopKanriUpdDt() {
        return shopKanriUpdDt;
    }

    /**
     *  店舗管理テーブル更新日時を設定します。
     * @param shopKanriUpdDt   店舗管理テーブル更新日時
     */
    public void setShopKanriUpdDt(String shopKanriUpdDt) {
        this.shopKanriUpdDt = shopKanriUpdDt;
    }

}