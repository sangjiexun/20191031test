/*
 * $Id: CjnInquiryTypeUpdatePageService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/21  BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service;

import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeUpdatePageInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeUpdatePageOutServiceBean;

/**
 * 問い合せ種別更新画面の情報を取得するサービス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnInquiryTypeUpdatePageService {

    /**
     * 問い合せ種別更新画面の情報を取得します。
     * @param bean 検索パラメータ
     * @return 問い合せ種別更新画面の情報
     */
    public CjnInquiryTypeUpdatePageOutServiceBean
                selectTypeUpdatePage(CjnInquiryTypeUpdatePageInServiceBean bean);
}
