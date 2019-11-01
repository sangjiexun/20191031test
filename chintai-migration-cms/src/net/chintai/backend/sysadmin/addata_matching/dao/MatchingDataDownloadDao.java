/*
 * $Id: MatchingDataDownloadDao.java 4367 2009-09-01 05:37:54Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/27     BGT)石井       新規作成
 *
 */
package net.chintai.backend.sysadmin.addata_matching.dao;

import java.util.List;

import net.chintai.backend.sysadmin.addata_matching.domain.MatchingDataDownloadDomain;


/**
 * 照合結果ダウンロードDao(CSV出力用)
 * @author e-ishii
 * @version $Revision: 4367 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface MatchingDataDownloadDao {

    /**
     * 照合結果を取得します。
     * @param param パラメータ
     * @return 照合結果情報
     */
    public List<MatchingDataDownloadDomain> selectMatchingDataToCsv(
            MatchingDataDownloadParamBean param);

}
