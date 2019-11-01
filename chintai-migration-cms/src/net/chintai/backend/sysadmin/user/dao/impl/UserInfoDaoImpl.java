/*
 * $Id: UserInfoDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/26  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.user.dao.UserInfoDao;
import net.chintai.backend.sysadmin.user.dao.UserInfoParamBean;
import net.chintai.backend.sysadmin.user.domain.UserDomain;

/**
 * UserInfoDaoインターフェースの実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserInfoDaoImpl extends SqlMapClientDaoSupport 
    implements UserInfoDao {

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.dao.UserInfoDao#userInfo(net.chintai.backend.sysadmin.user.dao.UserInfoParamBean)
     */
    public UserDomain userInfo(UserInfoParamBean paramBean) {

        return (UserDomain) getSqlMapClientTemplate().queryForObject("user.userInfo",
                paramBean);
    }
}