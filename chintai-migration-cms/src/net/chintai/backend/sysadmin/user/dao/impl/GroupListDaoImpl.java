/*
 * $Id: GroupListDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/18  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.user.dao.GroupListDao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


/**
 * グループリストDAOの実装クラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupListDaoImpl extends SqlMapClientDaoSupport implements
        GroupListDao {

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.dao.GroupListDao#getGroupList()
     */
    public List getGroupList() {
        return getSqlMapClientTemplate().queryForList("user.selectGroupList");
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.dao.GroupListDao#getAuthorityList()
     */
    public List getAuthorityList() {
        return getSqlMapClientTemplate().queryForList("user.selectAuthorityList");
    }

}
