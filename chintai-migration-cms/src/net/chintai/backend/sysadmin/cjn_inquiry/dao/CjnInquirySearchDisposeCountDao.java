/*
 * $Id: CjnInquirySearchDisposeCountDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/09/21   BGT)児島      新規作成
 * 2007/10/05   BGT)楊恩美    更新
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao;

import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnInquirySearchDisposeCountInfo;

/**
 * 問い合せ処理件数取得DAO。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnInquirySearchDisposeCountDao {

    /**
     * 問い合せ処理件数を取得します。
     * @param paramBean 検索パラメータ
     * @return 処理件数リスト
     */
    public CjnInquirySearchDisposeCountInfo selectDisposeCountList(CjnInquirySearchDisposeCountPageParamBean paramBean);
}
