/*
 * $Id: AspAreaInfo.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/15  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_bukken.domain;

import java.sql.Timestamp;

/**
 * 不動産ASP設定のエリア登録完了で使用するDomain
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspAreaInfo {

    /** 店舗コード */
    private String shopCd;

    /** 都道府県コード */
    private String prefCd;

    /** ソートキー */
    private String sortKey;

    /** 不動産ASP連番 */
    private Long aspShopSeq;

    /** レコード作成日時*/
    private Timestamp insDt;

    /** レコード作成プログラムＩＤ*/
    private String insPg;

    /** レコード作成者*/
    private String insId;

    /** レコード更新日時*/
    private Timestamp updDt;

    /** レコード更新プログラムＩＤ*/
    private String updPg;

    /** レコード更新者*/
    private String updId;

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
     * ソートキーを取得します。
     * @return sortKey ソートキー
     */
    public String getSortKey() {
        return sortKey;
    }

    /**
     * ソートキーを設定します。
     * @param sortKey ソートキー
     */
    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    /**
     * 不動産ASP連番を返します。
     * @return 不動産ASP連番
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
     * レコード作成日時を返します。
     * @return insDt
     */
    public Timestamp getInsDt() {
        return insDt;
    }

    /**
     * レコード作成日時を設定します。
     * @param insDt  レコード作成日時
     */
    public void setInsDt(Timestamp insDt) {
        this.insDt = insDt;
    }

    /**
     * レコード作成プログラムＩＤを返します。
     * @return レコード作成プログラムＩＤ
     */
    public String getInsPg() {
        return insPg;
    }

    /**
     * レコード作成プログラムＩＤを設定します。
     * @param insPg  レコード作成プログラムＩＤ
     */
    public void setInsPg(String insPg) {
        this.insPg = insPg;
    }

    /**
     * レコード作成者を返します。
     * @return レコード作成者
     */
    public String getInsId() {
        return insId;
    }

    /**
     * レコード作成者を設定します。
     * @param insId  レコード作成者
     */
    public void setInsId(String insId) {
        this.insId = insId;
    }

    /**
     * レコード更新日時を返します。
     * @return レコード更新日時
     */
    public Timestamp getUpdDt() {
        return updDt;
    }

    /**
     * レコード更新日時を設定します。
     * @param updDt  レコード更新日時
     */
    public void setUpdDt(Timestamp updDt) {
        this.updDt = updDt;
    }

    /**
     * レコード更新プログラムＩＤを返します。
     * @return レコード更新プログラムＩＤ
     */
    public String getUpdPg() {
        return updPg;
    }

    /**
     * レコード更新プログラムＩＤを設定します。
     * @param updPg  レコード更新プログラムＩＤ
     */
    public void setUpdPg(String updPg) {
        this.updPg = updPg;
    }

    /**
     * レコード更新者を返します。
     * @return レコード更新者
     */
    public String getUpdId() {
        return updId;
    }

    /**
     * レコード更新者を設定します。
     * @param updId  レコード更新者
     */
    public void setUpdId(String updId) {
        this.updId = updId;
    }

}
