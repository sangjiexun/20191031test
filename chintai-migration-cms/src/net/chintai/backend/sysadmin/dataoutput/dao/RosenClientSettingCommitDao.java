/*
 * $Id: RosenClientSettingCommitDao.java 4792 2014-01-10 02:47:00Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/11/07     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.dao;

import java.util.List;


/**
 * 沿線別データ元除外設定更新用Dao
 * @author KAMEDA Takuma
 * @version $Revision: 4792 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface RosenClientSettingCommitDao {

    /**
     * 他社データ連携沿線除外設定Delete処理
     * @param paramBean 削除用Bean
     */
    public void deleteEnsenSkipConfig(RosenClientSettingCommitParamBean paramBean);

    /**
     * 他社データ連携沿線除外設定Insert処理
     * @param commitList 登録用Beanリスト
     */
    public void insertEnsenSkipConfig(List<RosenClientSettingCommitParamBean> commitList);

}
