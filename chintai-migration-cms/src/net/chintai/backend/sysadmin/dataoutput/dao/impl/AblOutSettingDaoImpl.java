/*
 * $Id: AblOutSettingDaoImpl.java 4717 2013-11-05 07:45:02Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/10/11     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.dataoutput.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.dataoutput.dao.AblOutSettingDao;
import net.chintai.backend.sysadmin.dataoutput.domain.AblOutSettingDomain;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


/**
 * AblOutSettingDao実装クラス
 * @author KAMEDA Takuma
 * @version $Revision: 4717 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AblOutSettingDaoImpl extends SqlMapClientDaoSupport implements AblOutSettingDao{

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.dataoutput.dao.AblOutSettingDao#getAblOutSettingDate()
     */
    @SuppressWarnings("unchecked")
    public List<AblOutSettingDomain> getAblOutSettingInfo() {
        return getSqlMapClientTemplate().queryForList("dataoutput.getAblSettingList");
    }

}
