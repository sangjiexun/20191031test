/*
 * $Id: ProfilePasswordCheckDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/26  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.profile.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.profile.dao.ProfilePasswordCheckDao;
import net.chintai.backend.sysadmin.profile.dao.ProfilePasswordCheckParamBean;

/**
 * ProfilePasswordCheckDaoインターフェースの実装クラス。
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ProfilePasswordCheckDaoImpl
    extends SqlMapClientDaoSupport implements ProfilePasswordCheckDao {

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.profile.dao.ProfilePasswordCheckDao#profilePasswordCheck(net.chintai.backend.sysadmin.profile.dao.ProfilePasswordCheckParamBean)
     */
    public int profilePasswordCheck(ProfilePasswordCheckParamBean paramBean) {

        return (Integer) getSqlMapClientTemplate().
            queryForObject("profile.profilePasswdCheck",paramBean);
    }
}