/*
 * LoginDaoImpl.java
 * ---------------------------------------------------------
 * 更新日      更新者     内容
 * ---------------------------------------------------------
 * 2007/06/15  BGT)児島   新規作成
 *
 */
package net.chintai.backend.sysadmin.login.dao.impl;

import net.chintai.backend.sysadmin.login.dao.MngSessionDao;
import net.chintai.backend.sysadmin.login.dao.MngSessionParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * LoginDao インターフェースの実装クラス。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MngSessionDaoImpl extends SqlMapClientDaoSupport implements MngSessionDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.login.dao.LoginDao#insertMngSession(net.chintai.backend.sysadmin.common.session.SessionBean)
     */
    public Long insertMngSession(MngSessionParamBean paramBean) {
        return (Long)getSqlMapClientTemplate().insert("login.insertMngSession",paramBean);
    }

    @Override
    public void deleteMngSession(Long sidId) {
        getSqlMapClientTemplate().delete("login.deleteMngSession",sidId);
   }


}
