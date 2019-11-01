/*
 * $Id: TetudoGaishaSearchServiceImpl.java 4076 2008-11-19 09:33:13Z m-ono $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2008/10/08  BGT)長谷川正一 新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;
import net.chintai.backend.sysadmin.master.dao.TetudoGaishaSearchDao;
import net.chintai.backend.sysadmin.master.dao.TetudoGaishaSearchParamBean;
import net.chintai.backend.sysadmin.master.domain.TetudoGaishaInfo;
import net.chintai.backend.sysadmin.master.service.TetudoGaishaSearchService;
import net.chintai.backend.sysadmin.master.service.bean.TetudoGaishaInSearchrviceBean;
import net.chintai.backend.sysadmin.master.service.bean.TetudoGaishaOutSearchServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * TetudoGaishaSearchServiceの実装クラス
 * 
 * @author S.HASEGAWA
 * @version $Revision: 4076 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public class TetudoGaishaSearchServiceImpl implements TetudoGaishaSearchService {

    /** 鉄道会社検索DAO */
    private TetudoGaishaSearchDao tetudoGaishaSearchDao = null;

    public void setTetudoGaishaSearchDao(TetudoGaishaSearchDao tetudoGaishaSearchDao) {
        this.tetudoGaishaSearchDao = tetudoGaishaSearchDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.service.TetudoGaishaSearchService#tetudoGaishaSearch(net.chintai.backend.sysadmin.master.service.bean.TetudoGaishaInSearchrviceBean,
     *      net.chintai.backend.sysadmin.common.pager.BasePagerCondition)
     */
    public List<TetudoGaishaOutSearchServiceBean> tetudoGaishaSearch(TetudoGaishaInSearchrviceBean inServiceBean,
            BasePagerCondition condition) throws Exception {

        // 鉄道会社検索ParamBean
        TetudoGaishaSearchParamBean paramBean = new TetudoGaishaSearchParamBean();
        try {
            // 検索条件を鉄道会社検索ParamBeanに設定する。
            BeanUtils.copyProperties(paramBean, inServiceBean);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        // 検索条件に合致する鉄道会社数を取得する。
        int resultCount = tetudoGaishaSearchDao.selectTetudoGaishaCount(paramBean);

        // 鉄道会社数をページングデータに設定する。
        condition.setCount(resultCount);

        // 取得した鉄道会社数が鉄道会社の取得開始位置より小さかった場合、取得開始位置を補正する
        if (resultCount <= condition.getOffset()) {
            condition.setOffset(condition.getOffset() - condition.getLimit());
        }
        // 検索条件に合致する鉄道会社情報一覧を取得する。
        List rsTetudoGaishaList = tetudoGaishaSearchDao.selectTetudoGaishaList(paramBean, condition);

        // 鉄道会社情報Beanリスト
        List<TetudoGaishaOutSearchServiceBean> tetudoGaishaInfoList = new ArrayList<TetudoGaishaOutSearchServiceBean>();

        // 取得した鉄道会社情報一覧を鉄道会社情報Beanリストに設定する。
        for (int i = 0; i < rsTetudoGaishaList.size(); i++) {

            TetudoGaishaInfo tetudoGaishaInfo = (TetudoGaishaInfo) rsTetudoGaishaList.get(i);
            TetudoGaishaOutSearchServiceBean outSearchServiceBean = new TetudoGaishaOutSearchServiceBean();
            try {
                BeanUtils.copyProperties(outSearchServiceBean, tetudoGaishaInfo);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            tetudoGaishaInfoList.add(outSearchServiceBean);
        }
        return tetudoGaishaInfoList;
    }
}
