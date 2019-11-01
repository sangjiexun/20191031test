/*
 * $Id: ReviewBukkenInfoDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/15  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.review.dao.ReviewAutoDelInfoParamBean;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenInfoDao;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenInfoParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewBukkenInfoDomain;

/**
 * ReviewBukkenInfoDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenInfoDaoImpl extends SqlMapClientDaoSupport implements ReviewBukkenInfoDao {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewBukkenInfoDao#getReviewHistory(net.chintai.backend.sysadmin.review.dao.ReviewBukkenInfoParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<ReviewBukkenInfoDomain> getReviewHistory(ReviewBukkenInfoParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList("review.selectReviewHistory", paramBean);
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewBukkenInfoDao#getReviewStatus(net.chintai.backend.sysadmin.review.dao.ReviewBukkenInfoParamBean)
     */
    public ReviewBukkenInfoDomain getReviewStatus(ReviewBukkenInfoParamBean paramBean) {
        return (ReviewBukkenInfoDomain) getSqlMapClientTemplate().queryForObject(
                "review.selectReviewStatus", paramBean);
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewBukkenInfoDao#seleclAutoDelInfo()
     */
    public int seleclAutoDelInfo(ReviewAutoDelInfoParamBean paramBean) {
        return (Integer) getSqlMapClientTemplate().queryForObject("review.selectAutoDelterm", paramBean);
    }

}
