package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountDeleteCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountDeleteCommitParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ContractAmountDeleteCommitDaoの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountDeleteCommitDaoImpl extends SqlMapClientDaoSupport implements
        ContractAmountDeleteCommitDao {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountDeleteCommitDao#deleteWakuInfo(net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountDeleteCommitParamBean)
     */
    public int deleteWakuInfo(ContractAmountDeleteCommitParamBean paramBean) {
        return getSqlMapClientTemplate().update("shopBukken.deleteWakuInfo", paramBean);
    }
}
