/*
 * $Id: TorihikisakiListDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/20  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiListDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiListParamBean;
import net.chintai.backend.sysadmin.demand.domain.TorihikisakiListDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * TorihikisakiListDaoの実装クラス
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiListDaoImpl extends SqlMapClientDaoSupport implements TorihikisakiListDao {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiListDao#selectTotalCount(net.chintai.backend.sysadmin.demand.dao.TorihikisakiListParamBean)
     */
    public int selectTotalCount(TorihikisakiListParamBean paramBean) {
        return (Integer) getSqlMapClientTemplate().queryForObject("demand.selectTotalCount",
                paramBean);
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiListDao#getTorihikisakiList(net.chintai.backend.sysadmin.demand.dao.TorihikisakiListParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<TorihikisakiListDomain> getTorihikisakiList(TorihikisakiListParamBean paramBean) {

        return getSqlMapClientTemplate().queryForList("demand.selectTorihikisakiListForCSV",
                paramBean);
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiListDao#getTorihikisakiList(net.chintai.backend.sysadmin.demand.dao.TorihikisakiListParamBean
     * net.chintai.backend.sysadmin.common.pager.BasePagerCondition condition)
     */
    @SuppressWarnings("unchecked")
    public List<TorihikisakiListDomain> getTorihikisakiList(TorihikisakiListParamBean paramBean,
            BasePagerCondition condition) {
        return getSqlMapClientTemplate().queryForList("demand.selectTorihikisakiList",
                paramBean, condition.getOffset(), condition.getLimit());
    }

}
