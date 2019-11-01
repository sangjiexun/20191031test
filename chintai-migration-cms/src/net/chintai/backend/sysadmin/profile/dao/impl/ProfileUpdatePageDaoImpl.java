/*
 * $Id: ProfileUpdatePageDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/03  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.profile.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.profile.dao.ProfileUpdatePageDao;
import net.chintai.backend.sysadmin.profile.dao.ProfileUpdatePageParamBean;
import net.chintai.backend.sysadmin.profile.domain.Profile;

/**
 * ProfileUpdatePageDaoインターフェースの実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ProfileUpdatePageDaoImpl extends SqlMapClientDaoSupport 
    implements ProfileUpdatePageDao {

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.profile.dao.ProfileUpdatePageDao#profileUpdatePage(net.chintai.backend.sysadmin.profile.dao.ProfileUpdatePageParamBean)
     */
    public Profile profileUpdatePage(ProfileUpdatePageParamBean paramBean) {

        return (Profile) getSqlMapClientTemplate().queryForObject("profile.profileUpdatePage",
                paramBean);
    }
}