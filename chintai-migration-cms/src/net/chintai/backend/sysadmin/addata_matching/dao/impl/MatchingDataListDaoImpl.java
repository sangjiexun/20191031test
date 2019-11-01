/*
 * $Id: MatchingDataListDaoImpl.java 4367 2009-09-01 05:37:54Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/25     BGT)石井       新規作成
 *
 */
package net.chintai.backend.sysadmin.addata_matching.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import net.chintai.backend.sysadmin.addata_matching.dao.MatchingDataListDao;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;


/**
 * MatchingDataListDaoの実装クラス
 * @author e-ishii
 * @version $Revision: 4367 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MatchingDataListDaoImpl extends SqlMapClientDaoSupport
                                                            implements MatchingDataListDao{

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.addata_matching.dao.
     * MatchingDataListDao#selectMatchingData()
     */
    public List matchingDataList(
            BasePagerCondition condition) {

        return getSqlMapClientTemplate()
        .queryForList("adDataMatching.matchingDataList", condition.getOffset(),
                condition.getLimit());
    }

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.addata_matching.dao.
     * MatchingDataListDao#matchingDataCount()
     */
    public int matchingDataCount() {

        return (Integer) getSqlMapClientTemplate().queryForObject
        ("adDataMatching.matchingDataTotalCount");
    }
}
