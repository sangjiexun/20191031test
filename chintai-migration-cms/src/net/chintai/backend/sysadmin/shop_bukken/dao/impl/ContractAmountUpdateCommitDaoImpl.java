package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountUpdateCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountUpdateCommitParamBean;

/**
 * ContractAmountUpdateCommitDaoの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountUpdateCommitDaoImpl extends SqlMapClientDaoSupport implements
        ContractAmountUpdateCommitDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountUpdateCommitDao#updateContractAmount(net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountUpdateCommitParamBean)
     */
    public int updateContractAmount(ContractAmountUpdateCommitParamBean paramBean) {
        return getSqlMapClientTemplate().update("shopBukken.updateContractAmount", paramBean);
    }
}
