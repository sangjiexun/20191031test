/*
 * $Id: UserDeleteConfirmDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/25  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.user.dao.UserDeleteConfirmDao;
import net.chintai.backend.sysadmin.user.dao.UserDeleteConfirmParamBean;

/**
 * UserDeleteConfirmDao の実装クラス
 * 
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserDeleteConfirmDaoImpl
        extends SqlMapClientDaoSupport implements UserDeleteConfirmDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.dao.UserDeleteConfirmDao#userDeleteConfirm(net.chintai.backend.sysadmin.user.dao.UserDeleteConfirmParamBean)
     */
    public List userDeleteConfirm(UserDeleteConfirmParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList("user.userDeleteConfirm", paramBean);
    }

}
