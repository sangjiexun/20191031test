/*
 * $Id: ReviewBukkenStatusUpdateCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/19  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao.impl;

import net.chintai.backend.sysadmin.review.dao.ReviewBukkenStatusUpdateCommitParamBean;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkennStatusUpdateCommitDao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ReviewBukkenStatusUpdateCommitDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenStatusUpdateCommitDaoImpl extends SqlMapClientDaoSupport implements
    ReviewBukkennStatusUpdateCommitDao {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewBukkennStatusUpdateCommitDao#updateBukkenStatus(net.chintai.backend.sysadmin.review.dao.ReviewBukkenStatusUpdateCommitParamBean)
     */
    public int updateBukkenStatus(ReviewBukkenStatusUpdateCommitParamBean paramBean) {
        return getSqlMapClientTemplate().update("review.updateBukkenStatus", paramBean);
    }

    @Override
    public String selectBukkenStatusCheck(ReviewBukkenStatusUpdateCommitParamBean paramBean) {
        return (String)getSqlMapClientTemplate().queryForObject("review.selectBukkenStatusCheck",paramBean);
    }
}
