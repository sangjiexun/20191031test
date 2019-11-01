/*
 * $Id: RosenSearchDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/11/13  BGT)沈鍾沿     新規作成
 *
 */
package net.chintai.backend.sysadmin.master.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.master.dao.RosenNameSearchDao;
import net.chintai.backend.sysadmin.master.dao.RosenNameSearchParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * RosenNameSearchDaoの実装クラス
 *
 * @author Sim-JongYeon
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenNameSearchDaoImpl extends SqlMapClientDaoSupport implements RosenNameSearchDao {


    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.master.dao.RosenNameSearchDao#selectEnsenByEnsenEkiName(net.chintai.backend.sysadmin.master.dao.RosenNameSearchParamBean)
     */
    public List selectEnsenByEnsenEkiName(RosenNameSearchParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList("master.selectEnsenByEnsenEkiName",
                paramBean);
    }

}
