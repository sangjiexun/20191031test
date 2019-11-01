/*
 * $Id: AuthDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/08/08   BGT)児島      新規作成
 * 2007/10/31   BGT)児島      CJN_ACCOUNT_TYPE取得メソッド実装
 */
package net.chintai.backend.sysadmin.common.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.common.dao.AuthDao;
import net.chintai.backend.sysadmin.common.dao.AuthParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * AuthDao の実装クラス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class AuthDaoImpl extends SqlMapClientDaoSupport implements AuthDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.dao.AuthDao#selectAuthorityCount(
     *      net.chintai.backend.sysadmin.common.dao.AuthParamBean)
     */
    public int selectAuthorityCount(AuthParamBean bean) {
        return (Integer) getSqlMapClientTemplate().queryForObject("auth.selectAuthorityCount", bean);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.dao.AuthDao#selectAuthorityList(
     *      net.chintai.backend.sysadmin.common.dao.AuthParamBean)
     */

    @SuppressWarnings("unchecked")
    public List<String> selectAuthorityList(AuthParamBean bean) {
        return getSqlMapClientTemplate().queryForList("auth.selectAuthorityList", bean);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.dao.AuthDao#selectCjnAccountType(java.lang.String)
     */
    public String selectCjnAccountType(String userId) {
        return (String) getSqlMapClientTemplate().queryForObject("auth.selectCjnAccountType", userId);
    }

}
