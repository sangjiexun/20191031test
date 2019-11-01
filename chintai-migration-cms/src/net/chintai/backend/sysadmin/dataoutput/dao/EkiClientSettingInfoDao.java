/*
 * $Id: EkiClientSettingInfoDao.java 4792 2014-01-10 02:47:00Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/12/18     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.dao;

import java.util.List;

import net.chintai.backend.sysadmin.dataoutput.domain.EkiClientSettingDomain;
import net.chintai.backend.sysadmin.dataoutput.domain.MstEkiDomain;


/**
 * 他社データ連携駅除外設定取得用Dao
 * @author KAMEDA Takuma
 * @version $Revision: 4792 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface EkiClientSettingInfoDao {

    /**
     * 駅別データ元出力設定を取得
     * @param paramBean 検索条件
     * @return 検索結果リスト
     */
    public List<EkiClientSettingDomain> getEkiOutSettingList(EkiClientSettingParamBean paramBean);

    /**
     * MST_EKI情報を取得
     * @param paramBean 検索条件
     * @return 検索結果リスト
     */
    public List<MstEkiDomain> getMstEkiList(EkiClientSettingParamBean paramBean);

    /**
     * 親データ削除用沿線別データ元出力設定を取得
     * @param paramBean 検索条件
     * @return 検索結果リスト
     */
    public List<String> getEnsenClientList(EkiClientSettingParamBean paramBean);

}
