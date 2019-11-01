/*
 * $Id: TorihikisakiDeleteCommitServiceImpl.java 3682 2007-12-20 06:35:55Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/07  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.service.impl;

import net.chintai.backend.sysadmin.common.exception.ApplicationException;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiDeleteCommitDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiDeleteCommitParamBean;
import net.chintai.backend.sysadmin.demand.service.TorihikisakiDeleteCommitService;
import net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiDeleteCommitInServiceBean;

/**
 * TorihikisakiDeleteCommitServiceの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3682 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiDeleteCommitServiceImpl implements TorihikisakiDeleteCommitService {

    /** 取引先削除処理DAO */
    TorihikisakiDeleteCommitDao torihikisakiDeleteCommitDao;

    /**
     * 取引先削除処理DAOを設定します。
     * @param torihikisakiDeleteCommitDao 取引先削除処理DAO
     */
    public void setTorihikisakiDeleteCommitDao(
            TorihikisakiDeleteCommitDao torihikisakiDeleteCommitDao) {
        this.torihikisakiDeleteCommitDao = torihikisakiDeleteCommitDao;
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.service.TorihikisakiDeleteCommitService#deleteTorihikisaki(net.chintai.backend.sysadmin.demand.service.bean.TorihikisakiDeleteCommitInServiceBean)
     */
    public void deleteTorihikisaki(TorihikisakiDeleteCommitInServiceBean inBean)
            throws ApplicationException {

        TorihikisakiDeleteCommitParamBean paramBean = new TorihikisakiDeleteCommitParamBean();
        String[] seq = inBean.getDelFlgList();
        String[] updDt = inBean.getUpdDt();

        for (int i = 0; i < seq.length; i++) {
            paramBean.setTorihikisakiSeq(seq[i]);
            paramBean.setUpdDt(updDt[i]);
            paramBean.setUpdId(inBean.getUpdId());
            paramBean.setUpdPg(inBean.getUpdPg());

            int invaldateCnt = torihikisakiDeleteCommitDao.deleteTorihikisaki(paramBean);

            if (invaldateCnt == 0) {
                throw new ApplicationException("ERROR.M.DEMAND.0080");
            }
        }
    }
}
