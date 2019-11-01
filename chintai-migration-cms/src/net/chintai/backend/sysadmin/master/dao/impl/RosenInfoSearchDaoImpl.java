/*
 * $Id: RosenInfoSearchDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/14  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.master.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.master.dao.RosenInfoSearchDao;
import net.chintai.backend.sysadmin.master.dao.RosenInfoSearchParamBean;

/**
 * RosenInfoSearchDaoの実装クラス。
 * 
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenInfoSearchDaoImpl extends SqlMapClientDaoSupport implements RosenInfoSearchDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.dao.RosenInfoSearchDao#selectRosenInfoByEnsenCd(net.chintai.backend.sysadmin.master.dao.RosenInfoSearchParamBean)
     */
    public List selectRosenInfoByEnsenCd(RosenInfoSearchParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList("master.selectRosenInfoByEnsenCd", paramBean);
    }

}
