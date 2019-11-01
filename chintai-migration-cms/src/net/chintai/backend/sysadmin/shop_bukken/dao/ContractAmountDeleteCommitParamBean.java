package net.chintai.backend.sysadmin.shop_bukken.dao;

/**
 * 契約明細詳細(契約数量あり)設定情報削除
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountDeleteCommitParamBean {

    /** 店舗コード  */
    private String shopCd;

    /** 契約コード */
    private String keiyakuCd;

    /** 契約サブコード  */
    private String keiyakuSubCd;

    /** 削除する適用月 */
    private String delFlg;

    /** 取引先テーブルの最終更新日付 */
    private String torihikisakiUpdDt;

    /** 更新者ID */
    private String updId;

    /** 更新プログラム */
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
     * 削除する適用月を取得します。
     * @return 削除する適用月
     */
    public String getDelFlg() {
        return delFlg;
    }

    /**
     * 削除する適用月を設定します。
     * @param delFlg 削除する適用月
     */
    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg;
    }

    /**
     * 取引先テーブルの最終更新日付を取得します。
     * @return 取引先テーブルの最終更新日付
     */
    public String getTorihikisakiUpdDt() {
        return torihikisakiUpdDt;
    }

    /**
     * 取引先テーブルの最終更新日付を設定します。
     * @param torihikisakiUpdDt 取引先テーブルの最終更新日付
     */
    public void setTorihikisakiUpdDt(String torihikisakiUpdDt) {
        this.torihikisakiUpdDt = torihikisakiUpdDt;
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
     * 更新プログラムを取得します。
     * @return 更新プログラム
     */
    public String getUpdPg() {
        return updPg;
    }

    /**
     * 更新プログラムを設定します。
     * @param updPg 更新プログラム
     */
    public void setUpdPg(String updPg) {
        this.updPg = updPg;
    }

}
