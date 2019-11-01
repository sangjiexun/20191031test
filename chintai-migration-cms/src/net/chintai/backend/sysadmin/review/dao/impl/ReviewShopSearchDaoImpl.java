/*
 * $Id: ReviewShopSearchDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.review.dao.ReviewShopSearchDao;
import net.chintai.backend.sysadmin.review.dao.ReviewShopSearchParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewShopSearchDomain;

/**
 * ReviewShopSearchDaoの実装クラス
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopSearchDaoImpl extends SqlMapClientDaoSupport implements ReviewShopSearchDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewShopSearchDao#selectShopSearch(net.chintai.backend.sysadmin.review.dao.ReviewShopSearchParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<ReviewShopSearchDomain> selectShopSearch(ReviewShopSearchParamBean paramBean,
            BasePagerCondition condition) {
        return getSqlMapClientTemplate().queryForList("review.selectShopSearch", paramBean,
                condition.getOffset(), condition.getLimit());
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewShopSearchDao#selectTotalCnt(net.chintai.backend.sysadmin.review.dao.ReviewShopSearchParamBean)
     */
    public int selectTotalCnt(ReviewShopSearchParamBean paramBean) {
        return (Integer) getSqlMapClientTemplate().queryForObject("review.selectShopTotalCnt",
                paramBean);
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewShopSearchDao#selectVaildTable()
     */
    public String selectVaildTable() {
        return (String) getSqlMapClientTemplate().queryForObject("review.selectValidTable");
    }

}
