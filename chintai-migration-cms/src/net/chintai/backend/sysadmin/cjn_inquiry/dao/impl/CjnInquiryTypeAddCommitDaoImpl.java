/*
 * $Id: CjnInquiryTypeAddCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/23  BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryTypeAddCommitDao;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryTypeInfo;

/**
 * CjnInquiryTypeAddCommitDao の実装クラス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryTypeAddCommitDaoImpl extends SqlMapClientDaoSupport implements CjnInquiryTypeAddCommitDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryTypeAddCommitDao#insertTypeList(net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryTypeInfo)
     */
    public int insertType(CjnInquiryTypeInfo domain) {
        return (Integer) getSqlMapClientTemplate().insert("cjn_inquiry.insertType", domain);
    }
}
