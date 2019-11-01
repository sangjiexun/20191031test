/*
 * $Id: AspGroupUpdateCommitInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/24  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.bean;

/**
 * 不動産ASPグループ編集更新情報Bean
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspGroupUpdateCommitInServiceBean {

    /** 店舗コード */
    private String shopCd;

    /** グループ店舗コード */
    private String groupshopCd;

    /** ASP */
    private String aspFlg;

    /** 不動産ＡＳＰ連番 add kashiyama */
    private Long aspShopSeq;

    /** 店舗管理テーブル更新日時 */
    private String shopKanriUpdDt;

    /** レコード作成プログラムＩＤ add kashiyama */
    private String insPg;

    /** レコード作成者 add kashiyama */
    private String insId;

    /**
     * グループ店舗コードを取得します。
     * @return グループ店舗コード
     */
    public String getGroupshopCd() {
        return groupshopCd;
    }

    /**
     * グループ店舗コードを設定します。
     * @param groupshopCd グループ店舗コード
     */
    public void setGroupshopCd(String groupshopCd) {
        this.groupshopCd = groupshopCd;
    }

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
     * ASPを取得します。
     * @return ASP
     */
    public String getAspFlg() {
        return aspFlg;
    }

    /**
     * ASPを設定します。
     * @param aspFlg ASP
     */
    public void setAspFlg(String aspFlg) {
        this.aspFlg = aspFlg;
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
