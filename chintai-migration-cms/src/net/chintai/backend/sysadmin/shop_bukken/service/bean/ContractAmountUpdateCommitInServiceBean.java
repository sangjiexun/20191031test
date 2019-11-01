package net.chintai.backend.sysadmin.shop_bukken.service.bean;

/**
 * 取引先枠情報更新
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountUpdateCommitInServiceBean {

    /** 店舗コード  */
    private String shopCd;

    /** 契約コード */
    private String keiyakuCd;

    /** 契約サブコード  */
    private String keiyakuSubCd;

    /** 適用年月日時 */
    private String appStartDt;

    /** 枠数 */
    private String wakuCnt;

    /** 枠数(手入力) */
    private String wakuCntNote;

    /** 更新者ID */
    private String updId;

    /** プログラム名 */
    private String updPg;

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
     * 適用年月日時を返します。
     * @return 適用年月日時
     */
    public String getAppStartDt() {
        return appStartDt;
    }

    /**
     * 適用年月日時を設定します。
     * @param appStartDt  適用年月日時
     */
    public void setAppStartDt(String appStartDt) {
        this.appStartDt = appStartDt;
    }

    /**
     * 枠数を返します。
     * @return 枠数
     */
    public String getWakuCnt() {
        return wakuCnt;
    }

    /**
     * 枠数を設定します。
     * @param wakuCnt  枠数
     */
    public void setWakuCnt(String wakuCnt) {
        this.wakuCnt = wakuCnt;
    }

    /**
     * 枠数を返します。
     * @return 枠数
     */
    public String getWakuCntNote() {
        return wakuCntNote;
    }

    /**
     * 枠数を設定します。
     * @param wakuCntNote  枠数
     */
    public void setWakuCntNote(String wakuCntNote) {
        this.wakuCntNote = wakuCntNote;
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
     * プログラム名を取得します。
     * @return プログラム名
     */
    public String getUpdPg() {
        return updPg;
    }

    /**
     * プログラム名を設定します。
     * @param updPg プログラム名
     */
    public void setUpdPg(String updPg) {
        this.updPg = updPg;
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
