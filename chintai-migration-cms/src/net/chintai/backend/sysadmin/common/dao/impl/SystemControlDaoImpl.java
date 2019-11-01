/*
 * $Id: SystemControlDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/11/13   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.common.dao.impl;

import net.chintai.backend.sysadmin.common.dao.SystemControlDao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * SystemControlDao の実装クラス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class SystemControlDaoImpl extends SqlMapClientDaoSupport implements SystemControlDao {

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.dao.SystemControlDao#selectSystemControlValue(java.lang.String)
     */
    public String selectSystemControlValue(String property) {
        return (String) getSqlMapClientTemplate().queryForObject("systemControl.selectSystemControlValue", property);
    }
}
