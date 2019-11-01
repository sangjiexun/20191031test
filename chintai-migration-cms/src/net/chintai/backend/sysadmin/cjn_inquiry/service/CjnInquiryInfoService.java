/*
 * $Id: CjnInquiryInfoService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/21     BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service;

import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryInfoInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryInfoOutServiceBean;

/**
 * 問い合せ詳細Service
 * 
 * @author KOJIMA Takanori
 * @author Yang EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnInquiryInfoService {

    /**
     * 問い合せ詳細を取得します。
     * @param inServiceBean 検索パラメータ
     * @return 問い合せ詳細
     */
    public CjnInquiryInfoOutServiceBean cjnInquiryInfo(CjnInquiryInfoInServiceBean inServiceBean);
}
