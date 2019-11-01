/*
 * $Id: UserAddCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/20  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.user.dao.UserAddCommitDao;
import net.chintai.backend.sysadmin.user.dao.UserAddCommitParamBean;

/**
 * UserAddCommitDaoの実装クラス。
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserAddCommitDaoImpl
            extends SqlMapClientDaoSupport implements UserAddCommitDao {

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.dao.UserAddCommitDao#getUserAddCommit(net.chintai.backend.sysadmin.user.dao.UserAddCommitParamBean)
     */
    public void userAddCommit(UserAddCommitParamBean paramBean) {
        getSqlMapClientTemplate().insert("user.userAddCommit", paramBean);
    }
    
    public int cjnAccountCheck(UserAddCommitParamBean paramBean) {
        return (Integer) getSqlMapClientTemplate().
            queryForObject("user.addCjnAccountCheck", paramBean);
    }
}