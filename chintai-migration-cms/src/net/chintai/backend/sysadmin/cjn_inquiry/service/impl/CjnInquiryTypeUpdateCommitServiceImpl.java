/*
 * $Id: CjnInquiryTypeUpdateCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/26  BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryTypeUpdateCommitDao;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryTypeInfo;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryTypeUpdateCommitService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeUpdateCommitInServiceBean;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;

/**
 * 問い合せ種別を更新するサービス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryTypeUpdateCommitServiceImpl implements CjnInquiryTypeUpdateCommitService {

    /** 問い合せ種別更新DAO */
    CjnInquiryTypeUpdateCommitDao typeUpdateCommitDao;

    /**
     * 問い合せ種別更新DAOを設定します。
     * @param dao
     */
    public void setCjnInquiryTypeUpdateCommitDao(CjnInquiryTypeUpdateCommitDao dao) {
        typeUpdateCommitDao = dao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryTypeUpdateCommitService#updateType(
     *          net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeUpdateCommitInServiceBean)
     */
    public void updateType(CjnInquiryTypeUpdateCommitInServiceBean bean) throws ApplicationException {

        // 更新用データの準備
        CjnInquiryTypeInfo domain = new CjnInquiryTypeInfo();
        try {
            BeanUtils.copyProperties(domain, bean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // 更新実行
        int affected = typeUpdateCommitDao.updateType(domain);
        if (affected == 0) {
            throw new ApplicationException("ERROR.M.CJN_INQUIRY.0001");
        }
    }
}
