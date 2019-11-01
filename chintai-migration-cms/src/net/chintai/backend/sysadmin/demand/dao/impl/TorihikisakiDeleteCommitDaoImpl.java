/*
 * $Id: TorihikisakiDeleteCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/07  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import net.chintai.backend.sysadmin.demand.dao.TorihikisakiDeleteCommitDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiDeleteCommitParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * TorihikisakiDeleteCommitDaoの実装クラス
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiDeleteCommitDaoImpl extends SqlMapClientDaoSupport implements
        TorihikisakiDeleteCommitDao {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiDeleteCommitDao#deleteTorihikisaki(net.chintai.backend.sysadmin.demand.dao.TorihikisakiDeleteCommitParamBean)
     */
    public int deleteTorihikisaki(TorihikisakiDeleteCommitParamBean paramBean) {
        return getSqlMapClientTemplate().update("demand.deleteTorihikisaki", paramBean);
    }

}
