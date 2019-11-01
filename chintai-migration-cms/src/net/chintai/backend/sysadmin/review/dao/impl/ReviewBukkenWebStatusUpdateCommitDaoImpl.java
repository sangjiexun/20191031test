/*
 * $Id: ReviewBukkenWebStatusUpdateCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/19  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao.impl;

import net.chintai.backend.sysadmin.review.dao.ReviewBukkenWebStatusUpdateCommitDao;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenWebStatusUpdateCommitParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewBukkenWebStatusDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ReviewBukkenWebStatusUpdateCommitDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenWebStatusUpdateCommitDaoImpl extends SqlMapClientDaoSupport implements
        ReviewBukkenWebStatusUpdateCommitDao {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewBukkenWebStatusUpdateCommitDao#updateBukkenWebStatus(net.chintai.backend.sysadmin.review.dao.ReviewBukkenWebStatusUpdateCommitParamBean)
     */
    public int updateBukkenWebStatus(ReviewBukkenWebStatusUpdateCommitParamBean paramBean) {
        return getSqlMapClientTemplate().update("review.updateBukkenWebStatus", paramBean);
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewBukkenWebStatusUpdateCommitDao#updateBukkenWebStatus(net.chintai.backend.sysadmin.review.dao.ReviewBukkenWebStatusUpdateCommitParamBean)
     */
    public ReviewBukkenWebStatusDomain selectBukkenWebStatusCheck(ReviewBukkenWebStatusUpdateCommitParamBean paramBean) {
        return (ReviewBukkenWebStatusDomain)getSqlMapClientTemplate().queryForObject("review.selectBukkenWebStatus", paramBean);
    }

}
