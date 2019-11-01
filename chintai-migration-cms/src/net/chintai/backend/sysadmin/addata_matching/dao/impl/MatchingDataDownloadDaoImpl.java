/*
 * $Id: MatchingDataDownloadDaoImpl.java 4367 2009-09-01 05:37:54Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/27     BGT)石井       新規作成
 *
 */
package net.chintai.backend.sysadmin.addata_matching.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;



import net.chintai.backend.sysadmin.addata_matching.dao.MatchingDataDownloadDao;
import net.chintai.backend.sysadmin.addata_matching.dao.MatchingDataDownloadParamBean;


/**
 * MatchingDataDownloadDao インターフェースの実装クラス
 * @author e-ishii
 * @version $Revision: 4367 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class MatchingDataDownloadDaoImpl extends SqlMapClientDaoSupport
                                                implements MatchingDataDownloadDao{

    /* (非 Javadoc)
     * @see net.chintai.backend.sysadmin.addata_matching.dao.
     * MatchingDataDownloadDao#selectMatchingDataToCsv(net.chintai.backend.sysadmin.
     * addata_matching.dao.MatchingDataDownloadParamBean)
     */
    public List selectMatchingDataToCsv(MatchingDataDownloadParamBean param) {

        return getSqlMapClientTemplate().queryForList("adDataMatching.selectMatchingData", param);

    }
}
