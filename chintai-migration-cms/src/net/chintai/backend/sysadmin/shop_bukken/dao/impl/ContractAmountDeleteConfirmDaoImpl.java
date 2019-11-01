package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountDeleteConfirmDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountDeleteConfirmParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.ContractAmountDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * TorihikisakiBukkenWakuInfoDeleteConfirmDaoの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountDeleteConfirmDaoImpl extends SqlMapClientDaoSupport implements
        ContractAmountDeleteConfirmDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.TorihikisakiBukkenWakuInfoDeleteConfirmDao#getContractAmountForDelete(net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountDeleteConfirmParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<ContractAmountDomain> getContractAmountForDelete(
            ContractAmountDeleteConfirmParamBean paramBean) {
        return (List<ContractAmountDomain>) getSqlMapClientTemplate().queryForList(
                "shopBukken.selectContractAmountForDelete", paramBean);
    }

}
