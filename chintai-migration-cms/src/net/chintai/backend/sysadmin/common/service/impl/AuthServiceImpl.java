/*
 * $Id: AuthServiceImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/08/08     BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.common.service.impl;

import java.util.List;

import net.chintai.backend.sysadmin.common.AuthorityId;
import net.chintai.backend.sysadmin.common.dao.AuthDao;
import net.chintai.backend.sysadmin.common.dao.AuthParamBean;
import net.chintai.backend.sysadmin.common.service.AuthService;

/**
 * AuthService の実装クラス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AuthServiceImpl implements AuthService {

    /** 認証DAO */
    private AuthDao authDao;

    /**
     * 認証DAOを設定します。
     * @param authDao 認証DAO
     */
    public void setAuthDao(AuthDao authDao) {
        this.authDao = authDao;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.service.AuthService#authenticate(java.lang.String)
     */
    public boolean authenticate(String userId, AuthorityId authorityId) {
        AuthParamBean param = new AuthParamBean();
        param.setUserId(userId);
        param.setAuthorityId(authorityId.toString());

        int recordCount = authDao.selectAuthorityCount(param);
        return (recordCount == 1) ? true : false;
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.service.AuthService#getAuthorityList(java.lang.String)
     */
    public List<String> getAuthorityList(String userId) {
        AuthParamBean param = new AuthParamBean();
        param.setUserId(userId);
        return authDao.selectAuthorityList(param);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.service.AuthService#getCjnAccountType(java.lang.String)
     */
    public String getCjnAccountType(String userId) {
        return authDao.selectCjnAccountType(userId);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.service.AuthService#isAdminCjnAccountType(java.lang.String)
     */
    public boolean isAdminCjnAccountType(String userId) {
        return getCjnAccountType(userId).equals("1") ? true : false;
    }
}
