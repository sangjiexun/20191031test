/*
 * $Id: ReviewReplayCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/22  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.review.dao.ReviewReplayCommitDao;
import net.chintai.backend.sysadmin.review.dao.ReviewReplayCommitParamBean;

/**
 * ReviewReplayCommitDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewReplayCommitDaoImpl extends SqlMapClientDaoSupport
                                     implements ReviewReplayCommitDao {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewReplayCommitDao#updateWarningRireki(net.chintai.backend.sysadmin.review.dao.ReviewReplayCommitParamBean)
     */
    public void updateWarningRireki(ReviewReplayCommitParamBean paramBean) {
//        getSqlMapClientTemplate().update("review.updateWarningRireki", paramBean,1);
//        getSqlMapClientTemplate().update("review.updateBukkenKanri", paramBean,1);
          getSqlMapClientTemplate().queryForObject("review.procWebShinsaStatusKbnUpd",paramBean);
    }

    public int selectBukkenReviewReplayStatusCheck(ReviewReplayCommitParamBean paramBean) {
        return (int)getSqlMapClientTemplate().queryForObject("review.selectBukkenReviewReplayStatusCheck",paramBean);
    }
}
