/*
 * $Id: UserUpdateCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/25  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.user.dao.UserUpdateCommitDao;
import net.chintai.backend.sysadmin.user.dao.UserUpdateCommitParamBean;

/**
 * LinkUpdateCommitDaoインターフェースの実装クラス
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserUpdateCommitDaoImpl extends SqlMapClientDaoSupport implements UserUpdateCommitDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.dao.UserUpdateCommitDao#userUpdateCommit(net.chintai.backend.sysadmin.user.dao.UserUpdateCommitParamBean)
     */
    public int userUpdateCommit(UserUpdateCommitParamBean paramBean) {
        return getSqlMapClientTemplate().update("user.userUpdateCommit", paramBean);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.dao.UserUpdateCommitDao#deleteCjnAccountLevel(net.chintai.backend.sysadmin.user.dao.UserUpdateCommitParamBean)
     */
    public int deleteCjnAccountLevel(UserUpdateCommitParamBean paramBean) {
        return getSqlMapClientTemplate().delete("user.deleteCjnAccountLevel", paramBean);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.dao.UserUpdateCommitDao#cjnAccountCheck(net.chintai.backend.sysadmin.user.dao.UserUpdateCommitParamBean)
     */
    public int cjnAccountCheck(UserUpdateCommitParamBean paramBean) {
        return (Integer) getSqlMapClientTemplate().queryForObject("user.updateCjnAccountCheck", paramBean);
    }
}