/*
 * $Id: ProfileInfoDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/03  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.profile.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.profile.dao.ProfileInfoDao;
import net.chintai.backend.sysadmin.profile.dao.ProfileInfoParamBean;
import net.chintai.backend.sysadmin.profile.domain.Profile;

/**
 * ProfileInfoDaoインターフェースの実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ProfileInfoDaoImpl extends SqlMapClientDaoSupport 
    implements ProfileInfoDao {

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.profile.dao.ProfileInfoDao#profileInfo(net.chintai.backend.sysadmin.profile.dao.ProfileInfoParamBean)
     */
    public Profile profileInfo(ProfileInfoParamBean paramBean) {

        return (Profile) getSqlMapClientTemplate().queryForObject("profile.profileInfo",
                paramBean);
    }
}