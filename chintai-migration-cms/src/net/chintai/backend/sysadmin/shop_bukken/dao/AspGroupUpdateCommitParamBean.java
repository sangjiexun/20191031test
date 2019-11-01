/*
 * $Id: AspGroupUpdateCommitParamBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/24  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.dao;

/**
 * 不動産ASPグループ登録情報
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspGroupUpdateCommitParamBean {

    /** 店舗コード */
    private String shopCd;

    /** グループ店舗コード */
    private String groupshopCd;

    /** 店舗状態ステータス */
    private String aspFlg;

    /** 不動産ＡＳＰ連番 add kashiyama */
    private Long aspShopSeq;

    /** レコード作成プログラムＩＤ add kashiyama */
    private String insPg;

    /** レコード作成者 add kashiyama */
    private String insId;

    /**
     * 店舗状態ステータスを設定します。
     * @return aspFlg 店舗状態ステータス
     */
    public String getAspFlg() {
        return aspFlg;
    }

    /**
     * 店舗状態ステータスを取得します。
     * @param aspFlg 店舗状態ステータス
     */
    public void setAspFlg(String aspFlg) {
        this.aspFlg = aspFlg;
    }

    /**
     * グループ店舗コードを設定します。
     * @return groupshopCd グループ店舗コード
     */
    public String getGroupshopCd() {
        return groupshopCd;
    }

    /**
     * グループ店舗コードを取得します。
     * @param groupshopCd グループ店舗コード
     */
    public void setGroupshopCd(String groupshopCd) {
        this.groupshopCd = groupshopCd;
    }

    /**
     * 店舗コードを設定します。
     * @return shopCd 店舗コード
     */
    public String getShopCd() {
        return shopCd;
    }

    /**
     * 店舗コードを取得します。
     * @param shopCd 店舗コード
     */
    public void setShopCd(String shopCd) {
        this.shopCd = shopCd;
    }

    /**
     * 不動産ＡＳＰ連番を取得します。
     *
     * @return 不動産ＡＳＰ連番
     */
    public Long getAspShopSeq() {
        return aspShopSeq;
    }

    /**
     * 不動産ＡＳＰ連番を設定します。
     *
     * @param aspShopSeq
     *            不動産ＡＳＰ連番
     */
    public void setAspShopSeq(Long aspShopSeq) {
        this.aspShopSeq = aspShopSeq;
    }

    /**
     * レコード作成プログラムＩＤを返します。
     *
     * @return レコード作成プログラムＩＤ
     */
    public String getInsPg() {
        return insPg;
    }

    /**
     * レコード作成プログラムＩＤを設定します。
     *
     * @param insPg
     *            レコード作成プログラムＩＤ
     */
    public void setInsPg(String insPg) {
        this.insPg = insPg;
    }

    /**
     * レコード作成者を返します。
     *
     * @return レコード作成者
     */
    public String getInsId() {
        return insId;
    }

    /**
     * レコード作成者を設定します。
     *
     * @param insId
     *            レコード作成者
     */
    public void setInsId(String insId) {
        this.insId = insId;
    }

}
