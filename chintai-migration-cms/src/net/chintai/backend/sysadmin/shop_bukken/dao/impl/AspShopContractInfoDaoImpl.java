package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import net.chintai.backend.sysadmin.shop_bukken.dao.AspShopContractInfoDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.AspShopContractInfoParameterBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * AspShopInfoDaoの実装クラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AspShopContractInfoDaoImpl extends SqlMapClientDaoSupport implements AspShopContractInfoDao {
    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.AspShopInfoDao#selectAspShopContractInfo(net.chintai.backend.sysadmin.shop_bukken.dao.AspShopInfoParamBean)
     */
    @Override
    public Object selectAspShopContractInfo(AspShopContractInfoParameterBean paramBean) {
        return getSqlMapClientTemplate().queryForObject("shopBukken.selectAspShopContractInfo",
                paramBean);
    }
}
