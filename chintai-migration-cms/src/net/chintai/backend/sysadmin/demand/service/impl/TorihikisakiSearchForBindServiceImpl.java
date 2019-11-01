/*
 * $Id: TorihikisakiSearchForBindServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/20  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiSearchForBindDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiSearchForBindParamBean;
import net.chintai.backend.sysadmin.demand.domain.TorihikisakiSearchForBindDomain;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiSearchForBindService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiSearchForBindInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiSearchForBindOutServiceBean;

/**
 * TorihikisakiSearchForBindServiceの実装クラス
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiSearchForBindServiceImpl implements TorihikisakiSearchForBindService {

    /** 取引先検索DAO */
    private TorihikisakiSearchForBindDao torihikisakiSearchForBindDao;

    /**
     * 取引先検索DAOを設定します。
     * @param torihikisakiSearchForBindDao 取引先検索DAO
     */
    public void setTorihikisakiSearchForBindDao(TorihikisakiSearchForBindDao torihikisakiSearchForBindDao) {
        this.torihikisakiSearchForBindDao = torihikisakiSearchForBindDao;
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.TorihikisakiSearchForBindService#getTorihikisakiList(net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiSearchForBindInServiceBean)
     */
    public List<TorihikisakiSearchForBindOutServiceBean> getTorihikisakiList(
            TorihikisakiSearchForBindInServiceBean inBean, BasePagerCondition condition) {

        // 検索条件設定
        TorihikisakiSearchForBindParamBean paramBean = new TorihikisakiSearchForBindParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // 総件数取得＆設定
        int resultCnt = torihikisakiSearchForBindDao.selectTotalCount(paramBean);
        condition.setCount(resultCnt);
        // offset が総件数より大きい場合、offset-limit を設定
        if (resultCnt <= condition.getOffset()) {
            condition.setOffset(condition.getOffset() - condition.getLimit());
        }

        // 検索開始
        List<TorihikisakiSearchForBindDomain> rsList =
                torihikisakiSearchForBindDao.getTorihikisaki(paramBean, condition);

        // 戻り値設定
        List<TorihikisakiSearchForBindOutServiceBean> returnList =
                    new ArrayList<TorihikisakiSearchForBindOutServiceBean>();
        for (int i=0; i < rsList.size(); i++) {
            TorihikisakiSearchForBindOutServiceBean rsBean = new TorihikisakiSearchForBindOutServiceBean();
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