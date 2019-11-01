/*
 * $Id: ReviewBukkenStatusUpdateCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/19  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao.impl;

import net.chintai.backend.sysadmin.review.dao.ReviewBukkenRirekiAddCommitDao;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenRirekiAddParamBean;
import net.chintai.backend.sysadmin.review.dao.ReviewBukkenStatusAddParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ReviewBukkenStatusUpdateCommitDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewBukkenRirekiAddCommitDaoImpl extends SqlMapClientDaoSupport implements
    ReviewBukkenRirekiAddCommitDao {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewBukkennStatusUpdateCommitDao#selectPkBukkenRireki()
     */
    public Long selectPkBukkenRireki() {
        return (Long)getSqlMapClientTemplate().queryForObject("review.selectPkBukkenRireki");
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewBukkennStatusUpdateCommitDao#bukkenRirekiAdd(net.chintai.backend.sysadmin.review.dao.ReviewBukkenRirekiAddParamBean)
     */
    public void bukkenRirekiAdd(ReviewBukkenRirekiAddParamBean paramBean) {
        getSqlMapClientTemplate().insert("review.bukkenRirekiAddCommit",paramBean);
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewBukkennStatusUpdateCommitDao#bukkenStatusKanriAdd(net.chintai.backend.sysadmin.review.dao.ReviewBukkenStatusAddParamBean)
     */
    public void bukkenStatusKanriAdd(ReviewBukkenStatusAddParamBean paramBean) {
        getSqlMapClientTemplate().insert("review.bukkenStatuKanriAddCommit",paramBean);
    }

}
