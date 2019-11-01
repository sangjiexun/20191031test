/*
 * $Id: TorihikisakiWakuInfoAddCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/09  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoAddCommitDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoAddCommitParamBean;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiWakuInfoAddCommitService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoAddCommitInServiceBean;

/**
 * TorihikisakiWakuInfoAddCommitServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuInfoAddCommitServiceImpl implements
        TorihikisakiWakuInfoAddCommitService {

    /** 取引先物件枠設定情報更新DAO */
    TorihikisakiWakuInfoAddCommitDao torihikisakiWakuInfoAddCommitDao;

    /**
     * 取引先物件枠設定情報更新DAOを設定します。
     * @param torihikisakiWakuInfoAddCommitDao 取引先物件枠設定情報更新DAO
     */
    public void setTorihikisakiWakuInfoAddCommitDao(
            TorihikisakiWakuInfoAddCommitDao torihikisakiWakuInfoAddCommitDao) {
        this.torihikisakiWakuInfoAddCommitDao = torihikisakiWakuInfoAddCommitDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.TorihikisakiWakuInfoAddCommitService#insertTorihikisakiWakuInfo(net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoAddCommitInServiceBean)
     */
    public void insertTorihikisakiWakuInfo(TorihikisakiWakuInfoAddCommitInServiceBean inBean)
            throws ApplicationException {

        TorihikisakiWakuInfoAddCommitParamBean paramBean =
                new TorihikisakiWakuInfoAddCommitParamBean();

        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        try {
            torihikisakiWakuInfoAddCommitDao.insertTorihikisakiWakuInfo(paramBean);
        } catch (Exception e) {
            throw new ApplicationException("ERROR.M.DEMAND.0119");
        }

        // 登録後処理として取引先テーブルの最終更新日付を更新
        int torihikisakiUpdateCnt = torihikisakiWakuInfoAddCommitDao.updateTorihikisakiUpdDt(paramBean);

        if (torihikisakiUpdateCnt != 1) {
            throw new ApplicationException("ERROR.M.DEMAND.0119");
        }
    }
}
