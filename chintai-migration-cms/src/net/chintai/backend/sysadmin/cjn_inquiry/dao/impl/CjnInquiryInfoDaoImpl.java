/*
 * $Id: CjnInquiryInfoDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao.impl;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryInfoDao;
import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryInfoParamBean;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryInfo;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * CjnInquiryInfoDaoの実装クラス
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryInfoDaoImpl extends SqlMapClientDaoSupport implements CjnInquiryInfoDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryInfoDao#selectCjnInquiryInfo(net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryInfoParamBean)
     */
    public CjnInquiryInfo selectCjnInquiryInfo(CjnInquiryInfoParamBean paramBean) {
        return (CjnInquiryInfo) getSqlMapClientTemplate().queryForObject("cjn_inquiry.selectCjnInquiry", paramBean);
    }
    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryInfoDao#updateRefFlg(net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryInfoParamBean)
     */
    public int updateRefFlg(CjnInquiryInfoParamBean paramBean) {
        return getSqlMapClientTemplate().update("cjn_inquiry.udateRefFlg", paramBean);
    }

}
