/*
 * $Id: TorihikisakiSearchServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/15  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiSearchDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiSearchParamBean;
import net.chintai.backend.sysadmin.demand.domain.TorihikisakiSearchDomain;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiSearchService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiSearchInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiSearchOutServiceBean;


/**
 * TorihikisakiSearchServiceの実装クラス
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiSearchServiceImpl implements TorihikisakiSearchService {

    /** 取引先検索DAO */
    private TorihikisakiSearchDao torihikisakiSearchDao;

    /**
     * 取引先検索DAOを設定します。
     * @param torihikisakiSearchDao 取引先検索DAO
     */
    public void setTorihikisakiSearchDao(TorihikisakiSearchDao torihikisakiSearchDao) {
        this.torihikisakiSearchDao = torihikisakiSearchDao;
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.TorihikisakiSearchService#getTorihikisakiList(net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiSearchInServiceBean)
     */
    public List<TorihikisakiSearchOutServiceBean> getTorihikisakiList(
            TorihikisakiSearchInServiceBean inBean, BasePagerCondition condition) {

        // 検索条件設定
        TorihikisakiSearchParamBean paramBean = new TorihikisakiSearchParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // 総件数取得＆設定
        int resultCnt = torihikisakiSearchDao.selectTotalCount(paramBean);
        condition.setCount(resultCnt);
        // offset が総件数より大きい場合、offset-limit を設定
        if (resultCnt <= condition.getOffset()) {
            condition.setOffset(condition.getOffset() - condition.getLimit());
        }

        // 検索開始
        List<TorihikisakiSearchDomain> rsList =
                torihikisakiSearchDao.getTorihikisaki(paramBean, condition);

        // 戻り値設定
        List<TorihikisakiSearchOutServiceBean> returnList =
                    new ArrayList<TorihikisakiSearchOutServiceBean>();
        for (int i=0; i < rsList.size(); i++) {
            TorihikisakiSearchOutServiceBean rsBean = new TorihikisakiSearchOutServiceBean();
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
