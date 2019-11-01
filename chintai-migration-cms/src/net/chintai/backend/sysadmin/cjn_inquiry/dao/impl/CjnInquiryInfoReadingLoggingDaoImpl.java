/*
 * $Id: CjnInquiryInfoReadingLoggingDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/08  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao.impl;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryInfoReadingLoggingParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * CjnInquiryInfoReadingLoggingDaoの実装クラス
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryInfoReadingLoggingDaoImpl extends SqlMapClientDaoSupport implements
        net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryInfoReadingLoggingDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryInfoReadingLoggingDao#insertCjnInquiryInfoReadingLogging(net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryInfoReadingLoggingParamBean)
     */
    public void insertCjnInquiryInfoReadingLogging(CjnInquiryInfoReadingLoggingParamBean paramBean) {
        getSqlMapClientTemplate().insert("cjn_inquiry.insertCjnInquiryInfoReading", paramBean);
    }

}
