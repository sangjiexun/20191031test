/*
 * $Id: CjnInquiryTypeAddCommitService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者         内容
 * ---------------------------------------------------------
 * 2007/09/21   BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service;

import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquiryTypeAddCommitInServiceBean;

/**
 * 問い合せ種別の登録を行うサービスクラス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnInquiryTypeAddCommitService {

    /**
     * 問い合せ種別を登録します。
     * @param bean 問い合せ種別情報
     * @return 追加された問い合せ種別のID
     */
    public int insertType(CjnInquiryTypeAddCommitInServiceBean bean);
}
