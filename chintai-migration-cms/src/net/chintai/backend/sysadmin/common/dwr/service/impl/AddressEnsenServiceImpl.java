/*
 * $Id: AddressEnsenServiceImpl.java 4123 2009-02-27 11:22:16Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/03  BGT)沈鍾沿     新規作成
 * 2007/10/18  BGT)児島       Spring を使うように修正
 */
package net.chintai.backend.sysadmin.common.dwr.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.chintai.backend.sysadmin.common.dwr.dao.AddressEnsenDao;
import net.chintai.backend.sysadmin.common.dwr.dao.EnsenListParamBean;
import net.chintai.backend.sysadmin.common.dwr.domain.Address;
import net.chintai.backend.sysadmin.common.dwr.domain.Area;
import net.chintai.backend.sysadmin.common.dwr.domain.City;
import net.chintai.backend.sysadmin.common.dwr.domain.Eki;
import net.chintai.backend.sysadmin.common.dwr.domain.Ensen;
import net.chintai.backend.sysadmin.common.dwr.domain.Pref;
import net.chintai.backend.sysadmin.common.dwr.service.AddressEnsenService;
import net.chintai.backend.sysadmin.common.dwr.service.bean.AddressBean;
import net.chintai.backend.sysadmin.common.dwr.service.bean.AreaBean;
import net.chintai.backend.sysadmin.common.dwr.service.bean.CityBean;
import net.chintai.backend.sysadmin.common.dwr.service.bean.EkiBean;
import net.chintai.backend.sysadmin.common.dwr.service.bean.EnsenBean;
import net.chintai.backend.sysadmin.common.dwr.service.bean.PrefBean;
import net.chintai.backend.sysadmin.crnwl.service.MasterService;
import net.chintai.batch.common.domain.MstCity;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * AddressEnsenService の実装クラス。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 4123 $ Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AddressEnsenServiceImpl implements AddressEnsenService {

	/** 住所・沿線リスト取得DAO */
	AddressEnsenDao addressEnsenDao;

	@Autowired
	private MasterService masterService;

	/**
	 * DAOを設定します。
	 * @param dao
	 */
	public void setAddressEnsenDao(final AddressEnsenDao dao) {
		this.addressEnsenDao = dao;
	}

	/**
	 * @param word
	 * @return
	 * @see net.chintai.backend.sysadmin.crnwl.service.MasterService#getPrefCity(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> getPrefCity(final String word) {
		return this.masterService.getPrefCity(word);
	}

	/**
	 * @param zipcd
	 * @return
	 * @see net.chintai.backend.sysadmin.crnwl.service.MasterService#getAddress(java.lang.String)
	 */
	@Override
	public Map<String, String> getAddress(final String zipcd) {
		return this.masterService.getAddress(zipcd);
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see net.chintai.backend.sysadmin.common.dwr.service.AddressEnsenService#getEnsenEki(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> getEnsenEki(final String word) {
		return this.masterService.getEnsenEki(word);
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see net.chintai.backend.sysadmin.common.dwr.service.AddressEnsenService#getAreaList()
	 */
	@Override
	public List<AreaBean> getAreaList() {
		final List<Area> rsList = this.addressEnsenDao.selectAreaList();
		final List<AreaBean> beanList = new ArrayList<AreaBean>();

		if (rsList != null) {
			for (int i = 0; i < rsList.size(); i++) {
				final AreaBean areaBean = new AreaBean(rsList.get(i).getAreaCode(), rsList.get(i).getAreaName());
				beanList.add(areaBean);
			}
		}
		return beanList;
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see net.chintai.backend.sysadmin.common.dwr.service.AddressEnsenService#getCityList(java.lang.String)
	 */
	@Override
	public List<CityBean> getCityList(final String prefCode) {
		final List<City> rsList = this.addressEnsenDao.selectCityList(prefCode);
		final List<CityBean> beanList = new ArrayList<CityBean>();

		if (rsList != null) {
			for (int i = 0; i < rsList.size(); i++) {
				final CityBean cityBean = new CityBean(rsList.get(i).getCityCode(), rsList.get(i).getCityName());
				beanList.add(cityBean);
			}
		}
		return beanList;
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see net.chintai.backend.sysadmin.common.dwr.service.AddressEnsenService#getValidCityList(java.lang.String)
	 */
	@Override
	public List<CityBean> getValidCityList(final String prefCode) {
		final List<MstCity> rsList = this.masterService.getValidMstCityByPrefcd(prefCode);
		final List<CityBean> beanList = new ArrayList<CityBean>();

		if (rsList != null) {
			for (int i = 0; i < rsList.size(); i++) {
				final CityBean cityBean = new CityBean(rsList.get(i).getCitycd(), rsList.get(i).getCityname());
				beanList.add(cityBean);
			}
		}
		return beanList;
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see net.chintai.backend.sysadmin.common.dwr.service.AddressEnsenService#getEkiList(java.lang.String)
	 */
	@Override
	public List<EkiBean> getEkiList(final String ensenCode) {
		final List<Eki> rsList = this.addressEnsenDao.selectEkiList(ensenCode);
		final List<EkiBean> beanList = new ArrayList<EkiBean>();

		if (rsList != null) {
			for (int i = 0; i < rsList.size(); i++) {
				final EkiBean ekiBean = new EkiBean(rsList.get(i).getEkiCode(), rsList.get(i).getEkiName());
				beanList.add(ekiBean);
			}
		}
		return beanList;
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see net.chintai.backend.sysadmin.common.dwr.service.AddressEnsenService#getEnsenList(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<EnsenBean> getEnsenList(final String areaCode, final String ensenType) {
		final EnsenListParamBean param = new EnsenListParamBean();
		param.setAreaCode(areaCode);
		param.setEnsenType(ensenType);

		final List<Ensen> rsList = this.addressEnsenDao.selectEnsenList(param);
		final List<EnsenBean> beanList = new ArrayList<EnsenBean>();

		if (rsList != null) {
			for (int i = 0; i < rsList.size(); i++) {
				final EnsenBean ensenBean = new EnsenBean(rsList.get(i).getEnsenCode(), rsList.get(i).getEnsenName());
				beanList.add(ensenBean);
			}
		}
		return beanList;
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see net.chintai.backend.sysadmin.common.dwr.service.AddressEnsenService#getPrefList(java.lang.String)
	 */
	@Override
	public List<PrefBean> getPrefList(final String areaCode) {
		final List<Pref> rsList = this.addressEnsenDao.selectPrefList(areaCode);
		final List<PrefBean> beanList = new ArrayList<PrefBean>();

		if (rsList != null) {
			for (int i = 0; i < rsList.size(); i++) {
				final PrefBean prefBean = new PrefBean(rsList.get(i).getPrefCode(), rsList.get(i).getPrefName());
				beanList.add(prefBean);
			}
		}
		return beanList;
	}

	/*
	 * (非 Javadoc)
	 *
	 * @see net.chintai.backend.sysadmin.common.dwr.service.AddressEnsenService#getAddressList(java.lang.String)
	 */
	@Override
	public List<AddressBean> getAddressList(final String cityCode) {
		final List<Address> rsList = this.addressEnsenDao.selectAddressList(cityCode);
		final List<AddressBean> beanList = new ArrayList<AddressBean>();

		if (rsList != null) {
			for (int i = 0; i < rsList.size(); i++) {
				final AddressBean addressBean = new AddressBean(rsList.get(i).getZipCode(), rsList.get(i).getAddress());
				beanList.add(addressBean);
			}
		}
		return beanList;
	}
}