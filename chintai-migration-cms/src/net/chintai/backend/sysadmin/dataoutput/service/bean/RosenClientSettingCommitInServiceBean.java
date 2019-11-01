/*
 * $Id: RosenClientSettingCommitInServiceBean.java 4829 2014-01-15 02:36:12Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/11/07     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service.bean;

import java.util.List;


/**
 * 沿線別データ元除外設定更新用InServiceBean
 * @author KAMEDA Takuma
 * @version $Revision: 4829 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenClientSettingCommitInServiceBean {

    /** エリアコード */
    private String areaCd;

    /** 沿線タイプ */
    private String ensenType;

    /** 他社データ連携種類 */
    private String dcoType;

    /** Insert用リスト */
    private List<RosenClientSystemCommitListBean> commitList;

    /**
     * エリアコードを取得します。
     * @return エリアコード
     */
    public String getAreaCd() {
        return areaCd;
    }

    /**
     * エリアコードを設定します。
     * @param areaCd エリアコード
     */
    public void setAreaCd(String areaCd) {
        this.areaCd = areaCd;
    }

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
    public List<RosenClientSystemCommitListBean> getCommitList() {
        return commitList;
    }

    /**
     * Insert用リストを設定します。
     * @param commitList Insert用リスト
     */
    public void setCommitList(List<RosenClientSystemCommitListBean> commitList) {
        this.commitList = commitList;
    }

}
