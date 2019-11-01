package net.chintai.backend.sysadmin.shop_bukken.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountAddConfirmDao;
import net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountAddConfirmParamBean;

/**
 * ContractAmountAddConfirmDaoの実装クラス。
 *
 * @author
 * @version $Revision:  $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ContractAmountAddConfirmDaoImpl extends SqlMapClientDaoSupport implements
        ContractAmountAddConfirmDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountAddConfirmDao#checkAppliyYm(net.chintai.backend.sysadmin.shop_bukken.dao.ContractAmountAddConfirmParamBean)
     */
    public int checkAppliyYmdh(ContractAmountAddConfirmParamBean paramBean) {
        return (Integer) getSqlMapClientTemplate().queryForObject("shopBukken.countApplyYmdh", paramBean);
    }

}
