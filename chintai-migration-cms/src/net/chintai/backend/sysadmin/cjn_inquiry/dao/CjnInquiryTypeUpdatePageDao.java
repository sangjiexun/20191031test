/*
 * $Id: CjnInquiryTypeUpdatePageDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/09/21   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao;

import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquiryTypeInfo;

/**
 * 問い合せ種別更新情報を取得するDAO。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnInquiryTypeUpdatePageDao {

    /**
     * 問い合せ種別更新情報を取得します。
     * @param param 検索パラメータ
     * @return 問い合せ種別更新情報
     */
    public CjnInquiryTypeInfo selectTypeUpdatePage(CjnInquiryTypeUpdatePageParamBean param);
}
