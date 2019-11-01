package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import net.chintai.backend.sysadmin.shop_bukken.dao.ContractNormalUpdatePageDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractNormalUpdatePageParamBean;
import net.chintai.backend.sysadmin.shop_bukken.domain.ContractNormal;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ContractNormalUpdatePageDaoインターフェースの実装クラス
 *
 * @author m-kashiyama
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractNormalUpdatePageDaoImpl extends SqlMapClientDaoSupport
    implements ContractNormalUpdatePageDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ContractNormalUpdatePageDao#contractNormalkUpdatePage(net.chintai.backend.sysadmin.shop_bukken.dao.ContractNormalUpdatePageParamBean)
     */
    public ContractNormal contractNormalkUpdatePage(ContractNormalUpdatePageParamBean paramBean) {

        return (ContractNormal) getSqlMapClientTemplate().queryForObject("shopBukken.contractNormalUpdatePage",
                paramBean);
    }
}