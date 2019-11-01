/*
 * $Id: GroupDeleteConfirmDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/27  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.user.dao.GroupDeleteConfirmDao;
import net.chintai.backend.sysadmin.user.dao.GroupDeleteConfirmParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


/**
 * GroupDeleteConfirmDaoの実装クラス。
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupDeleteConfirmDaoImpl extends SqlMapClientDaoSupport implements
        GroupDeleteConfirmDao {

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.dao.GroupDeleteConfirmDao#getGroupListByGroupId(net.chintai.backend.sysadmin.user.dao.GroupDeleteConfirmParamBean)
     */
    public List selectGroupListByGroupId(GroupDeleteConfirmParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList("user.selectGroupByGroupId", paramBean);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.dao.GroupDeleteConfirmDao#getUsedGroupCount(net.chintai.backend.sysadmin.user.dao.GroupDeleteConfirmParamBean)
     */
    public int selectUsedGroupCount(GroupDeleteConfirmParamBean paramBean) {
        return ((Integer)getSqlMapClientTemplate().queryForObject("user.selectUsedGroupCount", paramBean)).intValue();
    }
    
}