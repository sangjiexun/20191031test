/*
 * $Id: TorihikisakiWakuInfoAddConfirmDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/12/13  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoAddConfirmDao;
import net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoAddConfirmParamBean;

/**
 * TorihikisakiWakuInfoAddConfirmDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class TorihikisakiWakuInfoAddConfirmDaoImpl extends SqlMapClientDaoSupport implements
        TorihikisakiWakuInfoAddConfirmDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoAddConfirmDao#checkAppliyYm(net.chintai.backend.sysadmin.demand.dao.TorihikisakiWakuInfoAddConfirmParamBean)
     */
    public int checkAppliyYm(TorihikisakiWakuInfoAddConfirmParamBean paramBean) {
        return (Integer) getSqlMapClientTemplate().queryForObject("demand.countApplyYm", paramBean);
    }

}
