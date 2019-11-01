/*
 * $Id: ShopBindUpdateCommitParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/16  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;

/**
 * 店舗紐付先更新データ
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopBindUpdateCommitParamBean {

    /** 店舗コード */
    private String shopCd;

    /** 最終更新日時 */
    private String updDt;

    /** 更新プログラムID */
    private String updPg;

    /** 更新者 */
    private String updId;

    /** 更新対象レコードのシーケンス番号 */
    private String torihikisakiSeq;

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
     * 更新プログラムIDを取得します。
     * @return 更新プログラムID
     */
    public String getUpdPg() {
        return updPg;
    }

    /**
     * 更新プログラムIDを設定します。
     * @param updPg 更新プログラムID
     */
    public void setUpdPg(String updPg) {
        this.updPg = updPg;
    }

    /**
     * 更新者を取得します。
     * @return 更新者
     */
    public String getUpdId() {
        return updId;
    }

    /**
     * 更新者を設定します。
     * @param updId 更新者
     */
    public void setUpdId(String updId) {
        this.updId = updId;
    }

    /**
     * 更新対象レコードのシーケンス番号を取得します。
     * @return 更新対象レコードのシーケンス番号
     */
    public String getTorihikisakiSeq() {
        return torihikisakiSeq;
    }

    /**
     * 更新対象レコードのシーケンス番号を設定します。
     * @param torihikisakiSeq 更新対象レコードのシーケンス番号
     */
    public void setTorihikisakiSeq(String torihikisakiSeq) {
        this.torihikisakiSeq = torihikisakiSeq;
    }

}
