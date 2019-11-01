/*
 * $Id: CjnUserAuthorityUpdateCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/16  BGT)楊恩美        新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao.impl;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserAuthorityUpdateCommitDao;
import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserAuthorityUpdateParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * CjnUserAuthorityUpdateCommitDaoの実装クラス
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserAuthorityUpdateCommitDaoImpl
            extends SqlMapClientDaoSupport implements CjnUserAuthorityUpdateCommitDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserAuthorityUpdateCommitDao#insertUserAuthority(net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserAuthorityUpdateParamBean)
     */
    public void insertUserAuthority(CjnUserAuthorityUpdateParamBean paramBean) {
        getSqlMapClientTemplate().insert("cjn_inquiry.insertUserAuthority", paramBean);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserAuthorityUpdateCommitDao#updateUserAuthority(net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserAuthorityUpdateParamBean)
     */
    public int deleteUserAuthority(CjnUserAuthorityUpdateParamBean paramBean) {
        return getSqlMapClientTemplate().delete("cjn_inquiry.deleteUserAuthority", paramBean);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserAuthorityUpdateCommitDao#selectUserAuthorityLastUpdateDt(net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserAuthorityUpdateParamBean)
     */
    public String selectUserAuthorityLastUpdateDt(CjnUserAuthorityUpdateParamBean paramBean) {
        String cjnAccountSeq = paramBean.getCjnAccountSeq();
        return (String) getSqlMapClientTemplate().queryForObject("cjn_inquiry.selectUserAuthorityLastUpdDt", cjnAccountSeq);
    }

}
