/*
 * $Id: ReviewShopMediaCountDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/05  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.review.dao.ReviewShopMediaCountDao;
import net.chintai.backend.sysadmin.review.dao.ReviewShopMediaCountParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewShopMediaCountDomain;

/**
 * ReviewShopMediaCountDaoの実装クラス。
 * 
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopMediaCountDaoImpl extends SqlMapClientDaoSupport implements
        ReviewShopMediaCountDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewShopMediaCountDao#selectShopMediaCnt(net.chintai.backend.sysadmin.review.dao.ReviewShopMediaCountParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<ReviewShopMediaCountDomain> selectShopMediaCnt(
            ReviewShopMediaCountParamBean paramBean, BasePagerCondition condition) {
        List<ReviewShopMediaCountDomain> returnList;
        if (paramBean.getOutPut().endsWith("csv")) {
            returnList =
                    getSqlMapClientTemplate().queryForList("review.selectShopMediaCntForCsv",
                            paramBean);
        } else {
            returnList =
                    getSqlMapClientTemplate().queryForList("review.selectShopMediaCnt", paramBean,
                            condition.getOffset() * 5, condition.getLimit() * 5);
        }
        return returnList;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewShopMediaCountDao#selectTotalCnt(net.chintai.backend.sysadmin.review.dao.ReviewShopMediaCountParamBean)
     */
    public int selectTotalCnt(ReviewShopMediaCountParamBean paramBean) {
        return (Integer) getSqlMapClientTemplate().queryForObject("review.shopMediaCnt", paramBean);
    }

    public ReviewShopMediaCountDomain selectCntTime() {
        return (ReviewShopMediaCountDomain) getSqlMapClientTemplate().queryForObject(
                "review.selectShopCntTime");
    }

}
