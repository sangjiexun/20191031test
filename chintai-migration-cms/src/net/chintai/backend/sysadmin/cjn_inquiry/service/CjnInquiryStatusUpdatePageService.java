/*
 * $Id: CjnInquiryStatusUpdatePageService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/21  BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service;

import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryStatusUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryStatusUpdatePageOutServiceBean;

/**
 * 問い合せ状況変更情報取得Service
 * 
 * @author KOJIMA Takanori
 * @author yang-eunmi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnInquiryStatusUpdatePageService {

    /**
     * 問い合せ詳細を取得します。
     * @param inServiceBean 検索パラメータ
     * @return 問い合せ詳細
     */
    public CjnInquiryStatusUpdatePageOutServiceBean selectCjnInquiryStatusUpdate(
            CjnInquiryStatusUpdatePageInServiceBean inServiceBean);
}
