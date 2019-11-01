/*
 * $Id: InquiryRecentSearchDaoImpl.java 4464 2010-09-27 08:05:10Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/05  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_inquiry.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.event.RowHandler;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.shop_inquiry.dao.InquiryRecentSearchDao;
import net.chintai.backend.sysadmin.shop_inquiry.dao.InquiryRecentSearchParamBean;


/**
 * InquiryRecentSearchDao の実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 4464 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class InquiryRecentSearchDaoImpl extends SqlMapClientDaoSupport
    implements InquiryRecentSearchDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.InquiryRecentSearchDao#inqueryRecentSearch()
     */
    public List inqueryRecentSearch
        (InquiryRecentSearchParamBean paramBean, BasePagerCondition condition) {

        return getSqlMapClientTemplate().
            queryForList("shop_inquiry.inquiryRecentSearch", paramBean,
                condition.getOffset(), condition.getLimit());
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_inquiry.dao.InquiryRecentSearchDao#inqueryRecentTotalList(net.chintai.backend.sysadmin.shop_inquiry.dao.InquiryRecentSearchParamBean)
     */
    public int inqueryRecentTotalList(InquiryRecentSearchParamBean paramBean) {

        return (Integer) getSqlMapClientTemplate().queryForObject("shop_inquiry.inquiryRecentListCount",
                paramBean);
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_inquiry.dao.InquiryRecentSearchDao#inqueryRecentSearchForCsv(com.ibatis.sqlmap.client.event.RowHandler, net.chintai.backend.sysadmin.shop_inquiry.dao.InquiryRecentSearchParamBean)
     */
    public void inqueryRecentSearchForCsv(RowHandler handler, InquiryRecentSearchParamBean paramBean) {

        getSqlMapClientTemplate().queryWithRowHandler("shop_inquiry.inquiryRecentSearchForCsv", paramBean, handler);
    }

}