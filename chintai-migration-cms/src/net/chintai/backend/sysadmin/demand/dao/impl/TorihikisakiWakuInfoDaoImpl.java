/*
 * $Id: TorihikisakiWakuInfoDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/08  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoParamBean;
import net.chintai.backend.sysadmin.demand.domain.TorihikisakiWakuInfoDomain;

/**
 * TorihikisakiWakuInfoUpdatePageDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuInfoDaoImpl extends SqlMapClientDaoSupport implements
        TorihikisakiWakuInfoDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoUpdatePageDao#getTorihikisakiWakuInfo(net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoUpdatePageParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<TorihikisakiWakuInfoDomain> getTorihikisakiWakuInfo(
            TorihikisakiWakuInfoParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList(
                "demand.selectTorihikisakiWakuInfo", paramBean);
    }

}
