/*
 * $Id: ShikutyosonClientSettingInfoService.java 4803 2014-01-10 05:38:20Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/12/27     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service;

import java.util.List;

import net.chintai.backend.sysadmin.dataoutput.service.bean.MstCityOutBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.ShikutyosonClientSettingInfoInServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.ShikutyosonClientSettingInfoOutServiceBean;


/**
 * 市区町村別データ元出力設定取得用サービスクラス
 * @author KAMEDA Takuma
 * @version $Revision: 4803 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface ShikutyosonClientSettingInfoService {

    /**
     * 市区町村別データ元出力設定を取得する
     * @param inServiceBean 入力情報
     * @return 検索結果リスト
     */
    public List<ShikutyosonClientSettingInfoOutServiceBean> getShikutyosonClienSettingInfoList(ShikutyosonClientSettingInfoInServiceBean inServiceBean);

    /**
     * MST_CITYを取得する
     * @param inServiceBean 入力情報
     * @return 検索結果リスト
     */
    public List<MstCityOutBean> getMstCityList(ShikutyosonClientSettingInfoInServiceBean inServiceBean);

    /**
     * 親データ削除用都道府県別データ元出力設定を取得する
     * @param inServiceBean 入力情報
     * @return 検索結果リスト
     */
    public List<String> getPrefClientTypeList(ShikutyosonClientSettingInfoInServiceBean inServiceBean);
}
