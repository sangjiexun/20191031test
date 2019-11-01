/*
 * $Id: FudousanUpdateConfirmServiceDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/12/04     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import net.chintai.backend.sysadmin.demand.dao.FudousanConfirmCompanyInfoParamBean;
import net.chintai.backend.sysadmin.demand.dao.FudousanUpdateConfirmServiceDao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * FudousanUpdateConfirmServiceDaoの実装クラス
 * 
 * @author TAKAHASHI Yuki
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanUpdateConfirmServiceDaoImpl extends SqlMapClientDaoSupport implements
        FudousanUpdateConfirmServiceDao {

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.FudousanUpdateConfirmServiceDao#confirmCompanyInfo(net.chintai.backend.sysadmin.demand.dao.FudousanConfirmCompanyInfoParamBean)
     */
    public int confirmCompanyInfo(FudousanConfirmCompanyInfoParamBean paramBean) {
        return (Integer) getSqlMapClientTemplate().queryForObject("demand.confirmCompanyInfo",
                paramBean);
    }
}
