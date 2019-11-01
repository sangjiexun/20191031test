/*
 * $Id: InquiryRecentInfoService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_inquiry.service;

import net.chintai.backend.sysadmin.shop_inquiry.service.bean.InquiryRecentInfoInServiceBean;
import net.chintai.backend.sysadmin.shop_inquiry.service.bean.InquiryRecentInfoOutServiceBean;

/**
 * 問い合せ履歴詳細サービスクラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface InquiryRecentInfoService {

    /**
     * 問い合せ履歴詳細
     * @return InquiryRecentInfoOutServiceBean
     * @param inServiceBean
     */
    public InquiryRecentInfoOutServiceBean
        inquiryRecentInfo(InquiryRecentInfoInServiceBean inServiceBean);
}