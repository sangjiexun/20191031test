/*
 * $Id: DcoTypeDaoImpl.java 4773 2014-01-09 08:06:59Z t-kameda $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2013/11/08     BGT)亀田       新規作成
 *
 */
package net.chintai.backend.sysadmin.common.dwr.dao.impl;

import java.util.List;

import net.chintai.backend.sysadmin.common.dwr.dao.DcoTypeDao;
import net.chintai.backend.sysadmin.common.dwr.domain.DcoType;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * DcoTypeDao実装クラス
 * @author KAMEDA Takuma
 * @version $Revision: 4773 $ Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class DcoTypeDaoImpl extends SqlMapClientDaoSupport implements DcoTypeDao {

    /* (非 Javadoc) @see net.chintai.backend.sysadmin.common.dwr.dao.DcoTypeDao#selectDcoTypeList()
     */
    @SuppressWarnings("unchecked")
    public List<DcoType> selectDcoTypeList(String dcoTypes) {
        return getSqlMapClientTemplate().queryForList("dcotype.selectMstDcoTypeList", dcoTypes);
    }

}
