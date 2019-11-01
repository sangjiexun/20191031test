/*
 * $Id: TorihikisakiWakuMaintenanceDownloadParamBean.java 4656 2013-10-09 08:20:39Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/09/18     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao;


/**
 * 物件枠数・物件リスティング枠数のCSVダウンロード用検索Bean
 * @author KAMEDA Takuma
 * @version $Revision: 4656 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuMaintenanceDownloadParamBean {

    /** 担当支社コード */
    private String shisyaCd;

    /** 取引先コード1(不動産会社コード) */
    private String torihikisakiCd1;

    /** 取引先コード2(取引先コード) */
    private String torihikisakiCd2;

    /** 不動産会社名 */
    private String fudousanName;


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



}
