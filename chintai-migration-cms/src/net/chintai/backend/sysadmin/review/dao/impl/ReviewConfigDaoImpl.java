/*
 * $Id: ReviewConfigDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/09/25  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.review.dao.ReviewConfigDao;
import net.chintai.backend.sysadmin.review.domain.ReviewAutoDelDomain;
import net.chintai.backend.sysadmin.review.domain.ReviewConfigDomain;
import net.chintai.backend.sysadmin.review.domain.ReviewMadoriTypeDomain;
import net.chintai.backend.sysadmin.review.domain.ReviewPrefConfigDomain;

/**
 * ReviewConfigDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewConfigDaoImpl extends SqlMapClientDaoSupport implements
        ReviewConfigDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewConfigDao#selectReviewConfigInfo()
     */
    @SuppressWarnings("unchecked")
    public List<ReviewConfigDomain> selectReviewConfig() {
        return getSqlMapClientTemplate().queryForList(
                "review.selectReviewConfig");
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewConfigDao#selectMadoriConfig()
     */
    @SuppressWarnings("unchecked")
    public List<ReviewMadoriTypeDomain> selectMadoriConfig() {
        return getSqlMapClientTemplate().queryForList(
                "review.selectMadoriConfig");
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewConfigDao#selectAutoDelConfig()
     */
    @SuppressWarnings("unchecked")
    public List<ReviewAutoDelDomain> selectAutoDelConfig() {
        return getSqlMapClientTemplate().queryForList(
                "review.selectAutoDelConfig");
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewConfigDao#selectPrefConfig()
     */
    @SuppressWarnings("unchecked")
    public List<ReviewPrefConfigDomain> selectPrefConfig() {
        return getSqlMapClientTemplate()
                .queryForList("review.selectPrefConfig");
    }

}
