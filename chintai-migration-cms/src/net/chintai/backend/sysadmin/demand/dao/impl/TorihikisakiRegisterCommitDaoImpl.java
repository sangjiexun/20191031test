/*
 * $Id: TorihikisakiRegisterCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/04  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.demand.dao.TorihikisakiRegisterCommitDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiRegisterCommitParamBean;

/**
 * TorihikisakiRegisterCommitDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiRegisterCommitDaoImpl extends SqlMapClientDaoSupport implements
        TorihikisakiRegisterCommitDao {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiRegisterCommitDao#getTorihikisakiCd(java.lang.String)
     */
    public String getTorihikisakiCd(String fudousanCd) {
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

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiRegisterCommitDao#insertTorihikisaki(net.chintai.backend.sysadmin.demand.dao.TorihikisakiRegisterCommitParamBean)
     */
    public int insertTorihikisaki(TorihikisakiRegisterCommitParamBean paramBean) {
        return (Integer) getSqlMapClientTemplate().insert("demand.insertTorihikisaki", paramBean);
    }

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiRegisterCommitDao#insertTorihikisakiRyoukin(net.chintai.backend.sysadmin.demand.dao.TorihikisakiRegisterCommitParamBean)
     */
    public void insertTorihikisakiRyoukin(TorihikisakiRegisterCommitParamBean paramBean) {
        getSqlMapClientTemplate().insert("demand.insertTorihikisakiRyoukin", paramBean);
    }

}
