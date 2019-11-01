/*
 * $Id: ReviewBukkenSearchDaoImpl.java 3910 2008-05-27 06:56:09Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/09  BGT)李昊燮   新規作成
 * 2008/05/27  BGT)李昊燮   メッソドselectVaildTable追加    
 */
package net.chintai.backend.sysadmin.review.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.review.dao.ReviewAutoDelInfoParamBean;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenSearchDao;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenSearchParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewBukkenSearchDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ReviewBukkenSearchDaoの実装クラス
 *
 * @author lee-hosup
 * @version $Revision: 3910 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenSearchDaoImpl extends SqlMapClientDaoSupport implements
        ReviewBukkenSearchDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewBukkenSearchDao#selectBukkenSearch(net.chintai.backend.sysadmin.review.dao.ReviewBukkenSearchParamBean,
     *      net.chintai.backend.sysadmin.common.pager.BasePagerCondition)
     */
    @SuppressWarnings("unchecked")
    public List<ReviewBukkenSearchDomain> selectBukkenSearch(ReviewBukkenSearchParamBean paramBean,
            BasePagerCondition condition) {
        return getSqlMapClientTemplate().queryForList("review.selectBukken", paramBean,
                condition.getOffset(), condition.getLimit());
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewBukkenSearchDao#selectBukkenTotanCnt(net.chintai.backend.sysadmin.review.dao.ReviewBukkenSearchParamBean)
     */
    public int selectBukkenTotalCnt(ReviewBukkenSearchParamBean paramBean) {
        return (Integer) getSqlMapClientTemplate().queryForObject("review.selectBukkenTotalCnt",
                paramBean);
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewBukkenSearchDao#seleclAutoDelInfo()
     */
    public int seleclAutoDelInfo(ReviewAutoDelInfoParamBean paramBean) {
        return (Integer) getSqlMapClientTemplate().queryForObject("review.selectAutoDelterm",
                paramBean);
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewBukkenSearchDao#selectVaildTable()
     */
    public String selectVaildTable() {
        return (String) getSqlMapClientTemplate()
                .queryForObject("review.getChintaiBukkenTableName");
    }
}
