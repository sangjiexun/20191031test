/*
 * $Id: RosenInfoOutServiceBean.java 4055 2008-11-12 01:04:22Z m-ono $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/17  BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service.bean;

/**
 * 沿線・駅詳細Bean
 * 
 * @author JavaBeans Code Generator
 * @version $Revision: 4055 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public class RosenInfoOutServiceBean {

    /** 沿線タイプ */
    private String ensenType;

    /** 沿線名称 */
    private String ensenName;

    /** 沿線名称かな */
    private String ensenKana;

    /** 沿線シーケンス番号(Webソートキー) */
    private String ensenSeq;

    /** 会社名 */
    private String railwaycoName;

    /** エリア */
    private String areaName;

    /** 駅コード */
    private String ekiCd;

    /** 駅名 */
    private String ekiName;

    /** 始発駅（フラグ） */
    private String startekiFlg;

    /** 急行停車（駅停車種類フラグ） */
    private String stopFlg;

    /** 駅シーケンス番号 */
    private String ekiSeq;

    /** 統一駅コード */
    private String ekiNo;

    /** 統一駅名称 */
    private String unionEkiName;

    /** 統一駅名称かな */
    private String unionEkiKana;

    /** 駅住所 */
    private String ekiAddress;

    /** 緯度 */
    private String locationY;

    /** 経度 */
    private String locationX;

    /** 最終更新日 */
    private String updDt;

    /** 削除（駅データ） */
    private String delKbn;

    /** 駅配布停止区分 */
    private String ekiUseStopFlg;

    /**
     * 沿線タイプを取得します。
     * @return 沿線タイプ
     */
    public String getEnsenType() {
        return ensenType;
    }

    /**
     * 沿線タイプを設定します。
     * @param ensenType 沿線タイプ
     */
    public void setEnsenType(String ensenType) {
        this.ensenType = ensenType;
    }

    /**
     * 沿線名称を取得します。
     * @return 沿線名称
     */
    public String getEnsenName() {
        return ensenName;
    }

    /**
     * 沿線名称を設定します。
     * @param ensenName 沿線名称
     */
    public void setEnsenName(String ensenName) {
        this.ensenName = ensenName;
    }

    /**
     * 沿線名称かなを取得します。
     * @return 沿線名称かな
     */
    public String getEnsenKana() {
        return ensenKana;
    }

    /**
     * 沿線名称かなを設定します。
     * @param ensenKana 沿線名称かな
     */
    public void setEnsenKana(String ensenKana) {
        this.ensenKana = ensenKana;
    }

    /**
     * 沿線シーケンス番号（Webソートキー）を取得します。
     * @return タイプ
     */
    public String getEnsenSeq() {
        return ensenSeq;
    }

    /**
     * 沿線シーケンス番号（Webソートキー）を設定します。
     * @param ensenSeq タイプ
     */
    public void setEnsenSeq(String ensenSeq) {
        this.ensenSeq = ensenSeq;
    }

    /**
     * 会社名を取得します。
     * @return 会社名
     */
    public String getRailwaycoName() {
        return railwaycoName;
    }

    /**
     * 会社名を設定します。
     * @param railwaycoName 会社名
     */
    public void setRailwaycoName(String railwaycoName) {
        this.railwaycoName = railwaycoName;
    }

    /**
     * エリアを取得します。
     * @return エリア
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * エリアを設定します。
     * @param areaName エリア
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 駅コードを取得します。
     * @return 駅コード
     */
    public String getEkiCd() {
        return ekiCd;
    }

    /**
     * 駅コードを設定します。
     * @param ekiCd 駅コード
     */
    public void setEkiCd(String ekiCd) {
        this.ekiCd = ekiCd;
    }

    /**
     * 駅名を取得します。
     * @return 駅名
     */
    public String getEkiName() {
        return ekiName;
    }

    /**
     * 駅名を設定します。
     * @param ekiName 駅名
     */
    public void setEkiName(String ekiName) {
        this.ekiName = ekiName;
    }

    /**
     * 始発駅（フラグ）を取得します。
     * @return 始発駅（フラグ）
     */
    public String getStartekiFlg() {
        return startekiFlg;
    }

    /**
     * 始発駅（フラグ）を設定します。
     * @param starteki_Flg 始発駅（フラグ）
     */
    public void setStartekiFlg(String startekiFlg) {
        this.startekiFlg = startekiFlg;
    }

    /**
     * 急行停車（駅停車種類フラグ）を取得します。
     * @return 急行停車（駅停車種類フラグ））
     */
    public String getStopFlg() {
        return stopFlg;
    }

    /**
     * 急行停車（駅停車種類フラグ）を設定します。
     * @param stopFlg 急行停車（駅停車種類フラグ）
     */
    public void setStopFlg(String stopFlg) {
        this.stopFlg = stopFlg;
    }

    /**
     * 駅シーケンス番号を取得します。
     * @return 駅シーケンス番号
     */
    public String getEkiSeq() {
        return ekiSeq;
    }

    /**
     * 駅シーケンス番号を設定します。
     * @param starteki_Flg 駅シーケンス番号
     */
    public void setEkiSeq(String ekiSeq) {
        this.ekiSeq = ekiSeq;
    }

    /**
     * 統一駅コードを取得します。
     * @return 統一駅コード
     */
    public String getEkiNo() {
        return ekiNo;
    }

    /**
     * 統一駅コードを設定します。
     * @param ekiNo 統一駅コード
     */
    public void setEkiNo(String ekiNo) {
        this.ekiNo = ekiNo;
    }

    /**
     * 統一駅名称を取得します。
     * @return 統一駅名称
     */
    public String getUnionEkiName() {
        return unionEkiName;
    }

    /**
     * 統一駅名称を設定します。
     * @param unionEkiName 統一駅名称
     */
    public void setUnionEkiName(String unionEkiName) {
        this.unionEkiName = unionEkiName;
    }

    /**
     * 統一駅名称かなを取得します。
     * @return 統一駅名称かな
     */
    public String getUnionEkiKana() {
        return unionEkiKana;
    }

    /**
     * 統一駅名称かなを設定します。
     * @param unionEkiKana 統一駅名称かな
     */
    public void setUnionEkiKana(String unionEkiKana) {
        this.unionEkiKana = unionEkiKana;
    }

    /**
     * 駅住所を取得します。
     * @return 駅住所
     */
    public String getEkiAddress() {
        return ekiAddress;
    }

    /**
     * 駅住所を設定します。
     * @param ekiAddress 駅住所
     */
    public void setEkiAddress(String ekiAddress) {
        this.ekiAddress = ekiAddress;
    }

    /**
     * 緯度を取得します。
     * @return 緯度
     */
    public String getLocationY() {
        return locationY;
    }

    /**
     * 緯度を設定します。
     * @param locationY 緯度
     */
    public void setLocationY(String locationY) {
        this.locationY = locationY;
    }

    /**
     * 経度を取得します。
     * @return 経度
     */
    public String getLocationX() {
        return locationX;
    }

    /**
     * 経度を設定します。
     * @param locationX 経度
     */
    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    /**
     * 最終更新日を取得します。
     * @return 最終更新日
     */
    public String getUpdDt() {
        return updDt;
    }

    /**
     * 最終更新日を設定します。
     * @param updDt 最終更新日
     */
    public void setUpdDt(String updDt) {
        this.updDt = updDt;
    }

    /**
     * 削除（駅データ）を設定します。
     * @param delKbn 削除（駅データ）
     */
    public void setDelKbn(String delKbn) {
        this.delKbn = delKbn;
    }

    /**
     * 削除（駅データ）を取得します。
     * @return 削除（駅データ）
     */
    public String getDelKbn() {
        return delKbn;
    }

    /**
     * 駅配布停止区分を取得します。
     * @return 駅配布停止区分
     */
    public String getEkiUseStopFlg() {
        return ekiUseStopFlg;
    }

    /**
     * 駅配布停止区分を設定します。
     * @param ekiUseStopFlg 駅配布停止区分
     */
    public void setEkiUseStopFlg(String ekiUseStopFlg) {
        this.ekiUseStopFlg = ekiUseStopFlg;
    }

}
