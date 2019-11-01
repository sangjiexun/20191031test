/*
 * $Id: AspGroupInfoInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/23  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.bean;

/**
 * グループに追加する店舗情報
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspGroupInfoInServiceBean {

    /** グループ店舗コード */
    private String groupshopCd;

    /** 店舗コード */
    private String shopCd;

    /** 不動産ＡＳＰ連番 add kashiyama */
    private Long aspShopSeq;

    /** 店舗管理テーブル更新日時 */
    private String shopKanriUpdDt;

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
     * 店舗管理テーブル更新日時を返します。
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
