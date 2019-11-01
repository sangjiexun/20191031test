/*
 * $Id: CjnInquiryInfoReadingLoggingServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/08  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.impl;

import java.lang.reflect.InvocationTargetException;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryInfoReadingLoggingDao;
import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryInfoReadingLoggingParamBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryInfoReadingLoggingService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryInfoInServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * CjnInquiryInfoReadingLoggingServiceの実装クラス
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryInfoReadingLoggingServiceImpl implements CjnInquiryInfoReadingLoggingService {

    /** 問い合せ詳細情報閲覧ログ記録 DAO */
    private CjnInquiryInfoReadingLoggingDao cjnInquiryInfoReadingLoggingDao;

    /**
     * 問い合せ詳細情報閲覧ログ記録DAOを設定します。
     * 
     * @param cjnInquiryInfoReadingLoggingDao
     */
    public void setCjnInquiryInfoReadingLoggingDao(
            CjnInquiryInfoReadingLoggingDao cjnInquiryInfoReadingLoggingDao) {

        this.cjnInquiryInfoReadingLoggingDao = cjnInquiryInfoReadingLoggingDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryInfoReadingLoggingService#write(java.lang.String,
     *      net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryInfoInServiceBean)
     */
    public void write(CjnInquiryInfoInServiceBean inServiceBean) {

        CjnInquiryInfoReadingLoggingParamBean paramBean =
                new CjnInquiryInfoReadingLoggingParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // 問い合せ詳細閲覧情報ログ記録
        cjnInquiryInfoReadingLoggingDao.insertCjnInquiryInfoReadingLogging(paramBean);

    }

}
