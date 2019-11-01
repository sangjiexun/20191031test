/*
 * $Id: TorihikisakiListServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
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
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiListDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiListParamBean;
import net.chintai.backend.sysadmin.demand.domain.TorihikisakiListDomain;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiListService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiListInServiceBean;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiListOutServiceBean;

/**
 * TorihikisakiListServiceの実装クラス
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiListServiceImpl implements TorihikisakiListService {

    /** 取引先一覧CSV出力用データ取得DAO */
    TorihikisakiListDao torihikisakiListDao;

    /**
     * 取引先一覧CSV出力用データ取得DAOを設定します。
     * @param torihikisakiListDao 取引先一覧CSV出力用データ取得DAO
     */
    public void setTorihikisakiListDao(TorihikisakiListDao torihikisakiListDao) {
        this.torihikisakiListDao = torihikisakiListDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.TorihikisakiListService#getTorihikisakiList(net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiListInServiceBean)
     */
    public List<TorihikisakiListOutServiceBean> getTorihikisakiList(
            TorihikisakiListInServiceBean inBean, BasePagerCondition condition) {

        TorihikisakiListParamBean paramBean = new TorihikisakiListParamBean();
        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        List<TorihikisakiListDomain> rsList;

        if("csv".equals(inBean.getOutPut())){

            rsList = torihikisakiListDao.getTorihikisakiList(paramBean);
        } else {

            int resultCnt = torihikisakiListDao.selectTotalCount(paramBean);
            condition.setCount(resultCnt);

            // offset が総件数より大きい場合、offset-limit を設定
            if (resultCnt <= condition.getOffset()) {
                condition.setOffset(condition.getOffset() - condition.getLimit());
            }

            // 検索開始
            rsList = torihikisakiListDao.getTorihikisakiList(paramBean, condition);
        }

        List<TorihikisakiListOutServiceBean> returnList = new ArrayList<TorihikisakiListOutServiceBean>();
        for(int i = 0; i<rsList.size(); i++){
            TorihikisakiListOutServiceBean outBean = new TorihikisakiListOutServiceBean();
            try {
                BeanUtils.copyProperties(outBean, rsList.get(i));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
            returnList.add(outBean);
        }

        return returnList;
    }
}
