/*
 * $Id: AspPrefInfo.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/11  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.domain;

/**
 * 不動産ASP設定で使用する都道府県用Domain
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspPrefInfo {

    /** 店舗コード */
    private String shopCd;

    /** 都道府県コード */
    private String prefCd;

    /** 都道府県名 */
    private String prefName;

    /** 都道府県ソートキー */
    private String sortKey;

    /** 不動産ASP設定(エリア)の最終更新日付 */
    private String updDt;

    /** 不動産ASP連番 */
    private Long aspShopSeq;

    /** 不動産ASP設定(エリア)のレコード作成プログラムＩＤ*/
    private String insPg;

    /** 不動産ASP設定(エリア)のレコード作成者*/
    private String insId;

    /**
     * 店舗コードを取得します。
     * @return shopCd 店舗コード
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
     * 都道府県コードを取得します。
     * @return prefCd 都道府県コード
     */
    public String getPrefCd() {
        return prefCd;
    }

    /**
     * 都道府県コードを設定します。
     * @param prefCd 都道府県コード
     */
    public void setPrefCd(String prefCd) {
        this.prefCd = prefCd;
    }

    /**
     * エリア都道府県のコード名を取得します。
     * @return prefName エリア都道府県のコード名
     */
    public String getPrefName() {
        return prefName;
    }

    /**
     * エリア都道府県のコード名を設定します。
     * @param prefName エリア都道府県のコード名
     */
    public void setPrefName(String prefName) {
        this.prefName = prefName;
    }

    /**
     * 都道府県ソートキーを取得します。
     * @return sortKey 都道府県ソートキー
     */
    public String getSortKey() {
        return sortKey;
    }

    /**
     * 都道府県ソートキーを設定します。
     * @param sortKey 都道府県ソートキー
     */
    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }


    /**
     * 不動産ASP連番を返します。
     * @return aspShopSeq
     */
    public Long getAspShopSeq() {
        return aspShopSeq;
    }

    /**
     * 不動産ASP連番を設定します。
     * @param aspShopSeq  不動産ASP連番
     */
    public void setAspShopSeq(Long aspShopSeq) {
        this.aspShopSeq = aspShopSeq;
    }

    /**
     * 不動産ASP設定(エリア)のレコード作成プログラムＩを返します。
     * @return insPg
     */
    public String getInsPg() {
        return insPg;
    }

    /**
     * 不動産ASP設定(エリア)のレコード作成プログラムＩを設定します。
     * @param insPg  不動産ASP設定(エリア)のレコード作成プログラムＩ
     */
    public void setInsPg(String insPg) {
        this.insPg = insPg;
    }


    /**
     * 不動産ASP設定(エリア)のレコード作成者を返します。
     * @return 不動産ASP設定(エリア)のレコード作成者
     */
    public String getInsId() {
        return insId;
    }

    /**
     * 不動産ASP設定(エリア)のレコード作成者を設定します。
     * @param insId  不動産ASP設定(エリア)のレコード作成者
     */
    public void setInsId(String insId) {
        this.insId = insId;
    }

    /**
     * 不動産ASP設定(エリア)のレコード作成者を返します。
     * @return 不動産ASP設定(エリア)のレコード作成者
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 不動産ASP設定(エリア)の最終更新日付を設定します。
     * @param updDt 不動産ASP設定(エリア)の最終更新日付
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

}
