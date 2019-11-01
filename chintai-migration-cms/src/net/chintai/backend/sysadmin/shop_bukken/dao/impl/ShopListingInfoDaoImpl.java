package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingInfoDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingInfoParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.ShopListingInfoDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ShopListingInfoDaoの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShopListingInfoDaoImpl extends SqlMapClientDaoSupport implements ShopListingInfoDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingInfoDao#getContractInfo(net.chintai.backend.sysadmin.shop_bukken.dao.ShopListingInfoParamBean)
     */
    public ShopListingInfoDomain getContractInfo(ShopListingInfoParamBean paramBean) {
    	List<ShopListingInfoDomain> list = getSqlMapClientTemplate().queryForList(
                "shopBukken.selectContractShopListingInfo", paramBean);
    	if(list != null && list.size() > 0){
    		return list.get(0);
    	}else{
    		return new ShopListingInfoDomain();
    	}

        //return getSqlMapClientTemplate().queryForObject(
        //        "shopBukken.selectContractShopListingInfo", paramBean);
    }
}
