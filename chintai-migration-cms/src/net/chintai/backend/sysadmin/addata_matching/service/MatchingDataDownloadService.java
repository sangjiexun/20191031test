/*
 * $Id: MatchingDataDownloadService.java 4367 2009-09-01 05:37:54Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/08/27     BGT)石井       新規作成
 *
 */
package net.chintai.backend.sysadmin.addata_matching.service;

import java.util.List;

import net.chintai.backend.sysadmin.addata_matching.service.bean.MatchingDataDownloadInServiceBean;
import net.chintai.backend.sysadmin.addata_matching.service.bean.MatchingDataDownloadOutServiceBean;
import net.chintai.backend.sysadmin.common.exception.ApplicationException;


/**
 * 照合結果取得処理を提供するサービスクラス。
 * @author e-ishii
 * @version $Revision: 4367 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface MatchingDataDownloadService {

    /**
     * 照合結果を取得します。
     * @param paramBean パラメータ
     * @return 照合結果
     * @throws ApplicationException
     */
    public List<MatchingDataDownloadOutServiceBean> matchingDataCsvDownload(
            MatchingDataDownloadInServiceBean paramBean) throws ApplicationException;

}
