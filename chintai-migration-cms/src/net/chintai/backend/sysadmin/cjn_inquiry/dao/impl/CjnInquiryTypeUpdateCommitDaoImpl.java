/*
 * $Id: CjnInquiryTypeUpdateCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/26  BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao.impl;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryTypeUpdateCommitDao;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryTypeInfo;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * CjnInquiryTypeUpdateCommitDao の実装クラス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryTypeUpdateCommitDaoImpl
            extends SqlMapClientDaoSupport implements CjnInquiryTypeUpdateCommitDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryTypeUpdateCommitDao#updateType(net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryTypeInfo)
     */
    public int updateType(CjnInquiryTypeInfo domain) {
        return getSqlMapClientTemplate().update("cjn_inquiry.updateType", domain);
    }
}
