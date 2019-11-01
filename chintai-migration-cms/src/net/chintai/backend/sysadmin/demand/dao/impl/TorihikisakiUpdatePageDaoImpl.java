/*
 * $Id: TorihikisakiUpdatePageDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/05  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import net.chintai.backend.sysadmin.demand.dao.TorihikisakiUpdatePageDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiUpdatePageParamBean;
import net.chintai.backend.sysadmin.demand.domain.TorihikisakiUpdatePageDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * TorihikisakiUpdatePageDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiUpdatePageDaoImpl extends SqlMapClientDaoSupport implements
        TorihikisakiUpdatePageDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiUpdatePageDao#getTorihikisakiInfo(net.chintai.backend.sysadmin.demand.dao.TorihikisakiUpdatePageParamBean)
     */
    public TorihikisakiUpdatePageDomain getTorihikisakiInfo(
            TorihikisakiUpdatePageParamBean paramBean) {
        return (TorihikisakiUpdatePageDomain) getSqlMapClientTemplate().queryForObject(
                "demand.selectTorihikisakiInfoForUpdate", paramBean);
    }

}
