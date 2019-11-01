/*
 * $Id: ShikutyosonClientSettingCommitDao.java 4794 2014-01-10 03:05:24Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2014/01/06     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.dao;

import java.util.List;


/**
 * 市区町村別データ元出力設定登録用Dao
 * @author KAMEDA Takuma
 * @version $Revision: 4794 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShikutyosonClientSettingCommitDao {

    /**
     * 他社データ連携駅除外設定Delete処理
     * @param paramBean 削除用Bean
     */
    public void deleteShikutyosonSkipConfig(ShikutyosonClientSettingCommitParamBean paramBean);

    /**
     * 他社データ連携駅除外設定Insert処理
     * @param commitList 削除用Beanリスト
     */
    public void insertShikutyosonSkipConfig(List<ShikutyosonClientSettingCommitParamBean> commitList);

    /**
     * 他社データ連携駅除外設定、他社データ連携沿線除外設定Delete処理
     * @param paramBean 削除用Bean
     */
    public void deletePrefSkipConfig(ShikutyosonClientSettingCommitParamBean paramBean);

}
