/*
 * $Id: EkiClientSettingCommitDao.java 4792 2014-01-10 02:47:00Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/11/07     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.dao;

import java.util.List;


/**
 * 他社データ連携駅除外設定更新用Dao
 * @author KAMEDA Takuma
 * @version $Revision: 4792 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface EkiClientSettingCommitDao {

    /**
     * 他社データ連携駅除外設定Delete処理
     * @param paramBean 削除用Bean
     */
    public void deleteEkiSkipConfig(EkiClientSettingCommitParamBean paramBean);

    /**
     * 他社データ連携駅除外設定Insert処理
     * @param commitList 登録用Beanリスト
     */
    public void insertEkiSkipConfig(List<EkiClientSettingCommitParamBean> commitList);

    /**
     * 他社データ連携駅除外設定、他社データ連携沿線除外設定Delete処理
     * @param paramBean 削除用Bean
     */
    public void deleteEnsenSkipConfig(EkiClientSettingCommitParamBean paramBean);

}
