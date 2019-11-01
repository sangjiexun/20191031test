/*
 * $Id: RosenClientSettingSearchService.java 4803 2014-01-10 05:38:20Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/31     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.service;

import java.util.List;

import net.chintai.backend.sysadmin.dataoutput.service.bean.MstEnsenOutBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.RosenClientSettingSearchInServiceBean;
import net.chintai.backend.sysadmin.dataoutput.service.bean.RosenClientSettingSearchOutServiceBean;


/**
 * 沿線別データ元除外設定取得用サービスクラス
 * @author KAMEDA Takuma
 * @version $Revision: 4803 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface RosenClientSettingSearchService {

    /**
     * 沿線別データ元除外設定リストを取得します
     * @param inServiceBean 入力情報
     * @return 沿線別データ元除外設定検索取得結果リスト
     */
    public List<RosenClientSettingSearchOutServiceBean> getRosenOutSetingList(RosenClientSettingSearchInServiceBean inServiceBean);

    /**
     * 沿線マスタ情報を取得します
     * @param inServiceBean 入力情報
     * @return 沿線マスタ検索取得結果リスト
     */
    public List<MstEnsenOutBean> getMstEnsen(RosenClientSettingSearchInServiceBean inServiceBean);
}
