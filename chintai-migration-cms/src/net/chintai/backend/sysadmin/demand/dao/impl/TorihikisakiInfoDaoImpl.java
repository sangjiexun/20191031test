/*
 * $Id: TorihikisakiInfoDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/26  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import net.chintai.backend.sysadmin.demand.dao.TorihikisakiInfoDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiInfoParamBean;
import net.chintai.backend.sysadmin.demand.domain.TorihikisakiInfoDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * TorihikisakiInfoDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiInfoDaoImpl extends SqlMapClientDaoSupport implements TorihikisakiInfoDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiInfoDao#getTorihikisakiDetailInfo(net.chintai.backend.sysadmin.demand.dao.TorihikisakiInfoParamBean)
     */
    public TorihikisakiInfoDomain getTorihikisakiDetailInfo(TorihikisakiInfoParamBean paramBean) {
        return (TorihikisakiInfoDomain) getSqlMapClientTemplate().queryForObject(
                "demand.selectTorihikisakiInfo", paramBean);
    }
}
