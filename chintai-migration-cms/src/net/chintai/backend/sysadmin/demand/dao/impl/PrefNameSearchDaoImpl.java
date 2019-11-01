/*
 * $Id: PrefNameSearchDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/26  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.demand.dao.PrefNameSearchDao;
import net.chintai.backend.sysadmin.demand.dao.PrefNameSearchParamBean;
import net.chintai.backend.sysadmin.demand.domain.PrefNameSearchDomain;

/**
 * PrefNameSearchDaoの実装クラス
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class PrefNameSearchDaoImpl extends SqlMapClientDaoSupport implements PrefNameSearchDao {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.PrefNameSearchDao#getPrefName(net.chintai.backend.sysadmin.demand.dao.PrefNameSearchParamBean)
     */
    public PrefNameSearchDomain getPrefName(PrefNameSearchParamBean paramBean) {
        return (PrefNameSearchDomain) getSqlMapClientTemplate().queryForObject(
                "demand.selectPrefName", paramBean);
    }

}
