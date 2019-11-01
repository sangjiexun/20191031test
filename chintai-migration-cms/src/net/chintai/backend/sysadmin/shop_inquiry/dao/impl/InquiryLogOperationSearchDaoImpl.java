/*
 * $Id: InquiryLogOperationSearchDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/11  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_inquiry.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.shop_inquiry.dao.InquiryLogOperationSearchDao;
import net.chintai.backend.sysadmin.shop_inquiry.dao.InquiryLogOperationSearchParamBean;
import net.chintai.backend.sysadmin.shop_inquiry.domain.InquiryLogOperation;

/**
 * InquiryLogOperationSearchDao の実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class InquiryLogOperationSearchDaoImpl extends SqlMapClientDaoSupport 
    implements InquiryLogOperationSearchDao {

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_inquiry.dao.InquiryLogOperationSearchDao#inquiryLogOperationSearch(net.chintai.backend.sysadmin.shop_inquiry.dao.InquiryLogOperationSearchParamBean, net.chintai.backend.sysadmin.common.pager.BasePagerCondition)
     */
    @SuppressWarnings("unchecked")
    public List<InquiryLogOperation> inquiryLogOperationSearch(
            InquiryLogOperationSearchParamBean paramBean,
            BasePagerCondition condition) {

        return getSqlMapClientTemplate().
        queryForList("shop_inquiry.inquiryLogOperationSearch", paramBean,
            condition.getOffset(), condition.getLimit());
    }

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_inquiry.dao.InquiryLogOperationSearchDao#inquiryLogOperationTotalList(net.chintai.backend.sysadmin.shop_inquiry.dao.InquiryLogOperationSearchParamBean)
     */
    public int inquiryLogOperationTotalList(
            InquiryLogOperationSearchParamBean paramBean) {

        return (Integer) getSqlMapClientTemplate().
        queryForObject("shop_inquiry.inquiryLogOperationListCount", paramBean);
    }
}