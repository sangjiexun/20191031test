/*
 * $Id: CjnInquirySearchDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/05  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquirySearchDao;
import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquirySearchParamBean;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquirySearchList;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * CjnInquirySearchDaoの実装クラス
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquirySearchDaoImpl extends SqlMapClientDaoSupport implements CjnInquirySearchDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquirySearchDao#selectInquiryList(net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquirySearchParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<CjnInquirySearchList> selectInquiryList(CjnInquirySearchParamBean paramBean,
            BasePagerCondition condition) {
        return getSqlMapClientTemplate().queryForList("cjn_inquiry.selectInquiryList", paramBean,
                condition.getOffset(), condition.getLimit());
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquirySearchDao#selectInquiryListCount(net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquirySearchParamBean)
     */
    public int selectInquiryListCount(CjnInquirySearchParamBean paramBean) {
        return (Integer) getSqlMapClientTemplate().queryForObject(
                "cjn_inquiry.selectInquiryListCount", paramBean);
    }
}
