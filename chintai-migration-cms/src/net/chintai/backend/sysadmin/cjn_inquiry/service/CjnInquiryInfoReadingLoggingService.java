/*
 * $Id: CjnInquiryInfoReadingLoggingService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/08  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service;

import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryInfoInServiceBean;

/**
 * 問い合せ詳細情報閲覧ログ記録Service
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnInquiryInfoReadingLoggingService {

    /**
     * 問い合せ詳細情報閲覧時に閲覧者、閲覧時刻を記録します。
     * @param inServiceBean 記録する情報
     */
    public void write(CjnInquiryInfoInServiceBean inServiceBean);

}
