package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountInfoDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountInfoParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.ContractAmountInfoDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ContractAmountInfoDaoの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountInfoDaoImpl extends SqlMapClientDaoSupport implements ContractAmountInfoDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountInfoDao#getContractInfo(net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountInfoParamBean)
     */
    public ContractAmountInfoDomain getContractInfo(ContractAmountInfoParamBean paramBean) {
        return (ContractAmountInfoDomain) getSqlMapClientTemplate().queryForObject(
                "shopBukken.selectContractAmountInfo", paramBean);
    }
}
