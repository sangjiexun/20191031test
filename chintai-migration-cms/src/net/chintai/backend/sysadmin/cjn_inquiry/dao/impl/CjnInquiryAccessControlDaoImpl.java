/*
 * $Id: CjnInquiryAccessControlDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/11/04   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao.impl;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryAccessControlDao;
import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryAccessControlParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * CjnInquiryAccessControlDao の実装クラス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryAccessControlDaoImpl extends SqlMapClientDaoSupport implements CjnInquiryAccessControlDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryAccessControlDao#selectCjnAccountSeqCountForInqId(net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryAccessControlParamBean)
     */
    public int selectCjnAccountSeqCountForInqId(CjnInquiryAccessControlParamBean param) {
        return (Integer) getSqlMapClientTemplate().queryForObject("cjn_inquiry.selectCjnAccountSeqCountForInqId", param);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryAccessControlDao#selectCjnAccountSeqCountForKindSeq(net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryAccessControlParamBean)
     */
    public int selectCjnAccountSeqCountForKindSeq(CjnInquiryAccessControlParamBean param) {
        return (Integer) getSqlMapClientTemplate().queryForObject("cjn_inquiry.selectCjnAccountSeqCountForKindSeq", param);
    }

}
