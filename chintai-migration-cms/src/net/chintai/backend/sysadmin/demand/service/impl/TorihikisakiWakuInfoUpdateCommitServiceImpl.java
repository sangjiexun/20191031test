/*
 * $Id: TorihikisakiWakuInfoUpdateCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/10  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoUpdateCommitDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoUpdateCommitParamBean;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiWakuInfoUpdateCommitService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoUpdateCommitInServiceBean;

/**
 * TorihikisakiWakuInfoUpdateCommitServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuInfoUpdateCommitServiceImpl implements
        TorihikisakiWakuInfoUpdateCommitService {

    /** 取引先物件枠設定情報更新DAO */
    TorihikisakiWakuInfoUpdateCommitDao torihikisakiWakuInfoUpdateCommitDao;

    /**
     * 取引先物件枠設定情報更新DAOを設定します。
     * @param torihikisakiWakuInfoUpdateCommitDao 取引先物件枠設定情報更新DAO
     */
    public void setTorihikisakiWakuInfoUpdateCommitDao(TorihikisakiWakuInfoUpdateCommitDao torihikisakiWakuInfoUpdateCommitDao) {
        this.torihikisakiWakuInfoUpdateCommitDao = torihikisakiWakuInfoUpdateCommitDao;
    }


    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.TorihikisakiWakuInfoUpdateCommitService#updateTorihikisakiWakuInfo(net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoUpdateCommitInServiceBean)
     */
    public void updateTorihikisakiWakuInfo(TorihikisakiWakuInfoUpdateCommitInServiceBean inBean)
            throws ApplicationException {

        TorihikisakiWakuInfoUpdateCommitParamBean paramBean =
                new TorihikisakiWakuInfoUpdateCommitParamBean();

        try {
            BeanUtils.copyProperties(paramBean, inBean);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        int updateCnt = torihikisakiWakuInfoUpdateCommitDao.updateTorihikisakiWakuInfo(paramBean);

        if (updateCnt != 1) {
            throw new ApplicationException("ERROR.M.DEMAND.0119");
        }

        // 更新後処理として取引先テーブルの最終更新日付を更新
        int torihikisakiUpdateCnt = torihikisakiWakuInfoUpdateCommitDao.updateTorihikisakiUpdDt(paramBean);

        if (torihikisakiUpdateCnt != 1) {
            throw new ApplicationException("ERROR.M.DEMAND.0119");
        }
    }
}
