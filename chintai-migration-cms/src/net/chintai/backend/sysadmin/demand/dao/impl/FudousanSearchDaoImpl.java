/*
 * $Id: FudousanSearchDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/21  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.demand.dao.FudousanSearchDao;
import net.chintai.backend.sysadmin.demand.dao.FudousanSearchParamBean;
import net.chintai.backend.sysadmin.demand.domain.FudousanSearchDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * FudousanSearchDaoの実装クラス
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanSearchDaoImpl extends SqlMapClientDaoSupport implements FudousanSearchDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.FudousanSearchDao#getFudousanList(net.chintai.backend.sysadmin.demand.dao.FudousanSearchParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<FudousanSearchDomain> getFudousanList(FudousanSearchParamBean paramBean,
            BasePagerCondition condition) {
        return getSqlMapClientTemplate().queryForList("demand.selectFudousan", paramBean,
                condition.getOffset(), condition.getLimit());
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.FudousanSearchDao#selectTotalCount(net.chintai.backend.sysadmin.demand.dao.FudousanSearchParamBean)
     */
    public int selectTotalCount(FudousanSearchParamBean paramBean) {
        return (Integer) getSqlMapClientTemplate().queryForObject("demand.selectFudousanTotalCnt",
                paramBean);
    }

}
