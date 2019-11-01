/*
 * $Id: GroupAddCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/27  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao.impl;

import net.chintai.backend.sysadmin.user.dao.GroupAddCommitDao;
import net.chintai.backend.sysadmin.user.domain.Authority;
import net.chintai.backend.sysadmin.user.domain.Group;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


/**
 * GroupAddCommitDao の実装クラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupAddCommitDaoImpl extends SqlMapClientDaoSupport implements
        GroupAddCommitDao {

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.dao.GroupAddCommitDao#insertGroup(net.chintai.backend.sysadmin.user.domain.Group)
     */
    public void insertGroup(Group group) {
        getSqlMapClientTemplate().insert("user.insertGroup", group);

    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.dao.GroupAddCommitDao#insertGroupByAuthority(net.chintai.backend.sysadmin.user.domain.Authority)
     */
    public void insertGroupByAuthority(Authority authority) {
        getSqlMapClientTemplate().insert("user.insertGroupByAuthority", authority);

    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.dao.GroupAddCommitDao#selectSeqGroupID()
     */
    public int selectSeqGroupID() {
        return ((Integer)getSqlMapClientTemplate().queryForObject("user.selectSeqGroupId")).intValue();

    }

}
