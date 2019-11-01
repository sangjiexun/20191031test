/*
 * $Id: TorihikisakiDeleteConfirmDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/06  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.demand.dao.TorihikisakiDeleteConfirmDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiDeleteConfirmParamBean;
import net.chintai.backend.sysadmin.demand.domain.TorihikisakiDeleteConfirmDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * TorihikisakiDeleteConfirmDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiDeleteConfirmDaoImpl extends SqlMapClientDaoSupport implements
        TorihikisakiDeleteConfirmDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiDeleteConfirmDao#getTorihikisakiInfoForDel(net.chintai.backend.sysadmin.demand.dao.TorihikisakiDeleteConfirmParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<TorihikisakiDeleteConfirmDomain> getTorihikisakiInfoForDel(
            TorihikisakiDeleteConfirmParamBean paramBean) {
        return (List<TorihikisakiDeleteConfirmDomain>) getSqlMapClientTemplate().queryForList(
                "demand.selectTorihikisakiInfoForDel", paramBean);
    }

}
