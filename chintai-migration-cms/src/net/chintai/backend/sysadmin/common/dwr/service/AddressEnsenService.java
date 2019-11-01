/*
 * $Id: AddressEnsenService.java 4123 2009-02-27 11:22:16Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/10/16   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.common.dwr.service;

import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.common.dwr.service.bean.AddressBean;
import net.chintai.backend.sysadmin.common.dwr.service.bean.AreaBean;
import net.chintai.backend.sysadmin.common.dwr.service.bean.CityBean;
import net.chintai.backend.sysadmin.common.dwr.service.bean.EkiBean;
import net.chintai.backend.sysadmin.common.dwr.service.bean.EnsenBean;
import net.chintai.backend.sysadmin.common.dwr.service.bean.PrefBean;

/**
 * 「地域から検索」プルダウンリストを取得するサービスクラス。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 4123 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AddressEnsenService {

	public Map<String, String> getAddress(String zipcd);

	public List<Map<String, Object>> getPrefCity(String word);

	public List<Map<String, Object>> getEnsenEki(String word);

    /**
     * エリアリストを取得します。
     * @return エリアリスト
     */
    public List<AreaBean> getAreaList();

    /**
     * 都道府県リストを取得します。
     * @param areaCode エリアコード
     * @return 都道府県リスト
     */
    public List<PrefBean> getPrefList(String areaCode);

    /**
     * 市区町村リストを取得します。
     * @param prefCode 都道府県コード
     * @return 市区町村リスト
     */
    public List<CityBean> getCityList(String prefCode);

    public List<CityBean> getValidCityList(String prefCode);

    /**
     * 沿線リストを取得します。
     * @param areaCode エリアコード
     * @param ensenType 沿線タイプ
     * @return 沿線リスト
     */
    public List<EnsenBean> getEnsenList(String areaCode, String ensenType);

    /**
     * 駅リストを取得します。
     * @param ensenCode 沿線コード
     * @return 駅リスト
     */
    public List<EkiBean> getEkiList(String ensenCode);

    /**
     * 市区町村以下の町域名を取得します。
     * @param cityCode 全国都道府県JISコード
     * @return 市区町村以下の町域名
     */
    public List<AddressBean> getAddressList(String cityCode);
}