package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountAddCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountAddCommitParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


/**
 * ContractAmountAddCommitDaoの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountAddCommitDaoImpl extends SqlMapClientDaoSupport implements
        ContractAmountAddCommitDao {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountAddCommitDao#insertContractAmount(net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountAddCommitParamBean)
     */
    public String insertContractAmount(ContractAmountAddCommitParamBean paramBean) {
        return (String)getSqlMapClientTemplate().insert("shopBukken.insertContractAmount",paramBean);
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountAddCommitDao#insertContractAmountDetail(net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountAddCommitParamBean)
     */
    public void insertContractAmountDetail(ContractAmountAddCommitParamBean paramBean) {
        getSqlMapClientTemplate().insert("shopBukken.insertContractAmountDetail",paramBean);
    }

}
