/*
 * $Id: UserPasswordChangePageDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/10  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.user.dao.UserPasswordChangePageDao;
import net.chintai.backend.sysadmin.user.dao.UserPasswordChangePageParamBean;
import net.chintai.backend.sysadmin.user.domain.UserDomain;

/**
 * UserPasswordChangePageDaoインターフェースの実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserPasswordChangePageDaoImpl extends SqlMapClientDaoSupport 
    implements UserPasswordChangePageDao {

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.dao.UserPasswordChangePageDao#userPasswordChangePage(net.chintai.backend.sysadmin.user.dao.UserPasswordChangePageParamBean)
     */
    public UserDomain userPasswordChangePage(
            UserPasswordChangePageParamBean paramBean) {

        return (UserDomain) getSqlMapClientTemplate().queryForObject("user.userPasswordChangePage",
                paramBean);
    }
}