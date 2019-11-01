package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.shop_bukken.dao.ContractNormalUpdateCommitDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractNormalUpdateCommitParamBean;

/**
 * ContractNormalUpdateCommitDaoインターフェースの実装クラス
 *
 * @author m-kashiyama
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractNormalUpdateCommitDaoImpl extends SqlMapClientDaoSupport
    implements ContractNormalUpdateCommitDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ContractNormalUpdateCommitDao#adparkUpdateCommit(net.chintai.backend.sysadmin.shop_bukken.dao.ContractNormalUpdateCommitParamBean)
     */
    public int contractNormalUpdateCommit(ContractNormalUpdateCommitParamBean paramBean) {

        return getSqlMapClientTemplate().update
            ("shopBukken.contractNormalUpdateCommit", paramBean);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ContractNormalUpdateCommitDao#adparkUpdateCommit(net.chintai.backend.sysadmin.shop_bukken.dao.ContractNormalUpdateCommitParamBean)
     */
    public Long contractNormalAddCommit(ContractNormalUpdateCommitParamBean paramBean) {
        return (Long)getSqlMapClientTemplate().insert
                ("shopBukken.contractNormalAddCommit", paramBean);
    }

}