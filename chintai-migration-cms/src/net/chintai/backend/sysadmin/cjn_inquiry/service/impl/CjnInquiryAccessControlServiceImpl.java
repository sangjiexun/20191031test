/*
 * $Id: CjnInquiryAccessControlServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/11/04   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.impl;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryAccessControlDao;
import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryAccessControlParamBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryAccessControlService;

/**
 * CjnInquiryAccessControlService の実装クラス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryAccessControlServiceImpl implements CjnInquiryAccessControlService {

    /** ACL(AccessController) DAO */
    private CjnInquiryAccessControlDao aclDao;

    /**
     * ACL DAO を設定します。
     * @param dao
     */
    public void setCjnInquiryAccessControlDao(CjnInquiryAccessControlDao dao) {
        aclDao = dao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryAccessControlService#isAccessibleForInqId(java.lang.String,
     *      java.lang.String)
     */
    public boolean isAccessibleForInqId(String userId, String cjnInqId) {
        // パラメータ構築
        CjnInquiryAccessControlParamBean param = new CjnInquiryAccessControlParamBean();
        param.setCjnInqId(cjnInqId);
        param.setUserId(userId);

        // アクセス可否判定実行
        return (aclDao.selectCjnAccountSeqCountForInqId(param) == 1) ? true : false;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryAccessControlService#isAccessibleForKindSeq(java.lang.String,
     *      int)
     */
    public boolean isAccessibleForKindSeq(String userId, int cjnInqKindSeq) {
        // パラメータ構築
        CjnInquiryAccessControlParamBean param = new CjnInquiryAccessControlParamBean();
        param.setCjnInqKindSeq(cjnInqKindSeq);
        param.setUserId(userId);

        // アクセス可否判定実行
        return (aclDao.selectCjnAccountSeqCountForKindSeq(param) == 1) ? true : false;
    }
}
