/*
 * $Id: TorihikisakiSearchForBindDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/20  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiSearchForBindDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiSearchForBindParamBean;
import net.chintai.backend.sysadmin.demand.domain.TorihikisakiSearchForBindDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * TorihikisakiSearchForBindDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiSearchForBindDaoImpl extends SqlMapClientDaoSupport implements
        TorihikisakiSearchForBindDao {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiSearchForBindDao#getTorihikisaki(net.chintai.backend.sysadmin.demand.dao.TorihikisakiSearchForBindParamBean, net.chintai.backend.sysadmin.common.pager.BasePagerCondition)
     */
    @SuppressWarnings("unchecked")
    public List<TorihikisakiSearchForBindDomain> getTorihikisaki(
            TorihikisakiSearchForBindParamBean paramBean, BasePagerCondition condition) {
        return getSqlMapClientTemplate().queryForList("demand.selectTorihikisakiSearchForBind",
                paramBean, condition.getOffset(), condition.getLimit());
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiSearchForBindDao#selectTotalCount(net.chintai.backend.sysadmin.demand.dao.TorihikisakiSearchParamBean)
     */
    public int selectTotalCount(TorihikisakiSearchForBindParamBean paramBean) {
        return (Integer) getSqlMapClientTemplate().queryForObject(
                "demand.selectTorihikisakiSearchForBindTotalCnt", paramBean);
    }

}
