/*
 * $Id: LogOperationSearchDao.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/16  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao;

import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.user.domain.LogOperation;

/**
 * 操作ログ検索Dao
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface LogOperationSearchDao {
    
    public List<LogOperation> logOperation
        (LogOperationSearchParamBean paramBean, BasePagerCondition condition);

    public int logOperationTotalCount(LogOperationSearchParamBean paramBean);
}