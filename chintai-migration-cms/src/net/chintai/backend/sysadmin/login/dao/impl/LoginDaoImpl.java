/*
 * LoginDaoImpl.java
 * ---------------------------------------------------------
 * 更新日      更新者     内容
 * ---------------------------------------------------------
 * 2007/06/15  BGT)児島   新規作成
 *
 */
package net.chintai.backend.sysadmin.login.dao.impl;

import net.chintai.backend.sysadmin.login.dao.LoginDao;
import net.chintai.backend.sysadmin.login.dao.MngSessionParamBean;
import net.chintai.backend.sysadmin.login.domain.User;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * LoginDao インターフェースの実装クラス。
 *
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class LoginDaoImpl extends SqlMapClientDaoSupport implements LoginDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.login.dao.LoginDao#selectUserByUserId(java.lang.String)
     */
    public User selectUser(String userId) {
        return (User) getSqlMapClientTemplate().queryForObject("login.selectUser", userId);
    }


}
