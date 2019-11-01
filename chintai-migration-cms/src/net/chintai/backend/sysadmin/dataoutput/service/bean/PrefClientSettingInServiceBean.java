/*
 * $Id: PrefClientSettingInServiceBean.java 4750 2013-11-05 09:11:43Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/29     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service.bean;

import java.util.List;


/**
 * 都道府県別データ元出力設定のinServiceBean
 * @author KAMEDA Takuma
 * @version $Revision: 4750 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class PrefClientSettingInServiceBean {

    /** 他社データ連携種類 */
    private String dcoType;

    /** Insert用リスト */
    private List<PrefClientSystemCommitInServiceBean> commitList;

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
    public List<PrefClientSystemCommitInServiceBean> getCommitList() {
        return commitList;
    }

    /**
     * Insert用リストを設定します。
     * @param commitList Insert用リスト
     */
    public void setCommitList(List<PrefClientSystemCommitInServiceBean> commitList) {
        this.commitList = commitList;
    }


}
