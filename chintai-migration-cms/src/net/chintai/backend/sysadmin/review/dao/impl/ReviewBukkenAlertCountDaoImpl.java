/*
 * $Id: ReviewBukkenAlertCountDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/09/28  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenAlertCountDao;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenAlertCountParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewBukkenAlertCountDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ReviewBukkenAlertCountDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenAlertCountDaoImpl extends SqlMapClientDaoSupport implements
        ReviewBukkenAlertCountDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewBukkenAlertCountDao
     *      #selectTotalCount(net.chintai.backend.sysadmin.review.dao.ReviewBukkenAlertCountParamBean)
     */
    public int selectTotalCount(ReviewBukkenAlertCountParamBean paramBean) {
        return (Integer) getSqlMapClientTemplate().queryForObject("review.selectTotalCount",
                paramBean);
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewBukkenAlertCountDao
     *      #selectAlertBukken(net.chintai.backend.sysadmin.review.dao.ReviewBukkenAlertCountParamBeanm,
     *      net.chintai.backend.sysadmin.common.pager.BasePagerCondition
     *      condition)
     */
    @SuppressWarnings("unchecked")
    public List<ReviewBukkenAlertCountDomain> selectAlertBukken(
            ReviewBukkenAlertCountParamBean paramBean, BasePagerCondition condition) {
        return getSqlMapClientTemplate().queryForList("review.selectBukkenAlertCnt", paramBean,
                condition.getOffset(), condition.getLimit());
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewBukkenAlertCountDao
     *      #selectAlertBukken(net.chintai.backend.sysadmin.review.dao.ReviewBukkenAlertCountParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<ReviewBukkenAlertCountDomain> selectAlertBukken(
            ReviewBukkenAlertCountParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList("review.selectBukkenAlertCnt", paramBean);
    }

}
