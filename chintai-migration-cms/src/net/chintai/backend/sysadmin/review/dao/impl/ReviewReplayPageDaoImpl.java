/*
 * $Id: ReviewReplayPageDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/22  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.review.dao.ReviewReplayPageDao;
import net.chintai.backend.sysadmin.review.dao.ReviewReplayPageParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewReplayDomain;

/**
 * ReviewReplayPageDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewReplayPageDaoImpl extends SqlMapClientDaoSupport implements ReviewReplayPageDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewReplayPageDao#getReplayBukkenInfo(net.chintai.backend.sysadmin.review.dao.ReviewReplayPageParamBean)
     */
    public ReviewReplayDomain getReplayBukkenInfo(ReviewReplayPageParamBean paramBean) {
        return (ReviewReplayDomain) getSqlMapClientTemplate().queryForObject(
                "review.selectReturnMailInfo", paramBean);
    }

}
