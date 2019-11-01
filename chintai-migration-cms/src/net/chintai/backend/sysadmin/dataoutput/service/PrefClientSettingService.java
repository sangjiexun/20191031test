/*
 * $Id: PrefClientSettingService.java 4801 2014-01-10 05:09:26Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/23     BGT)亀田       E-0070 建物名表示に関する改修
 * 2014/01/07     BGT)亀田       E-0053_スマイティ用データ抽出　市区・駅対応
 */
package net.chintai.backend.sysadmin.dataoutput.service;

import java.util.List;

import net.chintai.backend.sysadmin.dataoutput.service.bean.MstPrefOutBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.PrefClientDataOutServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.PrefClientSettingInServiceBean;


/**
 * 都道府県別データ元出力設定の表示サービス
 *
 * @author e-ishii
 * @version $Revision: 4801 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface PrefClientSettingService {

	/**
	 * 都道府県別データ元情報を返す
	 * @param 入力されたフォーム情報用formBean 2013/10/24 追加
	 * @return 都道府県別データ元情報リスト
	 */
	public List<PrefClientDataOutServiceBean> getPrefClientDataList(PrefClientSettingInServiceBean inServiceBean);

	/**
	 * MstPref全件情報を返す
	 * @return MstPref全件
	 */
	public List<MstPrefOutBean> getMstPref(PrefClientSettingInServiceBean inServiceBean);



}
