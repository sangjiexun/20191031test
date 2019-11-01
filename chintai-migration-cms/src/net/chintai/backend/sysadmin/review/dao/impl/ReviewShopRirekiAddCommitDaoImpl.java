/*
 * $Id: ReviewBukkenStatusUpdateCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/19  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao.impl;

import net.chintai.backend.sysadmin.review.dao.ReviewShopRirekiAddCommitDao;
import net.chintai.backend.sysadmin.review.dao.ReviewShopRirekiAddParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ReviewBukkenStatusUpdateCommitDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopRirekiAddCommitDaoImpl extends SqlMapClientDaoSupport implements
    ReviewShopRirekiAddCommitDao {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewShopRirekiAddCommitDaoImpl#selectPkShopRireki()
     */
    public Long selectPkShopRireki() {
        return (Long)getSqlMapClientTemplate().queryForObject("review.selectPkShopRireki");
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewShopRirekiAddCommitDaoImpl#shopRirekiAdd(net.chintai.backend.sysadmin.review.dao.ReviewBukkenRirekiAddParamBean)
     */
    public void shopRirekiAdd(ReviewShopRirekiAddParamBean paramBean) {
        getSqlMapClientTemplate().insert("review.shopRirekiAddCommit",paramBean);
    }


}
