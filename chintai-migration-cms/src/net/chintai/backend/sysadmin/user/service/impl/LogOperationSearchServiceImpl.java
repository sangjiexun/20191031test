/*
 * $Id: LogOperationSearchServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/16  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.user.dao.LogOperationSearchDao;
import net.chintai.backend.sysadmin.user.dao.LogOperationSearchParamBean;
import net.chintai.backend.sysadmin.user.domain.LogOperation;
import net.chintai.backend.sysadmin.user.service.LogOperationSearchService;
import net.chintai.backend.sysadmin.user.service.bean.LogOperationSearchInServiceBean;
import net.chintai.backend.sysadmin.user.service.bean.LogOperationSearchOutServiceBean;

/**
 * LogOperationService の実装クラス。
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class LogOperationSearchServiceImpl implements LogOperationSearchService {

    /** 操作ログ検索DAO */
    private LogOperationSearchDao logOperationSearchDao = null;

    /**
     * 操作ログDAOを設定します。
     * @param logOperationSearchDao
     */
    public void setLogOperationSearchDao(LogOperationSearchDao logOperationSearchDao) {
        this.logOperationSearchDao = logOperationSearchDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.service.LogOperationService#logOperationSearch(net.chintai.backend.sysadmin.user.service.bean.LogOperationSearchInServiceBean,
     *      net.chintai.backend.sysadmin.common.pager.BasePagerCondition)
     */
    public List<LogOperationSearchOutServiceBean> logOperationSearch(LogOperationSearchInServiceBean inServiceBean,
            BasePagerCondition condition) throws IllegalAccessException, InvocationTargetException {

        // 検索条件をParamBeanに設定
        LogOperationSearchParamBean paramBean = new LogOperationSearchParamBean();
        BeanUtils.copyProperties(paramBean, inServiceBean);

        String authority = inServiceBean.getAuthority();
        String operationIdSearch = inServiceBean.getOperationIdSearch();
        if (StringUtils.isEmpty(operationIdSearch)) {
            paramBean.setOperationIdSearch(authority);
        }

        // 総件数取得
        int resultCnt = logOperationSearchDao.logOperationTotalCount(paramBean);
        condition.setCount(resultCnt);

        List<LogOperationSearchOutServiceBean> rsList = new ArrayList<LogOperationSearchOutServiceBean>();
        List<LogOperation> logOperationList;

        if (resultCnt == 0) {
            return rsList;
        } else {
            // 操作ログ情報リスト取得
            logOperationList = logOperationSearchDao.logOperation(paramBean, condition);
        }

        // offset が総件数より大きい場合、offset-limit を設定
        if (resultCnt <= condition.getOffset()) {
            condition.setOffset(condition.getOffset() - condition.getLimit());
        }

        // 操作ログリストをLogOperationSearchOutServiceBeanに設定
        for (int i = 0; i < logOperationList.size(); i++) {
            LogOperationSearchOutServiceBean outServiceBean = new LogOperationSearchOutServiceBean();
            LogOperation logOperation = (LogOperation) logOperationList.get(i);
            BeanUtils.copyProperties(outServiceBean, logOperation);
            rsList.add(outServiceBean);
        }
        return rsList;
    }
}