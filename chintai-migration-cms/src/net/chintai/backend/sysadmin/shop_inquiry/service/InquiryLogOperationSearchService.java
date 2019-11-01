/*
 * $Id: InquiryLogOperationSearchService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/11  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_inquiry.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.shop_inquiry.service.bean.InquiryLogOperationSearchInServiceBean;
import net.chintai.backend.sysadmin.shop_inquiry.service.bean.InquiryLogOperationSearchOutServiceBean;

/**
 * システム操作履歴検索サービス。
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface InquiryLogOperationSearchService {

    /**
     * システム操作履歴検索
     * 
     * @param inServiceBean 検索条件
     * @param condition ページング情報
     * @return システム操作履歴検索結果リスト
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public List<InquiryLogOperationSearchOutServiceBean> inquiryLogOperationSearch(
            InquiryLogOperationSearchInServiceBean inServiceBean, BasePagerCondition condition)
            throws IllegalAccessException, InvocationTargetException;
}