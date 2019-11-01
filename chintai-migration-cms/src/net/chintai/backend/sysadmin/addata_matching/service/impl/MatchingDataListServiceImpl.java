/*
 * $Id: MatchingDataListServiceImpl.java 4381 2009-09-08 02:33:31Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/25     BGT)石井       新規作成
 *
 */
package net.chintai.backend.sysadmin.addata_matching.service.impl;

import java.util.ArrayList;
import java.util.List;


import net.chintai.backend.sysadmin.addata_matching.dao.MatchingDataListDao;
import net.chintai.backend.sysadmin.addata_matching.domain.MatchingDataDomain;
import net.chintai.backend.sysadmin.addata_matching.service.MatchingDataListService;
import net.chintai.backend.sysadmin.addata_matching.service.bean.MatchingDataListInServiceBean;
import net.chintai.backend.sysadmin.addata_matching.service.bean.MatchingDataListOutServiceBean;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.common.util.BeanUtilsWrapper;

/**
 * MatchingDataListServiceの実装クラス。
 * @author e-ishii
 * @version $Revision: 4381 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MatchingDataListServiceImpl implements MatchingDataListService {

    /** MatchingDataList取得用 DAO */
    private MatchingDataListDao matchingDataListDao = null;

    /**
     * MatchingDataListDaoを設定する
     * @param MatchingDataListDao
     */
    public void setMatchingDataListDao(MatchingDataListDao matchingDataListDao) {
        this.matchingDataListDao = matchingDataListDao;
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * net.chintai.backend.sysadmin.addata_matching.service.MatchingDataListService
     * #getMatchingDataList()
     */
    public List<MatchingDataListOutServiceBean> getMatchingDataList
        (MatchingDataListInServiceBean inServiceBean,BasePagerCondition condition){

        // 総件数取得
        int resultCnt = matchingDataListDao.matchingDataCount();

        condition.setCount(resultCnt);

        List<MatchingDataListOutServiceBean> rsList =
            new ArrayList<MatchingDataListOutServiceBean>();

        if (resultCnt == 0) {
            return rsList;
        }

        // offset が総件数より大きい場合、offset-limit を設定
        if (resultCnt <= condition.getOffset()) {
            condition.setOffset(condition.getOffset() - condition.getLimit());
        }

        // 照合結果一覧リスト取得
        List<MatchingDataDomain> matchingDataList = matchingDataListDao.matchingDataList(condition);

        // 操作ログリストをLogOperationSearchOutServiceBeanに設定
        for (int i = 0; i < matchingDataList.size(); i++) {
            MatchingDataListOutServiceBean outServiceBean = new MatchingDataListOutServiceBean();
            MatchingDataDomain matchingDataDomain = (MatchingDataDomain) matchingDataList.get(i);
            BeanUtilsWrapper.copyProperties(outServiceBean, matchingDataDomain);
            rsList.add(outServiceBean);
        }
        return rsList;

    }

}
