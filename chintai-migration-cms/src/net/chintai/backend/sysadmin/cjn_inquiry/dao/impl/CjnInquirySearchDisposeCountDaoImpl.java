/*
 * $Id: CjnInquirySearchDisposeCountDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/05  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao.impl;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquirySearchDisposeCountDao;
import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquirySearchDisposeCountPageParamBean;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquirySearchDisposeCountInfo;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * CjnInquirySearchDisposeCountDaoの実装クラス
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquirySearchDisposeCountDaoImpl extends SqlMapClientDaoSupport implements CjnInquirySearchDisposeCountDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquirySearchDisposeCountDao#selectDisposeCountList(net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquirySearchDisposeCountPageParamBean)
     */
    public CjnInquirySearchDisposeCountInfo selectDisposeCountList(CjnInquirySearchDisposeCountPageParamBean paramBean) {
        return (CjnInquirySearchDisposeCountInfo) getSqlMapClientTemplate().queryForObject("cjn_inquiry.selectDisposeCountList", paramBean);
    }
}
