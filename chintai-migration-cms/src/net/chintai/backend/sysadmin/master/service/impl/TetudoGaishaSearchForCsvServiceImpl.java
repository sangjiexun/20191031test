/*
 * $Id: TetudoGaishaSearchForCsvServiceImpl.java 4076 2008-11-19 09:33:13Z m-ono $
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

import net.chintai.backend.sysadmin.master.dao.TetudoGaishaSearchDao;
import net.chintai.backend.sysadmin.master.dao.TetudoGaishaSearchParamBean;
import net.chintai.backend.sysadmin.master.domain.TetudoGaishaInfo;
import net.chintai.backend.sysadmin.master.service.TetudoGaishaSearchForCsvService;
import net.chintai.backend.sysadmin.master.service.bean.TetudoGaishaInSearchrviceBean;
import net.chintai.backend.sysadmin.master.service.bean.TetudoGaishaOutSearchServiceBean;

import org.apache.commons.beanutils.BeanUtils;

/**
 * TetudoGaishaSearchForCsvServiceの実装クラス
 * 
 * @author S.HASEGAWA
 * @version $Revision: 4076 $ Copyright: (C) CHINTAI Corporation All Right
 *          Reserved.
 */
public class TetudoGaishaSearchForCsvServiceImpl implements TetudoGaishaSearchForCsvService {

    /** 鉄道会社検索DAO */
    private TetudoGaishaSearchDao tetudoGaishaSearchDao = null;

    public void setTetudoGaishaSearchDao(TetudoGaishaSearchDao tetudoGaishaSearchDao) {
        this.tetudoGaishaSearchDao = tetudoGaishaSearchDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.service.TetudoGaishaSearchForCsvService#tetudoGaishaSearchForCsv(net.chintai.backend.sysadmin.master.service.bean.TetudoGaishaInSearchrviceBean)
     */
    public List<TetudoGaishaOutSearchServiceBean> tetudoGaishaSearchForCsv(TetudoGaishaInSearchrviceBean inServiceBean)
            throws Exception {

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

        // 検索条件に合致する鉄道会社情報一覧を取得する。
        List rsTetudoGaishaList = tetudoGaishaSearchDao.selectTetudoGaishaForCsv(paramBean);

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
