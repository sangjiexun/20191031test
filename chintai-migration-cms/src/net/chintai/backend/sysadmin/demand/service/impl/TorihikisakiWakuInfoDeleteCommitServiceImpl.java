/*
 * $Id: TorihikisakiWakuInfoDeleteCommitServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/10  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoDeleteCommitDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoDeleteCommitParamBean;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiWakuInfoDeleteCommitService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoDeleteCommitInServiceBean;

/**
 * TorihikisakiWakuInfoDeleteCommitServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuInfoDeleteCommitServiceImpl implements
        TorihikisakiWakuInfoDeleteCommitService {

    /** 取引先物件枠設定情報削除DAO */
    TorihikisakiWakuInfoDeleteCommitDao torihikisakiWakuInfoDeleteCommitDao;

    /**
     * 取引先物件枠設定情報削除DAOを設定します。
     * @param torihikisakiWakuInfoDeleteCommitDao 取引先物件枠設定情報削除DAO
     */
    public void setTorihikisakiWakuInfoDeleteCommitDao(
            TorihikisakiWakuInfoDeleteCommitDao torihikisakiWakuInfoDeleteCommitDao) {
        this.torihikisakiWakuInfoDeleteCommitDao = torihikisakiWakuInfoDeleteCommitDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.TorihikisakiWakuInfoDeleteCommitService#deleteWakuInfo(net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiWakuInfoDeleteCommitInServiceBean)
     */
    public void deleteWakuInfo(TorihikisakiWakuInfoDeleteCommitInServiceBean inBean)
            throws ApplicationException {

        TorihikisakiWakuInfoDeleteCommitParamBean paramBean =
                new TorihikisakiWakuInfoDeleteCommitParamBean();
        String[] delFlgList = inBean.getDelFlgList();

        for (int i = 0; i < delFlgList.length; i++) {
            paramBean.setTorihikisakiSeq(inBean.getTorihikisakiSeq());
            paramBean.setDelFlg(delFlgList[i]);
            paramBean.setUpdId(inBean.getUpdId());
            paramBean.setUpdPg(inBean.getUpdPg());
            paramBean.setTorihikisakiUpdDt(inBean.getTorihikisakiUpdDt());

            int deleteCnt = torihikisakiWakuInfoDeleteCommitDao.deleteWakuInfo(paramBean);

            if (deleteCnt == 0) {
                throw new ApplicationException("ERROR.M.DEMAND.0121");
            }
        }
        // 削除処理後処理として取引先テーブルの最終更新日付を更新
        int torihikisakiUpdateCnt = torihikisakiWakuInfoDeleteCommitDao.updateTorihikisakiUpdDt(paramBean);

        if (torihikisakiUpdateCnt != 1) {
            throw new ApplicationException("WARN.M.DEMAND.0121");
        }
    }
}
