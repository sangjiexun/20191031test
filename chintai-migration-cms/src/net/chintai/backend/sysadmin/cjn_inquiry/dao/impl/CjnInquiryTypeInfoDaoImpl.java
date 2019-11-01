/*
 * $Id: CjnInquiryTypeInfoDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者         内容
 * ---------------------------------------------------------
 * 2007/09/26   BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryTypeInfoDao;
import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryTypeInfoParamBean;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryTypeInfo;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryTypeInfoUsers;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * CjnInquiryTypeInfoDao の実装クラス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryTypeInfoDaoImpl
            extends SqlMapClientDaoSupport implements CjnInquiryTypeInfoDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryTypeInfoDao#selectTypeInfo(net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryTypeInfoParamBean)
     */
    public CjnInquiryTypeInfo selectTypeInfo(CjnInquiryTypeInfoParamBean param) {
        return (CjnInquiryTypeInfo) getSqlMapClientTemplate().queryForObject("cjn_inquiry.selectTypeInfo", param);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryTypeInfoDao#selectTypeInfoUsers(net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeInfoInServiceBean)
     */
    @SuppressWarnings("unchecked")
    public List<CjnInquiryTypeInfoUsers> selectTypeInfoUsers(CjnInquiryTypeInfoParamBean param) {
        return getSqlMapClientTemplate().queryForList("cjn_inquiry.selectTypeInfoUsers", param);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryTypeInfoDao#selectLastUpdateTimeForReadableUsers(int)
     */
    public String selectLastUpdateTimeForReadableUsers(int cjnInqKindSeq) {
        return (String) getSqlMapClientTemplate().queryForObject("cjn_inquiry.selectUsersAvailabilityLastUpdateTime", cjnInqKindSeq);
    }
}
