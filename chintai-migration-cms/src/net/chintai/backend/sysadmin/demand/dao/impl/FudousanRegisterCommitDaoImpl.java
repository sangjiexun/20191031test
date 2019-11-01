/*
 * $Id: FudousanRegisterCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/22  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import net.chintai.backend.sysadmin.demand.dao.FudousanRegisterCommitParamBean;
import net.chintai.backend.sysadmin.demand.dao.FudousanRegisterCommitDao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


/**
 * FudousanRegisterCommitServiceDaoの実装クラス。
 *
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanRegisterCommitDaoImpl extends SqlMapClientDaoSupport implements
        FudousanRegisterCommitDao {

    /* (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.FudousanRegisterCommitDao#insertFudousanInfo(net.chintai.backend.sysadmin.demand.dao.FudousanRegisterCommitParamBean)
     */
    public void insertFudousanInfo(FudousanRegisterCommitParamBean paramBean) {
        getSqlMapClientTemplate().insert("demand.insertFudousanInfo", paramBean);
    }

}
