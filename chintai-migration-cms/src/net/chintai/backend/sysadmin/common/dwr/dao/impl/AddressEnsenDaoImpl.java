/*
 * $Id: AddressEnsenDaoImpl.java 4123 2009-02-27 11:22:16Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/10/16   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.common.dwr.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.common.dwr.dao.AddressEnsenDao;
import net.chintai.backend.sysadmin.common.dwr.dao.EnsenListParamBean;
import net.chintai.backend.sysadmin.common.dwr.domain.Address;
import net.chintai.backend.sysadmin.common.dwr.domain.Area;
import net.chintai.backend.sysadmin.common.dwr.domain.City;
import net.chintai.backend.sysadmin.common.dwr.domain.Eki;
import net.chintai.backend.sysadmin.common.dwr.domain.Ensen;
import net.chintai.backend.sysadmin.common.dwr.domain.Pref;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * AddressEnsenDao の実装クラス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 4123 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AddressEnsenDaoImpl extends SqlMapClientDaoSupport implements AddressEnsenDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.dwr.dao.AddressEnsenDao#selectAreaList()
     */
    @SuppressWarnings("unchecked")
    public List<Area> selectAreaList() {
        return getSqlMapClientTemplate().queryForList("addressEnsen.selectAreaList");
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.dwr.dao.AddressEnsenDao#selectCityList(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    public List<City> selectCityList(String prefCode) {
        return getSqlMapClientTemplate().queryForList("addressEnsen.selectCityList", prefCode);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.dwr.dao.AddressEnsenDao#selectEkiList(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    public List<Eki> selectEkiList(String ensenCode) {
        return getSqlMapClientTemplate().queryForList("addressEnsen.selectEkiList", ensenCode);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.dwr.dao.AddressEnsenDao#selectEnsenList(net.chintai.backend.sysadmin.common.dwr.dao.EnsenListParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<Ensen> selectEnsenList(EnsenListParamBean param) {
        return getSqlMapClientTemplate().queryForList("addressEnsen.selectEnsenList", param);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.dwr.dao.AddressEnsenDao#selectPrefList(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    public List<Pref> selectPrefList(String areaCode) {
        return getSqlMapClientTemplate().queryForList("addressEnsen.selectPrefList", areaCode);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.dwr.dao.AddressEnsenDao#selectAddressList(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    public List<Address> selectAddressList(String cityCode) {
        return getSqlMapClientTemplate().queryForList("addressEnsen.selectAddressList", cityCode);
    }
}