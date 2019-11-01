/*
 * $Id: ShikutyosonClientSettingDao.java 4796 2014-01-10 04:15:22Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/12/27     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.dao;

import java.util.List;

import net.chintai.backend.sysadmin.dataoutput.domain.MstCityDomain;
import net.chintai.backend.sysadmin.dataoutput.domain.ShikutyosonClientSettingDomain;


/**
 * 市区町村別データ元出力設定検索用Dao
 * @author KAMEDA Takuma
 * @version $Revision: 4796 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShikutyosonClientSettingDao {

    /**
     * 市区町村別データ元出力設定を取得
     * @param paramBean 検索条件
     * @return 検索結果リスト
     */
    public List<ShikutyosonClientSettingDomain> getShikutyosonClientSettingList(ShikutyosonClientSettingParamBean paramBean);

    /**
     * MST_CITY情報を取得
     * @param paramBean 検索条件
     * @return 検索結果リスト
     */
    public List<MstCityDomain> getMstCityList(ShikutyosonClientSettingParamBean paramBean);

    /**
     * 親データ削除用都道府県別データ元出力設定を取得
     * @param paramBean 検索条件
     * @return 検索結果リスト
     */
    public List<String> getPrefClinetList(ShikutyosonClientSettingParamBean paramBean);
}
