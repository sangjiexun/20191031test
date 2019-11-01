/*
 * $Id: ReviewShopStatusUpdateConfirmDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/16  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.review.dao.ReviewShopStatusUpdateConfirmDao;
import net.chintai.backend.sysadmin.review.dao.ReviewShopStatusUpdateConfirmParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewShopStatusUpdateDomain;


/**
 * ReviewShopStatusUpdateConfirmDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopStatusUpdateConfirmDaoImpl extends SqlMapClientDaoSupport
                                                implements ReviewShopStatusUpdateConfirmDao {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewShopStatusUpdateConfirmDao#getShopInfo(net.chintai.backend.sysadmin.review.dao.ReviewShopStatusUpdateConfirmParamBean)
     */
    public ReviewShopStatusUpdateDomain getShopInfo(ReviewShopStatusUpdateConfirmParamBean paramBean) {
        return (ReviewShopStatusUpdateDomain) getSqlMapClientTemplate().
                queryForObject("review.selectUpdateConfirmShopInfo", paramBean);
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewShopStatusUpdateConfirmDao#selectVaildTable()
     */
    public String selectVaildTable() {
        return (String) getSqlMapClientTemplate().queryForObject("review.selectValidTable");
    }

}
