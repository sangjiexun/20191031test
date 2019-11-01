/*
 * $Id: EkiClientSettingCommitInServiceBean.java 4803 2014-01-10 05:38:20Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/11/07     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service.bean;

import java.util.List;


/**
 * 他社データ連携駅除外設定更新用InServiceBean
 * @author KAMEDA Takuma
 * @version $Revision: 4803 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class EkiClientSettingCommitInServiceBean {

    /** 他社データ連携種類 */
    private String dcoType;

    /** Insert用リスト */
    private List<EkiClientSystemCommitListBean> commitList;

    /** 沿線コード */
    private String ensenCd;

    /** 沿線別削除処理用パラメータ */
    private String parentalType;

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
    public List<EkiClientSystemCommitListBean> getCommitList() {
        return commitList;
    }

    /**
     * Insert用リストを設定します。
     * @param commitList Insert用リスト
     */
    public void setCommitList(List<EkiClientSystemCommitListBean> commitList) {
        this.commitList = commitList;
    }

    /**
     * 沿線コードを取得します。
     * @return 沿線コード
     */
    public String getEnsenCd() {
        return ensenCd;
    }

    /**
     * 沿線コードを設定します。
     * @param ensenCd 沿線コード
     */
    public void setEnsenCd(String ensenCd) {
        this.ensenCd = ensenCd;
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

}
