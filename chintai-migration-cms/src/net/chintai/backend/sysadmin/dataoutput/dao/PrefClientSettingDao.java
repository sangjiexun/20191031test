/*
 * $Id: PrefClientSettingDao.java 4791 2014-01-10 02:38:58Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/23     BGT)亀田       E-0070 建物名表示に関する改修
 * 2014/01/07     BGT)亀田       E-0053_スマイティ用データ抽出　市区・駅対応
 */
package net.chintai.backend.sysadmin.dataoutput.dao;

import java.util.List;

import net.chintai.backend.sysadmin.dataoutput.domain.MstPrefDomain;
import net.chintai.backend.sysadmin.dataoutput.domain.PrefClientDataDomain;

/**
 * 都道府県別データ元出力設定情報取得Dao
 * @author e-ishii
 * @version $Revision: 4791 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface PrefClientSettingDao {


	/**
	 * 都道府県別データ元出力設定を取得
	 * 他社データ連携種類を検索条件に追加したため、引数を追加 2013/10/24
	 * @param 検索条件
	 * @return 都道府県別データ元出力設定
	 */
	public List<PrefClientDataDomain> getPrefClientDataList(PrefClientSettingParamBean paramBean);


	/**
	 * MstPref情報を取得
	 * @return  MstPref情報
	 */
	public List<MstPrefDomain> getMstPref(PrefClientSettingParamBean paramBean);



}
