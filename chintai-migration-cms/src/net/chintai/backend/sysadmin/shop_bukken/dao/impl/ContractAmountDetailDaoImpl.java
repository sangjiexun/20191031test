package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountDetailDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountDetailParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.ContractAmountDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ContractAmountDetailDaoの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountDetailDaoImpl extends SqlMapClientDaoSupport implements
        ContractAmountDetailDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountDetailDao#getContractAmountDetail(net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountDetailParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<ContractAmountDomain> getContractAmountDetail(
            ContractAmountDetailParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList(
                "shopBukken.selectContractAmountDetail", paramBean);
    }

}
