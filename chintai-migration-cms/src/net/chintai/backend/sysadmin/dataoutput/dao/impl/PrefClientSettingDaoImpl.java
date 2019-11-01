/*
 * $Id: PrefClientSettingDaoImpl.java 4797 2014-01-10 04:20:55Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/23     BGT)亀田       E-0070 建物名表示に関する改修
 * 2014/01/07     BGT)亀田       E-0053_スマイティ用データ抽出　市区・駅対応
 */
package net.chintai.backend.sysadmin.dataoutput.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.dataoutput.dao.PrefClientSettingDao;
import net.chintai.backend.sysadmin.dataoutput.dao.PrefClientSettingParamBean;
import net.chintai.backend.sysadmin.dataoutput.domain.MstPrefDomain;
import net.chintai.backend.sysadmin.dataoutput.domain.PrefClientDataDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


/**
 *
 * PrefClientSettingDaoの実装クラス
 *
 * @author e-ishii
 * @version $Revision: 4797 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class PrefClientSettingDaoImpl extends SqlMapClientDaoSupport implements PrefClientSettingDao {



    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.dao.PrefClientSettingDao
     * #getPrefClientDataList(net.chintai.backend.sysadmin.dataoutput.dao.PrefClientSettingParamBean)
     */
    @SuppressWarnings("unchecked")
    public List<PrefClientDataDomain> getPrefClientDataList(PrefClientSettingParamBean paramBean) {

        return getSqlMapClientTemplate().queryForList("dataoutput.getPrefClientDataList",paramBean);
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.dao.PrefClientSettingDao#getMstPref()
     */
    @SuppressWarnings("unchecked")
    public List<MstPrefDomain> getMstPref(PrefClientSettingParamBean paramBean) {

        return getSqlMapClientTemplate().queryForList("dataoutput.getMstPref",paramBean);
    }

}
