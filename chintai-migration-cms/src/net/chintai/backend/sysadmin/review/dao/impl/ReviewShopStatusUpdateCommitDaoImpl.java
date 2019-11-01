/*
 * $Id: ReviewShopStatusUpdateCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/17  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.review.dao.ReviewShopStatusUpdateCommitDao;
import net.chintai.backend.sysadmin.review.dao.ReviewShopStatusUpdateCommitParamBean;

/**
 * ReviewShopStatusUpdateCommitDao実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopStatusUpdateCommitDaoImpl extends SqlMapClientDaoSupport implements
        ReviewShopStatusUpdateCommitDao {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewShopStatusUpdateCommitDao#updateShopStatus(net.chintai.backend.sysadmin.review.dao.ReviewShopStatusUpdateCommitParamBean)
     */
    public int updateShopStatus(ReviewShopStatusUpdateCommitParamBean paramBean) {
        return getSqlMapClientTemplate().update("review.updateShopStatus", paramBean);
    }

}
