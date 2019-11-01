package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountUpdatePageDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountUpdatePageParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.ContractAmountDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ContractAmountUpdatePageDaoの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountUpdatePageDaoImpl extends SqlMapClientDaoSupport implements
        ContractAmountUpdatePageDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountUpdatePageDao#getContractAmount(net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountUpdatePageParamBean)
     */
    public ContractAmountDomain getContractAmount(
            ContractAmountUpdatePageParamBean paramBean) {
        return (ContractAmountDomain) getSqlMapClientTemplate().queryForObject(
                "shopBukken.selectContractAmountForUpdate", paramBean);
    }

}
