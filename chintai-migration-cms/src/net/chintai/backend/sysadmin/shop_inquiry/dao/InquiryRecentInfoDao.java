/*
 * $Id: InquiryRecentInfoDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_inquiry.dao;

import net.chintai.backend.sysadmin.shop_inquiry.domain.InquiryRecent;

/**
 * 問い合せ履歴詳細DAO
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface InquiryRecentInfoDao {

    /**
     * 問い合せ履歴詳細
     * @param paramBean
     * @return InquiryRecent
     */
    public InquiryRecent inquiryRecentInfo(InquiryRecentInfoParamBean paramBean);
}