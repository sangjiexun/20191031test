/*
 * $Id: TorihikisakiUpdateCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/06  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import net.chintai.backend.sysadmin.demand.dao.TorihikisakiUpdateCommitDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiUpdateCommitParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * TorihikisakiUpdateCommitDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiUpdateCommitDaoImpl extends SqlMapClientDaoSupport implements
        TorihikisakiUpdateCommitDao {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiUpdateCommitDao#updateTorihikisakiInfo(net.chintai.backend.sysadmin.demand.dao.TorihikisakiUpdateCommitParmaBean)
     */
    public int updateTorihikisakiInfo(TorihikisakiUpdateCommitParamBean paramBean) {
        return getSqlMapClientTemplate().update("demand.updateTorihikisakiInfo", paramBean);
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiUpdateCommitDao#getNewTorihikisakiCd(net.chintai.backend.sysadmin.demand.dao.TorihikisakiUpdateCommitParmaBean)
     */
    public String getNewTorihikisakiCd(String fudousanCd) {
        String newTorihikisakiCd =
            (String) getSqlMapClientTemplate().queryForObject("demand.selectNewTorhikisakiCd",
                    fudousanCd);
        int cnt =
            (Integer) getSqlMapClientTemplate().queryForObject("demand.fudousanExistCheck",
                    fudousanCd);
        if (cnt < 1){
            newTorihikisakiCd = null;
        }

        return newTorihikisakiCd;

    }

}
