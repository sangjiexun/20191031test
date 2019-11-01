/*
 * $Id: InquiryLogOperationSearchDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/11  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.shop_inquiry.dao;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.shop_inquiry.domain.InquiryLogOperation;

/**
 * システム操作履歴検索Dao
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface InquiryLogOperationSearchDao {

    public List<InquiryLogOperation> inquiryLogOperationSearch
        (InquiryLogOperationSearchParamBean paramBean, BasePagerCondition condition);
    
    public int inquiryLogOperationTotalList(InquiryLogOperationSearchParamBean paramBean);
}