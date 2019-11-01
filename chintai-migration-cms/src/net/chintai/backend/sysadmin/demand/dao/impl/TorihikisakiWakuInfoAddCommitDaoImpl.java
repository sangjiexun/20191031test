/*
 * $Id: TorihikisakiWakuInfoAddCommitDaoImpl.java 3681 2007-12-20 05:24:14Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/09  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoAddCommitDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoAddCommitParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


/**
 * TorihikisakiWakuInfoAddCommitDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3681 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuInfoAddCommitDaoImpl extends SqlMapClientDaoSupport implements
        TorihikisakiWakuInfoAddCommitDao {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoAddCommitDao#insertTorihikisakiWakuInfo(net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoAddCommitParamBean)
     */
    public void insertTorihikisakiWakuInfo(TorihikisakiWakuInfoAddCommitParamBean paramBean) {
        getSqlMapClientTemplate().insert("demand.insertTorihikisakiWakuInfo",paramBean);
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoAddCommitDao#updateTorihikisakiUpdDt(net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoAddCommitParamBean)
     */
    public int updateTorihikisakiUpdDt(TorihikisakiWakuInfoAddCommitParamBean paramBean) {
        return getSqlMapClientTemplate().update("demand.updateTorihikisakiUpdDtByWakuInfoAdd", paramBean);
    }

}
