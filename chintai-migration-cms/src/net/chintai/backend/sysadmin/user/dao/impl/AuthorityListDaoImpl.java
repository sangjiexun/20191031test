/*
 * $Id: AuthorityListDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/19  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.user.dao.AuthorityListDao;


/**
 * グループの権限リストDAOの実装クラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AuthorityListDaoImpl extends SqlMapClientDaoSupport implements
        AuthorityListDao {

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.dao.AuthorityListDao#getAuthorityList()
     */
    public List getAuthorityList() {
        return getSqlMapClientTemplate().queryForList("user.selectAuthorityList");
    }

}
