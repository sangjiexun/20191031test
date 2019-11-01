/*
 * $Id: CjnUserInfoDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/12  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserInfoDao;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnUserAccountInfo;
import net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnUserInfo;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * CjnUserInfoDaoの実装クラス
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserInfoDaoImpl extends SqlMapClientDaoSupport implements CjnUserInfoDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserInfoDao#cjnAccountLevelList(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    public List<CjnUserAccountInfo> cjnAccountLevelList(String cjnAccountSeq) {
        return getSqlMapClientTemplate().queryForList("cjn_inquiry.cjnAccountSeq", cjnAccountSeq);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserInfoDao#selectCjnUser(java.lang.String)
     */
    public CjnUserInfo selectCjnUser(String cjnAccountSeq) {
        return (CjnUserInfo) getSqlMapClientTemplate().queryForObject("cjn_inquiry.selectCjnUser", cjnAccountSeq);
    }

}
