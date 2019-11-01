/*
 * $Id: ReviewConfigCityDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/09/28  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.review.dao.ReviewConfigCityDao;
import net.chintai.backend.sysadmin.review.dao.ReviewConfigCityParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewConfigCityDomain;

/**
 * ReviewConfigCityDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewConfigCityDaoImpl extends SqlMapClientDaoSupport implements
        ReviewConfigCityDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewConfigCityDao#selectPrefName(net.chintai.backend.sysadmin.review.dao.ReviewConfigCityParamBean)
     */
    public ReviewConfigCityDomain selectPrefName(
            ReviewConfigCityParamBean paramBean) {
        return (ReviewConfigCityDomain) getSqlMapClientTemplate()
                .queryForObject("review.selectPrefName", paramBean);
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewConfigCityDao#selectCityConfig(net.chintai.backend.sysadmin.review.dao.ReviewConfigCityParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<ReviewConfigCityDomain> selectCityConfig(
            ReviewConfigCityParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList(
                "review.selectCityConfig", paramBean);
    }

}
