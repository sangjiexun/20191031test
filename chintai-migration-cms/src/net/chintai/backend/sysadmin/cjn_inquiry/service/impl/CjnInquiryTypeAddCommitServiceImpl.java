/*
 * $Id: CjnInquiryTypeAddCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者         内容
 * ---------------------------------------------------------
 * 2007/09/23   BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnInquiryTypeAddCommitDao;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryTypeInfo;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryTypeAddCommitService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeAddCommitInServiceBean;

/**
 * CjnInquiryTypeAddCommitService の実装クラス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnInquiryTypeAddCommitServiceImpl implements CjnInquiryTypeAddCommitService {

    /** 問い合せ種別登録DAO */
    private CjnInquiryTypeAddCommitDao typeAddCommitDao;

    /**
     * 問い合せ種別登録DAOを設定します。
     * @param dao
     */
    public void setCjnInquiryTypeAddCommitDao(CjnInquiryTypeAddCommitDao dao) {
        typeAddCommitDao = dao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.CjnInquiryTypeAddCommitService#insertInquiryType(net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeAddCommitInServiceBean)
     */
    public int insertType(CjnInquiryTypeAddCommitInServiceBean bean) {
        CjnInquiryTypeInfo domain = new CjnInquiryTypeInfo();

        try {
            BeanUtils.copyProperties(domain, bean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // 登録処理
        return typeAddCommitDao.insertType(domain);
    }
}
