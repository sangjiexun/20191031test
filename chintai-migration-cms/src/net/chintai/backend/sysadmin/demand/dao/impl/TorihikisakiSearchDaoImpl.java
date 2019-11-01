/*
 * $Id: TorihikisakiSearchDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/15  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiSearchDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiSearchParamBean;
import net.chintai.backend.sysadmin.demand.domain.TorihikisakiSearchDomain;


/**
 * TorihikisakiSearchDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiSearchDaoImpl extends SqlMapClientDaoSupport
                                      implements TorihikisakiSearchDao {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiSearchDao#getTorihikisaki(net.chintai.backend.sysadmin.demand.dao.TorihikisakiSearchParamBean, net.chintai.backend.sysadmin.common.pager.BasePagerCondition)
     */
    @SuppressWarnings("unchecked")
    public List<TorihikisakiSearchDomain> getTorihikisaki(TorihikisakiSearchParamBean paramBean,
            BasePagerCondition condition) {
        return getSqlMapClientTemplate().queryForList(
                "demand.selectTorihikisaki", paramBean, condition.getOffset(), condition.getLimit());
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiSearchDao#selectTotalCount(net.chintai.backend.sysadmin.demand.dao.TorihikisakiSearchParamBean)
     */
    public int selectTotalCount(TorihikisakiSearchParamBean paramBean) {
        return (Integer) getSqlMapClientTemplate().queryForObject(
                "demand.selectTorihikisakiTotalCnt", paramBean);
    }

}
