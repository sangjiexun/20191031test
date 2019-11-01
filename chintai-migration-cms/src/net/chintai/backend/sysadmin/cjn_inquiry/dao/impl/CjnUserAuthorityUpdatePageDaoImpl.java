/*
 * $Id: CjnUserAuthorityUpdatePageDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/15  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserAuthorityUpdatePageDao;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnUserAuthorityUpdateInfo;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * CjnUserAuthorityUpdatePageDaoの実装クラス
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserAuthorityUpdatePageDaoImpl
            extends SqlMapClientDaoSupport implements CjnUserAuthorityUpdatePageDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserAuthorityUpdatePageDao#selectCjnAccountLevelList(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    public List<CjnUserAuthorityUpdateInfo> selectCjnAccountLevelList(String cjnAccountSeq) {
        return getSqlMapClientTemplate().queryForList("cjn_inquiry.selectCjnAccountLevelList", cjnAccountSeq);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserAuthorityUpdatePageDao#selectLastUpdateDt(java.lang.String)
     */
    public String selectLastUpdateDt(String cjnAccountSeq) {
        return (String) getSqlMapClientTemplate().queryForObject("cjn_inquiry.selectUserAuthorityLastUpdDt",cjnAccountSeq); 
    }

}
