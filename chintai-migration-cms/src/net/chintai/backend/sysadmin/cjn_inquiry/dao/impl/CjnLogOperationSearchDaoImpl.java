/*
 * $Id: CjnLogOperationSearchDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/01  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnLogOperationSearchDao;
import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnLogOperationSearchParamBean;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * CjnLogOperationSearchDaoの実装クラス。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnLogOperationSearchDaoImpl extends SqlMapClientDaoSupport implements CjnLogOperationSearchDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnLogOperationSearchDao#selectCjnLogCount(net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnLogOperationSearchParamBean)
     */
    public int selectCjnLogCount(CjnLogOperationSearchParamBean paramBean) {
        return (Integer) getSqlMapClientTemplate().queryForObject("cjn_inquiry.selectLogOperationCount", paramBean);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnLogOperationSearchDao#selectCjnLogList(net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnLogOperationSearchParamBean,
     *      net.chintai.backend.sysadmin.common.pager.BasePagerCondition)
     */
    public List selectCjnLogList(CjnLogOperationSearchParamBean paramBean, BasePagerCondition condition) {
        return getSqlMapClientTemplate().queryForList("cjn_inquiry.selectLogOperationList", paramBean,
                condition.getOffset(), condition.getLimit());
    }
}
