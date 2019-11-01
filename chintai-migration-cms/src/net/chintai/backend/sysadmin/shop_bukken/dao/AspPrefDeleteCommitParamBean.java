/*
 * $Id: AspPrefDeleteCommitParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/18  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

/**
 * 不動産ASP設定更新完了で都道府県のソートキーを削除された店舗コードと都道府県コードを保有するParamBean。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspPrefDeleteCommitParamBean {

    /** 店舗コード */
    private String shopCd;

    /** 不動産ASP連番 */
    private Long aspShopSeq;

    /** 削除する不動産ASP設定の都道府県コードリスト */
    private String[] prefCd;

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
     * 削除する不動産ASP設定の都道府県コードリストを取得します。
     * @return prefCd 削除する不動産ASP設定の都道府県コードリスト
     */
    public String[] getPrefCd() {
        return prefCd;
    }

    /**
     * 削除する不動産ASP設定の都道府県コードリストを設定します。
     * @param prefCd 削除する不動産ASP設定の都道府県コードリスト
     */
    public void setPrefCd(String[] prefCd) {
        this.prefCd = prefCd;
    }

}
