/*
 * $Id: CjnInquirySearchService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/21  BGT)児島       新規作成
 * 2007/10/05  BGT)楊恩美     実装
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service;

import java.util.List;

import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquirySearchInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnInquirySearchOutServiceBean;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;

/**
 * 問い合せ検索Service
 * 
 * @author KOJIMA Takanori
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnInquirySearchService {

    /**
     * 問い合せを検索します。
     * @param inServiceBean 検索条件
     * @param condition 検索結果のページング条件
     * @return 検索結果一覧
     */
    public List<CjnInquirySearchOutServiceBean>
                cjnInquirySearch(CjnInquirySearchInServiceBean inServiceBean, BasePagerCondition condition);
}
