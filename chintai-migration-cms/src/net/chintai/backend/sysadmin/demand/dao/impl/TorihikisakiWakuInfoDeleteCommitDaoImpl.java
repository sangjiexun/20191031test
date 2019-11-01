/*
 * $Id: TorihikisakiWakuInfoDeleteCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/10  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoDeleteCommitDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoDeleteCommitParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * TorihikisakiWakuInfoDeleteCommitDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuInfoDeleteCommitDaoImpl extends SqlMapClientDaoSupport implements
        TorihikisakiWakuInfoDeleteCommitDao {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoDeleteCommitDao#deleteWakuInfo(net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoDeleteCommitParamBean)
     */
    public int deleteWakuInfo(TorihikisakiWakuInfoDeleteCommitParamBean paramBean) {
        return getSqlMapClientTemplate().update("demand.deleteWakuInfo", paramBean);
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoDeleteCommitDao#updateTorihikisakiUpdDt(net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoDeleteCommitParamBean)
     */
    public int updateTorihikisakiUpdDt(TorihikisakiWakuInfoDeleteCommitParamBean paramBean) {
        return getSqlMapClientTemplate().update("demand.updateTorihikisakiUpdDtByWakuInfoDelete",
                paramBean);
    }

}
