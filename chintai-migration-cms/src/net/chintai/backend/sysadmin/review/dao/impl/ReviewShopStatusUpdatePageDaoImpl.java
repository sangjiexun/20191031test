/*
 * $Id: ReviewShopStatusUpdatePageDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/16  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.review.dao.ReviewShopStatusUpdatePageDao;
import net.chintai.backend.sysadmin.review.dao.ReviewShopStatusUpdatePageParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewShopStatusUpdateDomain;

/**
 * ReviewShopStatusUpdagePageDaoImplの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopStatusUpdatePageDaoImpl extends SqlMapClientDaoSupport implements
        ReviewShopStatusUpdatePageDao {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewShopStatusUpdatePageDao#selectShopStatusInfo(net.chintai.backend.sysadmin.review.dao.ReviewShopStatusUpdatePageParamBean)
     */
    public ReviewShopStatusUpdateDomain selectShopStatusInfo(
            ReviewShopStatusUpdatePageParamBean paramBean) {
        return (ReviewShopStatusUpdateDomain) getSqlMapClientTemplate().queryForObject(
                "review.selectUpdateShopInfo", paramBean);
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewShopStatusUpdatePageDao#selectVaildTable()
     */
    public String selectVaildTable() {
        return (String) getSqlMapClientTemplate().queryForObject("review.selectValidTable");
    }
}
