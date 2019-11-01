/*
 * $Id: EkiClientSettingInfoDaoImpl.java 4796 2014-01-10 04:15:22Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/12/18     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.dataoutput.dao.EkiClientSettingInfoDao;
import net.chintai.backend.sysadmin.dataoutput.dao.EkiClientSettingParamBean;
import net.chintai.backend.sysadmin.dataoutput.domain.EkiClientSettingDomain;
import net.chintai.backend.sysadmin.dataoutput.domain.MstEkiDomain;


/**
 * EkiClientSettingInfoDao実装クラス
 * @author KAMEDA Takuma
 * @version $Revision: 4796 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class EkiClientSettingInfoDaoImpl extends SqlMapClientDaoSupport implements EkiClientSettingInfoDao{

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.dao.EkiClientSettingInfoDao#getEkiOutSettingList(net.chintai.backend.sysadmin.dataoutput.dao.EkiClientSettingParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<EkiClientSettingDomain> getEkiOutSettingList(EkiClientSettingParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList("dataoutput.getEkiOutSettingList",paramBean);
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.dao.EkiClientSettingInfoDao#getEkiMstEki(net.chintai.backend.sysadmin.dataoutput.dao.EkiClientSettingParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<MstEkiDomain> getMstEkiList(EkiClientSettingParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList("dataoutput.getMstEkiList",paramBean);
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.dao.EkiClientSettingInfoDao#getEnsenClientList(net.chintai.backend.sysadmin.dataoutput.dao.EkiClientSettingParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<String> getEnsenClientList(EkiClientSettingParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList("dataoutput.getEnsenSkipConfig",paramBean);
    }

}
