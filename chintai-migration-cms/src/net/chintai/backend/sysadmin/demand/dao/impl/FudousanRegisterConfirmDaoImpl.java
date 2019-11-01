/*
 * $Id: FudousanRegisterConfirmDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/11/26  BGT)李昊燮   新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.demand.dao.FudousanConfirmCompanyInfoParamBean;
import net.chintai.backend.sysadmin.demand.dao.FudousanRegisterConfirmServiceDao;
import net.chintai.backend.sysadmin.demand.domain.FudousanDomain;

/**
 * FudousanRegisterConfirmServiceDaoの実装クラス
 * 
 * @author lee-hosup
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanRegisterConfirmDaoImpl extends SqlMapClientDaoSupport implements
        FudousanRegisterConfirmServiceDao {

    /*
     * (non-Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.FudousanRegisterConfirmServiceDao#confirmCompanyInfo(net.chintai.backend.sysadmin.demand.dao.FudousanRegisterConfirmParamBean)
     */
    public int confirmCompanyInfo(FudousanConfirmCompanyInfoParamBean paramBean) {
        return (Integer) getSqlMapClientTemplate().queryForObject("demand.confirmCompanyInfo",
                paramBean);
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.FudousanRegisterConfirmServiceDao#getNextFudousanCd()
     */
    public String getNextFudousanCd() {
        FudousanDomain rs =
                (FudousanDomain) getSqlMapClientTemplate().queryForObject(
                        "demand.getNextFudousanCd");
        return rs.getFudousanCd();
    }

}
