/*
 * $Id: GroupDeleteCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/27  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao.impl;

import net.chintai.backend.sysadmin.user.dao.GroupDeleteCommitDao;
import net.chintai.backend.sysadmin.user.dao.GroupDeleteCommitParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


/**
 * GroupDeleteCommitDao の実装クラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupDeleteCommitDaoImpl extends SqlMapClientDaoSupport implements
        GroupDeleteCommitDao {

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.dao.GroupDeleteCommitDao#deleteGroup(net.chintai.backend.sysadmin.user.dao.GroupDeleteCommitParamBean)
     */
    public int deleteGroupByGroupId(GroupDeleteCommitParamBean paramBean) {
       return getSqlMapClientTemplate().delete("user.deleteGroupByGroupId", paramBean);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.dao.GroupDeleteCommitDao#deleteAuthorityByGroupId(net.chintai.backend.sysadmin.user.dao.GroupDeleteCommitParamBean)
     */
    public int deleteAuthorityByGroupId(GroupDeleteCommitParamBean paramBean) {
       return getSqlMapClientTemplate().delete("user.deleteAuthorityByGroupId", paramBean);
    }

}