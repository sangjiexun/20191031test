/*
 * $Id: AspGroupDeleteCommitInServiceBean.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/25  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.service.bean;

import java.util.List;

/**
 * 不動産ASPグループから外す店舗情報
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspGroupDeleteCommitInServiceBean {

    /** 店舗コード */
    private String shopCd;

    /** 削除対象店舗コード */
    private List<String> delShop;

    /** 不動産ＡＳＰ連番 add kashiyama */
    private Long aspShopSeq;

    /** 店舗管理テーブル更新日時 */
    private String shopKanriUpdDt;

    /** 更新ユーザ名*/
    private String updId;

    /** 更新プログラム名*/
    private String updPg;

    /**
     * 削除対象店舗コードを取得します。
     * @return 削除対象店舗コード
     */
    public List<String> getDelShop() {
        return delShop;
    }

    /**
     * 削除対象店舗コードを設定します。
     * @param delShop 削除対象店舗コード
     */
    public void setDelShop(List<String> delShop) {
        this.delShop = delShop;
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
     * updIdを返します。
     * @return updId
     */
    public String getUpdId() {
        return updId;
    }

    /**
     * を設定します。
     * @param updId  updId
     */
    public void setUpdId(String updId) {
        this.updId = updId;
    }

    /**
     * updPgを返します。
     * @return updPg
     */
    public String getUpdPg() {
        return updPg;
    }

    /**
     * を設定します。
     * @param updPg  updPg
     */
    public void setUpdPg(String updPg) {
        this.updPg = updPg;
    }

}
