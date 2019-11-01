/*
 * $Id: UserUpdatePageDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/25  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.user.dao.UserUpdatePageDao;
import net.chintai.backend.sysadmin.user.dao.UserUpdatePageParamBean;
import net.chintai.backend.sysadmin.user.domain.UserDomain;

/**
 * UserUpdatePageDaoインターフェースの実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserUpdatePageDaoImpl extends SqlMapClientDaoSupport 
        implements UserUpdatePageDao {

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.dao.UserUpdatePageDao#userUpdatePage(net.chintai.backend.sysadmin.user.dao.UserUpdatePageParamBean)
     */
    public UserDomain userUpdatePage(UserUpdatePageParamBean paramBean) {
        
        return (UserDomain) getSqlMapClientTemplate().queryForObject("user.userUpdatePage",
                paramBean);
    }
}