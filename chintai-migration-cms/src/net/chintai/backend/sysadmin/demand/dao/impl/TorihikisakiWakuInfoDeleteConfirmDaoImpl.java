/*
 * $Id: TorihikisakiWakuInfoDeleteConfirmDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/10  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoDeleteConfirmDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoDeleteConfirmParamBean;
import net.chintai.backend.sysadmin.demand.domain.TorihikisakiWakuInfoDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * TorihikisakiBukkenWakuInfoDeleteConfirmDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuInfoDeleteConfirmDaoImpl extends SqlMapClientDaoSupport implements
        TorihikisakiWakuInfoDeleteConfirmDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiBukkenWakuInfoDeleteConfirmDao#getTorihikisakiWakuInfoForDelete(net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoDeleteConfirmParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<TorihikisakiWakuInfoDomain> getTorihikisakiWakuInfoForDelete(
            TorihikisakiWakuInfoDeleteConfirmParamBean paramBean) {
        return (List<TorihikisakiWakuInfoDomain>) getSqlMapClientTemplate().queryForList(
                "demand.selectTorihikisakiWakuInfoForDelete", paramBean);
    }

}
