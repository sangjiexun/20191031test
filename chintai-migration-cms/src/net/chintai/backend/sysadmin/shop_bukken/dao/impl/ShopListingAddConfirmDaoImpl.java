package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingAddConfirmDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingAddConfirmParamBean;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingKikanChkBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.ShopListingDetailDomain;

/**
 * ShopListingAddConfirmDaoの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingAddConfirmDaoImpl extends SqlMapClientDaoSupport implements
        ShopListingAddConfirmDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingAddConfirmDao#checkAppliyYm(net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingAddConfirmParamBean)
     */
    public int checkAppliyYmdh(ShopListingKikanChkBean paramBean) {
        return (Integer) getSqlMapClientTemplate().queryForObject("shopBukken.shopListingCountApplyYmdh", paramBean);
    }

	public List<ShopListingKikanChkBean> checkKeiyakuEndDt(
			ShopListingAddConfirmParamBean paramBean) {
		return (List<ShopListingKikanChkBean>) getSqlMapClientTemplate().queryForList(
                "shopBukken.shopListingChkKeiyakuEndDt", paramBean);
	}

	public ShopListingKikanChkBean viewCheck(
			ShopListingAddConfirmParamBean paramBean) {
		return (ShopListingKikanChkBean) getSqlMapClientTemplate().queryForObject(
                "shopBukken.viewCheck", paramBean);
	}

}
