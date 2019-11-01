/*
 * $Id: ReviewBukkenWebStatusUpdateConfirmDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/19  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.review.dao.ReviewAutoDelInfoParamBean;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenWebStatusUpdateConfirmDao;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenWebStatusUpdateConfirmParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewBukkenWebStatusUpdateDomain;

/**
 * ReviewBukkenWebStatusUpdateConfirmDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenWebStatusUpdateConfirmDaoImpl extends SqlMapClientDaoSupport implements
        ReviewBukkenWebStatusUpdateConfirmDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewBukkenWebStatusUpdateConfirmDao#getBukkenWebStatusInfo(net.chintai.backend.sysadmin.review.dao.ReviewBukkenWebStatusUpdateConfirmParamBean)
     */
    public ReviewBukkenWebStatusUpdateDomain getBukkenWebStatusInfo(
            ReviewBukkenWebStatusUpdateConfirmParamBean paramBean) {
        return (ReviewBukkenWebStatusUpdateDomain) getSqlMapClientTemplate().queryForObject(
                "review.selectBukkenWebStatusConfirmInfo", paramBean);
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewBukkenWebStatusUpdateConfirmDao#seleclAutoDelInfo(net.chintai.backend.sysadmin.review.dao.ReviewBukkenStatusUpdatePageParamBean)
     */
    public int seleclAutoDelInfo(ReviewAutoDelInfoParamBean paramBean) {
        return (Integer) getSqlMapClientTemplate().queryForObject("review.selectAutoDelterm", paramBean);
    }
}
