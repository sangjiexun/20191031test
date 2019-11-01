/*
 * $Id: InquiryRecentInfoServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_inquiry.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.shop_inquiry.dao.InquiryRecentInfoDao;
import net.chintai.backend.sysadmin.shop_inquiry.dao.InquiryRecentInfoParamBean;
import net.chintai.backend.sysadmin.shop_inquiry.domain.InquiryRecent;
import net.chintai.backend.sysadmin.shop_inquiry.service.InquiryRecentInfoService;
import net.chintai.backend.sysadmin.shop_inquiry.service.bean.InquiryRecentInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_inquiry.service.bean.InquiryRecentInfoOutServiceBean;
import net.chintai.batch.common.util.CryptUtils;

/**
 * InquiryRecentInfoServiceの実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class InquiryRecentInfoServiceImpl implements InquiryRecentInfoService {

    /** 問い合せ履歴詳細DAO */
    InquiryRecentInfoDao inquiryRecentInfoDao = null;

    /**
     * InquiryRecentInfoDaoを設定する
     * @param inquiryRecentInfoDao
     */
    public void setInquiryRecentInfoDao(InquiryRecentInfoDao inquiryRecentInfoDao) {
        this.inquiryRecentInfoDao = inquiryRecentInfoDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_inquiry.service.InquiryRecentInfoService#inquiryRecentInfo(net.chintai.backend.sysadmin.shop_inquiry.service.bean.InquiryRecentInfoInServiceBean)
     */
    public InquiryRecentInfoOutServiceBean inquiryRecentInfo(
            InquiryRecentInfoInServiceBean inServiceBean) {
        // 問い合せIDをParamBeanに設定
        InquiryRecentInfoParamBean paramBean = new InquiryRecentInfoParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // 問い合せ履歴詳細情報を取得
        InquiryRecent inquiryRecent =
            inquiryRecentInfoDao.inquiryRecentInfo(paramBean);
        //複合化
        inquiryRecent.setPassword(CryptUtils.decypt(inquiryRecent.getPassword()));

        // 取得した情報をOutServiceBeanに設定
        InquiryRecentInfoOutServiceBean outServiceBean =
            new InquiryRecentInfoOutServiceBean();
        try {
            BeanUtils.copyProperties(outServiceBean, inquiryRecent);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return outServiceBean;
    }
}