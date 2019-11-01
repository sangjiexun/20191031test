/*
 * $Id: CjnInquiryStatusUpdateCommitService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/21  BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service;

import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryStatusUpdateCommitInServiceBean;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;

/**
 * 問い合せ処理状況更新サービス
 * 
 * @author KOJIMA Takanori
 * @author yang-eunmi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnInquiryStatusUpdateCommitService {

    /**
     * 問い合せ処理状況更新
     * @param inServicebean 更新情報
     * @throws ApplicationException
     */
    public void cjnInquiryStatusUpdateCommit(CjnInquiryStatusUpdateCommitInServiceBean inServicebean)
            throws ApplicationException;

}
