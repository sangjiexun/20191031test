/*
 * $Id: FudousanDeleteConfirmDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/12/04     BGT)高橋       新規作成
 *
 */
package net.chintai.backend.sysadmin.demand.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.demand.dao.FudousanDeleteConfirmDao;
import net.chintai.backend.sysadmin.demand.dao.FudousanDeleteConfirmParamBean;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * 
 * @author TAKAHASHI Yuki
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class FudousanDeleteConfirmDaoImpl extends SqlMapClientDaoSupport implements
        FudousanDeleteConfirmDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.demand.dao.FudousanDeleteConfirmDao#fudousanDeleteConfirm(net.chintai.backend.sysadmin.demand.dao.FudousanDeleteConfirmParamBean)
     */
    @SuppressWarnings("unchecked")
    public List fudousanDeleteConfirm(
            FudousanDeleteConfirmParamBean paramBean) {
        return getSqlMapClientTemplate().queryForList("demand.fudousanDeleteConfirm", paramBean);
    }

}
