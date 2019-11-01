/*
 * $Id: ReviewBukkenStatusUpdateConfirmDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/18  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.review.dao.ReviewAutoDelInfoParamBean;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenStatusUpdateConfirmDao;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenStatusUpdateConfirmParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewBukkenStatusUpdateDomain;

/**
 * ReveiwBukkenStatusUpdateConfirmDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenStatusUpdateConfirmDaoImpl extends SqlMapClientDaoSupport implements
        ReviewBukkenStatusUpdateConfirmDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewBukkenStatusUpdateConfirmDao#getBukkenInfo(net.chintai.backend.sysadmin.review.dao.ReviewBukkenStatusUpdateConfirmParamBean)
     */
    public ReviewBukkenStatusUpdateDomain getBukkenInfo(
            ReviewBukkenStatusUpdateConfirmParamBean paramBean) {
        return (ReviewBukkenStatusUpdateDomain) getSqlMapClientTemplate().queryForObject(
                "review.selectBukkenStatusConfirmInfo", paramBean);
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewBukkenStatusUpdateConfirmDao#seleclAutoDelInfo(net.chintai.backend.sysadmin.review.dao.ReviewBukkenStatusUpdatePageParamBean)
     */
    public int seleclAutoDelInfo(ReviewAutoDelInfoParamBean paramBean) {
        return (Integer) getSqlMapClientTemplate().queryForObject("review.selectAutoDelterm",
                paramBean);
    }

}
