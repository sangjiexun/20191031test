/*
 * $Id: ProfilePasswordChangeCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/04  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.profile.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.profile.dao.ProfilePasswordChangeCommitDao;
import net.chintai.backend.sysadmin.profile.dao.ProfilePasswordChangeCommitParamBean;

/**
 * ProfilePasswordChangeCommitDaoインターフェースの実装クラス。
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ProfilePasswordChangeCommitDaoImpl
    extends SqlMapClientDaoSupport implements ProfilePasswordChangeCommitDao {

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.profile.dao.ProfilePasswordChangeCommitDao#profilePasswordChangeCommit(net.chintai.backend.sysadmin.profile.dao.ProfilePasswordChangeCommitParamBean)
     */
    public int profilePasswordChangeCommit(
            ProfilePasswordChangeCommitParamBean paramBean) {

        return getSqlMapClientTemplate().
            update("profile.profilePasswordChangeCommit",paramBean);
    }
}