/*
 * $Id: ProfileUpdateCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/04  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.profile.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.profile.dao.ProfileUpdateCommitDao;
import net.chintai.backend.sysadmin.profile.dao.ProfileUpdateCommitParamBean;

/**
 * ProfileUpdateCommitDaoインターフェースの実装クラス。
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ProfileUpdateCommitDaoImpl
    extends SqlMapClientDaoSupport implements ProfileUpdateCommitDao {

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.profile.dao.ProfileUpdateCommitDao#profileUpdateCommit(net.chintai.backend.sysadmin.profile.dao.ProfileUpdateCommitParamBean)
     */
    public int profileUpdateCommit(ProfileUpdateCommitParamBean paramBean) {

        return getSqlMapClientTemplate().
            update("profile.profileUpdateCommit",paramBean);
    }
}