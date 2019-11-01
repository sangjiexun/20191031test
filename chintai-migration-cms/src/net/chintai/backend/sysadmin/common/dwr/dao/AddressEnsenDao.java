/*
 * $Id: AddressEnsenDao.java 4123 2009-02-27 11:22:16Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/10/16   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.common.dwr.dao;

import java.util.List;

import net.chintai.backend.sysadmin.common.dwr.domain.Address;
import net.chintai.backend.sysadmin.common.dwr.domain.Area;
import net.chintai.backend.sysadmin.common.dwr.domain.City;
import net.chintai.backend.sysadmin.common.dwr.domain.Eki;
import net.chintai.backend.sysadmin.common.dwr.domain.Ensen;
import net.chintai.backend.sysadmin.common.dwr.domain.Pref;

/**
 * 都道府県・沿線・駅の各種リストを取得するDAO。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 4123 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface AddressEnsenDao {

    /**
     * エリアリストを取得します。
     * @return エリアリスト
     */
    public List<Area> selectAreaList();

    /**
     * 都道府県リストを取得します。
     * @return 都道府県リスト
     */
    public List<Pref> selectPrefList(String areaCode);

    /**
     * 市区町村リストを取得します。
     * @return 市区町村リスト
     */
    public List<City> selectCityList(String prefCode);

    /**
     * 沿線リストを取得します。
     * @return 沿線リスト
     */
    public List<Ensen> selectEnsenList(EnsenListParamBean param);

    /**
     * 駅リストを取得します。
     * @return 駅リスト
     */
    public List<Eki> selectEkiList(String ensenCode);

    /**
     * 市区町村以下の町域名を取得します。
     * @return 市区町村以下の町域名リスト
     */
    public List<Address> selectAddressList(String cityCode);
}
