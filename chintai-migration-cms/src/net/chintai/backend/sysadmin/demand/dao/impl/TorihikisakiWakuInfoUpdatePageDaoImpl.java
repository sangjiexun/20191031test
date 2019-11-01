/*
 * $Id: TorihikisakiWakuInfoUpdatePageDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/09  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoUpdatePageDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoUpdatePageParamBean;
import net.chintai.backend.sysadmin.demand.domain.TorihikisakiWakuInfoDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * TorihikisakiWakuInfoUpdatePageDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuInfoUpdatePageDaoImpl extends SqlMapClientDaoSupport implements
        TorihikisakiWakuInfoUpdatePageDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoUpdatePageDao#getTorihikisakiWakuInfo(net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoUpdatePageParamBean)
     */
    public TorihikisakiWakuInfoDomain getTorihikisakiWakuInfo(
            TorihikisakiWakuInfoUpdatePageParamBean paramBean) {
        return (TorihikisakiWakuInfoDomain) getSqlMapClientTemplate().queryForObject(
                "demand.selectTorihikisakiWakuInfoForUpdate", paramBean);
    }

}
