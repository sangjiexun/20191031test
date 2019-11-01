/*
 * $Id: CjnInquiryInfoReadingLoggingDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/08  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao;

/**
 * 問い合せ詳細情報閲覧ログ記録DAO
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnInquiryInfoReadingLoggingDao {

    /**
     * 問い合せ詳細情報閲覧ログ記録Insert
     * 
     * @param paramBean
     */
    public void insertCjnInquiryInfoReadingLogging(CjnInquiryInfoReadingLoggingParamBean paramBean);

}
