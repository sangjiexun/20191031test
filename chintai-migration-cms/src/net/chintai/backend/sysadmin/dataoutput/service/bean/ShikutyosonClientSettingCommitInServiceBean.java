/*
 * $Id: ShikutyosonClientSettingCommitInServiceBean.java 4830 2014-01-15 02:52:47Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2014/01/06     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service.bean;

import java.util.List;


/**
 * 市区町村別データ元出力設定情報更新用Bean
 * @author KAMEDA Takuma
 * @version $Revision: 4830 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShikutyosonClientSettingCommitInServiceBean {

    /** 他社データ連携種類 */
    private String dcoType;

    /** Insert用リスト */
    private List<ShikutyosonClientSystemCommitListBean> commitList;

    /** 都道府県コード */
    private String prefCd;

    /** 沿線別削除処理用パラメータ */
    private String parentalType;

    /** 全国都道府県JISコード */
    private String cityCd;

    /**
     * 他社データ連携種類を取得します。
     * @return 他社データ連携種類
     */
    public String getDcoType() {
        return dcoType;
    }

    /**
     * 他社データ連携種類を設定します。
     * @param dcoType 他社データ連携種類
     */
    public void setDcoType(String dcoType) {
        this.dcoType = dcoType;
    }

    /**
     * Insert用リストを取得します。
     * @return Insert用リスト
     */
    public List<ShikutyosonClientSystemCommitListBean> getCommitList() {
        return commitList;
    }

    /**
     * Insert用リストを設定します。
     * @param commitList Insert用リスト
     */
    public void setCommitList(List<ShikutyosonClientSystemCommitListBean> commitList) {
        this.commitList = commitList;
    }

    /**
     * 都道府県コードを取得します。
     * @return 都道府県コード
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
     * 沿線別削除処理用パラメータを取得します。
     * @return 沿線別削除処理用パラメータ
     */
    public String getParentalType() {
        return parentalType;
    }

    /**
     * 沿線別削除処理用パラメータを設定します。
     * @param parentalType 沿線別削除処理用パラメータ
     */
    public void setParentalType(String parentalType) {
        this.parentalType = parentalType;
    }

    /**
     * 全国都道府県JISコードを取得します。
     * @return 全国都道府県JISコード
     */
    public String getCityCd() {
        return cityCd;
    }

    /**
     * 全国都道府県JISコードを設定します。
     * @param cityCd 全国都道府県JISコード
     */
    public void setCityCd(String cityCd) {
        this.cityCd = cityCd;
    }

}
