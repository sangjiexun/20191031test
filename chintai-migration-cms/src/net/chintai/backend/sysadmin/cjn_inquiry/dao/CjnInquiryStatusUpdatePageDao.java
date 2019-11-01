/*
 * $Id: CjnInquiryStatusUpdatePageDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/09/21   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao;

import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryInfo;

/**
 * 問い合せ処理状況更新情報を取得するDao
 * 
 * @author KOJIMA Takanori
 * @author yang-eunmi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnInquiryStatusUpdatePageDao {

    /**
     * 問い合せ処理状況を含む、問い合せの情報を取得します。
     * @param paramBean 検索条件
     * @return 問い合せ情報
     */
    public CjnInquiryInfo selectCjnInquiryInfo(CjnInquiryInfoParamBean paramBean);
}
