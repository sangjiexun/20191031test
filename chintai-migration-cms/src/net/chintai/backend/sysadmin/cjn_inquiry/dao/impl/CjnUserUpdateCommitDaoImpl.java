/*
 * $Id: CjnUserUpdateCommitDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/15  BGT)楊恩美     新規作成
 *
 */
package net.chintai.backend.sysadmin.cjn_inquiry.dao.impl;

import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserUpdateCommitDao;
import net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserUpdateCommitParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * CjnUserUpdateCommitDaoの実装クラス
 * 
 * @author Yang-EunMi
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class CjnUserUpdateCommitDaoImpl
            extends SqlMapClientDaoSupport implements CjnUserUpdateCommitDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.cjn_inquiry.dao.CjnUserInfoUpdateCommitDao#updateCjnUser(net.chintai.backend.sysadmin.cjn_inquiry.domain.CjnUserInfo)
     */
    public int updateCjnUser(CjnUserUpdateCommitParamBean paramBean) {
        return (Integer) getSqlMapClientTemplate().update("cjn_inquiry.updateCjnUser", paramBean);
    }
}
