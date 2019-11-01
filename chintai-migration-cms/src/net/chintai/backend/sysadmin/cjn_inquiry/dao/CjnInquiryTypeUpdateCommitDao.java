/*
 * $Id: CjnInquiryTypeUpdateCommitDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者         内容
 * ---------------------------------------------------------
 * 2007/09/21   BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao;

import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryTypeInfo;

/**
 * 問い合せ種別を更新するDAO。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnInquiryTypeUpdateCommitDao {

    /**
     * 問い合せ種別を更新します。
     * @param domain 問い合せ種別の更新情報
     * @return 更新結果行数
     */
    public int updateType(CjnInquiryTypeInfo domain);
}
