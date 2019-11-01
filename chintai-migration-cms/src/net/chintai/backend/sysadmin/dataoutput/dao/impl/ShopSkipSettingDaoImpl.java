package net.chintai.backend.sysadmin.dataoutput.dao.impl;

import java.util.Date;
import java.util.List;

import net.chintai.backend.sysadmin.dataoutput.dao.ShopSkipSettingDao;
import net.chintai.backend.sysadmin.dataoutput.dao.ShopSkipSettingParamBean;
import net.chintai.backend.sysadmin.dataoutput.domain.ShopSkipSettingDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * 店舗別除外設定Dao実装クラス
 * @author watanabe
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */

public class ShopSkipSettingDaoImpl extends SqlMapClientDaoSupport implements ShopSkipSettingDao  {

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.dataoutput.dao.ShopSkipSettingDao#getShopSkipSetting(net.chintai.backend.sysadmin.dataoutput.dao.ShopSkipSettingParamBean)
	 */
	@Override
	public List<ShopSkipSettingDomain> getShopSkipSetting(ShopSkipSettingParamBean paramBean) {
		return getSqlMapClientTemplate().queryForList("dataoutput.getShopSkipConfig", paramBean);
	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.dataoutput.dao.ShopSkipSettingDao#deleteShopSkipConfig(net.chintai.backend.sysadmin.dataoutput.dao.ShopSkipSettingParamBean)
	 */
	@Override
	public void deleteShopSkipConfig(ShopSkipSettingParamBean paramBean) {
		getSqlMapClientTemplate().delete("dataoutput.deleteShopSkipConfig", paramBean);
	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.dataoutput.dao.ShopSkipSettingDao#insertShopSkipConfig(net.chintai.backend.sysadmin.dataoutput.dao.ShopSkipSettingParamBean)
	 */
	@Override
	public void insertShopSkipConfig(ShopSkipSettingParamBean paramBean) {
		getSqlMapClientTemplate().insert("dataoutput.insertShopSkipConfig", paramBean);
	}
	
	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.dataoutput.dao.ShopSkipSettingDao#deleteBkShopSkipConfig(java.util.Date)
	 */
	@Override
	public void deleteBkShopSkipConfig(Date param) {
		getSqlMapClientTemplate().delete("dataoutput.deleteBkShopSkipConfig", param);
	}

	/* (非 Javadoc)
	 * @see net.chintai.backend.sysadmin.dataoutput.dao.ShopSkipSettingDao#insertBkShopSkipConfig(net.chintai.backend.sysadmin.dataoutput.dao.ShopSkipSettingParamBean)
	 */
	@Override
	public void insertBkShopSkipConfig(ShopSkipSettingParamBean paramBean) {
		getSqlMapClientTemplate().insert("dataoutput.insertBkShopSkipConfig", paramBean);
	}
}
