/*
 * $Id: CjnInquiryStatusUpdateCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/11  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryStatusUpdateCommitDao;
import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryStatusUpdateCommitParamBean;

/**
 * CjnInquiryStatusUpdateCommitDao実装クラス
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryStatusUpdateCommitDaoImpl extends SqlMapClientDaoSupport implements
        CjnInquiryStatusUpdateCommitDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryStatusUpdateCommitDao#cjnInquiryStatusUpdateCommit(net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryStatusUpdateCommitParamBean)
     */
    public int updateCjnInquiryStatus(CjnInquiryStatusUpdateCommitParamBean paramBean) {
        return getSqlMapClientTemplate().update("cjn_inquiry.updateInquiryStastus", paramBean);
    }

}
