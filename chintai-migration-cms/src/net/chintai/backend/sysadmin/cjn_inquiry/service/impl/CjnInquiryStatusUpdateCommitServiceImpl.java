/*
 * $Id: CjnInquiryStatusUpdateCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/11  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryStatusUpdateCommitDao;
import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryStatusUpdateCommitParamBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryStatusUpdateCommitService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryStatusUpdateCommitInServiceBean;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;

/**
 * CjnInquiryStatusUpdateCommitService の実装クラス。
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryStatusUpdateCommitServiceImpl implements CjnInquiryStatusUpdateCommitService {

    /** 問い合せ更新Dao */
    private CjnInquiryStatusUpdateCommitDao cjnStatusUpdateCommitDao;

    /**
     * 問い合せ更新Daoを設定します。
     * @param cjnInquiryStatusUpdateCommitDao
     */
    public void setCjnInquiryStatusUpdateCommitDao(
            CjnInquiryStatusUpdateCommitDao cjnInquiryStatusUpdateCommitDao) {
        this.cjnStatusUpdateCommitDao = cjnInquiryStatusUpdateCommitDao;

    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryStatusUpdateCommitService#cjnInquiryStatusUpdateCommit(net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryStatusUpdateCommitInServiceBean)
     */
    public void cjnInquiryStatusUpdateCommit(CjnInquiryStatusUpdateCommitInServiceBean bean)
            throws ApplicationException {

        CjnInquiryStatusUpdateCommitParamBean paramBean =
                new CjnInquiryStatusUpdateCommitParamBean();

        try {
            BeanUtils.copyProperties(paramBean, bean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        int affected = cjnStatusUpdateCommitDao.updateCjnInquiryStatus(paramBean);

        if (affected == 0) {
            throw new ApplicationException("ERROR.M.CJN_INQUIRY.0003");
        }
    }

}
