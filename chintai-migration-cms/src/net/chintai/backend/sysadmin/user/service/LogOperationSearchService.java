/*
 * $Id: LogOperationSearchService.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/16  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.user.service.bean.LogOperationSearchInServiceBean;
import net.chintai.backend.sysadmin.user.service.bean.LogOperationSearchOutServiceBean;

/**
 * 操作ログ検索サービス。
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface LogOperationSearchService {

    /**
     * 物件詳細情報
     * @param inServiceBean
     * @param condition
     * @return List<LogOperationSearchOutServiceBean>
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public List<LogOperationSearchOutServiceBean> logOperationSearch(
            LogOperationSearchInServiceBean inServiceBean, BasePagerCondition condition)
            throws IllegalAccessException, InvocationTargetException;
}