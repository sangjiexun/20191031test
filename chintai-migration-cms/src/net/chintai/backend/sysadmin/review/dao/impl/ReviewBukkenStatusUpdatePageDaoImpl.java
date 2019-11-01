/*
 * $Id: ReviewBukkenStatusUpdatePageDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/17  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.review.dao.ReviewAutoDelInfoParamBean;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenStatusUpdatePageDao;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenStatusUpdatePageParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewBukkenStatusUpdateDomain;

/**
 * ReviewBukkenStatusUpdatePageDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenStatusUpdatePageDaoImpl extends SqlMapClientDaoSupport implements
        ReviewBukkenStatusUpdatePageDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewBukkenStatusUpdatePageDao#getBukkenStatusInfo(net.chintai.backend.sysadmin.review.dao.ReviewBukkenStatusUpdatePageParamBean)
     */
    public ReviewBukkenStatusUpdateDomain getBukkenStatusInfo(
            ReviewBukkenStatusUpdatePageParamBean paramBean) {
        return (ReviewBukkenStatusUpdateDomain) getSqlMapClientTemplate().queryForObject(
                "review.selectBukkenStatusInfo", paramBean);
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewBukkenStatusUpdatePageDao#seleclAutoDelInfo(net.chintai.backend.sysadmin.review.dao.ReviewBukkenStatusUpdatePageParamBean)
     */
    public int seleclAutoDelInfo(ReviewAutoDelInfoParamBean paramBean) {
        return (Integer) getSqlMapClientTemplate().queryForObject("review.selectAutoDelterm", paramBean);
    }

}
