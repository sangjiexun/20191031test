package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import net.chintai.backend.sysadmin.shop_bukken.dao.ContractInfoDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractInfoParameterBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.ContractInfo;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * AspShopInfoDaoの実装クラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractInfoDaoImpl extends SqlMapClientDaoSupport implements ContractInfoDao {

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.AspShopInfoDao#selectAspShopContractInfo(net.chintai.backend.sysadmin.shop_bukken.dao.AspShopInfoParamBean)
     */
    public ContractInfo selectShopContractInfo(ContractInfoParameterBean paramBean) {
        return (ContractInfo)getSqlMapClientTemplate().queryForObject("shopBukken.selectShopContractInfo",
                paramBean);
    }

}
