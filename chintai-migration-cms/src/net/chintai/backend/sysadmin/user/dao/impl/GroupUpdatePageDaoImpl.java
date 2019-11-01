/*
 * $Id: GroupUpdatePageDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/21  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.user.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.user.dao.GroupUpdatePageDao;
import net.chintai.backend.sysadmin.user.dao.GroupUpdatePageParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


/**
 * グループ更新ページの DAOの実装クラス
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class GroupUpdatePageDaoImpl extends SqlMapClientDaoSupport implements
        GroupUpdatePageDao {

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.user.dao.GroupUpdatePageDao#selectUpdateGroup(net.chintai.backend.sysadmin.user.dao.GroupUpdatePageParamBean)
     */
    public List selectUpdateGroup(GroupUpdatePageParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList("user.selectGroupUpdatePage", paramBean);
    }

}
