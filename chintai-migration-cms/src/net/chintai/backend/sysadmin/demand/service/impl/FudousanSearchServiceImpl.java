/*
 * $Id: FudousanSearchServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/21  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.demand.dao.FudousanSearchDao;
import net.chintai.backend.sysadmin.demand.dao.FudousanSearchParamBean;
import net.chintai.backend.sysadmin.demand.domain.FudousanSearchDomain;
import net.chintai.backend.sysadmin.demand.service.FudousanSearchService;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanSearchInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.FudousanSearchOutServiceBean;

/**
 * FudousanSearchServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanSearchServiceImpl implements FudousanSearchService {

    /** 不動産会社一覧情報検索DAO */
    FudousanSearchDao fudousanSearchDao;

    /**
     * 不動産会社一覧情報検索DAOを設定します。
     * @param fudousanSearchDao 不動産会社一覧情報検索DAO
     */
    public void setFudousanSearchDao(FudousanSearchDao fudousanSearchDao) {
        this.fudousanSearchDao = fudousanSearchDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.FudousanSearchService#getFudousanList(net.chintai.backend.sysadmin.demand.service.bean.FudousanSearchInServiceBean)
     */
    public List<FudousanSearchOutServiceBean> getFudousanList(FudousanSearchInServiceBean inBean,
            BasePagerCondition condition) {

        // 検索条件設定
        FudousanSearchParamBean paramBean = new FudousanSearchParamBean();

        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

//      総件数取得＆設定
        int resultCnt = fudousanSearchDao.selectTotalCount(paramBean);
        condition.setCount(resultCnt);
        // offset が総件数より大きい場合、offset-limit を設定
        if (resultCnt <= condition.getOffset()) {
            condition.setOffset(condition.getOffset() - condition.getLimit());
        }

        // 検索開始
        List<FudousanSearchDomain> rsList = fudousanSearchDao.getFudousanList(paramBean, condition);

        // 戻り値設定
        List<FudousanSearchOutServiceBean> returnList =
                new ArrayList<FudousanSearchOutServiceBean>();

        for (int i = 0; i < rsList.size(); i++) {
            FudousanSearchOutServiceBean rsBean = new FudousanSearchOutServiceBean();
            try {
                BeanUtils.copyProperties(rsBean, rsList.get(i));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            returnList.add(rsBean);
        }

        return returnList;
    }
}
