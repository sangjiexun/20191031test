/*
 * $Id: EkiClientSettingInfoService.java 4800 2014-01-10 05:02:50Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/12/18     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service;

import java.util.List;

import net.chintai.backend.sysadmin.dataoutput.service.bean.EkiClientSettingInfoInServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.EkiClientSettingInfoOutServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.MstEkiOutBean;


/**
 * 他社データ連携駅除外設定取得用Service
 * @author KAMEDA Takuma
 * @version $Revision: 4800 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface EkiClientSettingInfoService {

    /**
     * 他社データ連携駅除外設定を取得する
     * @param inServiceBean 入力情報
     */
    public List<EkiClientSettingInfoOutServiceBean> getEkiClienSettingInfoList(EkiClientSettingInfoInServiceBean inServiceBean);

    /**
     * MST_EKIを取得する
     * @param inServiceBean 入力情報
     * @return 検索結果リスト
     */
    public List<MstEkiOutBean> getMstEkiList(EkiClientSettingInfoInServiceBean inServiceBean);

    /**
     * 親データ削除用沿線別データ元出力設定を取得する
     * @param inServiceBean 入力情報
     * @return 検索結果リスト
     */
    public List<String> getEnsenClientTypeList(EkiClientSettingInfoInServiceBean inServiceBean);
}
