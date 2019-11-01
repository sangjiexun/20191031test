/*
 * $Id: CjnLogOperationSearchServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/01  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnLogOperationSearchDao;
import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnLogOperationSearchParamBean;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnLogOperationInfo;
import net.chintai.backend.sysadmin.cjn_inquiry.service.CjnLogOperationSearchService;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnLogOperationSearchInServiceBean;
import net.chintai.backend.sysadmin.cjn_inquiry.service.bean.CjnLogOperationSearchOutServiceBean;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;

import org.apache.commons.beanutils.BeanUtils;

/**
 * CjnLogOperationSearchService の実装クラス。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnLogOperationSearchServiceImpl implements CjnLogOperationSearchService {

    /** GroupList取得用 DAO */
    private CjnLogOperationSearchDao cjnLogOperationSearchDao;

    /**
     * DAOを設定します。
     * @param cjnLogOperationSearchDao
     */
    public void setCjnLogOperationSearchDao(CjnLogOperationSearchDao cjnLogOperationSearchDao) {
        this.cjnLogOperationSearchDao = cjnLogOperationSearchDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.service.CjnLogOperationSearchService#getCjnLogList()
     */
    public List getCjnLogList(CjnLogOperationSearchInServiceBean inServiceBean,
            BasePagerCondition condition) {

        // 検索用データを準備
        CjnLogOperationSearchParamBean paramBean = new CjnLogOperationSearchParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        
        // 検索の結果件数を取得
        int resultCount = cjnLogOperationSearchDao.selectCjnLogCount(paramBean);
        condition.setCount(resultCount);

        // offset が総件数より大きい場合、offset-limit を設定
        if (resultCount <= condition.getOffset()) {
            condition.setOffset(condition.getOffset() - condition.getLimit());
        }

        // 検索実行
        List rsList = cjnLogOperationSearchDao.selectCjnLogList(paramBean, condition);
        List<CjnLogOperationSearchOutServiceBean> cjnLogOperationList =
                new ArrayList<CjnLogOperationSearchOutServiceBean>();

        // 検索結果を取得
        for (int i = 0; i < rsList.size(); i++) {
            CjnLogOperationInfo cjnLogOperationInfo = (CjnLogOperationInfo) rsList.get(i);

            CjnLogOperationSearchOutServiceBean cjnLogOperation =
                    new CjnLogOperationSearchOutServiceBean();
            try {
                BeanUtils.copyProperties(cjnLogOperation, cjnLogOperationInfo);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            cjnLogOperationList.add(cjnLogOperation);
        }
        return cjnLogOperationList;
    }
}
