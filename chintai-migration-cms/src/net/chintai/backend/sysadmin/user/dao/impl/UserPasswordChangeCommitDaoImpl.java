/*
 * $Id: UserPasswordChangeCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/26  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.user.dao.UserPasswordChangeCommitDao;
import net.chintai.backend.sysadmin.user.dao.UserPasswordChangeCommitParamBean;

/**
 * UserPasswordChangeCommitDaoインターフェースの実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserPasswordChangeCommitDaoImpl
    extends SqlMapClientDaoSupport
        implements UserPasswordChangeCommitDao {

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.dao.UserPasswordChangeCommitDao#userPasswordChange(net.chintai.backend.sysadmin.user.dao.UserPasswordChangeCommitParamBean)
     */
    public int userPasswordChange(UserPasswordChangeCommitParamBean paramBean) {

        return getSqlMapClientTemplate().update("user.userPasswordChangeCommit",paramBean);
    }
}