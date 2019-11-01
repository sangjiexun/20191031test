/*
 * $Id: CjnInquirySearchDisposeCountServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/05  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.impl;

import java.lang.reflect.InvocationTargetException;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquirySearchDisposeCountDao;
import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquirySearchDisposeCountPageParamBean;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquirySearchDisposeCountInfo;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquirySearchDisposeCountService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquirySearchDisposeCountOutServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquirySearchDisposeCountPageInServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * CjnInquirySearchDisposeCountServiceの実装クラス
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquirySearchDisposeCountServiceImpl implements CjnInquirySearchDisposeCountService {

    /** 問い合せ処理件数取得DAO */
    private CjnInquirySearchDisposeCountDao disposeCountDao;

    /** 問い合せ処理件数取得DAOを設定します。 */
    public void setCjnInquirySearchDisposeCountDao(CjnInquirySearchDisposeCountDao disposeCountDao) {
        this.disposeCountDao = disposeCountDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquirySearchDisposeCountService#selectDisposeCountList(net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquirySearchDisposeCountPageParamBean)
     */
    public CjnInquirySearchDisposeCountOutServiceBean selectDisposeCountList(
                CjnInquirySearchDisposeCountPageInServiceBean inServiceBean) {

        // 検索条件を取得(sequenceを取得)
        CjnInquirySearchDisposeCountPageParamBean paramBean = new CjnInquirySearchDisposeCountPageParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // 件数を照会
        CjnInquirySearchDisposeCountOutServiceBean outBean = new CjnInquirySearchDisposeCountOutServiceBean();
        CjnInquirySearchDisposeCountInfo countDomain = disposeCountDao.selectDisposeCountList(paramBean);

        if (countDomain != null) {
            try {
                BeanUtils.copyProperties(outBean, countDomain);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return outBean;
    }
}
