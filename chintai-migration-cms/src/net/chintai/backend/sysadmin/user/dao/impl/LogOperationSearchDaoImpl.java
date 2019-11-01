/*
 * $Id: LogOperationSearchDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/16  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.user.dao.LogOperationSearchDao;
import net.chintai.backend.sysadmin.user.dao.LogOperationSearchParamBean;
import net.chintai.backend.sysadmin.user.domain.LogOperation;

/**
 * LogOperationSearchDao の実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class LogOperationSearchDaoImpl extends SqlMapClientDaoSupport 
    implements LogOperationSearchDao {

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.dao.LogOperationSearchDao#logOperation(net.chintai.backend.sysadmin.user.dao.LogOperationSearchParamBean, net.chintai.backend.sysadmin.common.pager.BasePagerCondition)
     */
    @SuppressWarnings("unchecked")
    public List<LogOperation> logOperation(
            LogOperationSearchParamBean paramBean, BasePagerCondition condition) {

        return getSqlMapClientTemplate().
            queryForList("user.logOperationSearch", paramBean,
                condition.getOffset(), condition.getLimit());
    }

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.dao.LogOperationSearchDao#logOperationTotalCount(net.chintai.backend.sysadmin.user.dao.LogOperationSearchParamBean)
     */
    public int logOperationTotalCount(LogOperationSearchParamBean paramBean) {

        return (Integer) getSqlMapClientTemplate().queryForObject
            ("user.logOperationTotalCount", paramBean);
    }
}