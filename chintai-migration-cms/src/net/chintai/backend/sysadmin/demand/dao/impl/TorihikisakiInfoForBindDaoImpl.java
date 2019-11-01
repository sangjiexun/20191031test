/*
 * $Id: TorihikisakiInfoForBindDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/27  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import net.chintai.backend.sysadmin.demand.dao.TorihikisakiInfoForBindDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiInfoForBindParamBean;
import net.chintai.backend.sysadmin.demand.domain.TorihikisakiInfoForBindDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * TorihikisakiInfoForBindDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiInfoForBindDaoImpl extends SqlMapClientDaoSupport implements
        TorihikisakiInfoForBindDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiInfoForBindDao#getTorihikisakiDetailInfo(net.chintai.backend.sysadmin.demand.dao.TorihikisakiInfoForBindParamBean)
     */
    public TorihikisakiInfoForBindDomain getTorihikisakiDetailInfo(
            TorihikisakiInfoForBindParamBean paramBean) {
        return (TorihikisakiInfoForBindDomain) getSqlMapClientTemplate().queryForObject(
                "demand.selectTorihikisakiInfoForBind", paramBean);
    }
}
