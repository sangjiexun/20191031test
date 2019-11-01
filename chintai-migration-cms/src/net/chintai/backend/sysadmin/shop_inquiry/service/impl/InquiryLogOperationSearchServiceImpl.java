/*
 * $Id: InquiryLogOperationSearchServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/11  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_inquiry.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.shop_inquiry.dao.InquiryLogOperationSearchDao;
import net.chintai.backend.sysadmin.shop_inquiry.dao.InquiryLogOperationSearchParamBean;
import net.chintai.backend.sysadmin.shop_inquiry.domain.InquiryLogOperation;
import net.chintai.backend.sysadmin.shop_inquiry.service.InquiryLogOperationSearchService;
import net.chintai.backend.sysadmin.shop_inquiry.service.bean.InquiryLogOperationSearchInServiceBean;
import net.chintai.backend.sysadmin.shop_inquiry.service.bean.InquiryLogOperationSearchOutServiceBean;

/**
 * InquiryLogOperationSearchService の実装クラス。
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class InquiryLogOperationSearchServiceImpl implements
        InquiryLogOperationSearchService {

    /** システム操作履歴検索DAOを宣言 */
    private InquiryLogOperationSearchDao inquiryLogOperationSearchDao = null;

    /** システム操作履歴検索DAOを設定 */
    public void setInquiryLogOperationSearchDao(
            InquiryLogOperationSearchDao inquiryLogOperationSearchDao) {
        this.inquiryLogOperationSearchDao = inquiryLogOperationSearchDao;
    }

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.shop_inquiry.service.InquiryLogOperationSearchService#inquiryLogOperationSearch(net.chintai.backend.sysadmin.shop_inquiry.service.bean.InquiryLogOperationSearchInServiceBean, net.chintai.backend.sysadmin.common.pager.BasePagerCondition)
     */
    public List<InquiryLogOperationSearchOutServiceBean> inquiryLogOperationSearch
        (InquiryLogOperationSearchInServiceBean inServiceBean, BasePagerCondition condition)
            throws IllegalAccessException, InvocationTargetException {

        // システム操作履歴検索条件を取得
        InquiryLogOperationSearchParamBean paramBean =
            new InquiryLogOperationSearchParamBean();
        BeanUtils.copyProperties(paramBean, inServiceBean);

        // 検索条件の総件数取得
        int resultCnt = inquiryLogOperationSearchDao.inquiryLogOperationTotalList(paramBean);
        condition.setCount(resultCnt);

        // offset が総件数より大きい場合、offset-limit を設定
        if (resultCnt <= condition.getOffset()) {
            condition.setOffset(condition.getOffset() - condition.getLimit());
        }

        // システム操作履歴検索結果リスト取得
        List<InquiryLogOperation> inquiryLogOperationList = inquiryLogOperationSearchDao.inquiryLogOperationSearch(paramBean, condition);
        List<InquiryLogOperationSearchOutServiceBean> rsList =
            new ArrayList<InquiryLogOperationSearchOutServiceBean>();

        // 取得した検索結果リストが1件以上ある場合
        if (inquiryLogOperationList != null) {
            for(int i = 0; i < inquiryLogOperationList.size(); i++) {
                InquiryLogOperationSearchOutServiceBean outServiceBean =
                    new InquiryLogOperationSearchOutServiceBean();
                BeanUtils.copyProperties(outServiceBean, inquiryLogOperationList.get(i));
                rsList.add(outServiceBean);
            }
        }
        return rsList;
    }
}