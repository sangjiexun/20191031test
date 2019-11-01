/*
 * $Id: RosenClientSettingSearchDaoImpl.java 4800 2014-01-10 05:02:50Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/31     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.dataoutput.dao.RosenClientSettingSearchDao;
import net.chintai.backend.sysadmin.dataoutput.dao.RosenClientSettingParamBean;
import net.chintai.backend.sysadmin.dataoutput.domain.MstEnsenDomain;
import net.chintai.backend.sysadmin.dataoutput.domain.RosenClientSettingDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


/**
 * RosenClientSettingSearchDao実装クラス
 * @author KAMEDA Takuma
 * @version $Revision: 4800 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class RosenClientSettingSearchDaoImpl extends SqlMapClientDaoSupport implements RosenClientSettingSearchDao {

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.dao.RosenOutSettingInfoDao#getRosenOutSettingList(net.chintai.backend.sysadmin.dataoutput.dao.RosenOutSettingParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<RosenClientSettingDomain> getRosenOutSettingList(RosenClientSettingParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList("dataoutput.getRosenOutSettingList",paramBean);
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.dao.RosenOutSettingInfoDao#getMstEnsenList(net.chintai.backend.sysadmin.dataoutput.dao.RosenOutSettingParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<MstEnsenDomain> getMstEnsenList(RosenClientSettingParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList("dataoutput.getMstEnsenList",paramBean);
    }

}
