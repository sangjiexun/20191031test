/*
 * $Id: UserAddConfirmDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/20  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.user.dao.UserAddConfirmDao;
import net.chintai.backend.sysadmin.user.dao.UserAddConfirmParamBean;
import net.chintai.backend.sysadmin.user.domain.UserDomain;

/**
 * UserAddConfirmDao インターフェースの実装クラス
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class UserAddConfirmDaoImpl
            extends SqlMapClientDaoSupport implements UserAddConfirmDao {

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.dao.UserAddConfirmDao#getUserId(net.chintai.backend.sysadmin.user.dao.UserAddConfirmParamBean)
     */
    public int userAddConfirm(UserAddConfirmParamBean paramBean) {
        UserDomain rs = (UserDomain)getSqlMapClientTemplate().queryForObject("user.userIdCheck",paramBean);
        
        return rs.getIdCount();
        //.queryForObject("link.getLinkId");
    }

}
