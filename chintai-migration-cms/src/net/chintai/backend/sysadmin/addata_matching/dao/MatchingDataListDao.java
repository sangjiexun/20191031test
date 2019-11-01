/*
 * $Id: MatchingDataListDao.java 4367 2009-09-01 05:37:54Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/25     BGT)石井       新規作成
 *
 */
package net.chintai.backend.sysadmin.addata_matching.dao;

import java.util.List;

import net.chintai.backend.sysadmin.addata_matching.domain.MatchingDataDomain;
import net.chintai.backend.sysadmin.common.pager.BasePagerCondition;


/**
 * 照合結果データ取得DAO
 * @author e-ishii
 * @version $Revision: 4367 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface MatchingDataListDao {

    /**
     * 照合結果を取得します。
     * @return 照合結果リスト
     */
    public List<MatchingDataDomain> matchingDataList( BasePagerCondition condition);


    /**
     * 照合結果の総件数を取得します。
     * @return 総件数
     */
    public int matchingDataCount();

}
