/*
 * $Id: TorihikisakiSearchForBindParamBean.java 3671 2007-12-20 02:09:07Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/20  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;


/**
 * 取引先検索（店舗コード紐付用）
 *
 * @author lee-hosup
 * @version $Revision: 3671 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiSearchForBindParamBean {

    /** 店舗コード */
    private String shopCd;

    /** 担当支社コード */
    private String shisyaCd;

    /** 取引先コード1(不動産会社コード) */
    private String torihikisakiCd1;

    /** 取引先コード2(取引先コード) */
    private String torihikisakiCd2;

    /** 不動産会社名 */
    private String fudousanName;

    /** 取引先名 */
    private String torihikisakiName;

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
     * 担当支社コードを取得します。
     * @return 担当支社コード
     */
    public String getShisyaCd() {
        return shisyaCd;
    }

    /**
     * 担当支社コードを設定します。
     * @param shisyaCd 担当支社コード
     */
    public void setShisyaCd(String shisyaCd) {
        this.shisyaCd = shisyaCd;
    }

    /**
     * 取引先コード1(不動産会社コード)を取得します。
     * @return 取引先コード1(不動産会社コード)
     */
    public String getTorihikisakiCd1() {
        return torihikisakiCd1;
    }

    /**
     * 取引先コード1(不動産会社コード)を設定します。
     * @param torihikisakiCd1 取引先コード1(不動産会社コード)
     */
    public void setTorihikisakiCd1(String torihikisakiCd1) {
        this.torihikisakiCd1 = torihikisakiCd1;
    }

    /**
     * 取引先コード2(取引先コード)を取得します。
     * @return 取引先コード2(取引先コード)
     */
    public String getTorihikisakiCd2() {
        return torihikisakiCd2;
    }

    /**
     * 取引先コード2(取引先コード)を設定します。
     * @param torihikisakiCd2 取引先コード2(取引先コード)
     */
    public void setTorihikisakiCd2(String torihikisakiCd2) {
        this.torihikisakiCd2 = torihikisakiCd2;
    }

    /**
     * 不動産会社名を取得します。
     * @return 不動産会社名
     */
    public String getFudousanName() {
        return fudousanName;
    }

    /**
     * 不動産会社名を設定します。
     * @param fudousanName 不動産会社名
     */
    public void setFudousanName(String fudousanName) {
        this.fudousanName = fudousanName;
    }

    /**
     * 取引先名を取得します。
     * @return 取引先名
     */
    public String getTorihikisakiName() {
        return torihikisakiName;
    }

    /**
     * 取引先名を設定します。
     * @param torihikisakiName 取引先名
     */
    public void setTorihikisakiName(String torihikisakiName) {
        this.torihikisakiName = torihikisakiName;
    }
}
