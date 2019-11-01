/*
 * $Id: CjnInquiryTypeUpdateCommitService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者         内容
 * ---------------------------------------------------------
 * 2007/09/21   BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service;

import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeUpdateCommitInServiceBean;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;

/**
 * 問い合せ種別を更新するサービス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnInquiryTypeUpdateCommitService {

    /**
     * 問い合せ種別を更新します。
     * @param bean 更新情報
     * @throws ApplicationException 更新結果が0件だったとき
     */
    public void updateType(CjnInquiryTypeUpdateCommitInServiceBean bean) throws ApplicationException;
}
