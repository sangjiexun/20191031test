/*
 * $Id: CjnInquiryInfoServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.impl;

import java.lang.reflect.InvocationTargetException;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryInfoDao;
import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryInfoParamBean;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryInfo;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryInfoService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryInfoInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryInfoOutServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * CjnInquiryInfoServiceの実装クラス
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryInfoServiceImpl implements CjnInquiryInfoService {

    /** 問い合せ詳細DAOを宣言 */
    public CjnInquiryInfoDao cjnInquiryInfoDao = null;

    /** 問い合せ詳細DAO設定 */
    public void setCjnInquiryInfoDao(CjnInquiryInfoDao cjnInquiryInfoDao) {
        this.cjnInquiryInfoDao = cjnInquiryInfoDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryInfoService#cjnInquiryInfo(net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryDetailInfoInServiceBean)
     */
    public CjnInquiryInfoOutServiceBean cjnInquiryInfo(
            CjnInquiryInfoInServiceBean inServiceBean) {

        // 問い合せ詳細取得の条件
        CjnInquiryInfoParamBean paramBean = new CjnInquiryInfoParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        // 閲覧状況更新
        cjnInquiryInfoDao.updateRefFlg(paramBean);

        // 問い合せ詳細取得
        CjnInquiryInfo infoDomain = cjnInquiryInfoDao.selectCjnInquiryInfo(paramBean);
        CjnInquiryInfoOutServiceBean outServiceBean = new CjnInquiryInfoOutServiceBean();
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
