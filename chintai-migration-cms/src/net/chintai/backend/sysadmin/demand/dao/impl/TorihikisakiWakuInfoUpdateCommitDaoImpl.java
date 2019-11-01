/*
 * $Id: TorihikisakiWakuInfoUpdateCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/10  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoUpdateCommitDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoUpdateCommitParamBean;

/**
 * TorihikisakiWakuInfoUpdateCommitDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuInfoUpdateCommitDaoImpl extends SqlMapClientDaoSupport implements
        TorihikisakiWakuInfoUpdateCommitDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoUpdateCommitDao#updateTorihikisakiWakuInfo(net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoUpdateCommitParamBean)
     */
    public int updateTorihikisakiWakuInfo(TorihikisakiWakuInfoUpdateCommitParamBean paramBean) {
        return getSqlMapClientTemplate().update("demand.updateTorihikisakiWakuInfo", paramBean);
    }

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoUpdateCommitDao#updateTorihikisakiUpdDt(net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoUpdateCommitParamBean)
     */
    public int updateTorihikisakiUpdDt(TorihikisakiWakuInfoUpdateCommitParamBean paramBean) {
        return getSqlMapClientTemplate().update("demand.updateTorihikisakiUpdDtByWakuInfoUpdate",
                paramBean);
    }

}
