/*
 * $Id: ShikutyosonClientSettingDaoImpl.java 4800 2014-01-10 05:02:50Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/12/27     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.dataoutput.dao.ShikutyosonClientSettingDao;
import net.chintai.backend.sysadmin.dataoutput.dao.ShikutyosonClientSettingParamBean;
import net.chintai.backend.sysadmin.dataoutput.domain.MstCityDomain;
import net.chintai.backend.sysadmin.dataoutput.domain.ShikutyosonClientSettingDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


/**
 * ShikutyosonClientSettingDao実装クラス
 * @author KAMEDA Takuma
 * @version $Revision: 4800 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class ShikutyosonClientSettingDaoImpl extends SqlMapClientDaoSupport implements ShikutyosonClientSettingDao{

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.dao.ShikutyosonClientSettingDao#getShikutyosonClientSettingList(net.chintai.backend.sysadmin.dataoutput.dao.ShikutyosonClientSettingParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<ShikutyosonClientSettingDomain> getShikutyosonClientSettingList(
            ShikutyosonClientSettingParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList("dataoutput.getShikutyosonOutSettingList",paramBean);
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.dao.ShikutyosonClientSettingDao#getMstCityList(net.chintai.backend.sysadmin.dataoutput.dao.ShikutyosonClientSettingParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<MstCityDomain> getMstCityList(ShikutyosonClientSettingParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList("dataoutput.getMstCityList",paramBean);
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.dao.ShikutyosonClientSettingDao#getPrefClinetList(net.chintai.backend.sysadmin.dataoutput.dao.ShikutyosonClientSettingParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<String> getPrefClinetList(ShikutyosonClientSettingParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList("dataoutput.getPrefSkipConfig",paramBean);    }

}
