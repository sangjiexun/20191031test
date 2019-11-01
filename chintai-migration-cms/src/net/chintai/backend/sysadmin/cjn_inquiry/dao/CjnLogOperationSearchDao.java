/*
 * $Id: CjnLogOperationSearchDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/09/21   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;

/**
 * システム操作履歴のDAO。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface CjnLogOperationSearchDao {

    /**
     * システム操作履歴の件数を取得します。
     * @param paramBean 検索条件
     * @return 検索件数
     */
    public int selectCjnLogCount(CjnLogOperationSearchParamBean paramBean);

    /**
     * システム操作履歴を取得します。
     * @param paramBean 検索条件
     * @return システム操作履歴リスト
     */
    public List selectCjnLogList(CjnLogOperationSearchParamBean paramBean,
            BasePagerCondition condition);
}
