/*
 * $Id: GroupUpdateCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/26  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao.impl;

import net.chintai.backend.sysadmin.user.dao.GroupUpdateCommitDao;
import net.chintai.backend.sysadmin.user.dao.GroupUpdateCommitParamBean;
import net.chintai.backend.sysadmin.user.domain.Authority;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * GroupUpdateCommitDao の実装クラス。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupUpdateCommitDaoImpl extends SqlMapClientDaoSupport implements GroupUpdateCommitDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.dao.GroupUpdateCommitDao#insertGroupByAuthority(net.chintai.backend.sysadmin.user.domain.Authority)
     */
    public void insertGroupByAuthority(Authority authority) {
        getSqlMapClientTemplate().insert("user.insertGroupByAuthority", authority);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.dao.GroupUpdateCommitDao#deleteGroupAuthority(net.chintai.backend.sysadmin.user.dao.GroupUpdateCommitParamBean)
     */
    public void deleteGroupAuthority(GroupUpdateCommitParamBean paramBean) {
        getSqlMapClientTemplate().delete("user.deleteGroupByAuthority", paramBean);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.dao.GroupUpdateCommitDao#updateGroupName(net.chintai.backend.sysadmin.user.dao.GroupUpdateCommitParamBean)
     */
    public void updateGroupName(GroupUpdateCommitParamBean paramBean) {
        getSqlMapClientTemplate().delete("user.updateGroupName", paramBean);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.dao.GroupUpdateCommitDao#selectUpdatable(net.chintai.backend.sysadmin.user.dao.GroupUpdateCommitParamBean)
     */
    public int selectUpdatable(GroupUpdateCommitParamBean paramBean) {
        return ((Integer) getSqlMapClientTemplate().queryForObject("user.selectUpdatable", paramBean)).intValue();
    }
}
