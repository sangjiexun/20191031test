/*
 * $Id: InquiryRecentSearchService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/09  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_inquiry.service;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.shop_inquiry.service.bean.InquiryRecentSearchInServiceBean;

/**
 * 問い合せ情報検索サービス。
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface InquiryRecentSearchService {

    /**
     * 物件詳細情報
     * 
     * @param inServiceBean 検索条件
     * @param condition ページング情報
     * @return 問い合せ情報リスト
     */
    public List inquiryRecentSearch(
            InquiryRecentSearchInServiceBean inServiceBean, BasePagerCondition condition);
}
