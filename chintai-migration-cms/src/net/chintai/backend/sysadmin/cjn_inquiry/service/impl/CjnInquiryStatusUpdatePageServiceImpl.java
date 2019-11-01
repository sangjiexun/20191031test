/*
 * $Id: CjnInquiryStatusUpdatePageServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.impl;

import java.lang.reflect.InvocationTargetException;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryInfoParamBean;
import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryStatusUpdatePageDao;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryInfo;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryStatusUpdatePageService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryStatusUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryStatusUpdatePageOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * CjnInquiryStatusUpdatePageServiceの実装クラス
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryStatusUpdatePageServiceImpl implements CjnInquiryStatusUpdatePageService {

    /** 問い合せ状況変更Dao宣言 */
    public CjnInquiryStatusUpdatePageDao cjnInquiryStatusUpdatePageDao = null;

    /** 問い合せ状況変更Dao設定 */
    public void setCjnInquiryStatusUpdatePageDao(
            CjnInquiryStatusUpdatePageDao cjnInquiryStatusUpdatePageDao) {
        this.cjnInquiryStatusUpdatePageDao = cjnInquiryStatusUpdatePageDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryStatusUpdatePageService#selectCjnInquiryStatusUpdate(net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryStatusUpdatePageInServiceBean)
     */
    public CjnInquiryStatusUpdatePageOutServiceBean selectCjnInquiryStatusUpdate(
            CjnInquiryStatusUpdatePageInServiceBean inServiceBean) {

        // 問い合せ詳細条件
        CjnInquiryInfoParamBean paramBean = new CjnInquiryInfoParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // 問い合せ詳細情報取得
        CjnInquiryInfo infoDomain = cjnInquiryStatusUpdatePageDao.selectCjnInquiryInfo(paramBean);
        CjnInquiryStatusUpdatePageOutServiceBean outServiceBean = new CjnInquiryStatusUpdatePageOutServiceBean();
        try {
            BeanUtils.copyProperties(outServiceBean, infoDomain);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return outServiceBean;
    }

}
