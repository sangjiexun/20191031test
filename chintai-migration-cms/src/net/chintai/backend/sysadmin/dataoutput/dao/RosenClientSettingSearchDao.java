/*
 * $Id: RosenClientSettingSearchDao.java 4793 2014-01-10 02:52:44Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/31     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.dao;

import java.util.List;

import net.chintai.backend.sysadmin.dataoutput.domain.MstEnsenDomain;
import net.chintai.backend.sysadmin.dataoutput.domain.RosenClientSettingDomain;


/**
 * 沿線別データ元除外設定検索用Dao
 * @author KAMEDA Takuma
 * @version $Revision: 4793 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface RosenClientSettingSearchDao {

    /**
     * 沿線別データ元出力設定を取得
     * @param paramBean 検索条件
     * @return 検索結果リスト
     */
    public List<RosenClientSettingDomain> getRosenOutSettingList(RosenClientSettingParamBean paramBean);

    /**
     * MST_ENSEN情報を取得
     * @param paramBean 検索条件
     * @return 検索結果リスト
     */
    public List<MstEnsenDomain> getMstEnsenList(RosenClientSettingParamBean paramBean);

}
