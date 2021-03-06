/*
 * $Id: OperationDaoImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/10/31  BGT)金東珍     新規作成
 *
 */
package net.chintai.backend.sysadmin.common.dwr.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.common.dwr.dao.OperationDao;
import net.chintai.backend.sysadmin.common.dwr.domain.Operation;

/**
 * OperationDao の実装クラス。
 *
 * @author Kim Dong Jin
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class OperationDaoImpl extends SqlMapClientDaoSupport
    implements OperationDao {

    /* 
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.dwr.dao.OperationDao#selectOperationList(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    public List<Operation> selectOperationList(String authorityId) {

        return getSqlMapClientTemplate().queryForList("operation.operationList", authorityId);
    }
}