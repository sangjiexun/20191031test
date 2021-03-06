/*
 * $Id: ReviewTodofukenMediaCountDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/03  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.review.dao.ReviewTodofukenMediaCountDao;
import net.chintai.backend.sysadmin.review.dao.ReviewTodofukenMediaCountParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewTodofukenMediaCountDomain;

/**
 * ReviewTodofukenMediaCountDaoの実装クラス
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewTodofukenMediaCountDaoImpl extends SqlMapClientDaoSupport implements
        ReviewTodofukenMediaCountDao {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewTodofukenMediaCountDao#selectMediaCount(net.chintai.backend.sysadmin.review.dao.ReviewTodofukenMediaCountParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<ReviewTodofukenMediaCountDomain> selectMediaCount(
            ReviewTodofukenMediaCountParamBean paramBean) {
        String sql;
        if(paramBean.getOutPut().endsWith("csv")){
            sql = "review.selectTodofukenMediaCntForCsv";
        }else{
            sql = "review.selectTodofukenMediaCnt";
        }
        return getSqlMapClientTemplate().queryForList(sql, paramBean);
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewTodofukenMediaCountDao#selectCntTime()
     */
    public ReviewTodofukenMediaCountDomain selectCntTime() {
        return (ReviewTodofukenMediaCountDomain) getSqlMapClientTemplate().queryForObject(
                "review.selectPrefCntTime");
    }

}
