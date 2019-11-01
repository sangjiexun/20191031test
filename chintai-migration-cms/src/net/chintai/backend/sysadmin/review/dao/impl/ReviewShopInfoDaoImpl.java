/*
 * $Id: ReviewShopInfoDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/10/12  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.review.dao.impl;

import net.chintai.backend.sysadmin.review.dao.ReviewShopInfoDao;
import net.chintai.backend.sysadmin.review.dao.ReviewShopInfoParamBean;
import net.chintai.backend.sysadmin.review.domain.ReviewShopInfoDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * ReviewShopInfoDaoの実装クラス
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ReviewShopInfoDaoImpl extends SqlMapClientDaoSupport implements ReviewShopInfoDao {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewShopInfoDao#getShopInfo(net.chintai.backend.sysadmin.review.dao.ReviewShopInfoParamBean)
     */
    public ReviewShopInfoDomain getShopInfo(ReviewShopInfoParamBean paramBean) {
        return (ReviewShopInfoDomain) getSqlMapClientTemplate().queryForObject(
                "review.selectShopInfo", paramBean);
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.review.dao.ReviewShopInfoDao#selectVaildTable()
     */
    public String selectVaildTable() {
        return (String) getSqlMapClientTemplate().queryForObject("review.selectValidTable");
    }
}
